package controller;

import model.avltree.AVLTree;
import model.dao.CustomerDAO;
import model.entities.Customer;
import view.ConsoleView;
import view.customer.CustomerView;

import java.util.Scanner;

public class CustomerController {
    Scanner scanner = new Scanner(System.in);
    CustomerView view = new CustomerView();
    ConsoleView mainView = new ConsoleView();

    CustomerDAO customerDAO;
    AVLTree<Customer> customers;

    public CustomerController() {
        this.customerDAO = new CustomerDAO();
        this.customers = customerDAO.getAllCustomers();
    }

    public void start () {
        while (true) {
            view.displayCustomerMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    this.createNewCustomer();
                    break;
                case 2:
                    this.display();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Chose from 1 - 5");
            }
        }
    }


    public void createNewCustomer () {
        mainView.displayInputMessage("phone number");
        String phoneNumber = scanner.nextLine();
        mainView.displayInputMessage("customer name");
        String cusName = scanner.nextLine();

        Customer newCusomer = new Customer(phoneNumber, cusName);
        customerDAO.createNewCustomer(newCusomer);
        customers.insert(newCusomer);
    }

    public Customer createNewCustomer (String phoneNumber) {
        mainView.displayInputMessage("customer name");
        String cusName = scanner.nextLine();

        Customer newCustomer = new Customer(phoneNumber, cusName);
        customerDAO.createNewCustomer(newCustomer);
        customers.insert(newCustomer);
        return newCustomer;
    }

    public void display () {
        view.displayAllCustomers(this.customers);
    }
}
