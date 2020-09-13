package pojo;

import pojo.RentalConstants;

public enum Status {

    Available(RentalConstants.STATUS_AVAILABLE),
    Booked(RentalConstants.STATUS_BOOKED),
    Running(RentalConstants.STATUS_RUNNING),
    Unavailable(RentalConstants.STATUS_UNAVAILABLE);

    private final String statusAvailable;

    Status(String statusAvailable) {
        this.statusAvailable = statusAvailable;
    }
}
