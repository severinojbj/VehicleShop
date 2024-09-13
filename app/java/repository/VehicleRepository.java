package app.java.repository;

import app.java.basic.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {
    private List<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList();
    }

    public VehicleRepository(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle (Vehicle vehicle) {
        this.vehicles.add(vehicle);
    } 
    
    public void updateVehicle (int index, Vehicle vehicle) {
        this.vehicles.set(index, vehicle);
    }

    public void removeVehicle (Vehicle vehicle) {
        this.vehicles.removeIf(item -> item.getPlate() == vehicle.getPlate());
    }
}
