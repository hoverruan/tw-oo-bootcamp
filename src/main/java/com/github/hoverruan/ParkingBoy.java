package com.github.hoverruan;

/**
 * @author Hover Ruan
 */
public class ParkingBoy {
    private ParkingLot[] parkingLotList;

    public ParkingBoy(ParkingLot... parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket park(Car car) throws NoAvailableParkingPointException {
        for (ParkingLot parkingLot : parkingLotList) {
            try {
                parkingLot.park(car);
                return new ParkingTicket(car);
            } catch (NoAvailableParkingPointException e) {
                // try next
            }
        }

        throw new NoAvailableParkingPointException();
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
