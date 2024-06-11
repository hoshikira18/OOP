package view;

import model.CourseRecord;
import model.Student;
import model.StudentReportRecord;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    public int viewMenu () {
        System.out.println("===============================");
        System.out.println("1. Add");
        System.out.println("2. Find/Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.println("Chose from 1 - 5");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public int viewUpdateMenu () {
        System.out.println("===============================");
        System.out.println("1. Update Name");
        System.out.println("2. Exit");
        System.out.println("Chose from 1 - 5");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public void displayMessage (String message) {
        System.out.println(message);
    }

    public void viewInput (String message) {
        System.out.print("Enter " + message + ": ");
    }

    public void viewInvalidMessage (String message) {
        System.out.println(ANSI_RED_BACKGROUND + message + ANSI_RESET);
    }

    public void viewErrMessage (String message) {
        System.out.println(ANSI_RED_BACKGROUND + message + ANSI_RESET);
    }

    public void viewContinueOption () {
        System.out.println("Do you want to continue? (Y/N)");
    }

    public void viewSearchingResults (List<Student> students) {
        for (Student s : students) {
            for (CourseRecord c : s.getCourseRecords()) {
                System.out.println(s.getStudentCode() + " - " +
                        s.getStudentName() + " - " +
                        c.getCourseName() + " - " +
                        c.getSemester());
            }
        }
    }

    public void viewReport (List<StudentReportRecord> report) {
        for (StudentReportRecord r: report) {
            System.out.printf("%-20s|%-20s|%20d\n", r.getsName(), r.getCourseName(), r.getTotalCourse());
        }
    }
}
