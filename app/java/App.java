package app.java;

import app.java.exception.DataEmptyException;
import app.java.exception.DataExistsException;
import app.java.service.Service;
import java.util.Scanner;

public class App {

    Service service;

    public App () {
        service = new Service ();
    }

    public int captureIntOption (Scanner s) {
        int option = 0;
        try {
            System.out.print ("Opção: ");
            option = s.nextInt();
        }
        catch (Exception e) {
            System.out.println("Opção desconhecida, tente novamente ou digite a opção certa para sair.");
            s.nextLine();
        }
        return option;
    }

    public int processFrontWelcome (Scanner s) {  
        System.out.println ("##############################################################################");
        System.out.println ("# Bem vindo à HemoCar - a Loja que dá o Sangue para você sair de carro novo! #");
        System.out.println ("##############################################################################");
        System.out.println("\n");     
        System.out.println("Escolha a opção desejada: \n" +
        "- 1: Frente de Loja.\n" + 
        "- 2: Manutenção no Cadastro.\n" +
        "- 3: Sair.\n");        
        int welcomeOption = this.captureIntOption(s);
        this.processWelcomeOption(s, welcomeOption);
        return welcomeOption;
    }

    public void processWelcomeOption (Scanner s, int welcomeOption) {
        switch (welcomeOption) {
            case 1:
                this.processFrontShop(s, welcomeOption);
                break;
            case 2:
                this.processRegisterManager(s, welcomeOption);
                break;
            case 3:
                System.out.println ("Saindo do Sistema...\n" 
                + "Obrigado por utilizar nossos serviços!");
                break;
            default:
                // System.out.println("Opção não disponível, tente novamente ou digite 3 para sair.");
                break;
        }
    }

    public void processFrontShop (Scanner s, int welcomeOption) {
        int menuOption = -1;
        while (menuOption != 6) {
            System.out.println ("******************");
            System.out.println ("* Frente de Loja *");
            System.out.println ("******************\n");

            System.out.println ("Digite a opção de Frente de Loja Desejada:\n"
            + "- 1: Gerenciar Veículo\n"
            + "- 2: Gerenciar Loja\n"
            + "- 3: Gerenciar Vendedor\n"
            + "- 4: Gerenciar Cliente\n"
            + "- 5: Gerenciar Venda\n"
            + "- 6: Voltar para o menu superior.\n");
            
            menuOption = this.captureIntOption(s);
            s.nextLine();
            if (menuOption != 0) {
                this.processFrontOption(s, welcomeOption, menuOption);
            }
            else {
                System.out.println("Opção não disponível, tente novamente ou digite a opção para voltar ao menu superior.");
            }            
        }
    }

    public void processFrontOption (Scanner s, int welcomeOption, int menuOption) {
        String subMenuOption = "";
        String message = "";
        switch (menuOption) {
            case 1:
                while (!subMenuOption.equals ("b")) {
                    System.out.println ("Digite a opção para Gerenciar Veículo desejada:\n"
                        + "- a: Consultar Veículo por Placa\n"
                        + "- b: Voltar ao menu superior\n");
                    System.out.print("Opção: ");
                    subMenuOption = s.nextLine();
                    message = this.processMenuVehicle(s, welcomeOption, menuOption, subMenuOption);
                    System.out.println ("\n" + message + "\n");
                    if (!"ab".contains(subMenuOption)) {
                        System.out.println("Opção não disponível, tente novamente ou digite a opção para voltar ao menu superior.\n");
                    }
                }
                break;
            case 2:
                while (!subMenuOption.equals ("b")) {
                    System.out.println ("Digite a opção para Gerenciar Loja desejada:\n"
                        + "- a: Listar todas as Lojas\n"
                        + "- b: Voltar ao menu superior\n");
                    System.out.print("Opção: ");
                    subMenuOption = s.nextLine();
                    message = this.processMenuShop(s, welcomeOption, menuOption, subMenuOption);
                    System.out.println ("\n" + message + "\n");
                    if (!"ab".contains(subMenuOption)) {
                        System.out.println("Opção não disponível, tente novamente ou digite a opção para voltar ao menu superior.\n");
                    }
                }
                break;
            case 3:
                while (!subMenuOption.equals ("b")) {
                    System.out.println ("Digite a opção para Gerenciar Vendedor desejada:\n"
                        + "- a: Consultar Vendedor por Nome\n"
                        + "- b: Voltar ao menu superior\n");
                    System.out.print("Opção: ");
                    subMenuOption = s.nextLine();
                    message = this.processMenuSeller(s, welcomeOption, menuOption, subMenuOption);
                    System.out.println ("\n" + message + "\n");
                    if (!"ab".contains(subMenuOption)) {
                        System.out.println("Opção não disponível, tente novamente ou digite a opção para voltar ao menu superior.\n");
                    }
                }
                break;
            case 4:
                while (!subMenuOption.equals ("c")) {
                    System.out.println ("Digite a opção para Gerenciar Cliente desejada:\n"
                        + "- a: Cadastrar Cliente\n"
                        + "- b: Consultar Cliente por CPF\n"
                        + "- c: Voltar ao menu superior\n");
                    System.out.print("Opção: ");
                    subMenuOption = s.nextLine();
                    message = this.processMenuCustomer(s, welcomeOption, menuOption, subMenuOption);
                    System.out.println ("\n" + message + "\n");
                    if (!"abc".contains(subMenuOption)) {
                        System.out.println("Opção não disponível, tente novamente ou digite a opção para voltar ao menu superior.\n");
                    }
                }
                break;
            case 5:
                while (!subMenuOption.equals ("b")) {
                    System.out.println ("Digite a opção para Gerenciar Venda desejada:\n"
                        + "- a: Cadastrar Venda\n"
                        + "- b: Voltar ao menu superior\n");
                    System.out.print("Opção: ");
                    subMenuOption = s.nextLine();
                    message = this.processMenuSale(s, welcomeOption, menuOption, subMenuOption);
                    System.out.println ("\n" + message + "\n");
                    if (!"ab".contains(subMenuOption)) {
                        System.out.println("Opção não disponível, tente novamente ou digite a opção para voltar ao menu superior.\n");
                    }
                }
                break;
            default:
                break;
        }
        
    }

    public void processRegisterManager (Scanner s, int welcomeOption) {
        int menuOption = -1;
        while (menuOption != 6) {
            System.out.println ("**************************");
            System.out.println ("* Manutenção no Cadastro *");
            System.out.println ("**************************\n");

            System.out.println ("Digite a opção de Manutenção no Cadastro Desejada:\n"
            + "- 1: Gerenciar Veículo\n"
            + "- 2: Gerenciar Loja\n"
            + "- 3: Gerenciar Vendedor\n"
            + "- 4: Gerenciar Cliente\n"
            + "- 5: Gerenciar Venda\n"
            + "- 6: Voltar para o menu superior.\n");
            
            menuOption = this.captureIntOption(s);
            s.nextLine();
            if (menuOption != 0) {
                this.processRegisterOption(s, welcomeOption, menuOption);
            }
            else {
                System.out.println("Opção não disponível, tente novamente ou digite a opção para voltar ao menu superior.");
            }            
        }

    }

    public void processRegisterOption (Scanner s, int welcomeOption, int menuOption) {
        String subMenuOption = "";
        String message = "";
        switch (menuOption) {
            case 1:
                while (!subMenuOption.equals ("d")) {
                    System.out.println ("Digite a opção para Gerenciar Veículo desejada:\n"
                        + "- a: Cadastrar Veículo\n"
                        + "- b: Excluir Veículo\n"
                        + "- c: Alterar Dados do Veículo\n"
                        + "- d: Voltar ao menu superior\n");
                    System.out.print("Opção: ");
                    subMenuOption = s.nextLine();
                    message = this.processMenuVehicle(s, welcomeOption, menuOption, subMenuOption);                 
                    System.out.println ("\n" + message + "\n");
                    if (!"abcd".contains(subMenuOption)) {
                        System.out.println("Opção não disponível, tente novamente ou digite a opção para voltar ao menu superior.\n");
                    }
                }
                break;
            case 2:
                while (!subMenuOption.equals ("d")) {
                    System.out.println ("Digite a opção para Gerenciar Loja desejada:\n"
                        + "- a: Cadastrar Loja\n"
                        + "- b: Excluir Loja\n"
                        + "- c: Alterar Dados do Loja\n"
                        + "- d: Voltar ao menu superior\n");
                    System.out.print("Opção: ");
                    subMenuOption = s.nextLine();
                    message = this.processMenuShop(s, welcomeOption, menuOption, subMenuOption);
                    System.out.println ("\n" + message + "\n");
                    if (!"abcd".contains(subMenuOption)) {
                        System.out.println("Opção não disponível, tente novamente ou digite a opção para voltar ao menu superior.\n");
                    }
                }
                break;
            case 3:
                while (!subMenuOption.equals ("d")) {
                    System.out.println ("Digite a opção para Gerenciar Vendedor desejada:\n"
                        + "- a: Cadastrar Vendedor\n"
                        + "- b: Excluir Vendedor\n"
                        + "- c: Alterar Dados do Vendedor\n"
                        + "- d: Voltar ao menu superior\n");
                    System.out.print("Opção: ");
                    subMenuOption = s.nextLine();
                    message = this.processMenuSeller(s, welcomeOption, menuOption, subMenuOption);
                    System.out.println ("\n" + message + "\n");
                    if (!"abcd".contains(subMenuOption)) {
                        System.out.println("Opção não disponível, tente novamente ou digite a opção para voltar ao menu superior.\n");
                    }
                }
                break;
            case 4:
                while (!subMenuOption.equals ("d")) {
                    System.out.println ("Digite a opção para Gerenciar Cliente desejada:\n"
                        + "- a: Cadastrar Cliente\n"
                        + "- b: Excluir Cliente\n"
                        + "- c: Alterar Dados do Cliente\n"
                        + "- d: Voltar ao menu superior\n");
                    System.out.print("Opção: ");
                    subMenuOption = s.nextLine();
                    message = this.processMenuCustomer(s, welcomeOption, menuOption, subMenuOption);
                    System.out.println ("\n" + message + "\n");
                    if (!"abcd".contains(subMenuOption)) {
                        System.out.println("Opção não disponível, tente novamente ou digite a opção para voltar ao menu superior.\n");
                    }
                }
                break;
            case 5:
                while (!subMenuOption.equals ("c")) {
                    System.out.println ("Digite a opção para Gerenciar Venda desejada:\n"
                        + "- a: Cadastrar Venda\n"
                        + "- b: Excluir Venda\n"
                        + "- c: Voltar ao menu superior\n");
                    System.out.print("Opção: ");
                    subMenuOption = s.nextLine();
                    message = this.processMenuSale(s, welcomeOption, menuOption, subMenuOption);
                    
                    if (!"abc".contains(subMenuOption)) {
                        System.out.println("Opção não disponível, tente novamente ou digite a opção para voltar ao menu superior.\n");
                    }
                }
                break;
            default:
                break;
        }
    }

    public String processMenuVehicle (Scanner s, int welcomeOption, int menuOption, String subMenuOption) {
        String message = "";
        if (welcomeOption == 1) {
            if (menuOption == 1) {
                if (subMenuOption.equals("a")) {
                    System.out.println ("Digite a placa do carro a ser consultada: ");
                    System.out.print ("Placa: ");
                    String plate = s.nextLine();
                    message = this.service.searchVehicleByPlate(plate);
                }
            }
        }
        else if (welcomeOption == 2){
            if (menuOption == 1) {
                switch (subMenuOption) {
                    case "a":
                        System.out.println ("Digite a marca do carro a ser inserido: ");
                        System.out.print ("Marca: ");
                        String brandName = s.nextLine();
                        System.out.println ("Digite o modelo do carro a ser inserido: ");
                        System.out.print ("Modelo: ");
                        String model = s.nextLine();
                        System.out.println ("Digite a placa do carro a ser inserido: ");
                        System.out.print ("Placa: ");
                        String plate = s.nextLine();
                        System.out.println ("Digite a categoria do carro a ser inserido: ");
                        System.out.print ("Categoria: ");
                        String category = s.nextLine();
                        System.out.println ("Digite a descrição do carro a ser inserido: ");
                        System.out.print ("Descrição: ");
                        String description = s.nextLine();
                        System.out.println ("Digite o ano do carro a ser inserido: ");
                        System.out.print ("Ano: ");
                        int year = s.nextInt();
                        System.out.println ("Digite o preço do carro a ser inserido: ");
                        System.out.print ("Preço: ");
                        double price = s.nextDouble();
                        System.out.println ("\n" + message + "\n");
                        message = this.service.insertVehicle(brandName, model, plate, category, description, year, price);
                        break;
                    case "b":
                        System.out.println ("Digite a placa do carro a ser excluida: ");
                        System.out.print ("Placa: ");
                        plate = s.nextLine();
                        message = this.service.deleteVehicle(plate);
                        break;
                    case "c":
                        System.out.println ("Digite a marca do carro a ser atualizado: ");
                        System.out.print ("Marca: ");
                        brandName = s.nextLine();
                        System.out.println ("Digite o modelo do carro a ser atualizado: ");
                        System.out.print ("Modelo: ");
                        model = s.nextLine();
                        System.out.println ("Digite a placa do carro a ser atualizado: ");
                        System.out.print ("Placa: ");
                        plate = s.nextLine();
                        System.out.println ("Digite a categoria do carro a ser atualizado: ");
                        System.out.print ("Categoria: ");
                        category = s.nextLine();
                        System.out.println ("Digite a descrição do carro a ser atualizado: ");
                        System.out.print ("Descrição: ");
                        description = s.nextLine();
                        System.out.println ("Digite o ano do carro a ser atualizado: ");
                        System.out.print ("Ano: ");
                        year = s.nextInt();
                        System.out.println ("Digite o preço do carro a ser atualizado: ");
                        System.out.print ("Preço: ");
                        price = s.nextDouble();
                        System.out.println ("\n" + message + "\n");
                        message = this.service.updateVehicle(brandName, model, plate, category, description, year, price);
                        break;
                }
            }
        }
        return message;
    }

    public String processMenuShop (Scanner s, int welcomeOption, int menuOption, String subMenuOption) {
        String message = "";
        if (welcomeOption == 1) {
            if (menuOption == 2) {
                if (subMenuOption.equals("a")) {
                    message = this.service.listAllSales();
                }
            }
        }
        else if (welcomeOption == 2){
            if (menuOption == 2) {
                switch (subMenuOption) {
                    case "a":
                        System.out.println ("Digite o nome da Loja a ser inserida: ");
                        System.out.print ("Nome: ");
                        String name = s.nextLine();
                        System.out.println ("Digite a localização da Loja a ser inserida: ");
                        System.out.print ("Localização: ");
                        String location = s.nextLine();
                        System.out.println ("Digite o numero de telefone da Loja a ser inserida: ");
                        System.out.print ("Telefone: ");
                        String phoneNumber = s.nextLine();
                        message = this.service.insertShop(name, location, phoneNumber);
                        break;
                    case "b":
                        System.out.println ("Digite o nome da Loja a ser excluida: ");
                        System.out.print ("Nome: ");
                        name = s.nextLine();
                        message = this.service.deleteShop(name);
                        break;
                    case "c":
                        System.out.println ("Digite o nome da Loja a ser atualizada: ");
                        System.out.print ("Nome: ");
                        name = s.nextLine();
                        System.out.println ("Digite a localização da Loja a ser atualizada: ");
                        System.out.print ("Localização: ");
                        location = s.nextLine();
                        System.out.println ("Digite o numero de telefone da Loja a ser atualizada: ");
                        System.out.print ("Telefone: ");
                        phoneNumber = s.nextLine();
                        message = this.service.updateShop(name, location, phoneNumber);
                        break;
                    default:
                        break;
                }
            }
        }
        return message;
    }

    public String processMenuSeller (Scanner s, int welcomeOption, int menuOption, String subMenuOption) {
        String message = "";
        if (welcomeOption == 1) {
            if (menuOption == 3) {
                if (subMenuOption.equals("a")) {
                    System.out.println ("Digite o nome do Vendedor a ser consultado: ");
                    System.out.print ("Nome: ");
                    String name = s.nextLine();
                    message = this.service.searchSellerByName(name);
                }
            }
        }
        else if (welcomeOption == 2){
            if (menuOption == 3) {
                switch (subMenuOption) {
                    case "a": 
                        System.out.println ("Digite o CPF do vendedor a ser inserido: ");
                        System.out.print ("CPF: ");
                        String CPF = s.nextLine();
                        System.out.println ("Digite o nome do vendedor a ser inserido: ");
                        System.out.print ("Nome: ");
                        String name = s.nextLine();
                        System.out.println ("Digite o número de telefone do vendedor a ser inserido: ");
                        System.out.print ("Telefone: ");
                        String phoneNumber = s.nextLine();
                        message = this.service.insertSeller(CPF, name, phoneNumber);                                
                        break;
                    case "b":
                        System.out.println ("Digite o CPF do vendedor: ");
                        System.out.print ("CPF: ");
                        CPF = s.nextLine();
                        message = this.service.deleteSeller(CPF);
                        break;
                    case "c":
                        System.out.println ("Digite o CPF do vendedor a ser atualizado: ");
                        System.out.print ("CPF: ");
                        CPF = s.nextLine();
                        System.out.println ("Digite o nome do vendedor a ser atualizado: ");
                        System.out.print ("Nome: ");
                        name = s.nextLine();
                        System.out.println ("Digite o número de telefone do vendedor a ser atualizado: ");
                        System.out.print ("Telefone: ");
                        phoneNumber = s.nextLine();
                        message = this.service.updateSeller(CPF, name, phoneNumber);
                        break;
                    default:
                        break;
                }
            }
        }
        return message;
    }

    public String processMenuCustomer (Scanner s, int welcomeOption, int menuOption, String subMenuOption) {
        String message = "";
        if (welcomeOption == 1) {
            if (menuOption == 4) {
                switch (subMenuOption) {
                    case "a": 
                        System.out.println ("Digite o CPF do cliente a ser inserido: ");
                        System.out.print ("CPF: ");
                        String CPF = s.nextLine();
                        System.out.println ("Digite o nome do cliente a ser inserido: ");
                        System.out.print ("Nome: ");
                        String name = s.nextLine();
                        System.out.println ("Digite o número de telefone do cliente a ser inserido: ");
                        System.out.print ("Telefone: ");
                        String phoneNumber = s.nextLine();
                        message = this.service.insertCustomer(CPF, name, phoneNumber);                                             
                        break;
                    case "b":
                        System.out.println ("Digite o CPF do cliente: ");
                        System.out.print ("CPF: ");
                        CPF = s.nextLine();
                        message = this.service.searchCustomerByCPF(CPF);
                        break;
                    default:
                        break;
                }
            }
        }
        else if (welcomeOption == 2){
            if (menuOption == 4) {
                switch (subMenuOption) {
                    case "a": 
                        System.out.println ("Digite o CPF do cliente a ser inserido: ");
                        System.out.print ("CPF: ");
                        String CPF = s.nextLine();
                        System.out.println ("Digite o nome do cliente a ser inserido: ");
                        System.out.print ("Nome: ");
                        String name = s.nextLine();
                        System.out.println ("Digite o número de telefone do cliente a ser inserido: ");
                        System.out.print ("Telefone: ");
                        String phoneNumber = s.nextLine();
                        message = this.service.insertCustomer(CPF, name, phoneNumber);                                                     
                        break;
                    case "b":
                        System.out.println ("Digite o CPF do cliente: ");
                        System.out.print ("CPF: ");
                        CPF = s.nextLine();
                        message = this.service.deleteCustomer(CPF);
                        break;
                    case "c": 
                        System.out.println ("Digite o CPF do cliente a ser atualizado: ");
                        System.out.print ("CPF: ");
                        CPF = s.nextLine();
                        System.out.println ("Digite o nome do cliente a ser atualizado: ");
                        System.out.print ("Nome: ");
                        name = s.nextLine();
                        System.out.println ("Digite o número de telefone do cliente a ser atualizado: ");
                        System.out.print ("Telefone: ");
                        phoneNumber = s.nextLine();
                        message = this.service.updateCustomer(CPF, name, phoneNumber);                                                     
                        break;
                    default:
                        break;
                }
            }
        }
        return message;
    }

    public String processMenuSale (Scanner s, int welcomeOption, int menuOption, String subMenuOption) {
        String message = "";
        if (welcomeOption == 1) {
            if (menuOption == 5) {
                if (subMenuOption.equals("a")) {
                    System.out.println ("Digite o valor da venda a ser inserida: ");
                    System.out.print ("Valor: ");
                    double value = s.nextDouble();
                    s.nextLine();
                    System.out.println ("Digite o CPF do cliente: ");
                    System.out.print ("CPF: ");
                    String CPF = s.nextLine();
                    System.out.println ("Digite o nome do vendedor: ");
                    System.out.print ("Nome: ");
                    String nameSeller = s.nextLine();
                    System.out.println ("Digite a placa do veiculo: ");
                    System.out.print ("Placa: ");
                    String plate = s.nextLine();
                    System.out.println ("Digite a data da venda a ser inserida: ");
                    System.out.print ("Data: ");
                    String sellData = s.nextLine();
                    message = this.service.insertSale(value, CPF, nameSeller, plate, sellData);
                }
            }
        }
        else if (welcomeOption == 2){
            if (menuOption == 5) {
                switch (subMenuOption) {
                    case "a":
                        System.out.println ("Digite o valor da venda a ser inserida: ");
                        System.out.print ("Valor: ");
                        double value = s.nextDouble();
                        s.nextLine();
                        System.out.println ("Digite o CPF do cliente: ");
                        System.out.print ("CPF: ");
                        String CPF = s.nextLine();
                        System.out.println ("Digite o nome do vendedor: ");
                        System.out.print ("Nome: ");
                        String nameSeller = s.nextLine();
                        System.out.println ("Digite a placa do veiculo: ");
                        System.out.print ("Placa: ");
                        String plate = s.nextLine();
                        System.out.println ("Digite a data da venda a ser inserida: ");
                        System.out.print ("Data: ");
                        String sellData = s.nextLine();
                        message = this.service.insertSale(value, CPF, nameSeller, plate, sellData);
                        break;
                    case "b":
                        System.out.println ("Digite o id da venda: ");
                        System.out.print ("ID: ");
                        int id = s.nextInt();
                        message = this.service.deleteSale(id);
                        break;
                    default:
                        break;
                }
            }
        }
        return message;
    }


    public static void main (String [] args) {
        Scanner s = new Scanner (System.in);
        App app = new App ();
        int appOption = 0;

        try {
            app.service.getVehicleBusiness().insertVehicle("Ford", "Ecosport", "xxx-3452", "SUV", "teste", 2023, 100.0);
        } catch (DataEmptyException | DataExistsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        while (appOption != 3) {
            appOption = app.processFrontWelcome(s);
        }
        s.close();
    }
}

