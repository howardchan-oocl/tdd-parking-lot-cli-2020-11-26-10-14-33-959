package com.oocl.cultivation;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy() {
        this.parkingLot = null;
    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        if (parkingLot == null)
            return null;
        return parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        if (parkingLot == null)
            return null;
        return parkingLot.fetch(ticket);
    }
}
