package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
    @Test
    void should_return_ticket_when_pack_a_car_given_parkingLot_with_capacity() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        //when
        Ticket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_null_when_pack_a_car_given_parkingLot_with_not_enough_capacity() {
        //given
        ParkingLot parkingLot = new ParkingLot(0);

        //when
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> parkingLot.park(new Car()));

        //then
        assertEquals("Not Enough Position", notEnoughPositionException.getMessage());
    }

    @Test
    void should_return_car_when_fetch_a_car_given_a_non_used_ticket_and_parkingLot_with_that_car() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car actual = new Car();
        Ticket ticket = parkingLot.park(actual);

        //when
        Car expected = parkingLot.fetch(ticket);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_return_null_when_fetch_a_car_given_a_wrong_ticket_and_parkingLot_with_that_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = new Ticket();

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(new Ticket()));

        //then
        assertEquals("Unrecognized Parking Ticket", unrecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_return_null_when_fetch_a_car_given_a_used_ticket_and_parkingLot_with_that_car() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);


        //when
        Car expected = parkingLot.fetch(ticket);
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(new Ticket()));


        //then
        assertEquals("Unrecognized Parking Ticket", unrecognizedParkingTicketException.getMessage());
    }
}

