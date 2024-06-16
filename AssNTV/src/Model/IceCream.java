/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author VIET
 */
public class IceCream {
    
    String creamId;
    String name;
    String taste;
    int price;

    public IceCream() {
    }

    public IceCream(String creamId, String name, String taste, int price) {
        this.creamId = creamId;
        this.name = name;
        this.taste = taste;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getCreamId() {
        return creamId;
    }

    public void setCreamId(String creamId) {
        this.creamId = creamId;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
}
