package com.github.hoverruan;

import static com.github.hoverruan.ParkingLotTest.parkingLotWithOnePoints;
import static com.github.hoverruan.ParkingLotTest.parkingLotWithZeroPoints;
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
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotWithOnePoints(), parkingLotWithOnePoints());

        parkingBoy.park(new Car());

        assertThat(parkingBoy.hasAvailableParkingPoints(), is(true));
    }

    @Test
    public void shouldRefuseParkRequestIfNoParkingLotHasAvailableParkingPoints() throws NoAvailableParkingPointException {
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotWithZeroPoints(), parkingLotWithZeroPoints());

        assertThat(parkingBoy.hasAvailableParkingPoints(), is(false));
    }

    @Test
    public void shouldReturnParkingTicketIfCouldPark() throws NoAvailableParkingPointException {
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotWithOnePoints(), parkingLotWithOnePoints());

        ParkingTicket ticket = parkingBoy.park(new Car());
        assertThat(ticket, is(notNullValue()));
    }
}
