import utils.InputCheck;

public class AdminController {
    public static void adminMenu() {
        while (true) {
            System.out.println("\nPress 1 to add a doctor, press 2 to add a doctor availability, and press 3 to exit");
            int userInput = InputCheck.checkInt(1, 3);

            if (userInput == 1) {
                Hospital.addDoctor();
            } else if (userInput == 2) {
                Hospital.addDoctorAvailabilities();
            } else if (userInput == 3) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}
