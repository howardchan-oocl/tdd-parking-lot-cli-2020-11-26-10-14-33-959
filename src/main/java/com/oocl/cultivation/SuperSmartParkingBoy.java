package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy {
    private final List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        Ticket ticket;

        ParkingLot parkingLot = parkingLots.stream().reduce(parkingLots.get(0), (a,b)->(a.getAvailablePositionRate()>b.getAvailablePositionRate())?a:b);

        ticket = parkingLot.park(car);

        return ticket;
    }

    public Car fetch(Ticket ticket) {
        return null;
    }
}
