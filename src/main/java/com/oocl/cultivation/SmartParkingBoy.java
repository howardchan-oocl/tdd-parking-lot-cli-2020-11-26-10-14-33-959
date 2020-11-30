package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends NotThatCleverParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        ParkingLot parkingLot = parkingLots.stream().reduce(parkingLots.get(0), (a, b) -> (a.getRemainSpace() > b.getRemainSpace() ? a : b));

        return parkingLot.park(car);
    }

    public boolean canPark() {
        ParkingLot parkingLot = parkingLots.stream().reduce(parkingLots.get(0), (a, b) -> (a.getRemainSpace() > b.getRemainSpace() ? a : b));
        return parkingLot.getRemainSpace() != 0;
    }
}
