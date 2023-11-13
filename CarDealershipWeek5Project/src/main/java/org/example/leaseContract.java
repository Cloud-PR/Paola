package org.example;

import java.time.LocalDate;

public class leaseContract extends Contract{
    public leaseContract(LocalDate dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double expectedEndingValue){
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    public double expectedEndingValue(){
        return getVehicleSold().getPrice() * .50;
    }
    public double leaseFee(){
        return getVehicleSold().getPrice()* .07;
    }
    @Override
    public double getTotalPrice(){
        return getMonthlyPayment() * 36;
    }

    @Override
    public double getMonthlyPayment() {
        return (getVehicleSold().getPrice() - expectedEndingValue()) / 36 + ((getVehicleSold().getPrice() + expectedEndingValue()) * (4/2400));
    }
}
