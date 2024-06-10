import java.util.Date;

public class Patient extends HospitalUser {

    public Patient(String id, String name, String dobString, String sex, String contactNumber) {
        super(id,name,dobString,sex,contactNumber);
    }

    public char getPatientType() {
        return this.id.charAt(0);
    }
}
