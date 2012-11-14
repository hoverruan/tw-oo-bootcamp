package com.github.hoverruan;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ParkingLot parkingLot;
    private int totalParkingPoints;

    /**
     * Rigourous Test :-)
     */
    @Before
    public void setUp() {
        totalParkingPoints = 100;
        parkingLot = new ParkingLot(totalParkingPoints);
    }

    @Test
    public void shouldDecreaseTheAvailableParkingLotBy1WhenOneCarLeft() throws NoAvailableParkingPointException {
        // given

        // when
        parkingLot.park(new Car());

        // then
        assertThat(parkingLot.getAvailableParkingPoints(), is(totalParkingPoints - 1));
    }

    @Test(expected = NoAvailableParkingPointException.class)
    public void shouldRefuseIfNoAvailableParkingPointLeft() throws NoAvailableParkingPointException {
        // given
        parkingLot.setAvailableParkingPoints(0);

        // when
        parkingLot.park(new Car());
    }

    @Test
    public void shouldIncreaseTheAvailableParkingLotBy1WhenOneCarEnter() {
        // given
        parkingLot.setAvailableParkingPoints(totalParkingPoints - 1);

        // when
        parkingLot.unpark(new Car());

        // then
        assertThat(parkingLot.getAvailableParkingPoints(), is(totalParkingPoints));
    }
}
