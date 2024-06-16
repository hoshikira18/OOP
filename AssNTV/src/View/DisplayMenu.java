/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author VIET
 */
public class DisplayMenu {

    public void displayMain() {
        System.out.println("=========MIXUE=========");
        System.out.println("1. Invoice.");
        System.out.println("2. Ice-Cream.");
        System.out.println("3. Employee.");
        System.out.println("4. Customer.");
        System.out.println("5. Exit.");
    }

    public void displayInvoice() {
        System.out.println("1. Create new invoice");
        System.out.println("2. Find invoice by name of customer (forget invoiceId)");
        System.out.println("3. Find invoice by date");
        System.out.println("4. Update old invoice");
        System.out.println("5. Information of invoice");
        System.out.println("6. Exit");
    }

    public void displayIceCream() {
        System.out.println("1. Add new ice-cream");
        System.out.println("2. Delete old ice-cream");
        System.out.println("3. Update ice-cream");
        System.out.println("4. Information of ice-cream");
        System.out.println("5. Show all ice-cream");
        System.out.println("6. Exit");
    }

    public void displayEmployee() {
        System.out.println("1. Add new employee");
        System.out.println("2. Delete old employee");
        System.out.println("3. Update employee");
        System.out.println("4. Information of an employee");
        System.out.println("5. List employees");
        System.out.println("6. Exit");
    }

    public void displayCustomer() {
        System.out.println("1. Add new customer");
        System.out.println("2. Information of customer");
        System.out.println("3. List inovces and total of customer");
        System.out.println("4. Exit");
    }
    
    

}
