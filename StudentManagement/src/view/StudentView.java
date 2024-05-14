package view;

import model.Report;
import model.Student;

import java.util.ArrayList;

public class StudentView {

    public void showMenu () {
        System.out.println("=====================================");
        System.out.println("==Welcome to the Student Management==");
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");
        System.out.print(" Enter your choice: ");
    }

    public void showStudent(Student student, int id) {
        System.out.println("ID: " + student.getCode() +
                " - NAME: " + student.getStudentName() +
                " - SEMESTER: " + student.getSemester() +
                " - COURSE: " + student.getCourseName());
    }

    public void showMultipleStudents(ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            showStudent(students.get(i), i+1);
        }
    }

    public void showStudentDetail(Student newStudent) {
        System.out.println("Name: " + newStudent.getStudentName());
    }

    public void showAskForContinue() {
        System.out.println("Do you want to continue? (Y/N)");
    }

    public void showUpdateDeleteStudentCase () {
        System.out.println("Do you want to update (U) or delete (D) student?");
    }

    public void showUpdateOptions () {
        System.out.println("1. Update code.");
        System.out.println("2. Update name.");
        System.out.println("3. Update semester.");
        System.out.println("4. Update courseName.");
        System.out.println("5. Quit.");
    }

    public void showSuccess () {
        System.out.println("Updated successfully!");
    }

    public void showStudentNotFound() {
        System.out.println("Student not found");
    }

    public void showReportsList (ArrayList<Report> reports) {
        for (Report report : reports) {
            System.out.printf("%-20s | %-20s | %-10s%n", report.getStudentName(), report.getCourseName(), report.getTotalCourse()+"");
        }
    }

}
