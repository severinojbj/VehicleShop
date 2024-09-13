package app.java.business.impl;

import app.java.basic.Sale;
import app.java.business.ISaleBusiness;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.exception.EmptyDataException;
import app.java.repository.SaleRepository;
import java.util.List;

public class SaleBusiness implements ISaleBusiness{

    private SaleRepository saleData;

    public SaleBusiness() {
        this.saleData = new SaleRepository();
    }

    public SaleRepository getSaleData() {
        return saleData;
    }

    public void setSaleData(SaleRepository saleData) {
        this.saleData = saleData;
    }

    @Override
    public List<Sale> listAllSales() throws EmptyDataException {
        List<Sale> resp = this.saleData.getSales();
        if (resp.isEmpty()) {
            throw new EmptyDataException ("Sale");
        }
        return resp;
    }

    @Override
    public Sale searchSaleByID(int id) throws DataNotExistsException, EmptyDataException {
        Sale resp = null;
        List<Sale> list = this.listAllSales();
        for (Sale item: list) {
            if (item.getId() == id) {
                resp = item;
            }
        }
        if (resp == null) {
            throw new DataNotExistsException ("Sale");
        }                
        return resp;
    }

    @Override
    public void insertSale(Sale sale) throws DataExistsException, EmptyDataException {
        if (sale != null) {
            try {
                Sale saleExists = this.searchSaleByID(sale.getId());
                throw new DataExistsException ("Sale");
            }
            catch (DataNotExistsException e) {
                this.saleData.addSale(sale);
            }    
        }
        else {
            throw new EmptyDataException ("Sale");
        }
    }

    @Override
    public void updateSale(Sale sale) throws DataNotExistsException, EmptyDataException {
        if (sale != null) {
            Sale saleExists = this.searchSaleByID(sale.getId());
            int index = this.saleData.getSales().indexOf(saleExists);
            this.saleData.updateSale (index, sale);
        }
        else {
            throw new EmptyDataException ("Sale");
        }
    }

    @Override
    public void deleteSale(Sale sale) throws DataNotExistsException, EmptyDataException {
        if (sale != null) {
            Sale saleExists = this.searchSaleByID(sale.getId());
            this.saleData.removeSale(saleExists);
        }
        else {
            throw new EmptyDataException ("Sale");
        }
    }    

}
