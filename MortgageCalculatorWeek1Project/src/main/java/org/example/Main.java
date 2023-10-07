//Create scanner
//sout-ask user to input their principal using nextDouble
//sout-ask user to input their interest rate using nextDouble
//sout-ask user to input their loan length nextInt (since its in #'s)
//next we are going to use users input to calculate the monthly
//interest rate (r) by dividing the annual interest rate by
//12 and then dividing by 100 to convert it to a decimal.
//double monthlyRate = annualrate/100/12;
//next we are going to do the same to calculate #
//of payments
//int numPmnts = loan length(wtvr user inputs) * 12 (represents mo. in a yr)
//next we will be calculating the monthly mortgage
//using the equation M = P[r(1+r)^n] / [(1+r)^n-1] (using math pow)
//M-monthly pmnt P-principal amnt
//r-mo interest rate (already calculated above)
//n-# of mo pmnts (already calculated above)
//After this, I will be calculating the Total Interest Paid
//(M * n) - P
//Finally, my calculator should display the monthly pmnt
//and Total Interest Paid to the user.

package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to Mortgage Calculator! Please begin by entering your principal.");
        double userPrincipal = scanner.nextDouble();

    System.out.println("Thank you, please enter your interest rate.");
        double userIntRate = scanner.nextDouble();

    System.out.println("Thank you, please enter your loan term.");
    int userLTerm = scanner.nextInt();

    double monthlyIntRate = userIntRate / 12 / 100;
    int numPmnts = userLTerm * 12;

    //equation created using math pow: M = P[r(1+r)^n] / [(1+r)^n-1]
    double monthlyPmnt = userPrincipal * monthlyIntRate * Math.pow(1 + monthlyIntRate, numPmnts) / (Math.pow(1 + monthlyIntRate, numPmnts) - 1);

    //here I just split the equation in two parts vv
    double totalAmntPaid = monthlyPmnt * numPmnts;
    double totalIntPaid = totalAmntPaid - userPrincipal;

        //added \n to put the amount in the next line
        System.out.printf("Your expected monthly payment will be: %.2f\n", monthlyPmnt);
        System.out.printf("Your total interest paid: %.2f\n", totalIntPaid);

        scanner.close();

    }
}