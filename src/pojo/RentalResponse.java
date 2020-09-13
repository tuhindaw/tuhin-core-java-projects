package pojo;

import pojo.BillDetail;
import pojo.Car;

public class RentalResponse {

    private Status status;
    private Car car;
    private int currentDistanceFromSource;
    private String message;
    private BillDetail billDetail;

    public RentalResponse(){}

    public RentalResponse(Status status, Car car, String message) {
        this.status = status;
        this.car = car;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getCurrentDistanceFromSource() {
        return currentDistanceFromSource;
    }

    public void setCurrentDistanceFromSource(int currentDistanceFromSource) {
        this.currentDistanceFromSource = currentDistanceFromSource;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BillDetail getBillDetail() {
        return billDetail;
    }

    public void setBillDetail(BillDetail billDetail) {
        this.billDetail = billDetail;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("pojo.RentalResponse{");
        sb.append("status=").append(status);
        sb.append(", car=").append(car);
        sb.append(", currentDistanceFromSource=").append(currentDistanceFromSource);
        sb.append(", message='").append(message).append('\'');
        sb.append(", billDetail=").append(billDetail);
        sb.append('}');
        return sb.toString();
    }
}
