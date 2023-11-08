package org.example;

//Overall, an extremely good job! You are getting separation of concerns
//and built an application that's closer to what you'd do in an actual company
//The only small thing is to try to make user error messages a little more meaningful
//so the user knows why they messed up.
public class Main {
    public static void main(String[] args) {
    UserInterface userInterface = new UserInterface();
    userInterface.displayVehicles();
    }

}