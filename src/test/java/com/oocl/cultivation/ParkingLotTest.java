package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void should_return_null_when_pack_a_car_given_parkingLot_with_not_enough_capacity() {
        //given
        PackingLot packingLot = new PackingLot(0);
        Car car = new Car();

        //when
        Ticket ticket = packingLot.park(car);

        //then
        assertNull(ticket);
    }

    @Test
    void should_return_car_when_fetch_a_car_given_a_non_used_ticket_and_parkingLot_with_that_car() {
        //given
        PackingLot packingLot = new PackingLot(1);
        Car actual = new Car();
        Ticket ticket = packingLot.park(actual);

        //when
        Car expected = packingLot.fetch(ticket);

        //then
        assertEquals(expected,actual);
    }
}
