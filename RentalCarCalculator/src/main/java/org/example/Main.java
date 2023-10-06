package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//create scanner
//prompt user to enter date they want to pick up
// # of days of rental needed
//ask if they need an electronic toll tag for 3.95/day (yes/no)
//gps for 2.95/day(yes/no)
//roadside assistance 3.95/day(yes/no)
//users current age
//display should show calculations for basic car rental,
// options cost, underage driver surcharge, and total cost

        Scanner scanner = new Scanner(System.in);


        System.out.println("Hello, what date would you like to pick up?");
        String pickUpDate = scanner.nextLine();

        System.out.println("Number of days desired to rent?");
        int rentalDays = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Would you like to add a toll tag for $3.95/day? (yes/no)");
        String tollTag = scanner.nextLine();
        double tollCost = 0;
        switch (tollTag.toLowerCase()) {
            case "yes":
                tollCost = 3.95 * rentalDays;
                break;
            case "no":
                break;
            default:
                System.out.println("Please choose 'yes' or 'no'.");
                return;

        }


        System.out.println("Would you like to add a GPS for $2.95/day? (yes/no)");
        String userGPS = scanner.nextLine();
        double gpsCost = 0;
        switch (userGPS.toLowerCase()){
            case "yes":
                gpsCost = 2.95 * rentalDays;
                break;
            case "no":
                break;
            default:
                System.out.println("Please choose 'yes' or 'no'.");
                return;

        }



        System.out.println("Would you like to add roadside assistance for $3.95/day? (yes/no)");
        String userRoadside = scanner.nextLine();
        double roadsideCost = 0;
        switch (userRoadside.toLowerCase()){
            case "yes":
                roadsideCost = 3.95 * rentalDays;
                break;
            case "no":
                break;
            default:
                System.out.println("Please chose 'yes' or 'no'.");
                return;
        }


        System.out.println("What is your age? Whole numbers only please. Note: There is a 30% surcharge on the basic car rental for drivers under 25.");
        int userAge = scanner.nextInt();

        double basicCarCost = 29.99 * rentalDays;
        double xtraCosts = tollCost + gpsCost + roadsideCost;

        if (userAge >= 25) {
            System.out.println("Great,thank you.");
        } else if (userAge < 25) {
            basicCarCost *= 1.3;
        }

        double totalCost = basicCarCost + xtraCosts;

        System.out.printf("Your total for today will be: $%.2f", totalCost);


    }
}