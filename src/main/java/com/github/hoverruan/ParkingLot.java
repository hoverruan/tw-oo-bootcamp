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

    public void setAvailableParkingPoints(int availableParkingPoints) {
        this.availableParkingPoints = availableParkingPoints;
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

    public void unpark(Car car) {
        availableParkingPoints++;
    }
}
