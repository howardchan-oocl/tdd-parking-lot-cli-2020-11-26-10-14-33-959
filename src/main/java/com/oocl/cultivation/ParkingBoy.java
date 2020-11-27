package com.oocl.cultivation;

public class ParkingBoy {
    private final PackingLot packingLot;

    public ParkingBoy(PackingLot packingLot) {
        this.packingLot = packingLot;
    }

    public Ticket park(Car car) {
        return packingLot.park(car);
    }
}
