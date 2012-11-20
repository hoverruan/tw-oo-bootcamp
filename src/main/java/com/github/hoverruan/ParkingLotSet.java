package com.github.hoverruan;

/**
 * @author Hover Ruan
 */
public class ParkingLotSet {
    private ParkingLot[] parkingLotList;

    public ParkingLotSet(ParkingLot... parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public void park(Car car) throws NoAvailableParkingPointException {
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.hasAvailableParkingPoints()) {
                parkingLot.park(car);
                return;
            }
        }
    }

    public boolean hasAvailableParkingPoints() {
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.hasAvailableParkingPoints()) {
                return true;
            }
        }

        return false;
    }
}
