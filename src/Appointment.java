import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
    Doctor doctor;
    Patient patient;
    String notes;
    Date date;
    String time;
    int slot;

    public static String[] timeSlots = {"5:00-6:00","6:00-7:00","7:00-8:00","8:00-9:00","9:00-10:00"};

    public void setTime(int i){
        this.slot = i;
        this.time = timeSlots[i-1];
    }

    public void setDate(String newAvailability){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.date= dateFormat.parse(newAvailability);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
        }
    }



}
