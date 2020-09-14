package unittest;

import exception.RentalCarException;
import org.junit.Assert;
import org.junit.Test;
import pojo.Car;
import pojo.RentalRequest;
import pojo.RentalResponse;
import pojo.RequestType;
import service.RentalCarService;
import service.RentalCarServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Unit test class to test features of a basic car rental service
 * Created by Tuhin Kumar Daw (tuhin.daw@gmail.com) on 09/13/2020
 */
public class CarRentalUnitTest {

    @Test
    public void testBookingDoneSuccessfully(){

        Car car = new Car("Honda",5);
        //Booking request
        RentalRequest bookingRequest = new RentalRequest(new Date(),new Date(),car, RequestType.Booking);
        RentalCarService service = new RentalCarServiceImpl();
        RentalResponse response = service.bookCar(bookingRequest);
        Assert.assertEquals(response.getCar().getCarId(), 8);
        Assert.assertEquals(response.getCar().getMake(), "Honda");
        Assert.assertEquals(response.getCar().getChasis(), "PA108");
        Assert.assertEquals(response.getCar().getModel(), "Accord");

    }

    @Test
    public void testBookingCarWithMatchingCapacity(){

        Car car = new Car(01,"PA106","Honda","Civic", 8);
        //Booking request
        RentalRequest bookingRequest = new RentalRequest(new Date(),new Date(),car, RequestType.Booking);
        RentalCarService service = new RentalCarServiceImpl();
        RentalResponse response = service.bookCar(bookingRequest);
        Assert.assertEquals(response.getCar().getCarId(), 6);
        Assert.assertEquals(response.getCar().getMake(), "Honda");
        Assert.assertEquals(response.getCar().getChasis(), "PA106");
        Assert.assertEquals(response.getCar().getModel(), "HSedan");

    }

    @Test (expected = RentalCarException.class)
    public void testBookingCarWithOverCapacity(){

        Car car = new Car(01,"PA106","Honda","Civic", 9);
        //Booking request with over capacity
        RentalRequest bookingRequest = new RentalRequest(new Date(),new Date(),car, RequestType.Booking);
        RentalCarService service = new RentalCarServiceImpl();
        RentalResponse response = service.bookCar(bookingRequest);
    }

    @Test
    public void testBookingDoneSuccessfullyForSimilarRequests(){

        //Booking request
        Car car = new Car(01,"PA101","Honda","Civic");
        RentalRequest bookingRequest = new RentalRequest(new Date(),new Date(),car, RequestType.Booking);
        RentalCarService service = new RentalCarServiceImpl();

        RentalResponse response = service.bookCar(bookingRequest);
        Assert.assertEquals(response.getCar().getCarId(), 8);
        Assert.assertEquals(response.getCar().getMake(), "Honda");
        Assert.assertEquals(response.getCar().getChasis(), "PA108");
        Assert.assertEquals(response.getCar().getModel(), "Accord");

        //Another booking request for similar type of car
        Car similarCar = new Car(01,"PA101","Honda","Civic");
        RentalRequest anotherBookingRequest = new RentalRequest(new Date(),new Date(),similarCar, RequestType.Booking);
        RentalResponse anotherResponse = service.bookCar(anotherBookingRequest);
        Assert.assertEquals(anotherResponse.getCar().getCarId(), 6);
        Assert.assertEquals(anotherResponse.getCar().getMake(), "Honda");
        Assert.assertEquals(anotherResponse.getCar().getChasis(), "PA106");
        Assert.assertEquals(anotherResponse.getCar().getModel(), "HSedan");

    }

    @Test
    public void testCancellationDoneSuccessfully(){

        Car car = new Car(2,"PA102", "Chevrolet", "Cruize");
        //Cancel request
        RentalRequest cancelRequest = new RentalRequest(new Date(),new Date(),car, RequestType.Cancel);
        RentalCarService service = new RentalCarServiceImpl();
        RentalResponse response = service.cancelBooking(cancelRequest);

        Assert.assertEquals(response.getCar().getCarId(), 2);
        Assert.assertEquals(response.getCar().getMake(), "Chevrolet");
        Assert.assertEquals(response.getCar().getChasis(), "PA102");
        Assert.assertEquals(response.getCar().getModel(), "Cruize");
        Assert.assertEquals(response.getMessage(), "Request has been cancelled successfully");

    }

    @Test
    public void testBillingFunctionality(){

        Car car = new Car(9,"PA109", "Audi", "X4");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date endDate = c.getTime();
        //Drop request
        RentalRequest dropRequest = new RentalRequest(new Date(),endDate,car, RequestType.Drop);
        RentalCarService service = new RentalCarServiceImpl();
        RentalResponse response = service.dropCar(dropRequest);

        Assert.assertEquals(response.getBillDetail().getBillAmount(), 230);

    }

    @Test
    public void testBillingFunctionalityWhenCarInUseAndNoBillingInformationGenerated(){

        Car car = new Car(9,"PA109", "Audi", "X4");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date endDate = c.getTime();
        //Drop request
        RentalRequest dropRequest = new RentalRequest(new Date(),endDate,car, RequestType.Booking);
        RentalCarService service = new RentalCarServiceImpl();
        RentalResponse response = service.bookCar(dropRequest);

        Assert.assertEquals(response.getBillDetail().getBillAmount(), 0);


    }


}
