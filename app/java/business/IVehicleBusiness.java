package app.java.business;

import app.java.basic.Vehicle;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.exception.EmptyDataException;
import java.util.List;

public interface IVehicleBusiness {

    public List<Vehicle> listAllVehicles () throws EmptyDataException;

    public Vehicle searchVehicleByPlate (String plate) throws DataNotExistsException, EmptyDataException;    

    public void insertVehicle (Vehicle vehicle) throws DataExistsException, EmptyDataException;

    public void updateVehicle (Vehicle vehicle) throws DataNotExistsException, EmptyDataException;

    public void deleteVehicle (Vehicle vehicle) throws DataNotExistsException, EmptyDataException;    

}
