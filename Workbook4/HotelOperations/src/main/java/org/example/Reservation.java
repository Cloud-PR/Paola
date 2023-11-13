package org.example;

public class Reservation {

    private RoomType roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(RoomType roomType, int numberOfNights, boolean isWeekend){
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    
    /*
    the room type can be either king or double. if the room type is
    king the price per night is 139 if its double the price is 124.
    */

    public double getPrice(){
        if(this.roomType == RoomType.King){
            return 139;
        }
        else {
            return 124;
        }

    }

    public int getNumberOfNights(){
        return this.numberOfNights;
    }
    public void setNumberOfNights(int numberOfNights){
        this.numberOfNights = numberOfNights;
    }
    public boolean isWeekend(){
        return this.isWeekend;
    }

    public void setIsWeekend(boolean isWeekend){
        this.isWeekend = isWeekend;
    }
}
