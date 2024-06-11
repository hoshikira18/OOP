package model;

public class CourseRecord {
    private String courseName;
    private String semester;

    public CourseRecord(String courseName, String semester) {
        this.courseName = courseName;
        this.semester = semester;
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
