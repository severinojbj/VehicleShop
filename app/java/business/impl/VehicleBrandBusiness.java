package app.java.business.impl;

import app.java.basic.VehicleBrand;
import app.java.business.IVehicleBrandBusiness;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.exception.EmptyDataException;
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

    @Override
    public List<VehicleBrand> listAllVehicleBrands() throws EmptyDataException {
        List<VehicleBrand> resp = this.brandData.getBrands ();
        if (resp.isEmpty()) {
            throw new EmptyDataException ("VehicleBrand");
        }
        return resp;
    }

    @Override
    public VehicleBrand searchVehicleBrandByID(int id) throws DataNotExistsException, EmptyDataException {
        VehicleBrand resp = null;
        List<VehicleBrand> list = this.listAllVehicleBrands();
        for (VehicleBrand item: list) {
            if (item.getId() == id) {
                    resp = item;
            }
        }
        if (resp == null) {
            throw new DataNotExistsException ("VehicleBrand");
        }           
        return resp;
    }

    @Override
    public VehicleBrand searchVehicleBrandByName (String name) throws DataNotExistsException, EmptyDataException {
        VehicleBrand resp = null;
        try {
            List<VehicleBrand> list = this.listAllVehicleBrands();
            for (VehicleBrand item: list) {
                if (item.getName().equalsIgnoreCase(name)) {
                    resp = item;
                }
            }
            if (resp == null) {
                throw new DataNotExistsException ("VehicleBrand");
            }
        }
        catch (DataNotExistsException e) {
            throw e;
        }            
        return resp;
    }

    @Override
    public void insertVehicleBrand(VehicleBrand vehicleBrand) throws DataExistsException, EmptyDataException {
        if (vehicleBrand != null) {
            try {
                VehicleBrand vehicleBrandExists = this.searchVehicleBrandByID(vehicleBrand.getId());
                throw new DataExistsException ("VehicleBrand");
            }
            catch (DataNotExistsException e) {
                this.brandData.addVehicleBrand(vehicleBrand);
            }    
        }
        else {
            throw new EmptyDataException ("VehicleBrand");
        }
    }

    @Override
    public void updateVehicleBrand(VehicleBrand vehicleBrand) throws DataNotExistsException, EmptyDataException {
        if (vehicleBrand != null) {
            VehicleBrand vehicleBrandExists = this.searchVehicleBrandByID(vehicleBrand.getId());
            int index = this.brandData.getBrands().indexOf(vehicleBrandExists);
            this.brandData.updateVehicleBrand (index, vehicleBrand);
        }
        else {
            throw new EmptyDataException ("VehicleBrand");
        }
    }

    @Override
    public void deleteVehicleBrand(VehicleBrand vehicleBrand) throws DataNotExistsException, EmptyDataException {
        if (vehicleBrand != null) {
            VehicleBrand vehicleBrandExists = this.searchVehicleBrandByID(vehicleBrand.getId());
            this.brandData.removeVehicleBrand (vehicleBrandExists);
        }
        else {
            throw new EmptyDataException ("VehicleBrand");
        }
    }
   
    
}
