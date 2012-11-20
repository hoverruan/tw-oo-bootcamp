package com.github.hoverruan;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * @author Hover Ruan
 */
public class ParkingBoyTest {
    @Test
    public void couldParkIfAnyParkingLotHasAvailableParkingPoints() throws NoAvailableParkingPointException {
        int totalParkingPointsPerParkingLot = 1;
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(totalParkingPointsPerParkingLot),
                new ParkingLot(totalParkingPointsPerParkingLot));

        parkingBoy.park(new Car());

        assertThat(parkingBoy.hasAvailableParkingPoints(), is(true));
    }

    @Test
    public void shouldRefuseParkRequestIfNoParkingLotHasAvailableParkingPoints() throws NoAvailableParkingPointException {
        int totalParkingPointsPerParkingLot = 1;

        ParkingLot parkingLotA = new ParkingLot(totalParkingPointsPerParkingLot);
        parkingLotA.park(new Car());

        ParkingLot parkingLotB = new ParkingLot(totalParkingPointsPerParkingLot);
        parkingLotB.park(new Car());

        ParkingBoy parkingBoy = new ParkingBoy(parkingLotA, parkingLotB);

        assertThat(parkingBoy.hasAvailableParkingPoints(), is(false));
    }

    @Test
    public void shouldReturnParkingTicketIfCouldPark() throws NoAvailableParkingPointException {
        int totalParkingPointsPerParkingLot = 1;

        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(totalParkingPointsPerParkingLot), new ParkingLot(totalParkingPointsPerParkingLot));

        ParkingTicket ticket = parkingBoy.park(new Car());
        assertThat(ticket, is(notNullValue()));
    }
}
