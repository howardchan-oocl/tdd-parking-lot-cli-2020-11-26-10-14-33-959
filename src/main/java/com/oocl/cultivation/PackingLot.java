package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class PackingLot {
    private final int capacity;
    private Map<Ticket, Car> ticketCarMap;

    public PackingLot(int capacity) {
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

    public Car fetch(Ticket ticket) {
        return ticketCarMap.remove(ticket);
    }
}
