/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author VIET
 */
public class Invoice {
    
    String invoiceId;
    HashMap<IceCream, Integer> items;
    int total;
    String date;
    String customerId;

    public Invoice() {
    }

    public Invoice(String invoiceId, String cusId, String date, HashMap<IceCream, Integer> items) {
        this.invoiceId = invoiceId;
        this.items = items;
        this.date = date;
        this.customerId = cusId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void addItem(IceCream ice_Cream, int quantity){
        for (Map.Entry<IceCream, Integer> entry : this.items.entrySet()) {
            if(entry.getKey().equals(ice_Cream)){
                entry.setValue(entry.getValue() + quantity);
                return;
            }
        }
        this.items.put(ice_Cream, quantity);
    }

    public int getTotal() {
        int payment = 0;
        for (Map.Entry<IceCream, Integer> entry : this.items.entrySet()) {
            int quantity = entry.getValue();
            int price = entry.getKey().price;
            payment += quantity * price;
        }
        return payment;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public HashMap<IceCream, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<IceCream, Integer> items) {
        this.items = items;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
