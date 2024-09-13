package app.java.repository;

import app.java.basic.Shop;
import java.util.ArrayList;
import java.util.List;

public class ShopRepository {

    private List<Shop> shops;

    public ShopRepository() {
        this.shops = new ArrayList();
    }

    public ShopRepository(List<Shop> shops) {
        this.shops = shops;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    public void addShop (Shop shop) {
        this.shops.add(shop);
    }

    public void updateShop (int index, Shop shop) {
        this.shops.set(index, shop);
    }

    public void removeShop (Shop shop) {
        this.shops.removeIf(item -> item.getId() == shop.getId());
    }    

}
