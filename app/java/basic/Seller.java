package app.java.basic;
public class Seller extends Person {
    
    private String name;

    public Seller () {
    }

    public Seller ( String name) {
        super();
        this.name = name;
    }

    public Seller (String cPF, String name) {
        this.setCPF(cPF); 
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }   

}
