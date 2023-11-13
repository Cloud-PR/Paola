package org.example;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    private static ArrayList<Transactions> transactions = new ArrayList<>();
    private static ArrayList<AddDeposit> deposits = new ArrayList<>();
    private static ArrayList<MakePayment> payments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            boolean entry = false;

            while (!entry) {
                System.out.println("Hi! Welcome to your Accounting Ledger App!");
                System.out.println("Please enter one of the following:");
                System.out.println("1. Add Deposit");
                System.out.println("2. Make Payment (Debit)");
                System.out.println("3. View Ledger");
                System.out.println("4. Exit the app");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addDeposit(scanner);
                        break;
                    case 2:
                        makePayment(scanner);
                        break;
                    case 3:
                        Ledger.displayLedger(scanner);
                        break;
                    case 4:
                        System.out.println("Goodbye! Have a great day.");
                        entry = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");


                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Please choose: 1, 2, 3, or 4.");
        }
    }


    public static void addDeposit(Scanner scanner) {
        try{
            System.out.println("Enter description of deposit: ");
            String description = scanner.nextLine();
            System.out.println("Enter Vendor: ");
            String vendor = scanner.nextLine();
            System.out.println("Enter Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            AddDeposit deposit = new AddDeposit(LocalDateTime.now(), description, vendor, amount);
            deposits.add(deposit);
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
            fileWriter.write(deposit.getDateTime() + "|" + description + "|" + vendor + "|" + amount + "\n");
            fileWriter.close();
            System.out.println("Deposit successfully saved.");
        } catch(IOException exception) {
            System.out.println("Error occurred.");
        }
        }
public static void makePayment(Scanner scanner){
        try{
            System.out.println("Enter description of payment: ");
            String description = scanner.nextLine();
            System.out.println("Enter Vendor: ");
            String vendor = scanner.nextLine();
            System.out.println("Enter Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            MakePayment payment = new MakePayment(LocalDateTime.now(), description, vendor, amount);
            payments.add(payment);
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
            fileWriter.write(payment.getDateTime() + "|" + description + "|" + vendor + "|" + (-amount) + "\n");
            fileWriter.close();
            System.out.println("Payment successfully saved.");
        } catch (IOException exception) {
            System.out.println("Error occurred while saving the payment information.");

        }
}

}
