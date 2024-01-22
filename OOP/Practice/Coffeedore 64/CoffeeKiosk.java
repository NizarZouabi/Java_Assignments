import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {
    ArrayList<Item> menu;
    ArrayList<Order> orders;

    public CoffeeKiosk() {
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addMenuItem(Item item) {
        item.setIndex(menu.size());
        menu.add(item);
    }

    public void displayMenu() {
        for (Item item : menu) {
            System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice() + "\n");
        }
    }

    public void newOrder() {
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        Order order = new Order();
        order.setName(name);
        displayMenu();

        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();

        while (!itemNumber.equals("q")) {
            int itemIdx = Integer.parseInt(itemNumber);
            if (itemIdx < menu.size() && itemIdx >= 0) {
                order.addItem(menu.get(itemIdx));
            } else {
                System.out.println("Invalid item index, please try again.");
            }
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
        }
        System.out.println("Thank you for your purchase, " + order.getName() + ". Here are your order details:\n");
        order.display();
    }

    public void addMenuItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter item name or q to quit:");
        String itemName = scanner.nextLine();

        while (!itemName.equals("q")) {
            System.out.println("Please enter item price:");
            double itemPrice = scanner.nextDouble();
            scanner.nextLine();
            Item newItem = new Item(itemName, itemPrice, menu.size());
            addMenuItem(newItem);

            System.out.println("Item added to menu.");
            displayMenu();

            System.out.println("Please enter item name or q to quit:");
            itemName = scanner.nextLine();
        }
        scanner.close();
    }
}
