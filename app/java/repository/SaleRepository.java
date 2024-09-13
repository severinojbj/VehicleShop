package app.java.repository;

import app.java.basic.Sale;
import java.util.ArrayList;
import java.util.List;

public class SaleRepository {

    private List<Sale> sales;

    public SaleRepository() {
        this.sales = new ArrayList<>();
    }

    public SaleRepository(List<Sale> sales) {
        this.sales = sales;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public void addSale (Sale sale) {
        this.sales.add(sale);
    }

    public void updateSale (int index, Sale sale) {
        this.sales.set(index, sale);
    }

    public void removeSale (Sale sale) {
        this.sales.removeIf(item -> item.getId() == sale.getId());
    }
    

}
