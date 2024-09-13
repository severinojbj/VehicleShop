package app.java.business.impl;

import app.java.basic.Customer;
import app.java.business.ICustomerBusiness;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.exception.EmptyDataException;
import app.java.repository.CustomerRepository;
import java.util.List;

public class CustomerBusiness implements ICustomerBusiness {

    private CustomerRepository customerData;

    public CustomerBusiness () {
        this.customerData = new CustomerRepository();
    }

    public CustomerRepository getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerRepository customerData) {
        this.customerData = customerData;
    }

    @Override
    public List<Customer> listAllCustomers() throws EmptyDataException {
        List<Customer> resp = this.customerData.getCustomers();
        if (resp.isEmpty()) {
            throw new EmptyDataException ("Customer");
        }
        return resp;
    }

    @Override
    public Customer searchCustomerByCPF(String CPF) throws DataNotExistsException, EmptyDataException {
        Customer resp = null;
        if (CPF != null) {
            List<Customer> list = this.listAllCustomers();
            for (Customer item: list) {
                if (item.getCPF().equals(CPF)) {
                    resp = item;
                }
            }
            if (resp == null) {
                throw new DataNotExistsException ("Customer");
            }        
        }
        else {
            throw new EmptyDataException ("CPF");
        }
        return resp;
    }

    @Override
    public void insertCustomer(Customer customer) throws DataExistsException, EmptyDataException {
        try {
            Customer customerExists = this.searchCustomerByCPF(customer.getCPF());
            throw new DataExistsException ("Customer");
        }
        catch (DataNotExistsException e) {
            this.customerData.addCustomer(customer);
        }        
    }

    @Override
    public void updateCustomer(Customer customer) throws DataNotExistsException, EmptyDataException {
        if (customer != null) {
            Customer customerExists = this.searchCustomerByCPF(customer.getCPF());
            int index = this.customerData.getCustomers().indexOf(customerExists);
            this.customerData.updateCustomer (index, customer);
        }
        else {
            throw new EmptyDataException ("Customer");
        }
    }

    @Override
    public void deleteCustomer(Customer customer) throws DataNotExistsException, EmptyDataException {
        if (customer != null) {
            Customer customerExists = this.searchCustomerByCPF(customer.getCPF());
            this.customerData.removeCustomer(customerExists);
        }
        else {
            throw new EmptyDataException ("Customer");
        }
   
    }    

}
