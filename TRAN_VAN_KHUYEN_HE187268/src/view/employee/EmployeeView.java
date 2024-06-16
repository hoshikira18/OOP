package view.employee;

import model.avltree.AVLNode;
import model.avltree.AVLTree;
import model.entities.Employee;

import java.util.ArrayList;

public class EmployeeView {
    public void displayEmployeeMenu () {
        System.out.println("");
        System.out.println("====== MIXUE EMPLOYEE =======");
        System.out.println("1. Add new employee");
        System.out.println("2. Search employee by name");
        System.out.println("3. Update employee details");
        System.out.println("4. Delete employee");
        System.out.println("5. Exit");
        System.out.println("Enter your choice (1-5): ");
    }

    public void displayUpdateEmployeeMenu () {
        System.out.println("");
        System.out.println("====== MIXUE UPDATE EMPLOYEE =======");
        System.out.println("1. Employee name");
        System.out.println("2. Employee salary");
        System.out.println("3. Exit");
        System.out.println("Enter your choice (1-3): ");
    }

    public void displayAllEmployees(AVLTree<Employee> employees) {
        displayEmployee(employees.root);
    }

    public void displayEmployee(AVLNode<Employee> root) {
        if(root == null) {
            return;
        }
        displayEmployee(root.left);
        System.out.println(root.data.toString());
        displayEmployee(root.right);
    }

    public void displaySearchingResults (ArrayList<Employee> searchingResults) {
        for(Employee e : searchingResults) {
            System.out.println(searchingResults.indexOf(e) + ". " + e.toString());
        }
    }
}
