/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author VIET
 */
public class Customer{
    
    String cusName;
    String customerId;
    ArrayList<Invoice> invoices;
    String rank;
    private String[] rankList = {"Plastic", "Iron", "Bronze", "Silver", "Gold", "Platinum", "Diamond", "Master"};

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRank() {
        int total = 0;
        for (Invoice invoice : this.invoices) {
            total += invoice.getTotal();
        }
        if(total < 50){
            rank = rankList[0];
        }else if(total >= 50 && total < 100){
            rank = rankList[1];
        }else if(total >= 100 && total < 200){
            rank = rankList[2];
        }else if(total >= 200 && total < 500){
            rank = rankList[3];
        }else if(total >= 500 && total < 1000){
            rank = rankList[4];
        }else if(total >= 1000 && total < 2000){
            rank = rankList[5];
        }else if(total >= 2000 && total < 5000){
            rank = rankList[6];
        }else if(total >= 5000 ){
            rank = rankList[7];
        }
        return rank;
    }
    
    
    
}
