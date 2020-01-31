package app;

import java.io.Serializable;

public class AttendanceForm implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    String day;
    String timeArrived;

    public AttendanceForm(String name, String day, String timeArrived) {

        this.name = name;
        this.day = day;
        this.timeArrived = timeArrived;
    }
}