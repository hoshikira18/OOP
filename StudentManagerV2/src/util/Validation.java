package util;

import model.CourseRecord;
import model.Student;
import model.StudentReportRecord;
import view.StudentView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Validation {
    Scanner scanner = new Scanner(System.in);
    StudentView view = new StudentView();

    // exist -> return that student
    // no -> return null
    public Student validateStudentExist (List<Student> studentsList, String sCode) {
        for(Student student : studentsList) {
            if(student.getStudentCode().equalsIgnoreCase(sCode)) {
                return student;
            }
        }
        return null;
    }

    public String getStudentCode () {
        while (true) {
            view.viewInput("student code");
            String sCode = scanner.nextLine();
            if(!sCode.isEmpty()) {
                return sCode;
            }
            view.viewInvalidMessage("Invalid student's code");
        }
    }


    public String getStudentName () {
        while(true) {
            view.viewInput("student name");
            String name = scanner.nextLine();
            if(!name.isEmpty()) {
                return name;
            }
            view.viewInvalidMessage("Invalid student's name");
        }
    }

    public String getStudentSemester () {
        while(true) {
            view.viewInput("student semester");
            String sSemester = scanner.nextLine();
            if(!sSemester.isEmpty()) {
                return sSemester;
            }
            view.viewInvalidMessage("Invalid Student Semester");
        }
    }

    public String getStudentCourse () {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("java");
        courses.add(".net");
        courses.add("c/c++");

        while(true) {
            view.viewInput("course name");
            String sCourse = scanner.nextLine();
            if(!sCourse.isEmpty() && courses.contains(sCourse.toLowerCase())) {
                return sCourse;
            }
            view.viewInvalidMessage("Invalid Course");
        }
    }

    public CourseRecord getCourseRecord (Student student) {
        while(true) {
            String sSemester = getStudentSemester();
            String sCourse = getStudentCourse();
            CourseRecord newCourseRecord = new CourseRecord(sCourse, sSemester);
            if(student == null) {
                return newCourseRecord;
            }
            if(!isCourseRecordExisted(student.getCourseRecords(), sSemester, sCourse)) {
                return newCourseRecord;
            }
            view.viewInvalidMessage("One course cannot be learned in one semester");
        }
    }

    public boolean isCourseRecordExisted (List<CourseRecord> courseRecords, String sSemester, String sCourse) {
        for (CourseRecord c : courseRecords) {
            if(sSemester.equalsIgnoreCase(c.getSemester()) && sCourse.equalsIgnoreCase(c.getCourseName())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkYesNo () {
        while(true) {
            view.viewContinueOption();
            String option = scanner.nextLine();
            if(option.equalsIgnoreCase("y")) {
                return true;
            }
            if(option.equalsIgnoreCase("n")) {
                return false;
            }
            view.viewInvalidMessage("Chose Y(Yes) or N(No) to continue!");
        }
    }

    public boolean checkUD () {
        while(true) {
            view.displayMessage("U(Update)/D(Delete)");
            String option = scanner.nextLine();
            if(option.equalsIgnoreCase("u")) {
                return true;
            }
            if(option.equalsIgnoreCase("d")) {
                return false;
            }
            view.viewInvalidMessage("Chose U(Update) or D(Delete) to continue!");
        }
    }

    public boolean checkReportRecordExisted (List<StudentReportRecord> reportRecords, StudentReportRecord newRecord) {
        for (StudentReportRecord r : reportRecords) {
            if(newRecord.getsName().equals(r.getsName()) &&
                newRecord.getCourseName().equals(r.getCourseName()) &&
                    newRecord.getTotalCourse() == r.getTotalCourse()
            ) {
                return true;
            }
        }
        return false;
    }

}
