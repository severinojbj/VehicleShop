package app.java.business.impl;

import app.java.basic.Vehicle;
import app.java.business.IVehicleBusiness;
import app.java.exception.DataExistsException;
import app.java.exception.DataNotExistsException;
import app.java.exception.EmptyDataException;
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

    @Override
    public List<Vehicle> listAllVehicles() throws EmptyDataException {
        List<Vehicle> resp = this.vehicleData.getVehicles();
        if (resp.isEmpty()) {
            throw new EmptyDataException ("Vehicle");
        }
        return resp;
    }

    @Override
    public Vehicle searchVehicleByPlate(String plate) throws DataNotExistsException, EmptyDataException {
        Vehicle resp = null;
        List<Vehicle> list = this.listAllVehicles();
        for (Vehicle item: list) {
            if (item.getPlate().equals(plate)) {
                resp = item;
            }
        }
        if (resp == null) {
            throw new DataNotExistsException ("Vehicle");
        }                
        return resp;
    }

    @Override
    public void insertVehicle(Vehicle vehicle) throws DataExistsException, EmptyDataException {
        if (vehicle != null) {
            try {
                Vehicle vehicleExists = this.searchVehicleByPlate(vehicle.getPlate());
                throw new DataExistsException ("Vehicle");
            }
            catch (DataNotExistsException e) {
                this.vehicleData.addVehicle(vehicle);
            }    
        }
        else {
            throw new EmptyDataException ("Vehicle");
        }
    }

    @Override
    public void updateVehicle(Vehicle vehicle) throws DataNotExistsException, EmptyDataException {
        if (vehicle != null) {
            Vehicle vehicleExists = this.searchVehicleByPlate(vehicle.getPlate());
            int index = this.vehicleData.getVehicles().indexOf(vehicleExists);
            this.vehicleData.updateVehicle (index, vehicle);
        }
        else {
            throw new EmptyDataException ("Vehicle");
        }
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) throws DataNotExistsException, EmptyDataException {
        if (vehicle != null) {
            Vehicle vehicleExists = this.searchVehicleByPlate(vehicle.getPlate());
            this.vehicleData.removeVehicle (vehicleExists);
        }
        else {
            throw new EmptyDataException ("Vehicle");
        }
    }
  
    
}
