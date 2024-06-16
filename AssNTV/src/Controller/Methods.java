/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Invoice;
import Model.Tree;
import java.util.Scanner;

/**
 *
 * @author VIET
 */
public class Methods {
    
    Scanner scanner = new Scanner(System.in);
    Tree<Invoice> invoiceTree;
    
    public void askADDInvoice(Invoice invoice){
        System.out.println("Invoice ID: ");
        invoice.setInvoiceId(scanner.nextLine());
        
        System.out.println("Invoice date: ");
        invoice.setDate(scanner.nextLine());
        
        System.out.println("Customer ID: ");
        invoice.setCustomerId(scanner.nextLine());
        
        System.out.println("Invoice items: ");
        String check = "";
        while (!check.equals("E")) {            
            System.out.println("Add items (A/a) or End (E/e)");
            if(check.equals("A") || check.equals("a")){
                System.out.println("Ice-cream ID: ");
                String creamID = scanner.nextLine();
                System.out.println("Quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                
            }
        }
    }
    
}
