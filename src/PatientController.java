import utils.InputCheck;

public class PatientController {

    public static void patientMenu() {
        while (true) {
            System.out.println("\nPress 1 to view doctors, press 2 to book an appointment, " +
                    "press 3 to view a selected doctor's bookings, press 4 to register patient and press 5 to exit");
            int userInput = InputCheck.checkInt(1, 5);

            if (userInput == 1) {
                System.out.println("\nAll Doctors ---");
                Hospital.printDoctorList();
            } else if (userInput == 2) {
                Hospital.makeAppointment();
            } else if (userInput == 3) {
                System.out.println("View a selected Doctor");
            } else if (userInput == 4) {
                Hospital.addPatient();
            } else if (userInput == 5) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }
}
