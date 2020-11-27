package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingLotTest {
    @Test
    void should_return_ticket_when_pack_a_car_given_parkingLot_with_capacity() {
        //given
        PackingLot packingLot = new PackingLot(1);
        Car car = new Car();

        //when
        Ticket ticket = packingLot.park(car);

        //then
        assertNotNull(ticket);
    }
}
