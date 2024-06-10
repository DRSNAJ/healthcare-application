import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SplittableRandom;

public class HospitalUser {
    String id;
    String name;
    Date dob;
    String sex;
    String contactNumber;

    public HospitalUser(String id, String name, String dobString, String sex, String contactNumber) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.id = id;
        this.name = name;
        try {
            this.dob = dateFormat.parse(dobString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
        }
        this.sex = sex;
        this.contactNumber = contactNumber;

    }
}

