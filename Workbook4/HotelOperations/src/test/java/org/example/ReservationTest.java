package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    public void getPrice_KingSize_IsCorrect(){
        //three stages of a unit test:
        //ARRANGE
        Reservation newReservation = new Reservation(RoomType.King, 2, false);

        //ACT-where we run the test
        double testPrice = newReservation.getPrice();

        //ASSERT
        //compare what i got to what i expect
        assertEquals(139, testPrice);
    }
    @Test
    public void getPrice_Doublesize_IsCorrect(){
        Reservation newReservation = new Reservation(RoomType.DOUBLE, 2, true);
        double testPrice = newReservation.getPrice();
        assertEquals(124, testPrice);
    }

}