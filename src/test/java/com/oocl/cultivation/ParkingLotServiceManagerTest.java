package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotServiceManagerTest {
    @Test
    void should_return_ticket_that_park_a_car_to_second_parking_lot_when_call_park_car_with_full_first_parking_lot() throws NotEnoughPositionException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingLots);
        Car car = new Car();

        //when
        Ticket ticket = parkingLotServiceManager.park(car);

        //then
        assertNotNull(ticket);
    }

    @Test
    void should_throw_NotEnoughPositionException_when_call_park_car_with_no_parking_lot_with_enough_position() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingLots);
        Car car = new Car();

        //when
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> parkingLotServiceManager.park(car));

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
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingLots);
        Car actual = new Car();
        Ticket ticket = parkingLotServiceManager.park(actual);


        //when
        Car expected = parkingLotServiceManager.fetch(ticket);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_throw_UnrecognizedParkingTicketException_that_fetch_a_car_by_an_invalid_ticket() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingLots);

        //when
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLotServiceManager.fetch(new Ticket()));

        //then
        assertEquals("Unrecognized Parking Ticket", unrecognizedParkingTicketException.getMessage());
    }

    @Test
    void should_his_or_her_parkingBoy_do_operation_when_call_his_or_her_parkingBoy_to_do_operation() throws NotEnoughPositionException, UnrecognizedParkingTicketException {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        List<ParkingLot> parkingLots2 = new ArrayList<>();
        ParkingLot parkingLot3 = new ParkingLot(1);
        parkingLots2.add(parkingLot3);
        NotThatCleverParkingBoy notThatCleverParkingBoy = new NotThatCleverParkingBoy(parkingLots2);

        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingLots);
        parkingLotServiceManager.addParkingBoy(notThatCleverParkingBoy);

        //when
        Ticket ticket = parkingLotServiceManager.assignParkingBoyToPark(new Car());
        Car car = parkingLotServiceManager.assignParkingBoyToFetch(ticket);

        //then
        assertNotNull(ticket);
        assertNotNull(car);
    }

    @Test
    void should_throw_exception_when_his_or_her_parkingBoy_fail_to_do_operation() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        List<ParkingLot> parkingLots2 = new ArrayList<>();
        ParkingLot parkingLot3 = new ParkingLot(0);
        parkingLots2.add(parkingLot3);
        NotThatCleverParkingBoy notThatCleverParkingBoy = new NotThatCleverParkingBoy(parkingLots2);

        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingLots);
        parkingLotServiceManager.addParkingBoy(notThatCleverParkingBoy);

        //when
        NotEnoughPositionException notEnoughPositionException = assertThrows(NotEnoughPositionException.class, () -> parkingLotServiceManager.assignParkingBoyToPark(new Car()));

        //then
        assertEquals("Not Enough Position", notEnoughPositionException.getMessage());
    }
}
