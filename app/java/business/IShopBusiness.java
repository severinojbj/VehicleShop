package app.java.business;

import app.java.basic.Shop;
import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import java.util.List;

public interface IShopBusiness {

    public List<Shop> listAllShops () throws DataNotExistsException;

    public Shop searchShopByID (int id) throws DataNotExistsException;

    public Shop searchShopByName(String name) throws DataEmptyException, DataNotExistsException;

    public void insertShop (String name, String location, String phoneNumber) throws DataEmptyException, DataExistsException;

    public void updateShop (String name, String location, String phoneNumber) throws DataEmptyException, DataNotExistsException;

    public void deleteShop (String name) throws DataEmptyException, DataNotExistsException;   

}
