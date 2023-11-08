package org.example;

import java.io.*;
import java.util.List;
import java.util.Scanner;

//make a file input stream that points to the file that holds my vehicles
//make a scanner to take in the file input stream
//create dealership object
//Loop through the file until there is no more file
//take each row, and use the String.split() method to get your data
//create a vehicle, from the array that String.split() returns
//take the vehicle and add it to the inventoryList of the dealership
//after the loop is finished, return the dealership
public class DealershipFileManager {
    //needs the private keyword
    private DealershipFileManager(){

    }

    //good use of static
    public  static Dealership getDealership(){
        Dealership dealership = new Dealership("Discount Motors", "13579 Odd st.", "817-777-1234");

        try{
            FileInputStream fs = new FileInputStream("src/main/resources/Inventory.csv");
            Scanner scanner = new Scanner(fs);

            scanner.nextLine();
            String input;
            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                String[] dataRow =input.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(dataRow[0]), Integer.parseInt(dataRow[1]), dataRow[2],
                        dataRow[3], dataRow[4], dataRow[5], Integer.parseInt(dataRow[6]), Double.parseDouble(dataRow[7]));
                dealership.addVehicle(vehicle);
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("File not found.");
        }
        return dealership;
    }

    public static void saveDealership(Dealership dealership){
        try
            (FileWriter fw= new FileWriter("src/main/resources/Inventory.csv")) {
                List<Vehicle> vehicles = dealership.getAllVehicles();
                for(Vehicle vehicle : vehicles) {
                    String line = vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getYear() + "|" + vehicle.getColor()
                            + "|" + vehicle.getPrice() + "|" + vehicle.getOdometer() + "|" + vehicle.getVehicleType();
                    fw.write(line);
                    fw.write(System.lineSeparator());
                }
                System.out.println("Dealership info saved successfully.");
            }
            catch(IOException e) {
                System.out.println("Dealership info unable to save.");
                e.printStackTrace();
            }
        }
    }

