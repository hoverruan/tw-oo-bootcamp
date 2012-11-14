package com.github.hoverruan;

/**
 * @author Hover Ruan
 */
public class ParkingLot {
    private int availableParkingPoints;
    private int totalParkingPoints;

    public ParkingLot(int totalParkingPoints) {
        this.totalParkingPoints = totalParkingPoints;
        this.availableParkingPoints = totalParkingPoints;
    }

    public int getAvailableParkingPoints() {
        return availableParkingPoints;
    }

    public void park(Car car) {
        availableParkingPoints--;
    }
}
