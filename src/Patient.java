import java.util.Date;

public class Patient extends HospitalUser {

    public Patient(String name, String dobString, String sex, String contactNumber) {
        super(null,name,dobString,sex,contactNumber);
        setPatientId();
    }

    private void setPatientId() {
        StringBuilder builder = new StringBuilder();
        builder.append('p').append('-');
        int idLen = 12;

        for (int i = 0; i <idLen; i++) {
            builder.append((int)(Math.random() * 9));
        }
        this.id = builder.toString();
    }


    public char getPatientType() {
        return this.id.charAt(0);
    }
}
