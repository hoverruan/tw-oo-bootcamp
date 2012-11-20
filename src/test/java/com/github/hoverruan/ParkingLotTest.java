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
    public void shouldDecreaseTheAvailableParkingLotBy1WhenOneCarLeft() throws NoAvailableParkingPointException {
        // given

        // when
        parkingLot.park(new Car());

        // then
        assertThat(parkingLot.getAvailableParkingPoints(), is(TOTAL_PARKING_POINTS - 1));
    }

    @Test
    public void shouldRefuseIfNoAvailableParkingPointLeft() throws NoAvailableParkingPointException {
        // given
        parkingLot = parkingLotWithOneParkingPoint();
        parkingLot.park(new Car());

        // then
        assertThat(parkingLot.hasAvailableParkingPoints(), is(false));
    }

    @Test
    public void shouldIncreaseTheAvailableParkingLotBy1WhenOneCarEnter() throws NoAvailableParkingPointException {
        // given
        parkingLot.park(new Car());

        // when
        parkingLot.pick(new Car());

        // then
        assertThat(parkingLot.getAvailableParkingPoints(), is(TOTAL_PARKING_POINTS));
    }

    static ParkingLot parkingLotWithOneParkingPoint() {
        return new ParkingLot(1);
    }
}
