package app.java.business.impl;

import app.java.basic.Shop;
import app.java.basic.Vehicle;
import app.java.basic.VehicleBrand;
import app.java.business.IVehicleBusiness;
import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.repository.VehicleRepository;
import java.util.List;

public class VehicleBusiness implements IVehicleBusiness {

    private VehicleRepository vehicleData;

    public VehicleBusiness() {
        this.vehicleData = new VehicleRepository ();
    }

    public VehicleRepository getVehicleData() {
        return vehicleData;
    }

    public void setVehicleData(VehicleRepository vehicleData) {
        this.vehicleData = vehicleData;
    }

    private Vehicle internalSearchVehicleByPlate (String plate) {
        Vehicle resp = null;
        List<Vehicle> list = this.vehicleData.getVehicles();
        if (list != null) {
            int counter = 0;
            boolean isEqual = false;
            while (!isEqual && counter < list.size()) {
                isEqual = list.get(counter).getPlate().equals(plate);
                if (isEqual) {
                    resp = list.get(counter);
                }
                counter++;
            }             
        }
        return resp;
    }

    @Override
    public List<Vehicle> listAllVehicles() throws DataNotExistsException {
        List<Vehicle> resp = this.vehicleData.getVehicles();
        if (resp == null) {
            throw new DataNotExistsException ("Vehicle");
        }
        return resp;
    }

    @Override
    public Vehicle searchVehicleByPlate(String plate) throws DataEmptyException, DataNotExistsException {
        Vehicle resp = null;
        if (plate != null) {
            resp = this.internalSearchVehicleByPlate(plate);
            if (resp == null) {
                throw new DataNotExistsException ("Vehicle");
            } 
        }
        else {
            throw new DataEmptyException ("Vehicle");
        }                       
        return resp;
    }

    @Override
    public void insertVehicle(VehicleBrand brand, String model, String plate, String category,
            String description, int year, double price) throws DataEmptyException, DataExistsException {    
        if (plate != null) {
            Vehicle vehicle = this.internalSearchVehicleByPlate(plate);
            if (vehicle == null) {
                vehicle = new Vehicle (brand, model, plate, category,
                    description, year, price);
            }   
            else {
                throw new DataExistsException ("Vehicle");
            }             
        }
        else {
            throw new DataEmptyException ("Vehicle");
        }
    }

    @Override
    public void updateVehicle (VehicleBrand brand, String model, String plate, String category,
    String description, int year, double price) throws DataEmptyException, DataNotExistsException {
        Vehicle vehicleExists = this.searchVehicleByPlate(vehicle.getPlate());
        if (vehicleExists != null) {
            int index = this.vehicleData.getVehicles().indexOf(vehicleExists);
            this.vehicleData.updateVehicle (index, vehicle);
        }
        else {
            throw new DataNotExistsException ("Vehicle");
        }   
    }

    @Override
    public void deleteVehicle(String plate) throws DataEmptyException, DataNotExistsException {
        Vehicle vehicleExists = this.searchVehicleByPlate(vehicle.getPlate());
        if (vehicleExists != null) {
            this.vehicleData.removeVehicle (vehicleExists);
        }
        else {
            throw new DataNotExistsException ("Vehicle");
        }
    }
  
    
}
