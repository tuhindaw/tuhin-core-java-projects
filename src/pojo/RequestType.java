package pojo;

public enum RequestType {

    Booking(RentalConstants.REQUEST_BOOKING),
    Cancel(RentalConstants.REQUEST_CANCEL),
    Drop(RentalConstants.REQUEST_DROP);

    private final String requestStatus;

    RequestType(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}
