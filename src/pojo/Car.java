package pojo;

import java.util.Objects;

public class Car {

    private int carId;
    private String chasis;
    private String make;
    private String model;

    public Car(int carId, String chasis, String make, String model) {
        this.carId = carId;
        this.chasis = chasis;
        this.make = make;
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getCarId() == car.getCarId() &&
                Objects.equals(getChasis(), car.getChasis()) &&
                Objects.equals(getMake(), car.getMake()) &&
                Objects.equals(getModel(), car.getModel());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCarId(), getChasis(), getMake(), getModel());
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("pojo.Car{");
        sb.append("carId=").append(carId);
        sb.append(", chasis='").append(chasis).append('\'');
        sb.append(", make='").append(make).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
