package controller;

import model.avltree.AVLTree;
import model.entities.Customer;
import model.entities.IceCream;
import model.entities.Invoice;
import utils.IDGenerator;
import utils.validation.CommonValidation;
import view.ConsoleView;
import view.ice_cream.IceCreamView;
import view.invoice.InvoiceView;

import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceController {
    Scanner scanner = new Scanner(System.in);
    ConsoleView mainView = new ConsoleView();
    InvoiceView invoiceView = new InvoiceView();
    IceCreamView iceCreamView = new IceCreamView();
    IDGenerator idGenerator = new IDGenerator();
    CommonValidation commonValidation = new CommonValidation();

//    CustomerController customerController;
    IceCreamController iceCreamController;

    public InvoiceController () {
//        this.customerController = new CustomerController();
        this.iceCreamController = new IceCreamController();
    }

    public void start() {
        while (true) {
            invoiceView.displayInvoiceMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    this.createInvoice();
                    break;
                case 2:
                    return;
                default:
                    mainView.displayMessage("Enter 1 or 2");
            }
        }
    }

    public void createInvoice() {
        boolean isSave = commonValidation.isContinue("Does customer want to save information? (Y/N)");

    }



}
