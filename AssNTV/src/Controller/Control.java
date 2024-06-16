/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Customer;
import Model.Employee;
import Model.IceCream;
import Model.Invoice;
import Model.Node;
import Model.Tree;
import View.DisplayMenu;
import View.PrintOutInfor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

/**
 *
 * @author VIET
 */
public class Control {

    DisplayMenu display = new DisplayMenu();
    PrintOutInfor print = new PrintOutInfor();
    
    Scanner scanner = new Scanner(System.in);
    
    
    Tree<Invoice> invoiceTree = new Tree<>();
    Tree<IceCream> iceCreamTree = new Tree<>();
    Tree<Employee> employeeTree = new Tree<>();
    Tree<Customer> customerTree = new Tree<>();
    

    public void controlInvoice() {
        
        String choose1 = "";
        
        while (!choose1.equals("6")) {
            
            display.displayInvoice();
            choose1 = scanner.nextLine();

            switch (choose1) {
                case "1":// Create new invoice
                    Invoice invoice = new Invoice();
                    invoiceTree.add(invoiceTree.getRoot(), invoice);
                    break;
                case "2":// Find invoice by name of customer (forget invoiceId)
                    
                    break;
                case "3":// Find invoice by date

                    break;
                case "4":// Update old invoice

                    break;
                case "5":// Information of invoice
                    Node<Invoice> invoice1;
                    String nodeID = "1234";
                    invoice1 = invoiceTree.getNode(invoiceTree.getRoot(), nodeID);
                    print.printInvoiceInfor(invoice1.getData());
                   
                    break;
                case "6":// Exit
                    System.out.println("Thank you for using.");
                    break;
                default:
                    System.out.println("Choose from 1 to 6:");
            }
        }
    }

    public void controlIceCream() {
        
        String choose2 = "";
        
        while (!choose2.equals("6")) {
            display.displayIceCream();
            choose2 = scanner.nextLine();

            switch (choose2) {
                case "1":// Add new ice-cream

                    break;
                case "2":// Delete old ice-cream

                    break;
                case "3":// Update ice-cream

                    break;
                case "4":// Information of ice-cream

                    break;
                case "5":// Show all ice-cream

                    break;
                case "6":// Exit
                    System.out.println("Thank you for using.");
                    break;
                default:
                    System.out.println("Choose from 1 to 6:");
            }
        }
    }

    public void controlEmployee() {
        
        String choose3 = "";
        
        while (!choose3.equals("6")) {
            display.displayEmployee();
            choose3 = scanner.nextLine();

            switch (choose3) {
                case "1":// Add new employee

                    break;
                case "2":// Delete old employee

                    break;
                case "3":// Update employee

                    break;
                case "4":// Information of an employee

                    break;
                case "5":// List employees

                    break;
                case "6":// Exit
                    System.out.println("Thank you for using.");
                    break;
                default:
                    System.out.println("Choose from 1 to 6:");
            }
        }
    }

    public void controlCustomer() {
        
        String choose4 = "";
        
        while (!choose4.equals("4")) {
            display.displayCustomer();
            choose4 = scanner.nextLine();

            switch (choose4) {
                case "1":// Add new customer

                    break;
                case "2":// Information of customer

                    break;
                case "3":// List inovces and total of customer

                    break;
                case "4":// Exit
                    System.out.println("Thank you for using.");
                    break;
                default:
                    System.out.println("Choose from 1 to 4:");
            }
        }
    }

}
