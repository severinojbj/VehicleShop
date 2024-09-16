package app.java.business.impl;

import app.java.basic.Sale;
import app.java.business.ISaleBusiness;
import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
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


    private Sale internalSearchSaleById (int id) {
        Sale resp = null;
        List<Sale> list = this.getSaleData().getSales();
        if (list != null) {
            int counter = 0;
            boolean isEqual = false;
            while (!isEqual && counter < list.size()) { 
                isEqual = list.get(counter).getId() == id;
                if (isEqual) {
                    resp = list.get(counter);
                }
            }
        }            
        return resp;
    }

    @Override
    public List<Sale> listAllSales() throws DataNotExistsException {
        List<Sale> resp = this.saleData.getSales();
        if (resp == null) {
            throw new DataNotExistsException ("Sale");
        }
        return resp;
    }

    @Override
    public Sale searchSaleByID(int id) throws DataNotExistsException {
        Sale resp = this.internalSearchSaleById(id);
        if (resp == null) {
            throw new DataNotExistsException ("Sale");
        }             
        return resp;
    }

    @Override
    public void insertSale(double value, String CPFCustomer, String nameSeller, 
        String carPlate, String sellData) throws DataEmptyException, DataExistsException {
        // try {
        //     Sale saleExists = this.searchSaleByID(sale.getId());
        //     throw new DataExistsException ("Sale");
        // }
        // catch (DataNotExistsException e) {
        //     this.saleData.addSale(sale);
        // }    
    }

    @Override
    public void updateSale (double value, String CPFCustomer, String nameSeller, 
        String carPlate, String sellData) throws DataEmptyException, DataNotExistsException {
        // Sale saleExists = this.searchSaleByID(sale.getId());
        // int index = this.saleData.getSales().indexOf(saleExists);
        // this.saleData.updateSale (index, sale);
    }

    @Override
    public void deleteSale(Sale sale) throws DataEmptyException, DataNotExistsException {
        Sale saleExists = this.searchSaleByID(sale.getId());
        this.saleData.removeSale(saleExists);
    }    

}
