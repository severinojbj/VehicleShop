package app.java.business.impl;

import app.java.basic.Shop;
import app.java.business.IShopBusiness;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.exception.EmptyDataException;
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

    @Override
    public List<Shop> listAllShops() throws EmptyDataException {
        List<Shop> resp = this.shopData.getShops();
        if (resp.isEmpty()) {
            throw new EmptyDataException ("Shop");
        }
        return resp;
    }

    @Override
    public Shop searchShopByID(int id) throws DataNotExistsException, EmptyDataException {
        Shop resp = null;
        List<Shop> list = this.listAllShops();
        for (Shop item: list) {
            if (item.getId() == id) {
                resp = item;
            }
        }
        if (resp == null) {
            throw new DataNotExistsException ("Shop");
        }                
        return resp;
    }

    @Override
    public void insertShop(Shop shop) throws DataExistsException, EmptyDataException {
        if (shop != null) {
            try {
                Shop shopExists = this.searchShopByID(shop.getId());
                throw new DataExistsException ("Shop");
            }
            catch (DataNotExistsException e) {
                this.shopData.addShop(shop);
            }    
        }
        else {
            throw new EmptyDataException ("Shop");
        }
    }

    @Override
    public void updateShop(Shop shop) throws DataNotExistsException, EmptyDataException {
        if (shop != null) {
            Shop shopExists = this.searchShopByID(shop.getId());
            int index = this.shopData.getShops().indexOf(shopExists);
            this.shopData.updateShop (index, shop);
        }
        else {
            throw new EmptyDataException ("Shop");
        }
    }

    @Override
    public void deleteShop(Shop shop) throws DataNotExistsException, EmptyDataException {
        if (shop != null) {
            Shop shopExists = this.searchShopByID(shop.getId());
            this.shopData.removeShop(shopExists);
        }
        else {
            throw new EmptyDataException ("Shop");
        }
    }
        
}
