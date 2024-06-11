package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentCode;
    private String studentName;
    private final List<CourseRecord> courseRecords;

    public Student(String studentCode, CourseRecord courseRecord, String studentName) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.courseRecords = new ArrayList<>();
        this.courseRecords.add(courseRecord);
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<CourseRecord> getCourseRecords() {
        return courseRecords;
    }

    public void addCourseRecord(CourseRecord course) {
        this.courseRecords.add(course);
    }
}
