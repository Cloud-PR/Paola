package org.example;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {
    private static ArrayList<Transactions> transactions = new ArrayList<>();
    private static ArrayList<AddDeposit> deposits = new ArrayList<>();
    private static ArrayList<MakePayment> payments = new ArrayList<>();


    public static void displayLedger(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Ledger Page: ");
            System.out.println("Please enter A, D, P, R, or H");
            System.out.println("A-Display all entries");
            System.out.println("D-Display the deposits");
            System.out.println("P-Display the payments");
            System.out.println("R-Run reports");
            System.out.println("H-Return to Home Screen");
            String options = scanner.nextLine().toUpperCase();

            switch (options) {
                case "A":
                    loadTransactions();
                    displayTransactions();
                    break;
                case "D":
                    loadTransactions();
                    displayDeposits();
                    break;
                case "P":
                    loadTransactions();
                    displayPayments();
                    break;
                case "R":
                    Reports.runReports();
                    break;
                case "H":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }


    public static void loadTransactions() {
        transactions.clear();
        deposits.clear();
        payments.clear();

        try (FileInputStream fis = new FileInputStream("src/main/resources/transactions.csv");
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] section = line.split("\\|");

                if (section.length == 4) {
                    LocalDateTime dateTime = LocalDateTime.parse(section[0]);
                    String description = section[1];
                    String vendor = section[2];
                    double amount = Double.parseDouble(section[3]);

                    Transactions transaction = new Transactions(dateTime, description, vendor, amount);

                    if (amount >= 0) {
                        deposits.add(new AddDeposit(dateTime, description, vendor, amount));
                    } else {
                        payments.add(new MakePayment(dateTime, description, vendor, amount));
                    }

                    transactions.add(transaction);
                } else {
                    System.out.println("Error in line: " + line);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        } catch (IOException ex) {
            System.out.println("Error reading file.");
        }
    }


    private static void displayTransactions() {
        System.out.println("All Entries:");
        for (Transactions transaction : transactions) {
            System.out.println(transaction);
        }

    }

    public static void displayDeposits() {
        System.out.println("Deposits:");
        for (AddDeposit deposit : deposits) {
            System.out.println(deposit);
        }
    }

    public static void displayPayments() {
        System.out.println("Payments:");
        for (MakePayment payment : payments) {
            System.out.println(payment);
        }
    }

}

