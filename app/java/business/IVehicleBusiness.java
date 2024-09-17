package app.java.business;

import app.java.basic.Vehicle;
import app.java.basic.VehicleBrand;
import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import java.util.List;

public interface IVehicleBusiness {

    public List<Vehicle> listAllVehicles () throws DataNotExistsException;

    public Vehicle searchVehicleByPlate (String plate) throws DataEmptyException, DataNotExistsException;    

    public void insertVehicle (VehicleBrand brand, String model, String plate, String category,
        String description, int year, double price) throws DataEmptyException, DataExistsException;

    public void insertVehicle(String brandName, String model, String plate, String category,
        String description, int year, double price) throws DataEmptyException, DataExistsException;

    public void updateVehicle (VehicleBrand brand, String model, String plate, String category,
        String description, int year, double price) throws DataEmptyException, DataNotExistsException;

    public void updateVehicle(String brandName, String model, String plate, String category,
        String description, int year, double price) throws DataEmptyException, DataExistsException, DataNotExistsException;

    public void deleteVehicle (String plate) throws DataEmptyException, DataNotExistsException;    

}
