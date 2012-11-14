package com.github.hoverruan;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
        assertTrue(true);
    }

    @Test
    public void shouldDecreaseTheAvailableParkingLotBy1WhenOneCarLeft() {
        // given
        int origAvailable = 100;

        ParkingLot parkingLot = new ParkingLot(origAvailable);
        Car car = new Car();

        // when
        parkingLot.park(car);

        // then
        assertThat(parkingLot.getAvailableParkingPoints(), is(origAvailable - 1));
    }
}
