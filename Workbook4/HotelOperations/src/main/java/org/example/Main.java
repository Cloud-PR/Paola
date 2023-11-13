package org.example;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //line 7 is an instance of a room vvvv
        Room room = new Room(2, 100, false, false);
        Room room2 = new Room(3, 250, false, false);
        Room room3 = new Room(2, 50, true, false);
        Room room4 = new Room(1, 75, false, true);
        Room room5 = new Room(4, 350, false, false);

        ArrayList<Room> hotelRooms = new ArrayList<>();
        hotelRooms.add(room);
        hotelRooms.add(room2);
        hotelRooms.add(room3);
        hotelRooms.add(room4);
        hotelRooms.add(room5);

        Hotel hotel = new Hotel("Cecil Hotel", "1234 yomommas st", "867-5309", hotelRooms);
        System.out.println("There are " + hotel.getNumberOfAvailableRooms() + " room(s) available");

    }
}