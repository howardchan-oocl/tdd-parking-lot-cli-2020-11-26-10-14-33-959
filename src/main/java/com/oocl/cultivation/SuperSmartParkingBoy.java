package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends NotThatCleverParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        ParkingLot parkingLot = parkingLots.stream().reduce(parkingLots.get(0), (a, b) -> (a.getAvailablePositionRate() > b.getAvailablePositionRate()) ? a : b);

        return parkingLot.park(car);
    }

    public boolean canPark() {
        ParkingLot parkingLot = parkingLots.stream().reduce(parkingLots.get(0), (a, b) -> (a.getAvailablePositionRate() > b.getAvailablePositionRate() ? a : b));
        return parkingLot.getRemainSpace() != 0;
    }
}
