package app.java.business.impl;

import app.java.basic.Shop;
import app.java.business.IShopBusiness;
import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.repository.ShopRepository;
import java.util.List;

public class ShopBusiness implements IShopBusiness{

    private ShopRepository shopData;

    public ShopBusiness() {
        this.shopData = new ShopRepository();
    }

    public ShopRepository getShopData() {
        return shopData;
    }

    public void setShopData(ShopRepository shopData) {
        this.shopData = shopData;
    }

    private Shop internalSearchShopByID (int id) {
        Shop resp = null;
        List<Shop> list = this.shopData.getShops();
        if (list != null) {
            int counter = 0;
            boolean isEqual = false;
            while (!isEqual && counter < list.size()) {
                isEqual = list.get(counter).getId() == id;
                if (isEqual) {
                    resp = list.get(counter);
                }
                counter++;
            }             
        }
        return resp;
    }

    private Shop internalSearchShopByName (String name) {
        Shop resp = null;
        List<Shop> list = this.shopData.getShops();
        if (list != null) {
            int counter = 0;
            boolean isEqual = false;
            while (!isEqual && counter < list.size()) {
                isEqual = list.get(counter).getName().equals(name);
                if (isEqual) {
                    resp = list.get(counter);
                }
                counter++;
            }   
        }           
        return resp;
    }

    @Override
    public List<Shop> listAllShops() throws DataNotExistsException{
        List<Shop> resp = this.shopData.getShops();
        if (resp == null) {
            throw new DataNotExistsException ("Shop");
        }
        return resp;
    }

    @Override
    public Shop searchShopByID(int id) throws DataNotExistsException {
        Shop resp = this.internalSearchShopByID(id);
        if (resp == null) {
            throw new DataNotExistsException ("Shop");
        }
        return resp;
    }

    @Override
    public Shop searchShopByName(String name) throws DataEmptyException, DataNotExistsException {
        Shop resp = null;
        if (name != null) {
            resp = this.internalSearchShopByName(name);
            if (resp == null) {
                throw new DataNotExistsException ("Shop");
            }
        }   
        else {
            throw new DataEmptyException ("Shop");
        }            
        return resp;
    }

    @Override
    public void insertShop (String name, String location, String phoneNumber) throws DataEmptyException, DataExistsException {
        if (name != null) {
            Shop shopExists = this.internalSearchShopByName(name);
            if (shopExists == null) {
                int index = this.shopData.getShops().size();
                Shop shop = new Shop (index, name, location, phoneNumber);
                this.shopData.addShop(shop);
            }
            else {
                throw new DataExistsException ("Shop");
            }
        }
        else {
            throw new DataEmptyException("Shop");
        }
    }

    @Override
    public void updateShop (String name, String location, String phoneNumber) throws DataEmptyException, DataNotExistsException {
        if (name != null) {
            Shop shopExists = this.internalSearchShopByName(name);
            if (shopExists != null) {
                int index = this.shopData.getShops().indexOf(shopExists);
                Shop shop = new Shop (index, name, location, phoneNumber);
                this.shopData.updateShop(index, shop);
            }
            else {
                throw new DataNotExistsException ("Shop");
            }
        }
        else {
            throw new DataEmptyException("Shop");
        }
    }

    @Override
    public void deleteShop (String name) throws DataEmptyException, DataNotExistsException {
        if (name != null) {
            Shop shopExists = this.internalSearchShopByName(name);
            if (shopExists != null) {
                this.shopData.removeShop(shopExists);
            }
            else {
                throw new DataNotExistsException ("Shop");
            }
        }
        else {
            throw new DataEmptyException("Shop");
        }
    }
        
}
