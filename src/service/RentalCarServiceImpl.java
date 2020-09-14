package service;

import exception.RentalCarException;
import pojo.*;
import service.RentalCarService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Basic car rental service
 * Created by Tuhin Kumar Daw (tuhin.daw@gmail.com) on 09/13/2020
 */
public class RentalCarServiceImpl implements RentalCarService {

    static List<Car> allCars = new ArrayList<>();
    static Map<Car, Status> currentStatusMap = new HashMap<>();
    static Map<Car, Integer> currentDistanceMap = new HashMap<>();

    static {
        allCars = LocalDataStore.getAllCarDetail();
        currentStatusMap = LocalDataStore.getCurrentStatus();
        currentDistanceMap = LocalDataStore.getCurrentDistanceFromSource();
    }

    @Override
    public List<Car> getAllCarDetail() {
        return LocalDataStore.getAllCarDetail();
    }

    @Override
    public RentalResponse rentCar(RentalRequest request) {
        RentalResponse response = new RentalResponse();
        Car car = request.getCar();
        if(checkAvailability(car)){
            response.setCar(car);
            response.setStatus(Status.Booked);
        }
        else {
            response.setCar(car);
            response.setStatus(Status.Unavailable);
        }

        return response;
    }

    @Override
    public boolean checkAvailability(Car car) {
        boolean isAvailable = false;
        Status status = LocalDataStore.getCurrentStatus().get(car.getCarId());
        if(status.equals(Status.Available)){
            isAvailable = true;
        }
        return isAvailable;
    }

    @Override
    public RentalResponse dropCar(RentalRequest request) throws RentalCarException {

        String message = "Request has been cancelled";
        try {
            updateStatus(request.getCar(), Status.Available);
        }
        catch (Exception ex){
            throw new RentalCarException("pojo.Car can not be dropped");
        }
        RentalResponse response = new RentalResponse(Status.Available,request.getCar(),message);
        response.setBillDetail(generateBill(request));
        return response;
    }

    //Get all available cars
    private Map<Car, Status> getAvailableCars(){

        Map<Car, Status> allAvailableCars = currentStatusMap.entrySet().stream()
                .filter(t->t.getValue().equals(Status.Available)).
                        collect(Collectors.toMap(t->t.getKey(),t->t.getValue()));

        return allAvailableCars;

    }

    //list of matching cars which are available for booking
    private List<Car> getAvailableCarsForBooking(RentalRequest request){

        //list of matching cars as per customer's preference
        List<Car> matchingCars = allCars.stream().
                filter(t->t.getMake().equals(request.getCar().getMake()))
                .filter(t->t.getSittingCapacity()>=request.getCar().getSittingCapacity())
                .collect(Collectors.toList());

        if(matchingCars.isEmpty()){
            throw new RentalCarException("No matching cars as per the customer's preference is found");
        }

        List<Car> availableCars = Optional.ofNullable(getAvailableCars().keySet().stream()
                .filter(t->(matchingCars.contains(t))).collect(Collectors.toList()))
                .orElseThrow(()-> new RentalCarException("No matching cars are found"));

        if(availableCars.isEmpty()){
            throw new RentalCarException("No matching cars as per the customer's preference is found");
        }

        return availableCars;

    }

    @Override
    public RentalResponse bookCar(RentalRequest request){

        String message = "Successfully booked car :: ";

        List<Car> availableCars = getAvailableCarsForBooking(request);


        //Find the matching car having minimum distance
        Car car = availableCars.get(0);
        int minDistance = currentDistanceMap.get(availableCars.get(0));
        for(Car i : availableCars){
            if(currentDistanceMap.get(i)<minDistance){
                minDistance = currentDistanceMap.get(i);
                car = i;
            }
        }


        try {
            updateStatus(car, Status.Booked);
            System.out.println("pojo.Status has been updated successfully");
        }

        catch (Exception ex){
            throw new RentalCarException("There has been an issue in booking car : "+car);
        }

        RentalResponse response = new RentalResponse();
        response.setStatus(Status.Booked);
        response.setCar(car);
        response.setCurrentDistanceFromSource(minDistance);
        response.setMessage(message + car);
        //Since car has just been booked, lets not generate any billing yet
        BillDetail billDetail = new BillDetail(0,0);
        response.setBillDetail(billDetail);


        return response;
    }

    @Override
    public RentalResponse cancelBooking(RentalRequest request) throws RentalCarException {
        String message = "Request has been cancelled successfully";
        try {
            updateStatus(request.getCar(), Status.Available);
        }
        catch (Exception ex){
            throw new RentalCarException("Booking can not be cancelled");
        }
        return new RentalResponse(Status.Available,request.getCar(), message);
    }

    @Override
    public BillDetail generateBill(RentalRequest request) {
        Date startTime = request.getStartTime();
        Date endTime = request.getEndTime();
        int difference = calculateDuration(startTime,endTime);
        int amount = difference*10;

        BillDetail billDetail = new BillDetail(amount,50);

        return billDetail;
    }

    private int calculateDuration(Date startTime, Date endTime){
        long difference_In_Time
                = endTime.getTime() - startTime.getTime();
        long difference_In_Hours
                = (difference_In_Time / (1000 * 60 * 60)) % 24;

        return new Long(difference_In_Hours).intValue();
    }

    //Update status accordingly
    private void updateStatus(Car car, Status status){
        synchronized (this) {
                System.out.println("pojo.Status is being updated to => " + status);
                currentStatusMap.compute(car, (key, val)
                        -> status);
        }
    }
}
