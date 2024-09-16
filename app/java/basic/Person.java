package app.java.basic;

public abstract class Person {
    public String CPF;
    public String name;    
    public String phoneNumber;

    public String getCPF () {
        return CPF;
    }

    public void setCPF (String cPF) {
        CPF = cPF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format ("CPF: %s, NOME: %s, TELEFONE: %s", this.CPF, this.name, this.phoneNumber);
    }
    
}
