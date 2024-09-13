package app.java.repository;

import app.java.basic.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private List<Customer> customers;

    public CustomerRepository () {
        this.customers = new ArrayList();
    }

    public CustomerRepository (List<Customer> customers) {
        this.customers = customers;
    }

    public void setCustomers (List<Customer> customers) {
        this.customers = customers;
    }

    public List<Customer> getCustomers () {
        return this.customers;
    }

    public void addCustomer (Customer customer) {
        this.customers.add(customer);
    }

    public void updateCustomer (int index, Customer customer) {
        this.customers.set(index, customer);
    }

    public void removeCustomer (Customer customer) {
        this.customers.removeIf(item -> item.getCPF() == customer.getCPF());
    }


}
