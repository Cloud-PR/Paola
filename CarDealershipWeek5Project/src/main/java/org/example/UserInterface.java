package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
       this.dealership = DealershipFileManager.getDealership();
    }


    public void displayVehicles() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Welcome to Menu, please enter one of the following options:");
                System.out.println("1. Get Vehicles by Price");
                System.out.println("2. Get Vehicles by Make/Model");
                System.out.println("3. Get Vehicles by Year");
                System.out.println("4. Get Vehicles by Color");
                System.out.println("5. Get Vehicles by Mileage");
                System.out.println("6. Get Vehicles by Type");
                System.out.println("7. Get All Vehicles");
                System.out.println("8. Add Vehicle");
                System.out.println("9. Remove Vehicle");
                System.out.println("99. Quit");

                int userOption = scanner.nextInt();

                switch (userOption) {
                    case 1:
                        processGetByPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequest();
                        break;
                    case 6:
                        processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        processGetAllVehiclesRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    case 99:
                        System.out.println("Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose one of the available options.");
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Please choose one of the numbers.");
            scanner.nextLine();
        } finally {
            scanner.close();
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        System.out.println("List of Vehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private void processGetByPriceRequest() {
        boolean isGettingByPrice = true;

        while (isGettingByPrice) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Minimum price requested?");
                double minPrice = scanner.nextDouble();
                System.out.println("Maximum price requested?");
                double maxPrice = scanner.nextDouble();

                if (minPrice < maxPrice) {
                    System.out.printf("Here's a list of the vehicles requested %d and %d", minPrice, maxPrice);
                    List<Vehicle> vehicleList = dealership.getVehiclesByPrice(minPrice, maxPrice);
                    displayVehicles(vehicleList);
                    isGettingByPrice = false;
                } else {
                    System.out.println("Please enter again");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Enter a number.");
            }
        }
    }
    private void processGetByMakeModelRequest() {
        boolean isGettingByMakeModel = true;

        while (isGettingByMakeModel) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the make:");
                String make = scanner.nextLine();
                System.out.println("Enter the model:");
                String model = scanner.nextLine();

                System.out.printf("Here's a list of the vehicles for make '%s' and model '%s'%n", make, model);
                List<Vehicle> vehicleList = dealership.getVehiclesByMakeModel(make, model);
                displayVehicles(vehicleList);
                isGettingByMakeModel = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private void processGetByYearRequest() {
        boolean isGettingByYear = true;

        while (isGettingByYear) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Minimum year requested?");
                int minYear = scanner.nextInt();
                System.out.println("Maximum year requested?");
                int maxYear = scanner.nextInt();

                if (minYear <= maxYear) {
                    System.out.printf("Here's a list of the vehicles between %d and %d%n", minYear, maxYear);
                    List<Vehicle> vehicleList = dealership.getVehiclesByYear(minYear, maxYear);
                    displayVehicles(vehicleList);
                    isGettingByYear = false;
                } else {
                    System.out.println("Invalid input. Please enter the years again.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void processGetByColorRequest() {
        boolean isGettingByColor = true;

        while (isGettingByColor) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the color:");
                String color = scanner.nextLine();

                System.out.printf("Here's a list of the vehicles with color '%s'%n", color);
                List<Vehicle> vehicleList = dealership.getVehiclesByColor(color);
                displayVehicles(vehicleList);
                isGettingByColor = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private void processGetByMileageRequest() {
        boolean isGettingByMileage = true;

        while (isGettingByMileage) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Minimum mileage requested?");
                double minMileage = scanner.nextDouble();
                System.out.println("Maximum mileage requested?");
                double maxMileage = scanner.nextDouble();

                if (minMileage <= maxMileage) {
                    System.out.printf("Here's a list of the vehicles between %.2f and %.2f miles%n", minMileage, maxMileage);
                    List<Vehicle> vehicleList = dealership.getVehiclesByMileage(minMileage, maxMileage);
                    displayVehicles(vehicleList);
                    isGettingByMileage = false;
                } else {
                    System.out.println("Invalid input. Please enter the mileage again.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void processGetByVehicleTypeRequest() {
        boolean isGettingByType = true;

        while (isGettingByType) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the vehicle type:");
                String type = scanner.nextLine();

                System.out.printf("Here's a list of the vehicles of type '%s'%n", type);
                List<Vehicle> vehicleList = dealership.getVehiclesByType(type);
                displayVehicles(vehicleList);
                isGettingByType = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private void processGetAllVehiclesRequest(){
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }
    private void processAddVehicleRequest(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter VIN:");
            int vin = scanner.nextInt();

            System.out.println("Enter year:");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter make:");
            String make = scanner.nextLine();

            System.out.println("Enter model:");
            String model = scanner.nextLine();

            System.out.println("Enter color:");
            String color = scanner.nextLine();

            System.out.println("Enter vehicle type:");
            String vehicleType = scanner.nextLine();

            System.out.println("Enter odometer:");
            int odometer = scanner.nextInt();

            System.out.println("Enter price:");
            double price = scanner.nextDouble();

            Vehicle newVehicle = new Vehicle(vin, year, make, model, color, vehicleType, odometer, price);
            dealership.addVehicle(newVehicle);
            System.out.println("Vehicle added successfully.");

            DealershipFileManager.saveDealership(dealership);
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input. Please enter the correct information.");
            scanner.nextLine();
        }
    }
    private void processRemoveVehicleRequest() {
        Scanner scanner = new Scanner(System.in);

        try {
            List<Vehicle> vehicles = dealership.getAllVehicles();
            displayVehicles(vehicles);

            System.out.println("Enter the VIN of the vehicle you want to remove:");
            int vinToRemove = scanner.nextInt();
            scanner.nextLine();

            Vehicle vehicleToRemove = null;
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getVin() == vinToRemove) {
                    vehicleToRemove = vehicle;
                    break;
                }
            }
            if (vehicleToRemove != null) {
                dealership.removeVehicle(vehicleToRemove);
                System.out.println("Vehicle removed successfully.");

                DealershipFileManager.saveDealership(dealership);
            } else {
                System.out.println("No vehicle found with the entered VIN.");
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

}


