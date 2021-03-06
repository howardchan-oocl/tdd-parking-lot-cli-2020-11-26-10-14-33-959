package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private Map<Ticket, Car> ticketCarMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        ticketCarMap = new HashMap<>();
    }

    public Ticket park(Car car) throws NotEnoughPositionException {
        if (capacity - ticketCarMap.size() <= 0) {
            throw new NotEnoughPositionException();
        }
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }

    public Car fetch(Ticket ticket) throws UnrecognizedParkingTicketException {
        if (!IsTicketValid(ticket)) {
            throw new UnrecognizedParkingTicketException();
        }
        return ticketCarMap.remove(ticket);
    }

    public int getRemainSpace() {
        return capacity - ticketCarMap.size();
    }

    public boolean IsTicketValid(Ticket ticket) {
        return ticketCarMap.containsKey(ticket);
    }

    public double getAvailablePositionRate() {
        if (capacity == 0)
            return 0;
        return (double) getRemainSpace() / capacity;
    }
}
