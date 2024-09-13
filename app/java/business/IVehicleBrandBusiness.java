package app.java.business;

import app.java.basic.VehicleBrand;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.exception.EmptyDataException;
import java.util.List;

public interface IVehicleBrandBusiness {

    public List<VehicleBrand> listAllVehicleBrands () throws EmptyDataException;

    public VehicleBrand searchVehicleBrandByID (int id) throws DataNotExistsException, EmptyDataException;    

    public VehicleBrand searchVehicleBrandByName (String name) throws DataNotExistsException, EmptyDataException;    

    public void insertVehicleBrand (VehicleBrand vehicleBrand) throws DataExistsException, EmptyDataException;

    public void updateVehicleBrand (VehicleBrand vehicleBrand) throws DataNotExistsException, EmptyDataException;

    public void deleteVehicleBrand (VehicleBrand vehicleBrand) throws DataNotExistsException, EmptyDataException;   

}
