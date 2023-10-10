package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Please enter your numerical score: ");
        int score = scanner.nextInt();

        if (90 <= score && score <= 100) {
            System.out.println("Your grade is an A.");
        } else if (80 <= score && score <= 89) {
            System.out.println("Your grade is a B.");
        }
        else if (70 <= score && score <= 79) {
            System.out.println("Your grade is a C.");
        }
        else if (60 <= score && score <= 69) {
            System.out.println("Your grade is a D.");
        }
        else {
            System.out.println("Your grade is an F.");
        }


    }
}