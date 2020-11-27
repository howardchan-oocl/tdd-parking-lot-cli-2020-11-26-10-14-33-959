package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    private final PackingLot packingLot;

    public ParkingBoy(PackingLot packingLot) {
        this.packingLot = packingLot;
    }

    public Ticket park(Car car) {
        return packingLot.park(car);
    }

    public List<Ticket> park(List<Car> cars) {
        return cars.stream().map(this::park).collect(Collectors.toList());
    }
}
