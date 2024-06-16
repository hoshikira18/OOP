/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Customer;
import Model.Employee;
import Model.IceCream;
import Model.Invoice;
import java.util.Map;

/**
 *
 * @author VIET
 */
public class PrintOutInfor {
    
    // Customer
    public void printCusInfor( Customer customer){
        System.out.println("---------CUSTOMER-INFOR---------");
        System.out.println("Name of customer: " + customer.getCusName());
        System.out.println("ID of customer: " + customer.getCustomerId());
        System.out.println("Rank of customer: " + customer.getRank());
        System.out.println("--------------------------------");
    }
    
    public void printInvoiceOfCus( Customer customer){
        System.out.println("---------ALL-INVOICES---------");
        for (Invoice invoice : customer.getInvoices()) {
            System.out.println("InvoiceID: "+invoice.getInvoiceId()+" | Total: "+ invoice.getTotal());
        }
        System.out.println("-------------------------------");
    }
    
    // Employee
    public void printEmpInfor(Employee employee){
        System.out.println("---------EMPLOYEE-INFOR---------");
        System.out.println("Name of employee: " + employee.getEmpName());
        System.out.println("ID of employee: "+ employee.getId());
        System.out.println("Phone number of employee: "+ employee.getPhone());
        System.out.println("Salary of employee: " + employee.getSalary());
        System.out.println("---------------------------------");
    }
    
    public void printListEmployee(Employee employee){
        System.out.println("Employee ID: "+employee.getId()
                + " | Employee name: "+employee.getEmpName());
    }
    
    // Ice-cream
    public void printIceCreamInfor(IceCream iceCream){
        System.out.println("---------ICE-CREAM---------");
        System.out.println("ID of ice-cream: " + iceCream.getCreamId());
        System.out.println("Name of ice-cream: " + iceCream.getName());
        System.out.println("Taste of ice-cream: " + iceCream.getTaste());
        System.out.println("Price of ice-cream: "+ iceCream.getPrice());
        System.out.println("---------------------------");
    }
    
    public void printListIceCream(IceCream iceCream){
        System.out.println("Ice-cream ID: "+ iceCream.getCreamId()
                + " | Ice-cream name: " + iceCream.getName());
    }
    
    // Invoice
    public void printInvoiceInfor(Invoice invoice){
        System.out.println("---------INVOICE---------");
        System.out.println("ID of invoice: " + invoice.getInvoiceId());
        System.out.println("ID of customer " + invoice.getCustomerId());
        System.out.println("Date of invoice: " + invoice.getDate());
        System.out.println("List items in invoice: ");
        int i =1;
        for (Map.Entry<IceCream, Integer> entry : invoice.getItems().entrySet()) {
            System.out.println("\t"+i+". " + entry.getKey().getName()
                    + " | Quantity: " + entry.getValue());
        }
        System.out.println("Total of invoice: "+ invoice.getTotal());
        System.out.println("--------------------------");
    }
    
    public void printInvoiceByDate(Invoice invoice){
        System.out.println("Invoice ID: " + invoice.getInvoiceId() 
                + " | Customer ID: " + invoice.getCustomerId() 
                + " | Total: " + invoice.getTotal());
    }
    
    
}
