package com.github.hoverruan;

import static com.github.hoverruan.ParkingLotTest.parkingLotWithOneParkingPoint;
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
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotWithOneParkingPoint(), parkingLotWithOneParkingPoint());

        parkingBoy.park(new Car());

        assertThat(parkingBoy.hasAvailableParkingPoints(), is(true));
    }

    @Test
    public void shouldRefuseParkRequestIfNoParkingLotHasAvailableParkingPoints() throws NoAvailableParkingPointException {
        ParkingLot parkingLotA = parkingLotWithOneParkingPoint();
        parkingLotA.park(new Car());

        ParkingLot parkingLotB = parkingLotWithOneParkingPoint();
        parkingLotB.park(new Car());

        ParkingBoy parkingBoy = new ParkingBoy(parkingLotA, parkingLotB);

        assertThat(parkingBoy.hasAvailableParkingPoints(), is(false));
    }

    @Test
    public void shouldReturnParkingTicketIfCouldPark() throws NoAvailableParkingPointException {
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotWithOneParkingPoint(), parkingLotWithOneParkingPoint());

        ParkingTicket ticket = parkingBoy.park(new Car());
        assertThat(ticket, is(notNullValue()));
    }
}
