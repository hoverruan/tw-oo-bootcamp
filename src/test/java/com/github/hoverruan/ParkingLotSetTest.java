package com.github.hoverruan;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * @author Hover Ruan
 */
public class ParkingLotSetTest {
    @Test
    public void couldParkIfAnyParkingLotHasAvailableParkingPoints() throws NoAvailableParkingPointException {
        int totalParkingPointsPerParkingLot = 1;
        ParkingLotSet parkingLotSet = new ParkingLotSet(new ParkingLot(totalParkingPointsPerParkingLot),
                new ParkingLot(totalParkingPointsPerParkingLot));

        parkingLotSet.park(new Car());

        assertThat(parkingLotSet.hasAvailableParkingPoints(), is(true));
    }

    @Test
    public void couldParkIfOneParkingLotHasAvailableParkingPoints() throws NoAvailableParkingPointException {
        int totalParkingPointsPerParkingLot = 1;
        ParkingLot parkingLotA = new ParkingLot(totalParkingPointsPerParkingLot);
        parkingLotA.park(new Car());
        ParkingLotSet parkingLotSet = new ParkingLotSet(parkingLotA,
                new ParkingLot(totalParkingPointsPerParkingLot));

        parkingLotSet.park(new Car());

        assertThat(parkingLotSet.hasAvailableParkingPoints(), is(false));
    }
}
