package pojo;

import pojo.Car;

import java.util.Date;

public class RentalRequest {

    private Date startTime;
    private Date endTime;
    private Car car;
    private RequestType requestType;

    public RentalRequest(){}

    public RentalRequest(Date startTime, Date endTime, Car car, RequestType requestType) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.car = car;
        this.requestType = requestType;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("pojo.RentalRequest{");
        sb.append("startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", car=").append(car);
        sb.append(", requestType=").append(requestType);
        sb.append('}');
        return sb.toString();
    }
}
