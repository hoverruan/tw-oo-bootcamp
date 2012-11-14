package com.github.hoverruan;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private int totalParkingPoints;

    /**
     * Rigourous Test :-)
     */
    @Before
    public void setUp() {
        totalParkingPoints = 100;
    }

    @Test
    public void shouldDecreaseTheAvailableParkingLotBy1WhenOneCarLeft() throws NoAvailableParkingPointException {
        // given
        ParkingLot parkingLot = new ParkingLot(totalParkingPoints);

        // when
        parkingLot.park(new Car());

        // then
        assertThat(parkingLot.getAvailableParkingPoints(), is(totalParkingPoints - 1));
    }

    @Test(expected = NoAvailableParkingPointException.class)
    public void shouldRefuseIfNoAvailableParkingPointLeft() throws NoAvailableParkingPointException {
        // given
        ParkingLot parkingLot = new ParkingLot(totalParkingPoints);
        parkingLot.setAvailableParkingPoints(0);

        // when
        parkingLot.park(new Car());
    }
}
