import utils.TableBuilder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Hospital {

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<Doctor> doctorList = new ArrayList<>();

    public Hospital() {

    }

    public void addDoctor() {
        Scanner scanner = new Scanner(System.in);
        String id;
        String name;
        String specialization;
        String dob;
        String sex;
        String contactNumber;

        System.out.print("\nEnter Doctor Details---\nID: ");
        id = scanner.nextLine();
        System.out.print("NAME: ");
        name = scanner.nextLine();
        System.out.print("SPECIALIZATION: ");
        specialization = scanner.nextLine();
        System.out.print("DOB (YYYY-MM-DD): ");
        String dobString = scanner.nextLine();
        System.out.print("SEX: ");
        sex = scanner.nextLine();
        System.out.print("CONTACT NUM: ");
        contactNumber = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, dobString, sex, contactNumber,specialization);
        this.doctorList.add(doctor);

    }

    public void printDoctorList(){
        ArrayList<String> doctorListHeaders = new ArrayList<>();
        doctorListHeaders.add("ID");
        doctorListHeaders.add("NAME");
        doctorListHeaders.add("SPECIALIZATION");
        doctorListHeaders.add("DOB");
        doctorListHeaders.add("SEX");
        doctorListHeaders.add("CONTACT NUM");

        ArrayList<ArrayList<String>> doctorListStrings = new ArrayList<>();
        for (Doctor doc : doctorList){
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

}
