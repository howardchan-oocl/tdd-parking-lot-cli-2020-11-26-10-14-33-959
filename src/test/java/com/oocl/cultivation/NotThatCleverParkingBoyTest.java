package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NotThatCleverParkingBoyTest {
    @Test
    void should_return_ticket_that_park_a_car_to_second_parking_lot_when_call_park_car_with_full_first_parking_lot() throws NotEnoughPositionException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        NotThatCleverParkingBoy notThatCleverParkingBoy = new NotThatCleverParkingBoy(parkingLots);
        Car car = new Car();

        //when
        Ticket ticket = notThatCleverParkingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_throw_NotEnoughPositionException_when_call_park_car_with_no_parking_lot_with_enough_position() throws NotEnoughPositionException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        NotThatCleverParkingBoy notThatCleverParkingBoy = new NotThatCleverParkingBoy(parkingLots);
        Car car = new Car();

        //when
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> notThatCleverParkingBoy.park(car));

        //then
        assertEquals("Not Enough Position", notEnoughPositionException.getMessage());
    }

    @Test
    void should_return_car_that_fetch_a_car_from_second_parking_lot_when_call_fetch_car_that_parked_in_second_parking_Lot() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        NotThatCleverParkingBoy notThatCleverParkingBoy = new NotThatCleverParkingBoy(parkingLots);
        Car actual = new Car();
        Ticket ticket = notThatCleverParkingBoy.park(actual);


        //when
        Car expected = notThatCleverParkingBoy.fetch(ticket);

        //then
        assertEquals(expected,actual);
    }
}
