package model.dao;

import model.avltree.AVLTree;
import model.entities.Employee;
import model.storage.EmployeeStorage;

public class EmployeeDAO {
    EmployeeStorage employeeStorage;

    public EmployeeDAO() {
        this.employeeStorage = new EmployeeStorage();
    }

    public void addEmployee(Employee employee) {
        employeeStorage.saveEmployee(employee);
    }

    public AVLTree<Employee> getAllEmployeesData() {
        return employeeStorage.getAllEmployees();
    }

    public void deleteEmployee (String id) {
        employeeStorage.deleteEmployee(id);
    }

    public Employee getEmployee (String id) {
        return employeeStorage.getEmployee(id);
    }

}
