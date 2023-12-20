package mainAplication;

import controller.Controller;
import entity.Client;
import java.util.List;
import java.util.Scanner;

public class AppRun {

    static Controller controller = new Controller();
    static Client client;

    public static void main(String[] args) {

        System.out.println("My Main Client");
        System.out.println();

        int choose;
        while (true) {

            System.out.println("------------------------------------Main---------------------------------");
            System.out.println("1) create client");
            System.out.println("2) update client");
            System.out.println("3) show all client");
            System.out.println("4) delete client ");
            System.out.println("5) exit program ");
            
             System.out.println("Select any option");
            Scanner sc = new Scanner(System.in);
            choose = sc.nextInt();
           
            switch (choose) {
                case 1:
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("create client");
                    System.out.println();
                    createData();
                    break;
                case 2:
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("update client");
                    updateData();
                    break;
                case 3:
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("show all client");
                    getAllData();
                    break;
                case 4:
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("delete client");
                    deleteData();
                    break;
                default:
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("selected not valid");
                    System.exit(0);

            }
            System.out.println();
        }
    }

    private static void createData() {
        System.out.println("enter with name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        System.out.println("enter with age: ");
        int age = sc.nextInt();

        client = new Client(name, age);

        controller.insert(client);

    }

    private static void updateData() {
        
        System.out.println("enter with name to modify: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        System.out.println("enter with age to modify: ");
        int age = sc.nextInt();
        
        client.setName(name);
        client.setAge(age);
        sc.nextLine();
        
        int pos = controller.update(client);
        System.out.println("client " + controller.getAll().get(pos).getName()
                + " age " + controller.getAll().get(pos).getAge());

        System.out.println("enter with name: ");
        sc = new Scanner(System.in);
        name = sc.next();
        sc.nextLine();
        
        System.out.println("enter with age: ");
        age = sc.nextInt();

        client.setName(name);
        client.setAge(age);

    }

    private static void deleteData() {

        System.out.println("enter with name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("enter with age: ");
        int age = sc.nextInt();
        client = new Client(name, age);
        int pos = controller.update(client);
        boolean isDelete = controller.delete(pos);
        if (isDelete) {
            System.out.println("deleted with success");
        }
    }

    private static void getAllData() {
        List<Client> allData = controller.getAll();
        System.out.println();
        for (int i = 0; i < allData.size(); i++) {            
            System.out.println("client: " + allData.get(i).getName() + " age: " + allData.get(i).getAge());
        }
        System.out.println("-------------------------------------end---------------------------------");
    }
}
