import java.util.ArrayList;
import java.util.List;

public class TestOrders {
    public static void main(String[] args) {

        Item item1 = new Item("mocha", 3.5);
        Item item2 = new Item("drip coffee", 2.5);
        Item item3 = new Item("latte", 6.0);
        Item item4 = new Item("cappuccino", 4.5);

        Order order1 = new Order("Sam", 3.5, true, new ArrayList<Item>(List.of(item1)) );
        Order order2 = new Order("Jimmy", 2.5, false, new ArrayList<Item>(List.of(item2)) );
        Order order3 = new Order("Noah", 6.0, true, new ArrayList<Item>(List.of(item3)) );
        Order order4 = new Order("Cindhuri", 4.5, false, new ArrayList<Item>(List.of(item4)));
        
        order1.name = "Cindhuri";
        order2.name = "Jimmy";
        order3.name = "Noah";
        order4.name = "Sam";
        
        order2.items.add(item1);
        order2.total += item1.price;

        order3.items.add(item4);
        order3.total += item4.price;

        order1.items.add(item3);
        order1.items.add(item3);
        order1.items.add(item3);
        order1.total += item3.price * 3;

        order4.ready = true;

        order2.ready = true;


        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order4.ready);
        System.out.printf("Ready: %s\n", order2.ready);
    }
}
