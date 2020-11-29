package com.oocl.cultivation;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        return parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        return parkingLot.fetch(ticket);
    }
}
