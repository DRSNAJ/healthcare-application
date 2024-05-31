public class Doctor extends HospitalUser {
    String specialization;

    Doctor() {
        super();
    }

    public boolean isPhysician() {

        String checkStr = "physician";
        int checkLen = checkStr.length();
        if (this.specialization.length() >= checkLen) {
            if (this.specialization.substring(this.specialization.length() - checkLen).equalsIgnoreCase(checkStr)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
