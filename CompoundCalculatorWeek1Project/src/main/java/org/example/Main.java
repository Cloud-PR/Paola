//Create scanner
//sout-ask user to input their deposit using nextDouble
//sout-ask user to input their interest rate using nextDouble
//sout-ask user to input the # of years using nextInt
//next we are going to Calculate the daily
//interest rate (r) by dividing the annual interest rate by
//365 (days of the year since it is daily compound)
//Next, using the equation FV = P(1 + r/n)^(n*t)
//we will be finding the future value of their deposit.
//FV-future value P-initial deposit amnt r-annual interest rate(decimal form)
//n-# of times the interest is compounded/yr
//t-# of yrs money is invested
//Next, I will calculate the total int earned using FV - P
//Finally, my calculator should output the future value and total int

package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Compound Calculator! Please begin by entering your deposit amount.");
        double initialDeposit = scanner.nextDouble();

        System.out.println("Thank you, please enter your annual interest rate.");
        double annualIntRate = scanner.nextDouble();

        System.out.println("Great! Now enter the number of years the money would be invested for.");
        int yearsInvested = scanner.nextInt();

        //divided by 365 (days of yr) then again by 100 to get it in decimal form
        double intRate = annualIntRate / 365 / 100;
        double daysLength = yearsInvested * 365;

        //equation created using math pow: FV = P(1 + r/n)^(n*t)
        double futureValue = initialDeposit * Math.pow(1 + intRate, daysLength);
        double totalInterest = futureValue - initialDeposit;

        System.out.printf("The future value of the item: $%.2f\n", futureValue);
        System.out.printf("Total interest of: $%.2f\n", totalInterest);

    }


}
