package service;

import exception.RentalCarException;
import pojo.BillDetail;
import pojo.Car;
import pojo.RentalRequest;
import pojo.RentalResponse;

import java.util.List;

public interface RentalCarService {

    List<Car> getAllCarDetail();
    RentalResponse rentCar(RentalRequest request);
    boolean checkAvailability(Car car);
    RentalResponse dropCar(RentalRequest car) throws RentalCarException;
    RentalResponse bookCar(RentalRequest request);
    RentalResponse cancelBooking(RentalRequest car) throws RentalCarException;
    BillDetail generateBill(RentalRequest request);

}
