public class Theatre {
    private Seat[][] seats;
    private final int rows = 5; // A–E
    private final int cols = 10; // 1–10

    public Theatre() {
        seats = new Seat[rows][cols];
        initializeSeats();
    }

    private void initializeSeats() {
        for (int row = 0; row < rows; row++) {
            char rowLetter = (char) ('A' + row);
            for (int col = 0; col < cols; col++) {
                String seatId = rowLetter + Integer.toString(col + 1);
                seats[row][col] = new Seat(seatId);
            }
        }
    }

    public void displaySeatingChart() {
        System.out.println("\nSeating Chart:");
        for (int row = 0; row < rows; row++) {
            char rowLabel = (char) ('A' + row);
            System.out.print(rowLabel + " ");
            for (int col = 0; col < cols; col++) {
                System.out.print(seats[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void reserveSeat(String seatId) {
        int[] pos = getSeatPosition(seatId);
        if (pos == null) {
            System.out.println("Invalid seat ID.");
            return;
        }

        Seat seat = seats[pos[0]][pos[1]];
        if (seat.isReserved()) {
            System.out.println("Seat " + seatId + " is already taken.");
            suggestAlternative();
        } else {
            seat.reserve();
            System.out.println("Seat " + seatId + " reserved successfully.");
        }
    }

    public void cancelReservation(String seatId) {
        int[] pos = getSeatPosition(seatId);
        if (pos == null) {
            System.out.println("Invalid seat ID.");
            return;
        }

        Seat seat = seats[pos[0]][pos[1]];
        if (!seat.isReserved()) {
            System.out.println("Seat " + seatId + " is not reserved.");
        } else {
            seat.cancelReservation();
            System.out.println("Reservation for seat " + seatId + " cancelled.");
        }
    }

    private int[] getSeatPosition(String seatId) {
        if (seatId.length() < 2 || seatId.length() > 3)
            return null;

        char rowChar = Character.toUpperCase(seatId.charAt(0));
        int row = rowChar - 'A';

        int col;
        try {
            col = Integer.parseInt(seatId.substring(1)) - 1;
        } catch (NumberFormatException e) {
            return null;
        }

        if (row < 0 || row >= rows || col < 0 || col >= cols)
            return null;

        return new int[]{row, col};
    }

    private void suggestAlternative() {
        System.out.println("Suggested available seats:");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!seats[row][col].isReserved()) {
                    System.out.println("- " + seats[row][col].getSeatId());
                    return; // Only suggest one seat for now
                }
            }
        }
        System.out.println("No available seats left.");
    }
}
