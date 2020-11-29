package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy {
    private final List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        Ticket ticket;

        ParkingLot parkingLot = parkingLots.stream().reduce(parkingLots.get(0), (a,b)->(a.getRemainSpace()>b.getRemainSpace()?a:b));

        ticket = parkingLot.park(car);

        return ticket;
    }

    public Car fetch(Ticket ticket) {
        return null;
    }
}
