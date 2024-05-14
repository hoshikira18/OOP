package model;
import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    private final Scanner sc = new Scanner(System.in);

    public boolean checkRecordExist (ArrayList<Student> students, Student student) {
        for (Student s : students) {
            if(student.getCode().equals(s.getCode())
                    && student.getStudentName().equals(s.getStudentName())
                    && student.getSemester().equals(s.getSemester())
                    && student.getCourseName().equals(s.getCourseName())
            )  {
                System.out.println("Record already exists");
                return true;
            }
        }
        return false;
    }

    public boolean checkReportExist (ArrayList<Report> reports, Report report) {
        for (Report r : reports) {
            if(
                report.getCode().trim().equals(r.getCode())
                && report.getCourseName().trim().equals(r.getCourseName())
                && report.getTotalCourse() == r.getTotalCourse()
            ) {
                return true;
            }
        }
        return false;
    }

    public boolean checkSameIdUpdateName (String curentName, String newName) {
        return curentName.equals(newName);
    }

    public boolean checkOutOfIndex(ArrayList<Student> students, int index) {
        return (index < 0 || index >= students.size());
    }
}