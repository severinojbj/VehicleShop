package app.java.business.impl;

import app.java.basic.Seller;
import app.java.business.ISellerBusiness;
import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.repository.SellerRepository;
import java.util.List;

public class SellerBusiness implements ISellerBusiness{

    private SellerRepository sellerData;

    public SellerBusiness() {
        this.sellerData = new SellerRepository();
    }
    
    public SellerRepository getSellerData() {
        return sellerData;
    }

    public void setSellerData(SellerRepository sellerData) {
        this.sellerData = sellerData;
    }

    private Seller internalSearchSellerByName (String name) {
        Seller resp = null;
        List<Seller> list = this.sellerData.getSellers();
        if (list != null) {
            int counter = 0;
            boolean isEqual = false;
            while (!isEqual && counter < list.size()) {
                isEqual = list.get(counter).getName().equals(name);
                if (isEqual) {
                    resp = list.get(counter);
                }
                counter++;
            }
        }             
        return resp;
    }

    private Seller internalSearchSellerByCPF (String CPF) {
        Seller resp = null;
        List<Seller> list = this.sellerData.getSellers();
        if (list != null) {
            int counter = 0;
            boolean isEqual = false;
            while (!isEqual && counter < list.size()) {
                isEqual = list.get(counter).getCPF().equals(CPF);
                if (isEqual) {
                    resp = list.get(counter);
                }
                counter++;
            }
        }             
        return resp;
    }

    @Override
    public List<Seller> listAllSellers() throws DataNotExistsException{
        List<Seller> resp = this.sellerData.getSellers();
        if (resp == null) {
            throw new DataNotExistsException("Seller");
        }
        return resp;
    }

    @Override
    public Seller searchSellerByName (String name) throws DataEmptyException, DataNotExistsException {
        Seller resp = null;
        if (name != null) {
            resp = this.internalSearchSellerByName(name);
            if (resp == null) {
                throw new DataNotExistsException ("Seller");
            }
        }
        else {
            throw new DataEmptyException ("Seller");
        }
        return resp;
    }

    @Override
    public void insertSeller(String CPF, String name, String phoneNumber) throws DataEmptyException, DataExistsException {
        if (CPF != null) {
            Seller sellerExists = this.internalSearchSellerByCPF(CPF);
            if (sellerExists == null) {
                Seller seller = new Seller (CPF, name, phoneNumber);
                this.sellerData.addSeller(seller);
            }   
            else {
                throw new DataExistsException ("Seller");
            } 
        }
        else {
            throw new DataEmptyException("Seller");
        }   
    }

    @Override
    public void updateSeller(String CPF, String name, String phoneNumber) throws DataEmptyException, DataNotExistsException {
        if (CPF != null) {
            Seller sellerExists = this.internalSearchSellerByCPF(CPF);
            if (sellerExists != null) {
                int index = this.sellerData.getSellers().indexOf(sellerExists);
                Seller seller = new Seller (CPF, name, phoneNumber);
                this.sellerData.updateSeller (index, seller); 
            }   
            else {
                throw new DataNotExistsException ("Seller");
            }
        }
        else {
            throw new DataEmptyException("Seller");
        }   
    }

    @Override
    public void deleteSeller(String CPF) throws DataEmptyException, DataNotExistsException {
        if (CPF != null) {
            Seller sellerrExists = this.internalSearchSellerByCPF(CPF);
            if (sellerrExists != null) {
                this.sellerData.removeSeller(sellerrExists);
            }   
            else {
                throw new DataNotExistsException ("Seller");
            }
        }
        else {
            throw new DataEmptyException("Seller");
        }
    }
   
}
