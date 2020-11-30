package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends NotThatCleverParkingBoy {

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        Ticket ticket;

        ParkingLot parkingLot = parkingLots.stream().reduce(parkingLots.get(0), (a,b)->(a.getRemainSpace()>b.getRemainSpace()?a:b));

        ticket = parkingLot.park(car);

        return ticket;
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        Car car = null;

        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.IsTicketValid(ticket)) {
                car = parkingLot.fetch(ticket);
            }
        }

        if (car == null) {
            throw new UnrecognizedParkingTicketException();
        }

        return car;
    }
}
