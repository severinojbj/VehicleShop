package app.java.basic;

public class Vehicle {

    private VehicleBrand brand;
    private String model;
    private String plate;

    public Vehicle () {

    }

    public Vehicle (VehicleBrand brand, String model, String plate) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
    }

    public VehicleBrand getBrand () {
        return brand;
    }

    public void setBrand (VehicleBrand brand) {
        this.brand = brand;
    }

    public String getModel () {
        return model;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public String getPlate () {
        return plate;
    }

    public void setPlate (String plate) {
        this.plate = plate;
    }
    
    
}
