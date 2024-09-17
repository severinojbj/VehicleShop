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
    private VehicleBrandBusiness vehicleBrandBusiness;

    public VehicleBusiness() {
        this.vehicleData = new VehicleRepository ();
        this.vehicleBrandBusiness = new VehicleBrandBusiness();
    }

    public VehicleBusiness(VehicleBrandBusiness vehicleBrandBusiness) {
        this.vehicleData = new VehicleRepository ();
        this.vehicleBrandBusiness = vehicleBrandBusiness;
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
    public void insertVehicle(String brandName, String model, String plate, String category,
            String description, int year, double price) throws DataEmptyException, DataExistsException {    
        if (plate != null) {
            Vehicle vehicleExists = this.internalSearchVehicleByPlate(plate);
            if (vehicleExists == null) {
                VehicleBrand brand = this.vehicleBrandBusiness.internalSearchVehicleBrandByName(brandName);
                if (brand == null) {
                    this.vehicleBrandBusiness.insertVehicleBrand(brandName);
                    int lastIndex = this.vehicleBrandBusiness.getBrandData().getBrands().size();
                    brand = this.vehicleBrandBusiness.getBrandData().getBrands().get(lastIndex);
                }
                Vehicle vehicle = new Vehicle (brand, model, plate, category,
                    description, year, price);
                this.vehicleData.addVehicle(vehicle);
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
        if (plate != null) {
            Vehicle vehicleExists = this.internalSearchVehicleByPlate(plate);
            if (vehicleExists != null) {
                int index = this.vehicleData.getVehicles().indexOf(vehicleExists);
                Vehicle vehicle = new Vehicle(brand, model, plate, category, description, year, price);
                this.vehicleData.updateVehicle (index, vehicle);
            }
            else {
                throw new DataNotExistsException ("Vehicle");
            }   
        }
        else {
            throw new DataEmptyException("Vehicle");
        }
    }

    @Override
    public void updateVehicle (String brandName, String model, String plate, String category,
    String description, int year, double price) throws DataEmptyException, DataExistsException, DataNotExistsException {
        if (plate != null) {
            Vehicle vehicleExists = this.searchVehicleByPlate(plate);
            if (vehicleExists != null) {
                VehicleBrand brand = this.vehicleBrandBusiness.internalSearchVehicleBrandByName(brandName);
                if (brand == null) {
                    this.vehicleBrandBusiness.insertVehicleBrand(brandName);
                    int lastIndex = this.vehicleBrandBusiness.getBrandData().getBrands().size();
                    brand = this.vehicleBrandBusiness.getBrandData().getBrands().get(lastIndex);
                }                
                int index = this.vehicleData.getVehicles().indexOf(vehicleExists);
                Vehicle vehicle = new Vehicle (brand, model, plate, category,
                    description, year, price);
                this.vehicleData.updateVehicle (index, vehicle);
            }   
            else {
                throw new DataNotExistsException ("Vehicle");
            }             
        }
        else {
            throw new DataEmptyException ("Vehicle");
        }
    }


    @Override
    public void deleteVehicle(String plate) throws DataEmptyException, DataNotExistsException {
        if (plate != null) {
            Vehicle vehicleExists = this.internalSearchVehicleByPlate(plate);
            if (vehicleExists != null) {
                this.vehicleData.removeVehicle(vehicleExists);
            }
            else {
                throw new DataNotExistsException ("Vehicle");
            }   
        }
        else {
            throw new DataEmptyException("Vehicle");
        }
    }
  
    
}
