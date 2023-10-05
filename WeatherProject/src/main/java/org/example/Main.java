package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How's the weather today?");

        String todaysWeather = scanner.nextLine();

        if(todaysWeather.equalsIgnoreCase("Sunny")){
            System.out.println("It's a great day for outdoor activities!.");
        }
        else if(todaysWeather.equalsIgnoreCase("Cloudy")){
            System.out.println("The weather is a bit uncertain.");
        }
        else if(todaysWeather.equalsIgnoreCase("Rainy")){
            System.out.println("Don't forget your umbrella!");
        }
        else {
            System.out.println("Sorry i'm not sure about that weather type.");
        }

    }
}