package model;

import view.StudentView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DBContext {
    ArrayList<Student> studentsArray = new ArrayList<Student>();
    Validation validation = new Validation();
    StudentView studentView = new StudentView();
    Scanner scanner = new Scanner(System.in);

    Student s1 = new Student("HE187268", "Tran Van Khuyen", "3", "SE");
    Student s3 = new Student("HE170019", "Phung Thi Khanh Linh", "3", "SE");
    Student s4 = new Student("HE187269", "Tran Van Khuyen b", "3", "SE");
    Student s5 = new Student("HE187268", "Tran Van Khuyen", "3", "SE");

    public void addSampleStudents() {
        studentsArray.add(s1);
        studentsArray.add(s4);
        studentsArray.add(s3);
        studentsArray.add(s5);
    }

    public void addStudent(Student newStudent) {
        boolean isExist = validation.checkRecordExist(studentsArray, newStudent);
        if (isExist) {
            return;
        }
        studentsArray.add(newStudent);
    }

    public void sortStudentsByName(ArrayList<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getStudentName().compareToIgnoreCase(s2.getStudentName());
            }
        });
    }

    public ArrayList<Student> findStudentByName(String keyword) {
        ArrayList<Student> searchingResults = new ArrayList<Student>();
        for (Student student : studentsArray) {
            if(student.getStudentName().contains(keyword)) {
                searchingResults.add(student);
            }
        }
        sortStudentsByName(searchingResults);
        return searchingResults;
    }

    public Student getStudentById(String id) {
        for (Student student : studentsArray) {
            if(student.getCode().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudentById(Student student) {
        studentsArray.remove(student);
    }

    public void updateStudent(Student newStudent, int index) {
        if(index-1 >= 0 && index-1 < studentsArray.size()) {
            studentsArray.remove(index-1);
        }
        else {
            System.out.println("Invalid option");
        }
        studentsArray.add(newStudent);
    }

    public void updateStudentName(String newName, String id) {
        for (Student student : studentsArray) {
            if(student.getCode().equals(id)) {
                student.setStudentName(newName);
            }
        }
    }

    public void sortReports(ArrayList<Report> reports) {
        Collections.sort(reports, new Comparator<Report>() {
            public int compare(Report r1, Report r2) {
                return r1.getStudentName().compareToIgnoreCase(r2.getStudentName());
            }
        });
    }

    public ArrayList<Report> getReports() {
        ArrayList<Report> reportsList = new ArrayList<Report>();
        for (Student student : studentsArray) {

            int totalCourse = 0;

            Report newReport = new Report();
            newReport.setCode(student.getCode().trim());
            newReport.setStudentName(student.getStudentName().trim());
            newReport.setCourseName(student.getCourseName().trim());

            for (Student s : studentsArray) {
                if(s.getCode().equals(student.getCode()) && s.getCourseName().equals(student.getCourseName())) {
                    totalCourse++;
                }
            }
            newReport.setTotalCourse(totalCourse);

            if(!validation.checkReportExist(reportsList, newReport)) {
                reportsList.add(newReport);
            }
        }
        sortReports(reportsList);
        return reportsList;
    }

    public ArrayList<Student> getAllStudents() {
        return studentsArray;
    }
}