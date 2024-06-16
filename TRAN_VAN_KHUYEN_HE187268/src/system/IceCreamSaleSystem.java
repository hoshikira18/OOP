package system;

import controller.CustomerController;
import controller.EmployeeController;
import controller.IceCreamController;
import controller.InvoiceController;
import view.ConsoleView;

import java.util.Scanner;

public class IceCreamSaleSystem {

    ConsoleView view;
    EmployeeController employeeController;
    CustomerController customerController;
    InvoiceController invoiceController;
    IceCreamController iceCreamController;
    Scanner scanner;

    public IceCreamSaleSystem() {
        this.view = new ConsoleView();
        this.scanner = new Scanner(System.in);
        this.employeeController = new EmployeeController();
        this.customerController = new CustomerController();
        this.invoiceController = new InvoiceController();
        this.iceCreamController = new IceCreamController();
    }

    public void start () {
        while(true) {
            view.displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    employeeController.start();
                    break;
                case 2:
                    iceCreamController.start();
                    break;
                case 3:
                    invoiceController.start();
                    break;
                case 5:
                    customerController.start();
                case 4:
                    return;
                default:
                    System.out.println("Chose from 1 - 4");
            }
        }
    }
}
