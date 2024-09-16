package app.java.business;

import app.java.basic.Sale;
import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import java.util.List;

public interface ISaleBusiness {
    
    public List<Sale> listAllSales () throws DataEmptyException, DataNotExistsException;

    public Sale searchSaleByID (int id) throws DataEmptyException, DataNotExistsException;    

    public void insertSale (double value, String CPFCustomer, String nameSeller, 
        String carPlate, String sellData) throws DataEmptyException, DataExistsException;

    public void updateSale (double value, String CPFCustomer, String nameSeller, 
        String carPlate, String sellData) throws DataEmptyException, DataNotExistsException;

    public void deleteSale (Sale sale) throws DataEmptyException, DataNotExistsException;   
}
