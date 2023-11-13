package org.example;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;


    //a constructor instantiate
    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public int getNumberOfBeds() {
        return this.numberOfBeds;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }

    public boolean isDirty() {
        return this.isDirty();
    }
  public boolean isAvailable(){
        if(this.isOccupied == false && this.isDirty == false) {
            return true;
        }
        else{
            return false;
        }
        //return !isOccupied && !isDirty
  }

  //custom methods
    public void checkIn(){
        if(isAvailable()){
            this.isDirty = false;
            this.isOccupied = false;
            System.out.println("Thank you for checking in!");
        }
        else {
            System.out.println("Cannot check you in sorry");
        }
    }

    public void checkOut(){
        if(isOccupied){
            this.isOccupied = true;
            System.out.println("Checked out!");
        }
    }

    public void cleanRoom(){
        if(!isOccupied && isDirty){
            this.isOccupied = false;
            this.isDirty = true;
            System.out.println("Room currently getting cleaned!");
        }
    }
}

