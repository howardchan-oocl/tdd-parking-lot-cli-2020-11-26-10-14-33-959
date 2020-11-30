package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotServiceManager extends NotThatCleverParkingBoy {
    private final List<NotThatCleverParkingBoy> parkingBoys;

    public ParkingLotServiceManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
        parkingBoys = new ArrayList<>();
    }

    public void addParkingBoy(NotThatCleverParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public Ticket assignParkingBoyToPark(Car car) throws NotEnoughPositionException {
        return parkingBoys.stream().filter(NotThatCleverParkingBoy::canPark).findFirst().orElseThrow(NotEnoughPositionException::new).park(car);
    }

    public Car assignParkingBoyToFetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        return parkingBoys.stream().filter(parkingBoy -> parkingBoy.canFetch(ticket)).findFirst().orElseThrow(UnrecognizedParkingTicketException::new).fetch(ticket);
    }
}
