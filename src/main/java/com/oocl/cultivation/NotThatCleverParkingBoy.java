package com.oocl.cultivation;

import java.util.List;

public class NotThatCleverParkingBoy {
    public final List<ParkingLot> parkingLots;

    public NotThatCleverParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        return parkingLots.stream().filter(parkingLot -> parkingLot.getRemainSpace() > 0).findFirst().orElseThrow(NotEnoughPositionException::new).park(car);
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        return parkingLots.stream().filter(parkingLot -> parkingLot.IsTicketValid(ticket)).findFirst().orElseThrow(UnrecognizedParkingTicketException::new).fetch(ticket);
    }

    public boolean canPark() {
        ParkingLot parkingLot = parkingLots.stream().filter(p -> p.getRemainSpace() > 0).findFirst().orElse(null);
        return parkingLot != null;
    }

    public boolean canFetch(Ticket ticket) {
        ParkingLot parkingLot = parkingLots.stream().filter(p -> p.IsTicketValid(ticket)).findFirst().orElse(null);
        return parkingLot != null;
    }
}
