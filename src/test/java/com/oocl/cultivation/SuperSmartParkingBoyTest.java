package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest {
    @Test
    void should_return_ticket_that_park_a_car_to_the_parking_lot_with_larger_available_position_rate() throws NotEnoughPositionException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(10);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLot2.park(new Car());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLots);

        //when
        Ticket ticket = superSmartParkingBoy.park(new Car());

        //then
        assertTrue(parkingLot1.IsTicketValid(ticket));
    }
}
