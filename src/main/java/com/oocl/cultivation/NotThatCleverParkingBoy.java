package com.oocl.cultivation;

import java.util.List;

public class NotThatCleverParkingBoy {
    private final List<ParkingLot> parkingLots;

    public NotThatCleverParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        Ticket ticket = null;

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getRemainSpace() > 0) {
                ticket = parkingLot.park(car);
            }
        }

        if (ticket == null) {
            throw new NotEnoughPositionException();
        }

        return ticket;
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        Car car = null;

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.IsTicketValid(ticket)) {
                car = parkingLot.fetch(ticket);
            }
        }

        return car;
    }
}
