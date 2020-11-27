package com.oocl.cultivation;

import java.util.List;

public class ParkingBoy {
    private final PackingLot packingLot;

    public ParkingBoy(PackingLot packingLot) {
        this.packingLot = packingLot;
    }

    public Ticket park(Car car) {
        return packingLot.park(car);
    }

    public List<Ticket> park(List<Car> Cars) {
        return null;
    }
}
