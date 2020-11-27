package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_call_pack_of_parking_lot_given_parkingLot_with_capacity() {
        //given
        PackingLot packingLot = new PackingLot(1);
        ParkingBoy packingBoy = new ParkingBoy(packingLot);
        Car car = new Car();

        //when
        Ticket ticket = packingBoy.park(car);

        //then
        assertNotNull(ticket);
    }
}
