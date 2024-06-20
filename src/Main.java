import utils.InputCheck;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void mainMenu() {

        while (true) {
            System.out.println("\nIf you are a hospital administrator please press 1, If you are a patient please press 2, Press 3 to exit");
            int userInput = InputCheck.checkInt(1, 3);
            if (userInput == 1) {
                AdminController.adminMenu();
            } else if (userInput == 2) {
                PatientController.patientMenu();
            } else if (userInput == 3) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public static void main(String[] args) {
        Hospital.addTempUsers();
        Hospital.printDoctorList();


        mainMenu();
    }
}