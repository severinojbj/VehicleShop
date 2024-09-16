package app.java.business;

import app.java.basic.VehicleBrand;
import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import java.util.List;

public interface IVehicleBrandBusiness {

    public List<VehicleBrand> listAllVehicleBrands () throws DataNotExistsException;

    public VehicleBrand searchVehicleBrandByID (int id) throws DataNotExistsException;    

    public VehicleBrand searchVehicleBrandByName (String name) throws DataEmptyException, DataNotExistsException;    

    public void insertVehicleBrand (String name) throws DataEmptyException, DataExistsException;

    public void updateVehicleBrand (String name) throws DataEmptyException, DataNotExistsException;

    public void deleteVehicleBrand (String name) throws DataEmptyException, DataNotExistsException;   

}
