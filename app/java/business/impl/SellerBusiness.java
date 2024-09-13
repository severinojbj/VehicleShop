package app.java.business.impl;

import app.java.basic.Seller;
import app.java.business.ISellerBusiness;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.exception.EmptyDataException;
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

    @Override
    public List<Seller> listAllSellers() throws EmptyDataException {
        List<Seller> resp = this.sellerData.getSellers();
        if (resp.isEmpty()) {
            throw new EmptyDataException ("Seller");
        }
        return resp;
    }

    @Override
    public Seller searchSellerByCPF(String CPF) throws DataNotExistsException, EmptyDataException {
        Seller resp = null;
        if (CPF != null) {
            List<Seller> list = this.listAllSellers();
            for (Seller item: list) {
                if (item.getCPF().equals(CPF)) {
                    resp = item;
                }
            }
            if (resp == null) {
                throw new DataNotExistsException ("Seller");
            }        
        }
        else {
            throw new EmptyDataException ("CPF");
        }
        return resp;
    }

    @Override
    public void insertSeller(Seller seller) throws DataExistsException, EmptyDataException {
        try {
            Seller sellerExists = this.searchSellerByCPF(seller.getCPF());
            throw new DataExistsException ("Seller");
        }
        catch (DataNotExistsException e) {
            this.sellerData.addSeller(seller);
        }    
    }

    @Override
    public void updateSeller(Seller seller) throws DataNotExistsException, EmptyDataException {
         if (seller != null) {
            Seller sellerExists = this.searchSellerByCPF(seller.getCPF());
            int index = this.sellerData.getSellers().indexOf(sellerExists);
            this.sellerData.updateSeller (index, seller);
        }
        else {
            throw new EmptyDataException ("Seller");
        }
    }

    @Override
    public void deleteSeller(Seller seller) throws DataNotExistsException, EmptyDataException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}
