package controller;

import model.DBContext;
import model.Report;
import model.Student;
import view.StudentView;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    Scanner scanner = new Scanner(System.in);
    private final StudentView view = new StudentView();
    private final DBContext db = new DBContext();

    public void addSampleStudents() {
        db.addSampleStudents();
    }

    public void getStudentInformation(Student newStudent) {
        System.out.print("Code: ");
        newStudent.setCode(scanner.nextLine());
        System.out.print("Name: ");
        newStudent.setStudentName(scanner.nextLine());
        System.out.print("Semester: ");
        newStudent.setSemester(scanner.nextLine());
        System.out.print("Course Name: ");
        newStudent.setCourseName(scanner.nextLine());
    }

    public void addStudent() {
        Student newStudent = new Student();
        getStudentInformation(newStudent);
        db.addStudent(newStudent);
    }

    public void addMultipleStudents() {
        int count = 1;
        int MIN_CREATION = 1;
        while (count <= MIN_CREATION) {
            addStudent();
            count++;
        }
        int isContinue;
        while (true) {
            view.showAskForContinue();
            isContinue = scanner.nextLine().equalsIgnoreCase("y") ? 1 : 0;
            if (isContinue == 1) {
                addStudent();
            } else {
                break;
            }
        }
    }

    public void showSearchingResult() {
        System.out.print("Keyword: ");
        String keyword = scanner.nextLine();
        ArrayList<Student> searchingResults = db.findStudentByName(keyword);
        view.showMultipleStudents(searchingResults);
    }

    public void handleUpdateDeleteStudent() {
        System.out.println("Enter student ID: ");
        String studentID = scanner.nextLine();
        Student student = db.getStudentById(studentID);
        if (student == null) {
            view.showStudentNotFound();
        } else {
            view.showUpdateDeleteStudentCase();
            String choice = scanner.nextLine().toLowerCase();
            int isUpdate = 0;
            int isDelete = 0;
            switch (choice) {
                case "u":
                    isUpdate = 1;
                    break;
                case "d":
                    isDelete = 1;
                    break;
            }

            if (isDelete == 1) {
                db.deleteStudentById(student);
            }
            if (isUpdate == 1) {

                int option = 0;
                while (option != 5) {
                    System.out.println("Enter your choice: ");
                    view.showUpdateOptions();
                    option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 1:
                            System.out.print("Enter new student ID: ");
                            String newStudentID = scanner.nextLine();
                            student.setCode(newStudentID);
                            break;
                        case 2:
                            System.out.print("Enter new student name: ");
                            String newStudentName = scanner.nextLine();
                            student.setStudentName(newStudentName);
                            break;
                        case 3:
                            System.out.print("Enter new student semester: ");
                            String newStudentSemester = scanner.nextLine();
                            student.setSemester(newStudentSemester);
                            break;
                        case 4:
                            System.out.print("Enter new student course name: ");
                            String newStudentCourseName = scanner.nextLine();
                            student.setCourseName(newStudentCourseName);
                            break;
                        default:
                            break;
                    }
                }
                db.updateStudent(student, studentID);
                view.showSuccess();
            }
        }
    }

    public void showAllStudents() {
        view.showMultipleStudents(db.getAllStudents());
    }

    public void report() {
        ArrayList<Report> reports = db.getReports();
        view.showReportsList(reports);
    }

}
