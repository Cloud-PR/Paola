package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    public void checkIn_IsNotOccupied_IsNotDirty(){
        //three stages of a unit test:
        //ARRANGE
        Room room = new Room(2, 10.5, false, false);

        //ACT
        room.checkIn();

        //Assert
        //expect it to be occupied and we expect it to be dirty
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
    }

    @Test
    public void checkOut() {
        Room room = new Room(2,100, true, true);
        room.checkOut();
        assertFalse(room.isOccupied());
    }
    @Test
    public void checkIn_RoomNotReady_CheckInFails(){
        Room room = new Room(3, 200, true, false);
        Room room2 = new Room(3, 200, true, true);
        Room room3 = new Room(4, 200,false,true);

        room.checkIn();
        room2.checkIn();
        room3.checkIn();

        assertTrue(room.isOccupied());
        assertFalse(room.isDirty());

        assertTrue(room2.isOccupied());
        assertTrue(room2.isDirty());

        assertFalse(room3.isOccupied());
        assertTrue(room3.isDirty());


    }

}