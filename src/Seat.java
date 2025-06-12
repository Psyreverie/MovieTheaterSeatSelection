public class Seat {
    private String seatId;
    private boolean isReserved;

    public Seat(String seatId) {
        this.seatId = seatId;
        this.isReserved = false;
    }

    public String getSeatId() {
        return seatId;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        isReserved = true;
    }

    public void cancelReservation() {
        isReserved = false;
    }

    @Override
    public String toString() {
        return isReserved ? "[X]" : "[ ]";
    }
}
