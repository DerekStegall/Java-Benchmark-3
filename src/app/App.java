package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static ArrayList<AttendanceForm> loadAttendance() {
        try {
            FileInputStream fileStream = new FileInputStream("attendance.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<AttendanceForm> attendance = (ArrayList<AttendanceForm>) os.readObject();
            os.close();
            return attendance;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<AttendanceForm>();
        }
    }

    private static void saveAttendance(ArrayList<AttendanceForm> attendance) {
        try {
            FileOutputStream fileStream = new FileOutputStream("attendance.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(attendance);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to update attendance.");
        }
    }

    // A method to build our attendance form
    private static AttendanceForm studentInfo() {

        // Collects the current student checking in
        System.out.println("Which student is checking in ? \n");
        System.out.println("Angie U");
        System.out.println("Christian G");
        System.out.println("Dakota N");
        System.out.println("Derek S");
        System.out.println("Destiny M");
        System.out.println("Devin B");
        System.out.println("Dylan M");
        System.out.println("Gillian F");
        System.out.println("JD G");
        System.out.println("Oscar G");
        System.out.println("Patton B");
        System.out.println("Tyler I");
        System.out.println(" ");
        String currentStudent = scanner.nextLine();

        // If student is listed, you may advance
        if (currentStudent.equals("Angie") || currentStudent.equals("Christian") || currentStudent.equals("Dakota")
                || currentStudent.equals("Derek") || currentStudent.equals("Destiny") || currentStudent.equals("Devin")
                || currentStudent.equals("Dylan") || currentStudent.equals("Gillian") || currentStudent.equals("JD")
                || currentStudent.equals("Oscar") || currentStudent.equals("Patton")
                || currentStudent.equals("Tyler")) {

            // What day are you signing in for ?
            System.out.println(" ");
            System.out.println("Today is: \n");
            System.out.println("Monday ");
            System.out.println("Tuesday ");
            System.out.println("Wednesday ");
            System.out.println("Thursday ");
            System.out.println("Friday ");
            System.out.println(" ");

            String currentDay = scanner.nextLine();

            // What time did you arrive on this day ?
            System.out.println("Arrival Time: \n");
            String arrivalTime = scanner.nextLine();

            // When all requiremnets are filled, a new log for attendance is made
            return new AttendanceForm(currentStudent, currentDay, arrivalTime);
        }
        return null;
    }

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<AttendanceForm> attendance = loadAttendance();

        AttendanceForm student = studentInfo();

        System.out.println("\n " + student.name + " arrived at " + student.timeArrived + " on " + student.day);
        System.out.println(" ");

        // add the student's info to the stored data
        attendance.add(student);

        // save that stored data
        saveAttendance(attendance);
    };
}