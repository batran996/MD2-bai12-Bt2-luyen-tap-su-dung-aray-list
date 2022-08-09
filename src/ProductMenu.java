import java.util.Scanner;

public class ProductMenu {
    Scanner scanner;
    private ProductManager pm;

    public ProductMenu() {
        this.scanner = new Scanner(System.in);
        this.pm = new ProductManager();
    }

    private int menu() {
        System.out.println("lua chon phuong thuc cua ban: ");
        System.out.println("1: add product");
        System.out.println("2: Show product");
        System.out.println("3: remove product ");
        System.out.println("4: exit product");
        return readMenu(0, 5);
    }

    private int readMenu(int min, int max) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > min && choice < max) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return choice;
    }

    private void addProduc() {
        System.out.println("enter id product");
        int id = readMenu(0, Integer.MAX_VALUE);
        System.out.println("Enter name Product : ");
        String name = scanner.nextLine();
        System.out.println("enter Price product");
        double price = readMenu(0, Integer.MAX_VALUE);
        Product p = new Product(id, name, (int) price);
        this.pm.addpProduct(p);

    }

    private void removeProduc2() {
        System.out.println("enter id remove");
        int id = readMenu(0, Integer.MAX_VALUE);
        if (this.pm.removeProduct(id)) {
            System.out.println("ok");
        } else {
            System.out.println("not Id");
        }
    }

    private void showPeoduct() {
        System.out.println("list product is: ");
        for (int i = 0; i < this.pm.count(); i++) {
            Product p = this.pm.getProduct(i);
            System.out.println("ID: " + p.getId() + " Name: " + p.getName() + " Price " + p.getPrice());

        }

    }

    public void begin() {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addProduc();
                    break;
                case 2:
                    showPeoduct();
                    break;
                case 3:
                    removeProduc2();
                    break;
                default:
                    break;

            }
        }
    }


}
