package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter first number");
        double firstNumber = scanner.nextDouble();

        System.out.println("Please enter second number");
        double secondNumber = scanner.nextDouble();

        System.out.println("Would you like to (A)dd, (S)ubtract, (M)ultiply or (D)ivide?");
        scanner.nextLine();

        String equationOption = scanner.nextLine();

        if (equationOption.equalsIgnoreCase("A")) {
            double result = firstNumber + secondNumber;
            System.out.printf("%.2f + %.2f = %.2f", firstNumber, secondNumber, result);
        }
        if (equationOption.equalsIgnoreCase("S")) {
            double result = firstNumber - secondNumber;
            System.out.printf("%.2f - %.2f =%.2f", firstNumber, secondNumber, result);
        }
        if (equationOption.equalsIgnoreCase("M")) {
            double result = firstNumber * secondNumber;
            System.out.printf("%.2f * %.2f = %.2f", firstNumber, secondNumber, result);
        }
        if (equationOption.equalsIgnoreCase("D")) {
            double result = firstNumber / secondNumber;
            System.out.printf("%.2f / %.2f = %.2f", firstNumber, secondNumber, result);
        }
    }
}