import utils.InputCheck;
import utils.TableBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static utils.InputCheck.checkInt;

public class Hospital {

    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static ArrayList<Doctor> doctorList = new ArrayList<>();
    private static ArrayList<Patient> patientList = new ArrayList<>();


    public Hospital() {

    }

    public static void addTempUsers() {
        doctorList.add(new Doctor("Dr. John Doe", "1984-04-12", "Male", "0777123456", "Cardiology"));
        doctorList.add(new Doctor("Dr. Sarah Smith", "1979-08-25", "Female", "0777123457", "Family Physician"));
        doctorList.add(new Doctor("Dr. Richard Lee", "1986-01-30", "Male", "0777123458", "Orthopedics"));
        doctorList.add(new Doctor("Dr. Alice Johnson", "1990-07-14", "Female", "0777123459", "Family Physician"));
        doctorList.add(new Doctor("Dr. Mark Brown", "1983-03-22", "Male", "0777123460", "Pediatrics"));
        doctorList.add(new Doctor("Dr. Jessica Davis", "1975-12-05", "Female", "0777123461", "Obstetrics"));
        doctorList.add(new Doctor("Dr. Robert Wilson", "1988-09-19", "Male", "0777123462", "General Surgery"));
        doctorList.add(new Doctor("Dr. Emily Moore", "1992-11-30", "Female", "0777123463", "Psychiatry"));
        doctorList.add(new Doctor("Dr. William Taylor", "1980-06-04", "Male", "0777123464", "Family Physician"));
        doctorList.add(new Doctor("Dr. Laura Martinez", "1985-05-18", "Female", "0777123465", "Radiology"));

        patientList.add(new Patient("Alice Green", "1995-02-15", "Female", "0777001234"));
        patientList.add(new Patient("Bob White", "1988-07-23", "Male", "0777001235"));
        patientList.add(new Patient("Clara Zane", "1973-03-08", "Female", "0777001236"));
        patientList.add(new Patient("David Yule", "2001-01-12", "Male", "0777001237"));
        patientList.add(new Patient("Eva Smith", "1984-05-30", "Female", "0777001238"));
        patientList.add(new Patient("Frank Brown", "1970-11-26", "Male", "0777001239"));
        patientList.add(new Patient("Gina Weld", "2005-09-15", "Female", "0777001240"));
        patientList.add(new Patient("Harry Quill", "1999-12-24", "Male", "0777001241"));
        patientList.add(new Patient("Irene Olive", "1992-04-20", "Female", "0777001242"));
        patientList.add(new Patient("Jack Nile", "1980-08-09", "Male", "0777001243"));
        patientList.add(new Patient("Kara Quest", "2003-07-02", "Female", "0777001244"));
        patientList.add(new Patient("Liam Peak", "1965-10-30", "Male", "0777001245"));
        patientList.add(new Patient("Mia Gale", "1978-03-14", "Female", "0777001246"));
        patientList.add(new Patient("Nolan Tate", "1985-12-11", "Male", "0777001247"));
        patientList.add(new Patient("Olivia Vane", "1990-01-01", "Female", "0777001248"));

        doctorList.get(0).setAvailabilities("2024-06-01");
        doctorList.get(0).setAvailabilities("2024-06-08");
        doctorList.get(0).setAvailabilities("2024-06-15");
        doctorList.get(0).setAvailabilities("2024-06-22");
        doctorList.get(0).setAvailabilities("2024-06-29");

        doctorList.get(1).setAvailabilities("2024-06-02");
        doctorList.get(1).setAvailabilities("2024-06-09");
        doctorList.get(1).setAvailabilities("2024-06-16");
        doctorList.get(1).setAvailabilities("2024-06-23");
        doctorList.get(1).setAvailabilities("2024-06-30");

        doctorList.get(2).setAvailabilities("2024-06-03");
        doctorList.get(2).setAvailabilities("2024-06-10");
        doctorList.get(2).setAvailabilities("2024-06-17");
        doctorList.get(2).setAvailabilities("2024-06-24");
        doctorList.get(2).setAvailabilities("2024-06-28");

        doctorList.get(3).setAvailabilities("2024-06-04");
        doctorList.get(3).setAvailabilities("2024-06-11");
        doctorList.get(3).setAvailabilities("2024-06-18");
        doctorList.get(3).setAvailabilities("2024-06-25");
        doctorList.get(3).setAvailabilities("2024-06-29");

        System.out.println("==========================");
        doctorList.get(0).printAvailabilities();

        System.out.println("\n==========================");
        printPatientList();
        System.out.println("ID: " + patientList.get(0).id);
        System.out.println("Name: " + patientList.get(0).name);
    }

    public static void addDoctor() {
        Scanner scanner = new Scanner(System.in);
        String name;
        String specialization;
        String sex;
        String contactNumber;

        System.out.print("\nEnter Doctor Details---\n");
        System.out.print("NAME: ");
        name = scanner.nextLine();
        System.out.print("SPECIALIZATION: ");
        specialization = scanner.nextLine();
        String dobString = InputCheck.dateCheck("yyyy-MM-dd", "DOB (YYYY-MM-DD): ");
        System.out.print("SEX: ");
        sex = scanner.nextLine();
        System.out.print("CONTACT NUM: ");
        contactNumber = scanner.nextLine();

        Doctor doctor = new Doctor(name, dobString, sex, contactNumber, specialization);
        doctorList.add(doctor);
    }

    public static void addPatient() {
        Scanner scanner = new Scanner(System.in);
        String name;
        String sex;
        String contactNumber;

        System.out.print("\nEnter Patient Details---\n");
        System.out.print("NAME: ");
        name = scanner.nextLine();
        String dobString = InputCheck.dateCheck("yyyy-MM-dd", "DOB (YYYY-MM-DD): ");
        System.out.print("SEX: ");
        sex = scanner.nextLine();
        System.out.print("CONTACT NUM: ");
        contactNumber = scanner.nextLine();

        Patient patient = new Patient(name, dobString, sex, contactNumber);
        patientList.add(patient);
    }

    public static void printDoctorList() {
        ArrayList<String> doctorListHeaders = new ArrayList<>();
        doctorListHeaders.add("ID");
        doctorListHeaders.add("NAME");
        doctorListHeaders.add("SPECIALIZATION");
        doctorListHeaders.add("DOB");
        doctorListHeaders.add("SEX");
        doctorListHeaders.add("CONTACT NUM");

        ArrayList<ArrayList<String>> doctorListStrings = new ArrayList<>();
        for (Doctor doc : doctorList) {
            ArrayList<String> doctorString = new ArrayList<>();
            doctorString.add(doc.id);
            doctorString.add(doc.name);
            doctorString.add(doc.specialization);
            doctorString.add(dateFormat.format(doc.dob));
            doctorString.add(doc.sex);
            doctorString.add(doc.contactNumber);

            doctorListStrings.add(doctorString);
        }

        TableBuilder doctorTable = new TableBuilder(doctorListHeaders);
        doctorTable.setTableData(doctorListStrings);
        doctorTable.printTable();
    }

    public static void addDoctorAvailabilities() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the doctors ID: ");
        String docID = scanner.nextLine();
        for (Doctor doc : doctorList) {
            if (docID.equals(doc.id)) {
                String inputDate = InputCheck.dateCheck("yyyy-MM-dd", "Enter an availability date (YYYY-MM-DD): ");
                doc.setAvailabilities(inputDate);
            }
        }
    }

    public static Doctor findDoctor(String id) throws Exception {
        for (Doctor doc : doctorList) {
            if (id.equals(doc.id)) {
                return doc;
            }
        }
        throw new Exception("Doctor with ID: " + id + " not found.");
    }

    public static Patient findPatient(String id) throws Exception {
        for (Patient patient : patientList) {
            if (id.equals(patient.id)) {
                return patient;
            }
        }
        throw new Exception("Patient with ID: " + id + " not found.");
    }


    public static void makeAppointment() {
        Scanner scanner = new Scanner(System.in);
        Appointment newAppointment = new Appointment();

        try {
            System.out.print("\nEnter Doctor Details---\n");
            System.out.print("Patient ID: ");
            String patientId = scanner.nextLine();
            newAppointment.patient = findPatient(patientId);
            System.out.print("Doctor ID: ");
            String doctorId = scanner.nextLine();
            newAppointment.doctor = findDoctor(doctorId);
            System.out.print("Notes: ");
            newAppointment.notes = scanner.nextLine();


            boolean retry = true;
            while (retry) {
                System.out.println("\nPlease select a date and timeslot for your selected date >>>>>>>");
                newAppointment.doctor.printAvailabilities();
                String dateString = InputCheck.dateCheck("yyyy-MM-dd", "Appointment Date (YYYY-MM-DD): ");
                System.out.println("Time slot: ");
                int userSlot = checkInt(1, Appointment.timeSlots.length);
                if (newAppointment.doctor.verifyDoctorAvailability(dateString, userSlot)) {
                    newAppointment.setTime(userSlot);
                    newAppointment.setDate(dateString);

                    for (Doctor doc : doctorList) {
                        if (doc.id.equals(doctorId)) {
                            doc.setAppointments(dateString, newAppointment);
                            System.out.println("\n\nAPPOINTMENT SUCCESSFULLY BOOKED");
                            doc.printAvailabilities();
                        }
                    }
                    retry = false;
                    break;
                } else {
                    System.out.println("Slot unavailable, retry? (y/n)");
                    String cancelInput = scanner.nextLine();
                    if (!cancelInput.equals("y")) {
                        retry = false;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void printPatientList() {
        ArrayList<String> doctorListHeaders = new ArrayList<>();
        doctorListHeaders.add("ID");
        doctorListHeaders.add("NAME");
        doctorListHeaders.add("DOB");
        doctorListHeaders.add("SEX");
        doctorListHeaders.add("CONTACT NUM");

        ArrayList<ArrayList<String>> patientListStrings = new ArrayList<>();
        for (Patient pat : patientList) {
            ArrayList<String> doctorString = new ArrayList<>();
            doctorString.add(pat.id);
            doctorString.add(pat.name);
            doctorString.add(dateFormat.format(pat.dob));
            doctorString.add(pat.sex);
            doctorString.add(pat.contactNumber);

            patientListStrings.add(doctorString);
        }

        TableBuilder doctorTable = new TableBuilder(doctorListHeaders);
        doctorTable.setTableData(patientListStrings);
        doctorTable.printTable();
    }

}
