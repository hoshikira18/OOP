package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Comparable<Employee>, Serializable {
    private String empId;
    private String empName;
    private double salary;
    private Date startWorkingDate;

    public Employee(String empId, String empName, double salary, Date startWorkingDate) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.startWorkingDate = startWorkingDate;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getStartWorkingDate() {
        return startWorkingDate;
    }

    public void setStartWorkingDate(Date startWorkingDate) {
        this.startWorkingDate = startWorkingDate;
    }

    @Override
    public int compareTo(Employee emp) {
        return this.empId.compareTo(emp.getEmpId());
    }

    public String toString() {
        return "ID: " + this.empId + " | " + this.empName + " | " + this.salary;
    }
}
