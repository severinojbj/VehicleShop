package app.java.business.impl;

import app.java.basic.VehicleBrand;
import app.java.business.IVehicleBrandBusiness;
import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.repository.VehicleBrandRepository;
import java.util.List;

public class VehicleBrandBusiness implements IVehicleBrandBusiness{

    private VehicleBrandRepository brandData;

    public VehicleBrandBusiness() {
        this.brandData = new VehicleBrandRepository();
    }

    public VehicleBrandRepository getBrandData() {
        return brandData;
    }

    public void setBrandData(VehicleBrandRepository brandData) {
        this.brandData = brandData;
    }

    private VehicleBrand internalSearchVehicleBrandByID (int id) {
        VehicleBrand resp = null;
        List<VehicleBrand> list = this.brandData.getBrands();
        if (list != null) {
            int contador = 0;
            boolean isEqual = false;
            while (!isEqual && contador < list.size()) {
                isEqual = list.get(contador).getId() == id;
                if (isEqual == true) {
                    resp = list.get(contador);
                }
                contador++;
            }
        }
        return resp;
    }

    public VehicleBrand internalSearchVehicleBrandByName (String name) {
        VehicleBrand resp = null;
        List<VehicleBrand> list = this.brandData.getBrands();
        if (list != null) {
            int contador = 0;
            boolean isEqual = false;
            while (!isEqual && contador < list.size()) {
                isEqual = list.get(contador).getName().equals(name);
                if (isEqual == true) {
                    resp = list.get(contador);
                }
                contador++;
            }
        }
        return resp;
    }

    @Override
    public List<VehicleBrand> listAllVehicleBrands() throws DataNotExistsException {
        List<VehicleBrand> resp = this.brandData.getBrands();
        if (resp == null) {
            throw new DataNotExistsException ("VehicleBrand");
        }
        return resp;
    }

    @Override
    public VehicleBrand searchVehicleBrandByID(int id) throws DataNotExistsException {
        VehicleBrand resp = this.internalSearchVehicleBrandByID (id);
        if (resp == null) {
            throw new DataNotExistsException ("VehicleBrand");
        }
        return resp;
    }

    @Override
    public VehicleBrand searchVehicleBrandByName (String name) throws DataEmptyException, DataNotExistsException {
        VehicleBrand resp = null;
        if (name != null) {
            resp = this.internalSearchVehicleBrandByName(name);
            if (resp == null) {
                throw new DataNotExistsException ("VehicleBrand");
            }
        }
        else {
            throw new DataEmptyException ("VehicleBrand");
        }
        return resp;
    }

    @Override
    public void insertVehicleBrand(String name) throws DataEmptyException, DataExistsException {
        if (name != null) { 
            VehicleBrand vehicleBrandExists = this.internalSearchVehicleBrandByName(name);
            if (vehicleBrandExists == null) {
                int index = this.brandData.getBrands().size();
                VehicleBrand vehicleBrand = new VehicleBrand(index, name);
                this.brandData.addVehicleBrand(vehicleBrand);
            }
            else {
                throw new DataExistsException ("VehicleBrand");
            }
        }
        else {
            throw new DataEmptyException("VehicleBrand");
        }
    }

    @Override
    public void updateVehicleBrand(String name) throws DataEmptyException, DataNotExistsException {
        if (name != null) { 
            VehicleBrand vehicleBrandExists = this.internalSearchVehicleBrandByName(name);
            if (vehicleBrandExists != null) {
                int index = this.brandData.getBrands().indexOf(vehicleBrandExists);
                VehicleBrand vehicleBrand = new VehicleBrand(index, name);
                this.brandData.updateVehicleBrand(index, vehicleBrand);
            }
            else {
                throw new DataNotExistsException ("VehicleBrand");
            }
        }
        else {
            throw new DataEmptyException("VehicleBrand");
        }
    }

    @Override
    public void deleteVehicleBrand(String name) throws DataEmptyException, DataNotExistsException {
        if (name != null) { 
            VehicleBrand vehicleBrandExists = this.internalSearchVehicleBrandByName(name);
            if (vehicleBrandExists != null) {
                this.brandData.removeVehicleBrand(vehicleBrandExists);
            }
            else {
                throw new DataNotExistsException ("VehicleBrand");
            }
        }
        else {
            throw new DataEmptyException("VehicleBrand");
        }
    }   
    
}
