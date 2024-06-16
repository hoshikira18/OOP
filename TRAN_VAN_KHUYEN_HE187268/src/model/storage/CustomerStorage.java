package model.storage;

import model.avltree.AVLTree;
import model.entities.Customer;
import model.entities.IceCream;
import view.ConsoleView;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomerStorage {
    final String CUSTOMER_STORAGE_PATH = "src/data/customer/";
    ConsoleView mainView = new ConsoleView();

    public AVLTree<Customer> getAllCustomers() {
        AVLTree<Customer> customers = new AVLTree<>();
        Path directoryPath = Paths.get(CUSTOMER_STORAGE_PATH);
        if (!Files.exists(directoryPath)) {
            mainView.displayMessage("No customer found in " + directoryPath);
            return customers;
        }

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath, "cus_*.dat")) {
            for (Path filePath : directoryStream) {
                try (
                        FileInputStream fileInputStream = new FileInputStream(filePath.toFile());
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ) {
                    Customer customer = (Customer) objectInputStream.readObject();
                    fileInputStream.close();
                    customers.insert(customer);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return customers;
    }

    public void saveNewCustomer(Customer customer) {
        try {
            Path directoryPath = Paths.get(CUSTOMER_STORAGE_PATH);
            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // create file path
        String filePath = CUSTOMER_STORAGE_PATH + "cus_" + customer.getCustomerPhone() + ".dat";
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(customer);
            fileOutputStream.close();
            mainView.displayMessage("Customer saved successfully to: " + filePath);
        } catch (IOException e) {
            mainView.displayMessage("saved: " + filePath);
        }
    }
}