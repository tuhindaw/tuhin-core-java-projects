import pojo.Car;
import pojo.RentalRequest;
import pojo.RequestType;
import thread.RequestProcessor;
import thread.Task;

import java.util.Arrays;
import java.util.Date;

public class Test {

    public static void main(String[] args){

        Car car = new Car(01,"PA101","Honda","Civic");
        //Booking request
        RentalRequest bookingReuest = new RentalRequest(new Date(),new Date(),car, RequestType.Booking);
        Task bookingTask = new Task(bookingReuest);

        //Cancel request
        RentalRequest cancelRequest = new RentalRequest(new Date(),new Date(),car, RequestType.Cancel);
        Task cancelTask = new Task(cancelRequest);

        RequestProcessor processor = new RequestProcessor();
        processor.processCarRequest(Arrays.asList(bookingTask,cancelTask));
        //service.RentalCarService bookingService = new service.RentalCarServiceImpl();
        //pojo.RentalResponse response = bookingService.bookCar(request);
        //System.out.println("Optimized car has been booked. Current distance from source rental service is : " +response.getCurrentDistanceFromSource());
        System.out.println("Optimized car has been booked. Current distance from source rental service is : ");


    }
}
