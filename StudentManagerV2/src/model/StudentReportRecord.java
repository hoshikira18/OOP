package model;

public class StudentReportRecord {
    public String sName;
    public String courseName;
    public int totalCourse;

    public StudentReportRecord(String sName, String courseName, int totalCourse) {
        this.sName = sName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    public StudentReportRecord () {

    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }
}
