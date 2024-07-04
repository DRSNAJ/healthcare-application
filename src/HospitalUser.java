import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SplittableRandom;

abstract class HospitalUser {
    private String id;
    private String name;
    Date dob;
    String sex;
    String contactNumber;
    private static int instanceCount;

    public HospitalUser(String name, String dobString, String sex, String contactNumber) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        setId();
        this.name = name;
        try {
            this.dob = dateFormat.parse(dobString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
        }
        this.sex = sex;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    private void setId(){
        StringBuilder builder = new StringBuilder();
        int idLen = 12;
        instanceCount++;

        this.id = String.format("%0" + idLen + "d", instanceCount);

    }

    protected void augmentId(String appendStr) {
        this.id = appendStr + '-' + this.id;
    }

    public String getName() {
        return name;
    }
}

