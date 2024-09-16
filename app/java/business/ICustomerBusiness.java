package app.java.business;

import app.java.basic.Customer;
import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import java.util.List;

public interface ICustomerBusiness {

    public List<Customer> listAllCustomers () throws DataNotExistsException;

    public Customer searchCustomerByCPF (String CPF) throws DataEmptyException, DataNotExistsException;   

    public void insertCustomer (String CPF, String name, String phoneNumber) throws DataEmptyException, DataExistsException;

    public void updateCustomer (String CPF, String name, String phoneNumber) throws DataEmptyException, DataNotExistsException;

    public void deleteCustomer (String CPF) throws DataEmptyException, DataNotExistsException;   
    
}
