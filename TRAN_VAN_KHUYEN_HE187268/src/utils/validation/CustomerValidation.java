package utils.validation;

import model.avltree.AVLTree;
import model.entities.Customer;

public class CustomerValidation {
    public boolean isCustomerExisted (AVLTree<Customer> customers, Customer customer) {
        return customers.isNodeExisted(customer);
    }

}
