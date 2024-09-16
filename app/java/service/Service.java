package app.java.service;

import app.java.basic.Customer;
import app.java.business.ICustomerBusiness;
import app.java.business.ISaleBusiness;
import app.java.business.ISellerBusiness;
import app.java.business.IShopBusiness;
import app.java.business.IVehicleBrandBusiness;
import app.java.business.IVehicleBusiness;
import app.java.business.impl.CustomerBusiness;
import app.java.business.impl.SaleBusiness;
import app.java.business.impl.SellerBusiness;
import app.java.business.impl.ShopBusiness;
import app.java.business.impl.VehicleBrandBusiness;
import app.java.business.impl.VehicleBusiness;
import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;

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

    

    public String searchCustomerByCPF (String CPF) {
        String message = "";
        try {
            Customer customer = this.customerBusiness.searchCustomerByCPF(CPF);
            message = "Cliente encontrado. " + customer.toString();
        }
        catch (DataNotExistsException e1) {
            message = "ERRO: ao procurar dados do cliente -> CPF não enmcontrado.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao procurar dados do cliente -> CPF não informado ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao procurar dados do cliente -> falha desconhecida.";
        }
        return message;
    }

    public String insertCustomer (String CPF, String name, String phoneNumber) {
        String message = String.format("Cliente CPF %s, NOME %s adicionado com sucesso.", CPF, name);        
        try {
            this.customerBusiness.insertCustomer(CPF, name, phoneNumber);
        }
        catch (DataExistsException e1) {
            message = "ERRO: ao inserir dados do cliente -> CPF já cadastrado.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao inserir dados do cliente -> CPF não informado ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao inserir dados do cliente -> falha desconhecida.";
        }
        return message;
    }

    public String updateCustomer (String CPF, String name, String phoneNumber) {
        String message = String.format("Cliente CPF %s, NOME %s atualizado com sucesso.", CPF, name);        
        try {
            this.customerBusiness.updateCustomer(CPF, name, phoneNumber);
        }
        catch (DataNotExistsException e1) {
            message = "ERRO: ao atualizar dados do cliente -> CPF não cadastrado.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao atualizar dados do cliente -> CPF não informado ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao atualizar dados do cliente -> falha desconhecida.";
        }
        return message;
    }

    public String deleteCustomer (String CPF) {
        String message = String.format("Cliente CPF %s removido com sucesso.", CPF);        
        try {
            this.customerBusiness.deleteCustomer(CPF);
        }
        catch (DataNotExistsException e1) {
            message = "ERRO: ao atualizar dados do cliente -> CPF não cadastrado.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao atualizar dados do cliente -> CPF não informado ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao atualizar dados do cliente -> falha desconhecida.";
        }
        return message;
    }

    // public void insertSale (Sale s) {
    //     this.saleBusiness.insertSale(s);
    // }

    // public void updateSale (Sale s) {
    //     this.saleBusiness.updateSale(s);
    // }

    // public void deleteSale (Sale s) {
    //     this.saleBusiness.deleteSale(s);
    // }

    public ICustomerBusiness getCustomerBusiness() {
        return customerBusiness;
    }

    public void setCustomerBusiness(ICustomerBusiness customerBusiness) {
        this.customerBusiness = customerBusiness;
    }

    public ISaleBusiness getSaleBusiness() {
        return saleBusiness;
    }

    public void setSaleBusiness(ISaleBusiness saleBusiness) {
        this.saleBusiness = saleBusiness;
    }

    public ISellerBusiness getSellerBusiness() {
        return sellerBusiness;
    }

    public void setSellerBusiness(ISellerBusiness sellerBusiness) {
        this.sellerBusiness = sellerBusiness;
    }

    public IShopBusiness getShopBusiness() {
        return shopBusiness;
    }

    public void setShopBusiness(IShopBusiness shopBusiness) {
        this.shopBusiness = shopBusiness;
    }

    public IVehicleBusiness getVehicleBusiness() {
        return vehicleBusiness;
    }

    public void setVehicleBusiness(IVehicleBusiness vehicleBusiness) {
        this.vehicleBusiness = vehicleBusiness;
    }

    public IVehicleBrandBusiness getVehicleBrandBusiness() {
        return vehicleBrandBusiness;
    }

    public void setVehicleBrandBusiness(IVehicleBrandBusiness vehicleBrandBusiness) {
        this.vehicleBrandBusiness = vehicleBrandBusiness;
    }

}
