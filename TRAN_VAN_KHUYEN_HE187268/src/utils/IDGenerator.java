package utils;

public class IDGenerator {
    public String generateEmployeeID () {
        return "emp_" + System.currentTimeMillis();
    }
    public String generateCustomerID () {
        return "cus_" + System.currentTimeMillis();
    }
    public String generateIceCreamID () {
        return "ice_" + System.currentTimeMillis();
    }
    public String generateInvoiceID () {
        return "inv_" + System.currentTimeMillis();
    }
}
