package com.oocl.cultivation;

import java.util.List;

public class ParkingLotServiceManager extends NotThatCleverParkingBoy {
    private final List<NotThatCleverParkingBoy> notThatCleverParkingBoys;

    public ParkingLotServiceManager(List<ParkingLot> parkingLots, List<NotThatCleverParkingBoy> notThatCleverParkingBoys) {
        super(parkingLots);
        this.notThatCleverParkingBoys = notThatCleverParkingBoys;
    }

    //todo remove index and let manager get the first boy to do operation
    public Ticket assignParkingBoyToPark(int parkingBoyIndex, Car car) throws NotEnoughPositionException {
        return notThatCleverParkingBoys.get(parkingBoyIndex).park(car);
    }

    public Car assignParkingBoyToFetch(int parkingBoyIndex, Ticket ticket) throws UnrecognizedParkingTicketException {
        return notThatCleverParkingBoys.get(parkingBoyIndex).fetch(ticket);
    }
}
