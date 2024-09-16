package app.java.business.impl;

import app.java.basic.Customer;
import app.java.business.ICustomerBusiness;
import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
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

    private Customer internalSearchCustomerByCPF (String CPF) {
        Customer resp = null;
        List<Customer> list = this.customerData.getCustomers();
        if (list != null) {
            int counter = 0;
            boolean isEqual = false;
            while (!isEqual && counter < list.size()) {
                isEqual = list.get(counter).getCPF().equals(CPF);
                if (isEqual) {
                    resp = list.get(counter);
                }
                counter++;
            }
        }             
        return resp;
    }

    @Override
    public List<Customer> listAllCustomers() throws DataNotExistsException {
        List<Customer> resp = this.customerData.getCustomers();
        if (resp == null) {
            throw new DataNotExistsException("Customer");
        }
        return resp;
    }

    @Override
    public Customer searchCustomerByCPF (String CPF) throws DataEmptyException, DataNotExistsException {
        Customer resp = null;
        if (CPF != null) { 
            resp = this.internalSearchCustomerByCPF(CPF);
            if (resp == null) {
                throw new DataNotExistsException ("Customer");
            }
        }    
        else {
            throw new DataEmptyException ("Customer");
        }                 
        return resp;
    }

    @Override
    public void insertCustomer (String CPF, String name, String phoneNumber) throws DataEmptyException, DataExistsException {
        if (CPF != null) {
            Customer customerExists = this.internalSearchCustomerByCPF(CPF);
            if (customerExists == null) {
                Customer customer = new Customer (CPF, name, phoneNumber);
                this.customerData.addCustomer(customer);
            }   
            else {
                throw new DataExistsException ("Customer");
            } 
        }
        else {
            throw new DataEmptyException("Customer");
        }
    }

    @Override
    public void updateCustomer (String CPF, String name, String phoneNumber) throws DataEmptyException, DataNotExistsException {
        if (CPF != null) {
            Customer customerExists = this.internalSearchCustomerByCPF(CPF);
            if (customerExists != null) {
                int index = this.customerData.getCustomers().indexOf(customerExists);
                Customer customer = new Customer (CPF, name, phoneNumber);
                this.customerData.updateCustomer (index, customer); 
            }   
            else {
                throw new DataNotExistsException ("Customer");
            }
        }
        else {
            throw new DataEmptyException("Customer");
        }    
    }

    @Override
    public void deleteCustomer (String CPF) throws DataEmptyException, DataNotExistsException {
        if (CPF != null) {
            Customer customerExists = this.internalSearchCustomerByCPF(CPF);
            if (customerExists != null) {
                this.customerData.removeCustomer(customerExists);
            }   
            else {
                throw new DataNotExistsException ("Customer");
            }
        }
        else {
            throw new DataEmptyException("Customer");
        }    
    }    

}
