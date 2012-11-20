package com.github.hoverruan;

/**
 * @author Hover Ruan
 */
public class ParkingLot {
    private int availableParkingPoints;

    public ParkingLot(int totalParkingPoints) {
        this.availableParkingPoints = totalParkingPoints;
    }

    public int getAvailableParkingPoints() {
        return availableParkingPoints;
    }

    public void park(Car car) throws NoAvailableParkingPointException {
        if (availableParkingPoints == 0) {
            throw new NoAvailableParkingPointException();
        }
        availableParkingPoints--;
    }

    public void pick(Car car) {
        availableParkingPoints++;
    }

    public boolean hasAvailableParkingPoints() {
        return availableParkingPoints > 0;
    }
}
