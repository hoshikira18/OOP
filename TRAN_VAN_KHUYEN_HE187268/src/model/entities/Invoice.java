package model.entities;

import model.avltree.AVLTree;

import java.io.Serializable;

public class Invoice implements Comparable<Invoice>, Serializable {
    private String invoiceId;
    private String customerPhone;
    private AVLTree<IceCream> items;
    private double total;

    public Invoice(String invoiceId, String customerPhone) {
        this.invoiceId = invoiceId;
        this.customerPhone = customerPhone;
        this.items = new AVLTree<>();
        this.total = 0;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public AVLTree<IceCream> getItems() {
        return items;
    }

    public void addItem(IceCream item) {
        this.total += item.getIceCreamPrice();
        this.items.insert(item);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int compareTo(Invoice o) {
        return this.invoiceId.compareTo(o.invoiceId);
    }

    public String toString() {
        return "ID: " + this.invoiceId + " | Phone: " + this.customerPhone + " | Total: " + this.total;
    }
}
