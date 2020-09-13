package thread;

import pojo.RentalRequest;
import service.RentalCarService;
import service.RentalCarServiceImpl;

public class Task implements Runnable{

    private RentalRequest request;
    private RentalCarService service;

    public Task(){}

    public Task(RentalRequest request) {
        this.request = request;
        service = new RentalCarServiceImpl();
    }

    @Override
    public void run() {

        switch (request.getRequestType()){

            case Booking:
                System.out.println("Booking request is being processed...");
                service.bookCar(request);
                break;

            case Drop:
                System.out.println("Drop request is being processed...");
                service.dropCar(request);
                break;

            case Cancel:
                System.out.println("Cancel request is being processed...");
                service.cancelBooking(request);
                break;

        }

    }
}
