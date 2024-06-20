package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCheck {

    public InputCheck() {

    }

    public static int checkInt(int lBound, int uBound) {
        Scanner scanner = new Scanner(System.in);
        int userInput = lBound - 1;
        boolean retry = false;

        while (!retry || userInput < lBound || userInput > uBound) {
            try {
                System.out.print("Input: ");
                userInput = scanner.nextInt();
                retry = true;
            } catch (InputMismatchException exception) {
                scanner.next();
                retry = false;
            }

            if (!retry || userInput < lBound || userInput > uBound) {
                System.out.println("\nIncorrect input format!");
                System.out.println("Input an integer between " + lBound + " and " + uBound + ".");
            }
        }
        return userInput;
    }

    public static String dateCheck(String dateFormatString, String userPrompt) {
        Scanner scanner = new Scanner(System.in);
        Date checkedDate = null;
        String dateSting = null;
        boolean retry = false;

        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        while (!retry) {
            try {
                System.out.print(userPrompt);
                checkedDate = dateFormat.parse(scanner.nextLine());
                retry = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter the date in " + dateFormatString + " format.");
                retry = false;
            }
        }

        return dateFormat.format(checkedDate);
    }

}
