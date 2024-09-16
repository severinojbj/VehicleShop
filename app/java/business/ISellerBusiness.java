package app.java.business;

import app.java.basic.Seller;
import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import java.util.List;

public interface ISellerBusiness {

    public List<Seller> listAllSellers () throws DataNotExistsException;

    public Seller searchSellerByName (String name) throws DataEmptyException, DataNotExistsException;   

    public void insertSeller (String CPF, String name, String phoneNumber) throws DataEmptyException, DataExistsException;

    public void updateSeller (String CPF, String name, String phoneNumber) throws DataEmptyException, DataNotExistsException;

    public void deleteSeller (String CPF) throws DataEmptyException, DataNotExistsException;   

}
