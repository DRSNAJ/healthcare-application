import java.util.InputMismatchException;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int checkInt(int lBound, int uBound){
        Scanner scanner = new Scanner(System.in);
        int userInput = lBound-1;
        boolean retry=false;

        while (userInput < lBound || userInput > uBound) {
            while (!retry){
                try {
                    System.out.print("Input: ");
                    userInput = scanner.nextInt();
                    retry = true;
                } catch (InputMismatchException exception) {
                    System.out.println("Incorrect input format");
                    System.out.print("Input: ");
                    scanner.next();
                    retry = false;
                }
            }
        }
        return userInput;
    }

    public static void userSelect(){

    }

    public static void main(String[] args) {
        while(true){
            System.out.println("\nIf you are a hospital administrator please press 1, If you are a patient please press 2, Press 3 to exit");
            int userInput = checkInt(1,3);
                if (userInput == 1) {
                    while(true){
                    System.out.println("\nPress 1 to add a doctor, press 2 to add a doctor availability, and press 3 to exit");
                    userInput = checkInt(1, 3);

                    if (userInput == 1) {
                        System.out.println("Add a doctor");
                    } else if (userInput == 2) {
                        System.out.println("Add doctor availability");
                    } else if (userInput == 3) {
                        System.out.println("Exit");
                        break;
                    } else {
                        System.out.println("Invalid Input");
                    }
                }
            } else if (userInput == 2) {
                    while(true) {
                        System.out.println("\nPress 1 to view doctors, press 2 to book an appointment, " +
                                "press 3 to view a selected doctor's bookings, press 4 to register patient and press 5 to exit");
                        userInput = checkInt(1, 5);

                        if (userInput == 1) {
                            System.out.println("View doctors list");
                        } else if (userInput == 2) {
                            System.out.println("Book an appointment");
                        } else if (userInput == 3) {
                            System.out.println("View a selected Doctor");
                        } else if (userInput == 4) {
                            System.out.println("Register patient");
                        } else if (userInput == 5) {
                            System.out.println("Exit");
                            break;
                        } else {
                            System.out.println("Invalid Input");
                        }
                    }
            } else if (userInput == 3) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}