package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_call_park_of_parking_lot_given_parkingLot_with_capacity() {
        //given
        PackingLot packingLot = new PackingLot(1);
        ParkingBoy packingBoy = new ParkingBoy(packingLot);
        Car car = new Car();

        //when
        Ticket ticket = packingBoy.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_list_of_ticket_when_park_multiple_car_given_parkingLot_with_capacity() {
        //given
        PackingLot packingLot = new PackingLot(2);
        ParkingBoy packingBoy = new ParkingBoy(packingLot);
        List<Car> cars = new ArrayList<>();

        //when
        List<Ticket> ticket = packingBoy.park(cars);

        //then
        assertNotNull(ticket);
    }
}
