package com.oocl.cultivation;

import java.util.List;

public class ParkingLotServiceManager extends NotThatCleverParkingBoy{
    private final List<ParkingBoy> parkingBoys;

    public ParkingLotServiceManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
    }

    public Ticket assignParkingBoyToPark(int parkingBoyIndex, Car car) throws NotEnoughPositionException {
        return parkingBoys.get(parkingBoyIndex).park(car);
    }
}
