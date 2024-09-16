package app.java.repository;

import app.java.basic.VehicleBrand;
import java.util.ArrayList;
import java.util.List;

public class VehicleBrandRepository {
    private List<VehicleBrand> brands;

    public VehicleBrandRepository() {
        this.brands = new ArrayList ();
    }

    public VehicleBrandRepository(List<VehicleBrand> brands) {
        this.brands = brands;
    }

    public List<VehicleBrand> getBrands() {
        return brands;
    }

    public void setBrands(List<VehicleBrand> brands) {
        this.brands = brands;
    } 

    public void addVehicleBrand (VehicleBrand vehicleBrand) {
        this.brands.add(vehicleBrand);
    }

    public void updateVehicleBrand (int index, VehicleBrand vehicle) {
        this.brands.set(index, vehicle);
    }

    public void removeVehicleBrand (VehicleBrand vehicleBrand) {
        this.brands.removeIf(item -> item.getId() == vehicleBrand.getId());
    }
}
