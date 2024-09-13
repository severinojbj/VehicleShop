package app.java.business;

import app.java.basic.Sale;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.exception.EmptyDataException;
import java.util.List;

public interface ISaleBusiness {
    
    public List<Sale> listAllSales () throws EmptyDataException;

    public Sale searchSaleByID (int id) throws DataNotExistsException, EmptyDataException;    

    public void insertSale (Sale sale) throws DataExistsException, EmptyDataException;

    public void updateSale (Sale sale) throws DataNotExistsException, EmptyDataException;

    public void deleteSale (Sale sale) throws DataNotExistsException, EmptyDataException;   
}
