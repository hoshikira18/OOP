package model.storage;

import model.avltree.AVLTree;
import model.entities.Employee;
import view.ConsoleView;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmployeeStorage {
    final String EMPLOYEE_STORAGE_PATH = "src/data/employee/";

    ConsoleView view = new ConsoleView();

    public void saveEmployee(Employee employee) {
        try {
            Path directoryPath = Paths.get(EMPLOYEE_STORAGE_PATH);
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // create file path
        String filePath = EMPLOYEE_STORAGE_PATH + employee.getEmpId() + ".dat";
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(employee);
            fileOutputStream.close();
            view.displayMessage("Employee saved successfully to: " + filePath);
        } catch (IOException e) {
            view.displayMessage("Error while saving employee: " + filePath);
        }
    }

    public AVLTree<Employee> getAllEmployees() {
        AVLTree<Employee> employeeTree = new AVLTree<>();

        Path directoryPath = Paths.get(EMPLOYEE_STORAGE_PATH);
        if (!Files.exists(directoryPath)) {
            view.displayMessage("No employees found in " + directoryPath);
            return employeeTree;
        }

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath, "emp_*.dat")) {
            for (Path filePath : directoryStream) {
                try (
                        FileInputStream fileInputStream = new FileInputStream(filePath.toFile());
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ) {
                    Employee employee = (Employee) objectInputStream.readObject();
                    fileInputStream.close();
                    employeeTree.insert(employee);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return employeeTree;
    }

    public Employee getEmployee(String id) {

        Path directoryPath = Paths.get(EMPLOYEE_STORAGE_PATH);
        if (!Files.exists(directoryPath)) {
            view.displayMessage("No employees found in " + directoryPath);
            return null;
        }

        String filePath = EMPLOYEE_STORAGE_PATH + id + ".dat";
        try (
                FileInputStream fileInputStream = new FileInputStream(filePath);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            Employee employee = (Employee) objectInputStream.readObject();
            fileInputStream.close();
            return employee;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEmployee(String id) {
        String filePath = EMPLOYEE_STORAGE_PATH + id + ".dat";
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                System.out.println("File not found: " + id + ".dat");
                return;
            }

            // Delete the file
            if (file.delete()) {
                System.out.println("File deleted successfully: " + id + ".dat");
            } else {
                System.out.println("Failed to delete the file: " + id + ".dat");
            }
        } catch (SecurityException e) {
            System.out.println("Permission denied: Unable to delete the file");
        }
    }

}
