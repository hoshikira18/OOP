package model;

public class Student {
    private String code;
    private String studentName;
    private String semester;
    private String courseName;

    public Student() {
    }

    public Student(String code, String studentName, String semester, String courseName) {
        this.code = code;
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
