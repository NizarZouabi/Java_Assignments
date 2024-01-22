import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order() {
        this.name = "Guest";
        this.items = new ArrayList<>();
    }

    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void getStatusMessage() {
        if (ready == true) {
            System.out.println("Your order is ready.");
        } else {
            System.out.println("Your order will be ready soon.");
        }
    }

    public double getOrderTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void display() {
        System.out.printf("\nCustomer Name: %s\n", name);
        for (Item item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.printf("Total: $%s \n", getOrderTotal());
    }
}
