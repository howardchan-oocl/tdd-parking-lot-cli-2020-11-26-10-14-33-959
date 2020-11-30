package com.oocl.cultivation;

import java.util.List;

public class NotThatCleverParkingBoy {
    public final List<ParkingLot> parkingLots;

    public NotThatCleverParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getRemainSpace() > 0) {
                Ticket ticket = parkingLot.park(car);
                if (ticket != null)
                    return ticket;
            }
        }

        throw new NotEnoughPositionException();
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.IsTicketValid(ticket)) {
                return parkingLot.fetch(ticket);

            }
        }

        throw new UnrecognizedParkingTicketException();
    }
}
