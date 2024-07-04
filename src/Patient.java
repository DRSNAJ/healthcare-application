import java.util.Date;

public class Patient extends HospitalUser {

    public Patient(String name, String dobString, String sex, String contactNumber) {
        super(name, dobString, sex, contactNumber);
        augmentId("p");
    }
    public char getPatientType() {
        return getId().charAt(0);
    }
}
