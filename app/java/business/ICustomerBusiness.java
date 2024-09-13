package app.java.business;

import app.java.basic.Customer;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.exception.EmptyDataException;
import java.util.List;

public interface ICustomerBusiness {

    public List<Customer> listAllCustomers () throws EmptyDataException;

    public Customer searchCustomerByCPF (String CPF) throws DataNotExistsException, EmptyDataException;    

    public void insertCustomer (Customer customer) throws DataExistsException, EmptyDataException;

    public void updateCustomer (Customer customer) throws DataNotExistsException, EmptyDataException;

    public void deleteCustomer (Customer customer) throws DataNotExistsException, EmptyDataException;   
    
}
