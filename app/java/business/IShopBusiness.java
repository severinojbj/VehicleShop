package app.java.business;

import app.java.basic.Shop;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.exception.EmptyDataException;
import java.util.List;

public interface IShopBusiness {

    public List<Shop> listAllShops () throws EmptyDataException;

    public Shop searchShopByID (int id) throws DataNotExistsException, EmptyDataException;    

    public void insertShop (Shop shop) throws DataExistsException, EmptyDataException;

    public void updateShop (Shop shop) throws DataNotExistsException, EmptyDataException;

    public void deleteShop (Shop shop) throws DataNotExistsException, EmptyDataException;   

}
