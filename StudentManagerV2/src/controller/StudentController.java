package controller;

import model.CourseRecord;
import model.Student;
import model.StudentReportRecord;
import util.Validation;
import view.StudentView;

import java.util.*;

public class StudentController {
    Scanner scanner = new Scanner(System.in);
    Validation validation = new Validation();
    StudentView view = new StudentView();
    public List<Student> studentsList = new ArrayList<>();
    final int NUMBER_OF_ADDING = 2;

    Student s1 = new Student("HE187268", new CourseRecord("Java", "3"), "Tran Van Khuyen");
    Student s2 = new Student("HE187268", new CourseRecord(".NET", "3"), "Tran Van Khuyen");
    Student s3 = new Student("HE187268", new CourseRecord("C/C++", "3"), "Tran Van Khuyen");
    Student s5 = new Student("HE187268", new CourseRecord("C/C++", "4"), "Tran Van Khuyen");
    Student s4 = new Student("HE187269", new CourseRecord("C/C++", "5"), "Tran Van Linh");

    public void addSample () {
        studentsList.add(s1);
        studentsList.add(s2);
        studentsList.add(s3);
        studentsList.add(s4);
        studentsList.add(s5);
    }

    public void addStudent() {
        String sCode = validation.getStudentCode();
        // if student existed -> return this student
        // else return null
        Student existedStudent = validation.validateStudentExist(studentsList, sCode);
        String sName = "";
        if(existedStudent == null) sName = validation.getStudentName();
        CourseRecord newCourseRecord = validation.getCourseRecord(existedStudent);

        // if student exist -> add new course record to this student
        if(existedStudent != null) {
            existedStudent.addCourseRecord(newCourseRecord);
            return;
        }
        Student newStudent = new Student(sCode, newCourseRecord, sName);
        studentsList.add(newStudent);
    }

    public void addMultipleStudents () {
        for (int i = 1; i <= NUMBER_OF_ADDING; i++) {
            addStudent();
        }
        while(true) {
            boolean isContinue = validation.checkYesNo();
            if(isContinue) {
                addStudent();
            }
            else {
                break;
            }
        }
    }

    public void searchStudentByName () {
        view.viewInput("keyword");
        String keyword = scanner.nextLine();
        List<Student> searchingResults = new ArrayList<>();

        for (Student s : studentsList) {
            if(s.getStudentName().toLowerCase().contains(keyword.toLowerCase())) {
                searchingResults.add(s);
            }
        }
        sortByName(searchingResults);
        view.viewSearchingResults(searchingResults);
    }

    public void sortByName (List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getStudentName().compareTo(o2.getStudentName());
            }
        });
    }

    public void handleUpdateAndDelete () {
        view.viewInput("student code");
        String sCode = scanner.nextLine();
        Student existedStudent = validation.validateStudentExist(studentsList, sCode);
        if(existedStudent == null) {
            view.viewErrMessage("Student not found!");
            return;
        }

        boolean choice = validation.checkUD();
        if(choice) {
            updateStudent(sCode);
        }
        else {
            deleteStudent(sCode);
        }
        view.displayMessage("Success!");
    }

    public void updateStudent (String sCode) {
        while (true) {
            int choice = view.viewUpdateMenu();
            switch (choice) {
                case 1:
                    String newName = validation.getStudentName();
                    updateStudentName(sCode, newName);
                    break;
                case 2:
                    return;
                default:
                    view.displayMessage("Chose from 1 - 2.");
            }
        }
    }

    public void updateStudentName (String sCode, String newName) {
        for (Student s : studentsList) {
            if(s.getStudentCode().equalsIgnoreCase(sCode)) {
                s.setStudentName(newName);
                return;
            }
        }
    }

    public void deleteStudent (String sCode) {
        for(Student s : studentsList) {
            if(s.getStudentCode().equalsIgnoreCase(sCode)) {
                studentsList.remove(s);
                return;
            }
        }
    }

    public void reportStudentsInformation () {
        List<StudentReportRecord> report = new ArrayList<>();
        for(Student s : studentsList) {
            for (CourseRecord c : s.getCourseRecords()) {
                StudentReportRecord newReportRecord = getStudentReportRecord(s, c);
                if(!validation.checkReportRecordExisted(report, newReportRecord)) {
                    report.add(newReportRecord);
                }
            }
        }
        view.viewReport(report);
    }

    private static StudentReportRecord getStudentReportRecord(Student s, CourseRecord c) {
        StudentReportRecord newReportRecord = new StudentReportRecord();
        int totalCouse = 0;
        newReportRecord.setsName(s.getStudentName());
        newReportRecord.setCourseName(c.getCourseName());
        for (CourseRecord course : s.getCourseRecords()) {
            if(course.getCourseName().equals(c.getCourseName())) {
                totalCouse++;
            }
        }
        newReportRecord.setTotalCourse(totalCouse);
        return newReportRecord;
    }

}
