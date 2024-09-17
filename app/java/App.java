package app.java;

import app.java.service.Service;

public class App {


    public static void main (String [] args) {
        // Customer c = new Customer ();
        // System.out.println (c.getCPF());

        Service s = new Service();
        // s.insertShop("Loja 1", "teste");
        // s.insertShop("Loja 2", "teste 2");
        // s.deleteShop("Loja 1");
        // s.updateShop("Loja 2", "lala");
        // System.out.println (s.getShopBusiness().listAllShops().get(0).getLocation());

        // s.insertVehicle("Ford", "Ecosport", "XXX-8D45");
        // System.out.println (s.getVehicleBusiness().listAllVehicles().get(0).getPlate());
        String message = s.insertCustomer("00991202", "hjsdjhajgh", "0000");
        String message2 = s.insertCustomer("00991203", "hjsdjhajgh", "1111");
        String message3 = s.listAllCustomers();
        System.out.println (message3);
    }
}
