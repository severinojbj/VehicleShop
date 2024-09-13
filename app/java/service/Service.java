package app.java.service;

import app.java.basic.Customer;
import app.java.basic.Sale;
import app.java.basic.Seller;
import app.java.basic.Shop;
import app.java.basic.Vehicle;
import app.java.basic.VehicleBrand;
import app.java.business.ICustomerBusiness;
import app.java.business.ISaleBusiness;
import app.java.business.ISellerBusiness;
import app.java.business.IShopBusiness;
import app.java.business.IVehicleBrandBusiness;
// import app.java.business.IVehicleBrandBusiness;
import app.java.business.IVehicleBusiness;

import app.java.business.impl.CustomerBusiness;
import app.java.business.impl.SaleBusiness;
import app.java.business.impl.SellerBusiness;
import app.java.business.impl.ShopBusiness;
import app.java.business.impl.VehicleBrandBusiness;
import app.java.business.impl.VehicleBusiness;
import app.java.exception.DataExistsException;
// import app.java.business.impl.VehicleBrandBusiness;
import app.java.exception.DataNotExistsException;
import app.java.exception.EmptyDataException;

public class Service {

    private ICustomerBusiness customerBusiness;
    private ISaleBusiness saleBusiness;
    private ISellerBusiness sellerBusiness;
    private IShopBusiness shopBusiness;
    private IVehicleBusiness vehicleBusiness;
    private IVehicleBrandBusiness vehicleBrandBusiness;

    public Service () {

        this.customerBusiness = new CustomerBusiness();
        this.saleBusiness = new SaleBusiness();
        this.sellerBusiness = new SellerBusiness();
        this.shopBusiness = new ShopBusiness();
        this.vehicleBusiness = new VehicleBusiness ();
        this.vehicleBrandBusiness = new VehicleBrandBusiness();
    }

    private String insertVehicleBrand (String brandName) {
        String message = "Marca cadastrada com sucesso.";
        VehicleBrand brand;
        int regNumber = 0;

        try {
            regNumber = this.vehicleBrandBusiness.listAllVehicleBrands().size();
            // brand = new VehicleBrand (regNumber, brandName);
            // this.vehicleBrandBusiness.insertVehicleBrand(brand);
            message = "Marca já existente.";
        }
        catch (EmptyDataException e1) {
            message = "Primeira marca.";
        }
        
        brand = new VehicleBrand (0, brandName);
        this.vehicleBrandBusiness.insertVehicleBrand(brand);
        
        catch (DataExistsException e2) {
            message = "ERRO: problema na inserção de nova marca com dado existente: " + e2.getObjectError();
        }

        return message;
    }

    public String insertVehicle (String brandName, String model, String plate) {
        
        String message = "Veículo cadastrado com sucesso";
        VehicleBrand brand = null;
        Vehicle newVehicle = null;
        try {        
            brand = this.vehicleBrandBusiness.searchVehicleBrandByName(brandName);
        }
        catch (DataNotExistsException e) {
            message = this.insertVehicleBrand(brandName);
        }
        catch (EmptyDataException e) {
            if (e.getObjectError().equals ("String")) {
                message = "ERRO: a marca do veículo está ausente na inserção do veículo.";
            }
            else {
                message = "ERRO: algum dado está ausente na inserção do veículo.";
            }
        }
        
        try {
            newVehicle = new Vehicle(brand, model, plate);
            this.vehicleBusiness.insertVehicle(newVehicle);
        }
        catch () {

        }

        
        return message;
    }

    public void updateVehicle (Vehicle v) {
        this.vehicleBusiness.updateVehicle(v);
    }

    public void deleteVehicle (Vehicle v) {
        this.vehicleBusiness.insertVehicle(v);
    }

    public void insertShop (Shop s) {
        this.shopBusiness.insertShop(s);
    }

    public void updateShop (Shop s) {
        this.shopBusiness.updateShop(s);
    }

    public void deleteShop (Shop s) {
        this.shopBusiness.deleteShop(s);
    }

    public void insertSeller (Seller s) {
        this.sellerBusiness.insertSeller(s);
    }

    public void updateSeller (Seller s) {
        this.sellerBusiness.updateSeller(s);
    }

    public void deleteSeller (Seller s) {
        this.sellerBusiness.deleteSeller(s);
    }

    public void insertCustomer (Customer s) {
        this.customerBusiness.insertCustomer(s);
    }

    public void updateCustomer (Customer s) {
        this.customerBusiness.updateCustomer(s);
    }

    public void deleteCustomer (Customer s) {
        this.customerBusiness.deleteCustomer(s);
    }

    public void insertSale (Sale s) {
        this.saleBusiness.insertSale(s);
    }

    public void updateSale (Sale s) {
        this.saleBusiness.updateSale(s);
    }

    public void deleteSale (Sale s) {
        this.saleBusiness.deleteSale(s);
    }

}
