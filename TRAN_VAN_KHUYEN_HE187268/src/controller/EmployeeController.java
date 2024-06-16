package controller;

import model.avltree.AVLTree;
import model.dao.EmployeeDAO;
import model.entities.Employee;
import utils.IDGenerator;
import view.ConsoleView;
import view.employee.EmployeeView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmployeeController {
    Scanner scanner = new Scanner(System.in);
    IDGenerator idGenerator = new IDGenerator();
    EmployeeView view = new EmployeeView();
    ConsoleView mainView = new ConsoleView();

    public EmployeeDAO employeeDAO;
    public AVLTree<Employee> employeeTree;
    public EmployeeController() {
        this.employeeDAO = new EmployeeDAO();
        this.employeeTree = employeeDAO.getAllEmployeesData();
    }

    public void start () {
        while(true) {
            view.displayEmployeeMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    this.addEmployee();
                    break;
                case 2:
                    this.search();
                    break;
                case 3:
                    this.updateEmployee();
                    break;
                case 4:
                    this.deleteEmployee();
                    break;
                case 5:
                    return;
                case 6:
                    view.displayAllEmployees(employeeTree);
                default:
                    System.out.println("Chose from 1 - 5");
            }
        }
    }

    public void addEmployee() {
        String id = idGenerator.generateEmployeeID();
        mainView.displayInputMessage("Employee Name");
        String name = scanner.nextLine();
        mainView.displayInputMessage("Salary");
        double salary = Double.parseDouble(scanner.nextLine());

        Employee newEmp = new Employee(id, name, salary, new Date());

        employeeTree.insert(newEmp);
        employeeDAO.addEmployee(newEmp);
    }

    public ArrayList<Employee> searchEmployeeByName() {
        mainView.displayInputMessage("keyword (Name)");
        String keyword = scanner.nextLine();
        ArrayList<Employee> searchingResults = new ArrayList<>();
        employeeTree.searchEmployeeByName(employeeTree.root, keyword, searchingResults);
        return searchingResults;
    }

    public void search () {
        ArrayList<Employee> searchingResults = searchEmployeeByName();
        if(searchingResults.isEmpty()) {
            mainView.displayMessage("Employee not founded!");
            return;
        }
        view.displaySearchingResults(searchingResults);
    }

    public void updateEmployee () {

        ArrayList<Employee> searchingResults = searchEmployeeByName();
        view.displaySearchingResults(searchingResults);

        if(searchingResults.isEmpty()) {
            mainView.displayMessage("Employee not founded!");
            return;
        }

        mainView.displayMessage("Chose a record to update");
        mainView.displayInputMessage("record (Enter index)");
        int recordIndex = Integer.parseInt(scanner.nextLine());

        Employee chosenEmployee = employeeDAO.getEmployee(searchingResults.get(recordIndex).getEmpId());

        employeeTree.deleteNode(chosenEmployee);

        while(true) {
            view.displayUpdateEmployeeMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    mainView.displayInputMessage("new name");
                    String newName = scanner.nextLine();
                    chosenEmployee.setEmpName(newName);
                    break;
                case 2:
                    mainView.displayInputMessage("new salary");
                    double newSalary = Double.parseDouble(scanner.nextLine());
                    chosenEmployee.setSalary(newSalary);
                    break;
                case 3:
                    employeeTree.insert(chosenEmployee);
                    employeeDAO.addEmployee(chosenEmployee);
                    return;
                default:
                    System.out.println("Chose from 1 - 3");
            }
        }
    }

    public void deleteEmployee () {
        ArrayList<Employee> searchingResults = searchEmployeeByName();
        view.displaySearchingResults(searchingResults);

        if(searchingResults.isEmpty()) {
            mainView.displayMessage("Employee not founded!");
            return;
        }

        mainView.displayMessage("Chose a record to delete");
        mainView.displayInputMessage("record (Enter index)");
        int recordIndex = Integer.parseInt(scanner.nextLine());

        Employee chosenEmployee = employeeDAO.getEmployee(searchingResults.get(recordIndex).getEmpId());

        employeeTree.deleteNode(chosenEmployee);
        employeeDAO.deleteEmployee(chosenEmployee.getEmpId());
    }
}
