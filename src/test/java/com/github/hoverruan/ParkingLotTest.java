package com.github.hoverruan;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    private static final int TOTAL_PARKING_POINTS = 100;

    private ParkingLot parkingLot;

    @Before
    public void setUp() {
        parkingLot = new ParkingLot(TOTAL_PARKING_POINTS);
    }

    @Test
    public void shouldDecreaseTheAvailableParkingLotByOneWhenOneCarLeft() throws NoAvailableParkingPointException {
        parkingLot.park(new Car());

        assertThat(parkingLot.getAvailableParkingPoints(), is(TOTAL_PARKING_POINTS - 1));
    }

    @Test
    public void shouldRefuseIfNoAvailableParkingPointLeft() throws NoAvailableParkingPointException {
        parkingLot = zeroParkingLot();

        assertThat(parkingLot.hasAvailableParkingPoints(), is(false));
    }

    @Test
    public void shouldIncreaseTheAvailableParkingLotByOneWhenOneCarEnter() throws NoAvailableParkingPointException {
        parkingLot.park(new Car());

        assertThat(parkingLot.getAvailableParkingPoints(), is(TOTAL_PARKING_POINTS - 1));

        parkingLot.pick(new Car());

        assertThat(parkingLot.getAvailableParkingPoints(), is(TOTAL_PARKING_POINTS));
    }

    static ParkingLot singleParkingLot() {
        return new ParkingLot(1);
    }

    static ParkingLot zeroParkingLot() {
        return new ParkingLot(0);
    }
}
