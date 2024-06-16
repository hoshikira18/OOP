package model.dao;

import model.avltree.AVLNode;
import model.avltree.AVLTree;
import model.entities.Customer;
import model.entities.IceCream;
import model.storage.CustomerStorage;

public class CustomerDAO {
    CustomerStorage customerStorage;

    public CustomerDAO() {
        this.customerStorage = new CustomerStorage();
    }

    public AVLTree<Customer> getAllCustomers () {
        return customerStorage.getAllCustomers();
    }

    public void createNewCustomer (Customer customer) {
        customerStorage.saveNewCustomer(customer);
    }

}
