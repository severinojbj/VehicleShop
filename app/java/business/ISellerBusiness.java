package app.java.business;

import app.java.basic.Seller;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.exception.EmptyDataException;
import java.util.List;

public interface ISellerBusiness {

    public List<Seller> listAllSellers () throws EmptyDataException;

    public Seller searchSellerByCPF (String CPF) throws DataNotExistsException, EmptyDataException;    

    public void insertSeller (Seller seller) throws DataExistsException, EmptyDataException;

    public void updateSeller (Seller seller) throws DataNotExistsException, EmptyDataException;

    public void deleteSeller (Seller seller) throws DataNotExistsException, EmptyDataException;  

}
