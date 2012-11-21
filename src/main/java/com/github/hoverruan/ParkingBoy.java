package com.github.hoverruan;

import static ch.lambdaj.Lambda.filter;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static ch.lambdaj.collection.LambdaCollections.with;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;

import java.util.List;

/**
 * @author Hover Ruan
 */
public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(ParkingLot... parkingLotList) {
        this.parkingLotList = asList(parkingLotList);
    }

    public ParkingTicket park(Car car) throws NoAvailableParkingPointException {
        List<ParkingLot> availableParkingLots = getAvailableParkingLots();

        if (!availableParkingLots.isEmpty()) {
            availableParkingLots.get(0).park(car);

            return new ParkingTicket(car);
        }

        throw new NoAvailableParkingPointException();
    }

    public boolean hasAvailableParkingPoints() {
        return !getAvailableParkingLots().isEmpty();
    }

    private List<ParkingLot> getAvailableParkingLots() {
       return with(parkingLotList).retain(having(on(ParkingLot.class).hasAvailableParkingPoints()));
    }
}
