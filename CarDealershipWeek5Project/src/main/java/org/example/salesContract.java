package org.example;

import java.time.LocalDate;

public class salesContract extends Contract{
    private boolean isFinanced;
    public salesContract(LocalDate dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced){
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;
    }
    public boolean isFinanced(){
        return isFinanced;
    }
    public double salesTax(){
        return getVehicleSold().getPrice() * 0.05;
    }
    public double recordingFee(){
        return 100;
    }
    public double processingFee(){
        if(getVehicleSold().getPrice()<=10000){
            return 295;
        }
        else{
            return 495;
        }
    }

    //(P-RV)xr / 1-(1+r)^-n
    @Override
    public double getMonthlyPayment(){
        double principal = getVehicleSold().getPrice();
        double monthlyPayment;
        if(isFinanced){
            if(principal >= 10000){
                monthlyPayment = getTotalPrice() / 48; //for 48 mo
            }
            else{
                monthlyPayment = getTotalPrice() / 28; //for 24 mo
            }
        }else{
            return 0; //if theyre paying w/cash w/o finance-NO loan option
        }
        return monthlyPayment;
    }

    @Override
    public double getTotalPrice() {
        double principal = getVehicleSold().getPrice();
        double finalTotalprice;
        if (isFinanced) {
            if (principal >= 10000) {
                double r = 0.0425 / 12; //4.25% for 48 mo if price is 10k or more
                finalTotalprice = (48 * (principal * r * Math.pow(1 + r, 48)) / (Math.pow(1 + r, 48) - 1)) + recordingFee() + processingFee() + salesTax();
            } else {
                double r = 0.0525 / 12; //Otherwise 5.25% for 24 mo
                finalTotalprice = (24 * (principal * r * Math.pow(1 + r, 24)) / (Math.pow(1 + r, 24) - 1)) + recordingFee() + processingFee() + salesTax();
            }
        } else {
            finalTotalprice = principal + recordingFee() + processingFee() + salesTax(); //if buyer is paying cash
        }
        return finalTotalprice;
    }
}








