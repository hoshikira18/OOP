package model.entities;

import model.avltree.AVLNode;
import model.avltree.AVLTree;

import java.io.Serializable;

public class Customer implements Comparable<Customer>, Serializable {
    private String customerPhone;
    private String customerName;
    private AVLTree<Invoice> invoices;
    private String rank;
    private double totalInvoice;

    public Customer(String customerPhone, String customerName) {
        this.customerPhone = customerPhone;
        this.customerName = customerName;
        this.invoices = new AVLTree<>();
        this.totalInvoice = 0;
        this.rank = "D";
    }

    public Customer (String phone) {
        this.customerPhone = phone;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public AVLTree<Invoice> getInvoices() {
        return invoices;
    }

    public void addInvoice(Invoice invoice) {
        totalInvoice(invoices.root);
        if(this.totalInvoice >= 500000 && this.totalInvoice < 1000000) {
            this.rank = "C";
        }
        if(this.totalInvoice >= 1000000 && this.totalInvoice < 2000000) {
            this.rank = "B";
        }
        if(this.totalInvoice >= 2000000) {
            this.rank = "A";
        }
        this.invoices.insert(invoice);
    }

    public void setInvoices(AVLTree<Invoice> invoices) {
        this.invoices = invoices;
    }

    public void totalInvoice (AVLNode<Invoice> root) {
        if(root == null) {
            return;
        }
        totalInvoice(root.left);
        totalInvoice += root.data.getTotal();
        totalInvoice(root.right);
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(Customer o) {
        return this.customerPhone.compareTo(o.getCustomerPhone());
    }

    public String toString () {
        return this.customerPhone + " | " + this.customerName + " | " + this.rank;
    }
}
