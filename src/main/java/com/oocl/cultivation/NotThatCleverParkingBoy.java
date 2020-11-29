package com.oocl.cultivation;

import java.util.List;

public class NotThatCleverParkingBoy {
    private final List<ParkingLot> parkingLots;

    public NotThatCleverParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        //return packingLot.park(car);
        return null;
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        //return packingLot.fetch(ticket);
        return null;
    }
}
