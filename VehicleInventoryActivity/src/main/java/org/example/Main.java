package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[20];

        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101125, "Jeep Wrangler", "Yellow", 30000, 16000);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome, please select what you would like to do.");
        System.out.println("1 - List all vehicles");
        System.out.println("2 - Search by Make/Model");
        System.out.println("3 - Search by price range");
        System.out.println("4 - Search by color");
        System.out.println("5 - Add a vehicle");
        System.out.println("6 - Quit");

        System.out.println("Enter your command from options 1-6:");

       int userInput = scanner.nextInt();
       switch(userInput) {
           case 1:
               listAllVehicles(vehicles);
               break;
           case 2:
               findByMake(vehicles);
               break;
           case 3:
               findByPrice(vehicles);
               break;
           case 4:
               findByColor(vehicles);
               break;
           case 5:
               addAVehicle(vehicles);
               break;
           case 6:
               System.out.println("Goodbye.");
               break;
           default:
               System.out.println("Not a valid option. Please enter a digit between 1-6.");
       }
    }

    public static void listAllVehicles(Vehicle[] vehicles){
        for (Vehicle v : vehicles){
            if (v !=null){
                System.out.printf("ID: %d, Make/Model: %s, Color: %s, Odometer: %d, Price: %.2f%n", v.getVehicleId(), v.getMakeModel(), v.getColor(), v.getOdometerReading(), v.getPrice());

            }
        }
    }
    public static void findByMake(Vehicle[] make){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the make/model you are searching for:");
        String vehMakeModel = scanner.nextLine();

        boolean num = true;
        for (Vehicle v : make){
            if (v != null && v.getMakeModel().equalsIgnoreCase(vehMakeModel)){
                System.out.printf("ID: %d, Make/Model: %s, Color: %s, Odometer: %d, Price: %.2f%n", v.getVehicleId(), v.getMakeModel(), v.getColor(), v.getOdometerReading(), v.getPrice());
                num = false;
            }
        }
        if (num) {
            System.out.println("Im sorry, this is not available at the moment.");
        }
    }
    public static void findByPrice(Vehicle[] price){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the MIN price you're searching for:");
        double min = scanner.nextDouble();
        System.out.println("Now enter MAX price:");
        double max = scanner.nextDouble();

        boolean num = true;
        for(Vehicle v : price){
            if (v != null && v.getPrice() >= min && v.getPrice() <= max){
                System.out.printf("ID: %d, Make/Model: %s, Color: %s, Odometer: %d, Price: %.2f%n", v.getVehicleId(), v.getMakeModel(), v.getColor(), v.getOdometerReading(), v.getPrice());
                num = false;
            }
        }
        if (num){
            System.out.println("Im sorry, this is not available at the moment.");
        }
    }

    public static void findByColor(Vehicle[] color){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the color desired:");
        String desiredColor = scanner.nextLine();

        boolean num = true;

        for (Vehicle v : color) {
            if (v != null && v.getColor().equalsIgnoreCase(desiredColor)){
                System.out.printf("ID: %d, Make/Model: %s, Color: %s, Odometer: %d, Price: %.2f%n", v.getVehicleId(), v.getMakeModel(), v.getColor(), v.getOdometerReading(), v.getPrice());
                num = false;
            }
        }
        if (num){
            System.out.println("Im sorry, this is not available at the moment.");
        }
    }


    public static void addAVehicle(Vehicle[] addAVehicle){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter vehicle ID: ");
        int vehID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Make/Model: ");
        String vehMM = scanner.nextLine();

        System.out.println("Enter Color: ");
        String vehColor = scanner.nextLine();

        System.out.println("Enter Mileage: ");
        int vehMileage = scanner.nextInt();

        System.out.println("Enter Price: ");
        float price = scanner.nextFloat();

        Vehicle newVehicle = new Vehicle(vehID, vehMM, vehColor, vehMileage, price);

        for (int i = 0; i < addAVehicle.length; i++){
            if (addAVehicle[i] == null) {
                addAVehicle[i] = newVehicle;
                System.out.println("Vehicle has been added");
                System.out.printf("Vehicle ID: %d, Make/Model: %s, Color: %s, Mileage: %d, Price: %.2f%n", newVehicle.getVehicleId(), newVehicle.getMakeModel(), newVehicle.getColor(), newVehicle.getOdometerReading(), newVehicle.getPrice());
                return;

            }

        }
    }


}