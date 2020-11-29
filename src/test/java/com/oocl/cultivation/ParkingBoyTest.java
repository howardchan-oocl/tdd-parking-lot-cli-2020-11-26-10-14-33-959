package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_call_park_of_parking_lot_given_parkingLot_with_capacity() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy packingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        Ticket ticket = packingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_tickets_when_park_multiple_car_given_parkingLot_with_capacity() throws NotEnoughPositionException {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy packingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();

        //when
        Ticket tickets1 = packingBoy.park(car1);
        Ticket tickets2 = packingBoy.park(car2);

        //then
        assertNotNull(tickets1);
        assertNotNull(tickets2);
    }

    @Test
    void should_throw_not_enough_position_exception_when_park_a_car_given_parkingLot_with_not_enough_capacity() {
        //given
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingBoy packingBoy = new ParkingBoy(parkingLot);

        //when
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> packingBoy.park(new Car()));

        //then
        assertEquals("Not Enough Position", notEnoughPositionException.getMessage());
    }

    @Test
    void should_throw_Unrecognized_parking_ticket_exception_when_fetch_a_car_given_a_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingBoy packingBoy = new ParkingBoy(parkingLot);

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> packingBoy.fetch(new Ticket()));

        //then
        assertEquals("Unrecognized Parking Ticket", unrecognizedParkingTicketException.getMessage());
    }
}
