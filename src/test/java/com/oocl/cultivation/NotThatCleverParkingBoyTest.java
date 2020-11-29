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
}