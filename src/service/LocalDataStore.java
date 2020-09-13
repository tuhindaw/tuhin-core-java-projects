package service;

import pojo.Car;
import pojo.Status;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LocalDataStore {

    public static List<Car> getAllCarDetail(){

        return Arrays.asList(
                new Car(1,"PA101", "Honda", "Civic"),
                new Car(2,"PA102", "Chevrolet", "Cruize"),
                new Car(3,"PA103", "Honda", "Accord"),
                new Car(4,"PA104", "Audi", "X4"),
                new Car(5,"PA105", "BMW", "C7"),
                new Car(6,"PA106", "Honda", "Civic"),
                new Car(7,"PA107", "Chevrolet", "Cruize"),
                new Car(8,"PA108", "Honda", "Accord"),
                new Car(9,"PA109", "Audi", "X4"),
                new Car(10,"PA110", "BMW", "C7")

        );

    }

    public static Map<Car, Status> getCurrentStatus(){
        Map<Car, Status> statusMap = new ConcurrentHashMap<>();
        statusMap.put(getAllCarDetail().get(0),Status.Available);
        statusMap.put(getAllCarDetail().get(1),Status.Booked);
        statusMap.put(getAllCarDetail().get(2),Status.Running);
        statusMap.put(getAllCarDetail().get(3),Status.Unavailable);
        statusMap.put(getAllCarDetail().get(4),Status.Available);
        statusMap.put(getAllCarDetail().get(5),Status.Available);
        statusMap.put(getAllCarDetail().get(6),Status.Available);
        statusMap.put(getAllCarDetail().get(7),Status.Available);
        statusMap.put(getAllCarDetail().get(8),Status.Available);
        statusMap.put(getAllCarDetail().get(9),Status.Available);

        return statusMap;
    }

    public static Map<Car, Integer> getCurrentDistanceFromSource(){
        Map<Car, Integer> distanceMap = new HashMap<>();
        distanceMap.put(getAllCarDetail().get(0),30);
        distanceMap.put(getAllCarDetail().get(1),50);
        distanceMap.put(getAllCarDetail().get(2),30);
        distanceMap.put(getAllCarDetail().get(3),35);
        distanceMap.put(getAllCarDetail().get(4),0);
        distanceMap.put(getAllCarDetail().get(5),25);
        distanceMap.put(getAllCarDetail().get(6),50);
        distanceMap.put(getAllCarDetail().get(7),15);
        distanceMap.put(getAllCarDetail().get(8),25);
        distanceMap.put(getAllCarDetail().get(9),0);

        return distanceMap;
    }
}
