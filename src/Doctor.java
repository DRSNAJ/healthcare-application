import utils.TableBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class Doctor extends HospitalUser {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String specialization;
    ArrayList<Date> availabilities = new ArrayList<>();
    HashMap<Date, ArrayList<Appointment>> appointments = new HashMap<>();

    public Doctor(String name, String dobString, String sex, String contactNumber, String specialization) {
        super(null, name, dobString, sex, contactNumber);
        this.specialization = specialization;
        setDoctorId();
    }

    public boolean isPhysician() {
        String checkStr = "physician";
        return this.specialization.endsWith(checkStr);
    }

    private void setDoctorId() {
        StringBuilder builder = new StringBuilder();
        builder.append('d').append(Character.toLowerCase(specialization.charAt(0))).append('-');
        int idLen = 12;

        for (int i = 0; i < idLen; i++) {
            builder.append((int) (Math.random() * 9));
        }
        this.id = builder.toString();
    }


    public void printAvailabilities() {
        ArrayList<String> availabilitiesHeaders = new ArrayList<>();
        int row_count = 1;
        availabilitiesHeaders.add("Slot Number");
        for (Date avDate : availabilities) {
            availabilitiesHeaders.add(dateFormat.format(avDate));
        }

        ArrayList<ArrayList<String>> timeSlotStrings = new ArrayList<>();

        String cellString = "";
        for (String timeString: Appointment.timeSlots) {
            ArrayList<String> row = new ArrayList<>();
            for (Date checkDate : availabilities) {
                cellString = timeString;
                if (appointments.containsKey(checkDate)) {
                    ArrayList<Appointment> appListPrint = appointments.get(checkDate);
                    for (Appointment app : appListPrint){
                        if (timeString.equals(app.time)){
                            cellString = "-";
                        }
                    }
                }
                row.add(cellString);
            }
            row.addFirst(Integer.toString(row_count));
            row_count++;
            timeSlotStrings.add(row);
        }

        TableBuilder doctorTable = new TableBuilder(availabilitiesHeaders);
        doctorTable.setTableData(timeSlotStrings);

        System.out.println("\nID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Available Appointments----------------------");
        doctorTable.printTable();
    }

    public void setAppointments(String dateString, Appointment newAppointment) {
        try {
            Date date = dateFormat.parse(dateString);
            if (appointments.containsKey(date)) {
                appointments.get(date).add(newAppointment);
            } else {
                ArrayList<Appointment> settingAppointments = new ArrayList<>();
                settingAppointments.add(newAppointment);
                appointments.put(date, settingAppointments);
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void setAvailabilities(String newAvailability) {
        try {
            Date newAvailabilityIn = dateFormat.parse(newAvailability);
            this.availabilities.add(newAvailabilityIn);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
        }
    }

    public boolean verifyDoctorAvailability(String date, int slot) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date queryDate = dateFormat.parse(date);

        for (Date availability : availabilities) {
            if (availability.equals(queryDate) && appointments.containsKey(queryDate)) {
                for (Appointment checkAppoint : appointments.get(queryDate)){
                    if (checkAppoint.slot == slot){
                        return false;
                    }
                }
            }
        }
        return true;

    }


}
