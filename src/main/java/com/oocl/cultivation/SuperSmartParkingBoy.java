package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{
    private final List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        Ticket ticket;

        ParkingLot parkingLot = parkingLots.stream().reduce(parkingLots.get(0), (a,b)->(a.getAvailablePositionRate()>b.getAvailablePositionRate())?a:b);

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

        return car;    }
}
