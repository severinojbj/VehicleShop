package app.java.basic;

public class Vehicle {

    private VehicleBrand brand;
    private String model;
    private String plate;
    private String category;
    private String description;
    private int year;
    private double price;

    public Vehicle () {

    }

    public Vehicle (VehicleBrand brand, String model, String plate, String category, String description, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.category = category;
        this.description = description;
        this.year = year;
        this.price = price;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }    
    
    @Override
    public String toString() {
        return String.format ("PLACA: %s, MARCA: %s, MODELO: %s, CATEGORIA: %s, DESCRIÇÃO: %s, ANO: %s, PREÇO: %s", 
            this.brand.getName(),
            this.model,
            this.plate,
            this.category,
            this.description,
            this.year,
            this.price
        );
    }

}
