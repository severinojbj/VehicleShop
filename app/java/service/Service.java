package app.java.service;

import java.util.List;

import app.java.basic.Customer;
import app.java.basic.Sale;
import app.java.basic.Seller;
import app.java.basic.Shop;
import app.java.basic.Vehicle;
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
    private ISellerBusiness sellerBusiness;
    private IShopBusiness shopBusiness;    
    private IVehicleBrandBusiness vehicleBrandBusiness;
    private IVehicleBusiness vehicleBusiness;    
    private ISaleBusiness saleBusiness;

    public Service () {

        this.customerBusiness = new CustomerBusiness();       
        this.sellerBusiness = new SellerBusiness();
        this.shopBusiness = new ShopBusiness();
        this.vehicleBrandBusiness = new VehicleBrandBusiness();        
        this.vehicleBusiness = new VehicleBusiness ((VehicleBrandBusiness) this.vehicleBrandBusiness);
        this.saleBusiness = new SaleBusiness ((CustomerBusiness) this.customerBusiness, 
            (SellerBusiness) this.sellerBusiness, 
            (VehicleBusiness) this.vehicleBusiness);
    }
 
    public String listAllVehicles () {
        String message = "Veículos cadastradas:\n\n";
        try {
            List <Vehicle> vehicles = this.vehicleBusiness.listAllVehicles();
            for (Vehicle item: vehicles) {
                message += item.toString() + "\n";
            }
        }
        catch (DataNotExistsException e) {
            message += "(vazio)";
        }
        return message;
    }

    public String insertVehicle (String brandName, String model, String plate, String category,
            String description, int year, double price) {
        String message = String.format("Veículo MODELO %s, CATEGORIA %s, PLACA %s cadastrado com sucesso.", model, category, plate);        
        try {
            this.vehicleBusiness.insertVehicle(brandName, model, plate, category, description, year, price);
        }
        catch (DataExistsException e1) {
            message = "ERRO: ao inserir dados do veiculo -> placa já cadastrada.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao inserir dados do veiculo -> placa não informada ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao inserir dados do veiculo -> falha desconhecida.";
        }
        return message;
    }

    public String updateVehicle (String brandName, String model, String plate, String category,
            String description, int year, double price) {
        String message = String.format("Veículo MODELO %s, CATEGORIA %s, PLACA %s atuaizado com sucesso.", model, category, plate);        
                try {
            this.vehicleBusiness.updateVehicle(brandName, model, plate, category, description, year, price);
        }
        catch (DataNotExistsException e1) {
            message = "ERRO: ao atualizar dados do veiculo -> placa não cadastrada.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao atualizar dados do veiculo -> placa não informada ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao atualizar dados do veiculo -> falha desconhecida.";
        }
        return message;
    }

    public String deleteVehicle (String plate) {
        String message = String.format("Veículo PLACA %s removido com sucesso.", plate);        
        try {
            this.vehicleBusiness.deleteVehicle(plate);
        }
        catch (DataNotExistsException e1) {
            message = "ERRO: ao atualizar dados do veiculo -> placa não cadastrada.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao atualizar dados do veiculo -> placa não informada ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao atualizar dados do veiculo -> falha desconhecida.";
        }
        return message;
    }

    public String listAllShops () {
        String message = "Lojas cadastradas:\n";
        try {
            List <Shop> shops = this.shopBusiness.listAllShops();
            for (Shop item: shops) {
                message += item.toString() + "\n";
            }
        }
        catch (DataNotExistsException e) {
            message += "(vazio)";
        }
        return message;
    }

    public String insertShop (String name, String location, String phoneNumber) {
        String message = String.format("Loja NOME %s, ENDEREÇO %d, TELEFONE %s cadastrada com sucesso.", name, location, phoneNumber);        
        try {
            this.shopBusiness.insertShop(name, location, phoneNumber);
        }
        catch (DataExistsException e1) {
            message = "ERRO: ao inserir dados da loja -> nome já cadastrado.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao inserir dados da loja -> nome não informado ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao inserir dados da loja -> falha desconhecida.";
        }
        return message;
    }

    public String updateShop (String name, String location, String phoneNumber) {
        String message = String.format("Loja NOME %s, ENDEREÇO %d, TELEFONE %s atualizada com sucesso.", name, location, phoneNumber);        
        try {
            this.shopBusiness.updateShop(name, location, phoneNumber);
        }
        catch (DataNotExistsException e1) {
            message = "ERRO: ao atualizar dados da loja -> nome não cadastrado.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao atualizar dados da loja -> nome não informado ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao atualizar dados da loja -> falha desconhecida.";
        }
        return message;
    }

    public String deleteShop (String name) {
        String message = String.format("Loja Nome %s removida com sucesso.", name);        
        try {
            this.shopBusiness.deleteShop(name);
        }
        catch (DataNotExistsException e1) {
            message = "ERRO: ao atualizar dados da loja -> nome não cadastrado.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao atualizar dados da loja -> nome não informado ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao atualizar dados da loja -> falha desconhecida.";
        }
        return message;
    }    

    public String listAllSellers () {
        String message = "Vendedores cadastrados:\n";
        try {
            List <Seller> sellers = this.sellerBusiness.listAllSellers();
            for (Seller item: sellers) {
                message += item.toString() + "\n";
            }
        }
        catch (DataNotExistsException e) {
            message += "(vazio)";
        }
        return message;
    }

    public String searchSellerByName (String name) {
        String message = "";
        try {
            Seller seller = this.sellerBusiness.searchSellerByName(name);
            message = "Vendedor encontrado. " + seller.toString();
        }
        catch (DataNotExistsException e1) {
            message = "ERRO: ao procurar dados do vendedor -> CPF não enmcontrado.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao procurar dados do vendedor -> CPF não informado ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao procurar dados do vendedor -> falha desconhecida.";
        }
        return message;
    }

    public String insertSeller (String CPF, String name, String phoneNumber) {
        String message = String.format("Vendedor CPF %s, NOME %s, TELEFONE %s adicionado com sucesso.", CPF, name, phoneNumber);        
        try {
            this.customerBusiness.insertCustomer(CPF, name, phoneNumber);
        }
        catch (DataExistsException e1) {
            message = "ERRO: ao inserir dados do vendedor -> CPF já cadastrado.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao inserir dados do vendedor -> CPF não informado ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao inserir dados do vendedor -> falha desconhecida.";
        }
        return message;
    }

    public String updateSeller (String CPF, String name, String phoneNumber) {
        String message = String.format("Vendedor CPF %s, NOME %s, TELEFONE %s atualizado com sucesso.", CPF, name, phoneNumber);        
        try {
            this.customerBusiness.updateCustomer(CPF, name, phoneNumber);
        }
        catch (DataNotExistsException e1) {
            message = "ERRO: ao atualizar dados do vendedor -> CPF não cadastrado.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao atualizar dados do vendedor -> CPF não informado ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao atualizar dados do vendedor -> falha desconhecida.";
        }
        return message;
    }

    public String deleteSeller (String CPF) {
        String message = String.format("Vendedor CPF %s removido com sucesso.", CPF);        
        try {
            this.customerBusiness.deleteCustomer(CPF);
        }
        catch (DataNotExistsException e1) {
            message = "ERRO: ao remover dados do vendedor -> CPF não cadastrado.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao remover dados do vendedor -> CPF não informado ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao remover dados do vendedor -> falha desconhecida.";
        }
        return message;
    }

    public String listAllCustomers () {
        String message = "Clientes cadastrados:\n\n";
        try {
            List <Customer> customers = this.customerBusiness.listAllCustomers();
            for (Customer item: customers) {
                message += item.toString() + "\n";
            }
        }
        catch (DataNotExistsException e) {
            message += "(vazio)";
        }
        return message;
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
        String message = String.format("Cliente CPF %s, NOME %s, TELEFONE %s adicionado com sucesso.", CPF, name, phoneNumber); 
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
        String message = String.format("Cliente CPF %s, NOME %s, TELEFONE %s  atualizado com sucesso.", CPF, name, phoneNumber);        
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
            message = "ERRO: ao remover dados do cliente -> CPF não cadastrado.";
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao remover dados do cliente -> CPF não informado ou ausente.";
        }
        catch (Exception e3) {
            message = "ERRO: ao remover dados do cliente -> falha desconhecida.";
        }
        return message;
    }

    public String listAllSales () {
        String message = "Vendas cadastradas:\n";
        try {
            List <Sale> sales = this.saleBusiness.listAllSales();
            for (Sale item: sales) {
                message += item.toString() + "\n";
            }
        }
        catch (DataNotExistsException e) {
            message += "(vazio)";
        }
        return message;
    }

    public String insertSale (double value, 
            String CPFCustomer, String nameSeller, String carPlate, 
            String sellData) {
        String message = String.format("Venda cadastrada com sucesso.");        
        try {
            this.saleBusiness.insertSale (value, CPFCustomer, nameSeller, carPlate, sellData);
        }
        catch (DataNotExistsException e1) {
            message = "ERRO: ao inserir dados da venda -> Algum dado não cadastrado: " + e1.getObjectError();
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao inserir dados da venda -> Algum não informado ou ausente: " + e2.getObjectError();
        }
        catch (Exception e3) {
            message = "ERRO: ao inserir dados da venda -> falha desconhecida.";
        }
        return message;
    }

    public String updateSale (int id, double value, 
            String CPFCustomer, String nameSeller, String carPlate, 
            String sellData) {
        String message = String.format("Venda atualizada com sucesso.");        
        try {
            this.saleBusiness.updateSale (id, value, CPFCustomer, nameSeller, carPlate, sellData);
        }
        catch (DataNotExistsException e1) {
            message = "ERRO: ao atualizar dados da venda -> Algum dado não cadastrado: " + e1.getObjectError();
        }
        catch (DataEmptyException e2) {
            message = "ERRO: ao atualizar dados da venda -> Algo não informado ou ausente: " + e2.getObjectError();
        }
        catch (Exception e3) {
            message = "ERRO: ao atualizar dados da venda -> falha desconhecida.";
        }
        return message;
    }

    public String deleteSale (int id) {
        String message = String.format("Venda removida com sucesso.");        
        try {
            this.saleBusiness.deleteSale (id);
        }
        catch (DataNotExistsException e1) {
            message = "ERRO: ao remover venda -> venda não cadastrada.";
        }
        catch (Exception e2) {
            message = "ERRO: ao remover venda -> falha desconhecida.";
        }
        return message;
    }

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
