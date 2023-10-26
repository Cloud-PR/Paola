package org.example;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MakePayment {
    public static void makePayment(Scanner scanner) {
    }
    private LocalDateTime dateTime;
    private String description;
    private String vendor;
    private double amount;

    public MakePayment(LocalDateTime dateTime, String description, String vendor, double amount) {
        this.dateTime = dateTime;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toString(){
        return "Date: " + dateTime.toLocalDate() +
                " | Time: " + dateTime.toLocalTime() +
                " | Description: " + description +
                " | Vendor: " + vendor +
                " | Amount: " + amount;
    }
}


