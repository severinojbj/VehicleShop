package app.java.business.impl;

import app.java.basic.Customer;
import app.java.basic.Sale;
import app.java.basic.Seller;
import app.java.basic.Vehicle;
import app.java.business.ISaleBusiness;
import app.java.exception.DataEmptyException;
import app.java.exception.DataNotExistsException;
import app.java.repository.SaleRepository;
import java.util.List;

public class SaleBusiness implements ISaleBusiness{

    private SaleRepository saleData;
    private CustomerBusiness customerBusiness;
    private SellerBusiness sellerBusiness;
    private VehicleBusiness vehicleBusiness;

    public SaleBusiness() {
        this.saleData = new SaleRepository();
        this.customerBusiness = new CustomerBusiness();
        this.sellerBusiness = new SellerBusiness();
        this.vehicleBusiness = new VehicleBusiness();
    }

    public SaleBusiness (CustomerBusiness customerBusiness, SellerBusiness sellerBusiness,
            VehicleBusiness vehicleBusiness){
        this.saleData = new SaleRepository();
        this.customerBusiness = customerBusiness;
        this.sellerBusiness = sellerBusiness;
        this.vehicleBusiness = vehicleBusiness;
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
    public Sale searchSaleByID(int id) throws DataEmptyException, DataNotExistsException {
        Sale resp = this.internalSearchSaleById(id);
        if (resp == null) {
            throw new DataNotExistsException ("Sale");
        }             
        return resp;
    }

    @Override
    public void insertSale(double value, 
            String CPFCustomer, String nameSeller, String carPlate, 
            String sellData) throws DataEmptyException, DataNotExistsException {
        try {
            Customer customer = this.customerBusiness.searchCustomerByCPF(CPFCustomer);
            Seller seller = this.sellerBusiness.searchSellerByName(nameSeller);
            Vehicle vehicle = this.vehicleBusiness.searchVehicleByPlate(carPlate);
            int index = this.saleData.getSales().size();
            Sale sale = new Sale(index, value, customer, seller, vehicle, sellData);
            this.saleData.addSale(sale);
        }
        catch (DataEmptyException e1) {
            throw e1;
        }
        catch (DataNotExistsException e2) {
            throw e2;
        }
    }

    @Override
    public void updateSale (int id, double value, String CPFCustomer, String nameSeller, 
            String carPlate, String sellData) throws DataEmptyException, DataNotExistsException {
        
        Sale saleExists = this.saleData.getSales().get(id);
        if (saleExists != null) {
            try {           
                Customer customer = this.customerBusiness.searchCustomerByCPF(CPFCustomer);
                Seller seller = this.sellerBusiness.searchSellerByName(nameSeller);
                Vehicle vehicle = this.vehicleBusiness.searchVehicleByPlate(carPlate);
                Sale sale = new Sale(id, value, customer, seller, vehicle, sellData);
                this.saleData.updateSale(id, sale);
            }
            catch (DataEmptyException e1) {
                throw e1;
            }
            catch (DataNotExistsException e2) {
                throw e2;
            }
        }
        else {
            throw new DataNotExistsException("Sale");
        }        
                
    }

    @Override
    public void deleteSale(int id) throws DataEmptyException, DataNotExistsException {
        
        Sale saleExists = this.saleData.getSales().get(id);
        if (saleExists != null) {
            this.saleData.removeSale(saleExists);
        }
        else {
            throw new DataNotExistsException("Sale");
        }
    }    

}
