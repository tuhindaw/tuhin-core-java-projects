import pojo.Car;
import pojo.RentalRequest;
import pojo.RequestType;
import thread.RequestProcessor;
import thread.Task;

import java.util.Arrays;
import java.util.Date;

public class Test {

    public static void main(String[] args){

        Car car = new Car("Honda",4);
        Car car1 = new Car("BMW",7);
        Car car2 = new Car("Audi",7);

        // Booking request
        RentalRequest bookingReuest = new RentalRequest(new Date(),new Date(),car, RequestType.Booking);
        Task bookingTask = new Task(bookingReuest);

        //Cancel request
        RentalRequest cancelRequest = new RentalRequest(new Date(),new Date(),car1, RequestType.Cancel);
        Task cancelTask = new Task(cancelRequest);

        //Drop request
        RentalRequest dropRequest = new RentalRequest(new Date(),new Date(),car2, RequestType.Drop);
        Task dropTask = new Task(dropRequest);

        RequestProcessor processor = new RequestProcessor();
        processor.processCarRequest(Arrays.asList(bookingTask,cancelTask,dropTask));

        System.out.println("Optimized car has been booked.");


    }
}
