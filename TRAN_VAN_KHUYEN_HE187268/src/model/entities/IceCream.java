package model.entities;

import java.io.Serializable;

public class IceCream implements Comparable<IceCream>, Serializable {
    private String iceCreamId;
    private String iceCreamName;
    private double iceCreamPrice;

    public IceCream(String iceCreamId, String iceCreamName, double iceCreamPrice) {
        this.iceCreamId = iceCreamId;
        this.iceCreamName = iceCreamName;
        this.iceCreamPrice = iceCreamPrice;
    }

    public IceCream () {

    }

    public String getIceCreamId() {
        return iceCreamId;
    }

    public void setIceCreamId(String iceCreamId) {
        this.iceCreamId = iceCreamId;
    }

    public String getIceCreamName() {
        return iceCreamName;
    }

    public void setIceCreamName(String iceCreamName) {
        this.iceCreamName = iceCreamName;
    }

    public double getIceCreamPrice() {
        return iceCreamPrice;
    }

    public void setIceCreamPrice(double iceCreamPrice) {
        this.iceCreamPrice = iceCreamPrice;
    }

    @Override
    public int compareTo(IceCream o) {
        return (int)this.iceCreamPrice - (int)o.iceCreamPrice;
    }

    public String toString () {
        return "ID: " + this.iceCreamId + " | " + this.iceCreamName + " | " + this.iceCreamPrice;
    }
}
