package app.java.basic;
public class Customer extends Person {
    
    private String name;

    public Customer () {
    }

    public Customer (String name) {
        super();
        this.name = name;
    }

    public Customer (String cPF, String name) {
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
