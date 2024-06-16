package view.customer;

import model.avltree.AVLNode;
import model.avltree.AVLTree;
import model.entities.Customer;

public class CustomerView {
    public void displayCustomerMenu () {
        System.out.println("");
        System.out.println("===== MIXUE CUSTOMER =====");
        System.out.println("1. Add new customer");
        System.out.println("2. Display all customer");
    }

    public void displayAllCustomers(AVLTree<Customer> customers) {
        displayCustomer(customers.root);
    }

    public void displayCustomer(AVLNode<Customer> root) {
        if(root == null) {
            return;
        }
        displayCustomer(root.left);
        System.out.println(root.data.toString());
        displayCustomer(root.right);
    }


}
