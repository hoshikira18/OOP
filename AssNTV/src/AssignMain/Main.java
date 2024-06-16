package AssignMain;


import Controller.Control;
import View.DisplayMenu;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author VIET
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        DisplayMenu display = new DisplayMenu();
        Scanner scanner = new Scanner(System.in);
        Control control = new Control();
        
        String choose = "";
        while (!choose.equals("5")) {
            display.displayMain();
            choose = scanner.nextLine();

            switch (choose) {
                case "1":// Invoice
                    control.controlInvoice();
                    break;
                case "2":// Ice-cream
                    control.controlIceCream();
                    break;
                case "3":// Employee
                    control.controlEmployee();
                    break;
                case "4":// Customer
                    control.controlCustomer();
                    break;
                case "5":// Exit
                    System.out.println("Thank you for using.");
                    break;
                default:
                    System.out.println("Choose from 1 to 5:");
            }

        }
        

    }
    
}
