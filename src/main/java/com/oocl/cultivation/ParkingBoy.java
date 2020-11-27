package com.oocl.cultivation;

public class ParkingBoy {
    private final PackingLot packingLot;

    public ParkingBoy(PackingLot packingLot) {
        this.packingLot = packingLot;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        return packingLot.park(car);
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        return packingLot.fetch(ticket);
    }
}
