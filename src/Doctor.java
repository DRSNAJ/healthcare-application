import java.util.Date;

public class Doctor extends HospitalUser {
    String specialization;

    public Doctor(String id, String name, String dobString, String sex, String contactNumber,String specialization) {
        super(id,name,dobString,sex,contactNumber);
        this.specialization = specialization;
    }

    public boolean isPhysician() {
        String checkStr = "physician";
        return this.specialization.endsWith(checkStr);
//        int checkLen = checkStr.length();
//        if (this.specialization.length() >= checkLen) {
//            if (this.specialization.substring(this.specialization.length() - checkLen).equalsIgnoreCase(checkStr)) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
    }
}
