package com.oocl.cultivation;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    private final PackingLot packingLot;

    public ParkingBoy(PackingLot packingLot) {
        this.packingLot = packingLot;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        return packingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        return packingLot.fetch(ticket);
    }

//    public List<Ticket> park(List<Car> cars){
//        return cars.stream().map(car -> {park(car)}).collect(Collectors.toList());
//    }
}
