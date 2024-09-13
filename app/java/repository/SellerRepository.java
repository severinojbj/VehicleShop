package app.java.repository;

import app.java.basic.Seller;
import java.util.ArrayList;
import java.util.List;

public class SellerRepository {
    private List<Seller> sellers;

    public SellerRepository () {
        this.sellers = new ArrayList();
    }

    public SellerRepository (List<Seller> sellers) {
        this.sellers = sellers;
    }

    public void setSellers (List<Seller> sellers) {
        this.sellers = sellers;
    }

    public List<Seller> getSellers () {
        return this.sellers;
    }

    public void addSeller (Seller seller) {
        this.sellers.add(seller);
    }

    public void updateSeller (int index, Seller seller) {
        this.sellers.set(index, seller);
    }

    public void removeSeller (Seller seller) {
        this.sellers.removeIf(item -> item.getCPF() == seller.getCPF());
    }

}
