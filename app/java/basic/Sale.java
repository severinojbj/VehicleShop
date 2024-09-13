package app.java.basic;
public class Sale {
    
    private int id;
    private double value;
    private Customer customer;
    private Seller seller;
    private Vehicle car;
    
    public Sale () {

    }

    public Sale (int id, double value, Customer customer, Seller seller, Vehicle car) {
        
        this.id = id;
        this.value = value;
        this.customer = customer;
        this.seller = seller;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   

    public double getValue () {
        return value;
    }

    public void setValue (double value) {
        this.value = value;
    }

    public Customer getCustomer () {
        return customer;
    }

    public void setCustomer (Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller () {
        return seller;
    }

    public void setSeller (Seller seller) {
        this.seller = seller;
    }

    public Vehicle getCar () {
        return car;
    }

    public void setCar (Vehicle car) {
        this.car = car;
    }    

}
