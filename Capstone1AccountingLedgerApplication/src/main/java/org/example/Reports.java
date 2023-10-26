package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

        public class Reports {
            private static ArrayList<Transactions> transactions = new ArrayList<>();
            private static ArrayList<AddDeposit> deposits = new ArrayList<>();
            private static ArrayList<MakePayment> payments = new ArrayList<>();

            public static void runReports() {
                boolean exit = false;
                Scanner scanner = new Scanner(System.in);

                while (!exit) {
                    System.out.println("Report options to run:");
                    System.out.println("Please enter option 1, 2, 3, 4, 5, 6, or 0");
                    System.out.println("1- Month to date");
                    System.out.println("2- Previous Month");
                    System.out.println("3- Year to Date");
                    System.out.println("4- Previous Year");
                    System.out.println("5- Search by Vendor");
                    System.out.println("6- Custom Search");
                    System.out.println("0- Back to reports page");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {

                        case 1:
                            loadTransactions();
                            runMonthToDate(transactions);
                            break;
                        case 2:
                            loadTransactions();
                            runPreviousMonth(transactions);
                            break;
                        case 3:
                            loadTransactions();
                            runYearToDate(transactions);
                            break;
                        case 4:
                            loadTransactions();
                            runPreviousYear(transactions);
                            break;
                        case 5:
                            loadTransactions();
                            System.out.println("Vendor name:");
                            String vendor = scanner.nextLine();
                            searchByVendor(transactions, vendor);
                            break;
                        case 6:
                            System.out.println("Custom Search:");
                            String search = scanner.nextLine();
                            customSearch(transactions, search);
                            break;
                        case 0:
                            exit = true;
                            break;
                        default:
                            System.out.println("Invalid option please try again.");
                    }
                }
            }

            private static void runMonthToDate(ArrayList<Transactions> transactions) {
                LocalDate currentDate = LocalDate.now();
                int currentMonth = currentDate.getMonthValue();
                int currentYear = currentDate.getYear();

                double totalDeposits = 0;
                double totalPayments = 0;

                for (Transactions transaction : transactions) {
                    LocalDate transactionDate = LocalDate.from(transaction.getDateTime());
                    int transactionMonth = transactionDate.getMonthValue();
                    int transactionYear = transactionDate.getYear();

                    if (transactionMonth == currentMonth && transactionYear == currentYear) {
                        if (transaction.getAmount() > 0) {
                            totalDeposits += transaction.getAmount();
                        } else {
                            totalPayments += Math.abs(transaction.getAmount());
                        }
                    }
                }

                System.out.println("Month to Date Report:");
                System.out.println("Total Deposits: $" + totalDeposits);
                System.out.println("Total Payments: $" + totalPayments);
            }

            public static void runPreviousMonth(ArrayList<Transactions> transactions) {
                LocalDate currentDate = LocalDate.now();
                int currentMonth = currentDate.getMonthValue();
                int currentYear = currentDate.getYear();

                // To calculate previous month and year vvvv
                int previousMonth = (currentMonth - 1 == 0) ? 12 : currentMonth - 1;
                int previousYear = (currentMonth - 1 == 0) ? currentYear - 1 : currentYear;

                double totalDeposits = 0;
                double totalPayments = 0;

                for (Transactions transaction : transactions) {
                    LocalDate transactionDate = LocalDate.from(transaction.getDateTime());
                    int transactionMonth = transactionDate.getMonthValue();
                    int transactionYear = transactionDate.getYear();

                    if (transactionMonth == previousMonth && transactionYear == previousYear) {
                        if (transaction.getAmount() > 0) {
                            totalDeposits += transaction.getAmount();
                        } else {
                            totalPayments += Math.abs(transaction.getAmount());
                        }
                    }
                }

                System.out.println("Previous Month Report:");
                System.out.println("Total Deposits: $" + totalDeposits);
                System.out.println("Total Payments: $" + totalPayments);
            }

            public static void runYearToDate(ArrayList<Transactions> transactions) {
                LocalDate currentDate = LocalDate.now();
                int currentYear = currentDate.getYear();

                double totalDeposits = 0;
                double totalPayments = 0;

                for (Transactions transaction : transactions) {
                    LocalDate transactionDate = LocalDate.from(transaction.getDateTime());
                    int transactionYear = transactionDate.getYear();

                    if (transactionYear == currentYear) {
                        if (transaction.getAmount() > 0) {
                            totalDeposits += transaction.getAmount();
                        } else {
                            totalPayments += Math.abs(transaction.getAmount());
                        }
                    }
                }

                System.out.println("Year to Date Report:");
                System.out.println("Total Deposits: $" + totalDeposits);
                System.out.println("Total Payments: $" + totalPayments);
            }

            public static void runPreviousYear(ArrayList<Transactions> transactions) {
                LocalDate currentDate = LocalDate.now();
                int currentYear = currentDate.getYear();

                // To calculate previous year vvvv
                int previousYear = currentYear - 1;

                double totalDeposits = 0;
                double totalPayments = 0;

                for (Transactions transaction : transactions) {
                    LocalDate transactionDate = LocalDate.from(transaction.getDateTime());
                    int transactionYear = transactionDate.getYear();

                    if (transactionYear == previousYear) {
                        if (transaction.getAmount() > 0) {
                            totalDeposits += transaction.getAmount();
                        } else {
                            totalPayments += Math.abs(transaction.getAmount());
                        }
                    }
                }

                System.out.println("Previous Year Report:");
                System.out.println("Total Deposits: $" + totalDeposits);
                System.out.println("Total Payments: $" + totalPayments);
            }

            public static void searchByVendor(ArrayList<Transactions> transactions, String vendorName) {
                System.out.println("Transactions for Vendor: " + vendorName);
                boolean found = false;

                for (Transactions transaction : transactions) {
                    if (vendorName.equalsIgnoreCase(transaction.getVendor())) {
                        System.out.println(transaction);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No transactions found for the vendor: " + vendorName);
                }
            }

            public static void customSearch(ArrayList<Transactions> transactions, String searchString) {
                System.out.println("Custom Search:");
                System.out.println("Enter search criteria (date, description, vendor, etc.): ");
                String search = searchString.toLowerCase();
                boolean found = false;

                for (Transactions transaction : transactions) {

                    if (transaction.getDescription().toLowerCase().contains(search.toLowerCase()) ||
                            transaction.getVendor().toLowerCase().contains(search.toLowerCase()) ||
                            transaction.getDateTime().toString().contains(search)) {
                        System.out.println(transaction);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No transactions found based on the custom search criteria.");
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
        }









