public class BaristaTest {
    public static void main(String[] args) {

        Item item1 = new Item("mocha", 3.5);
        Item item2 = new Item("drip coffee", 2.5);
        Item item3 = new Item("latte", 6.0);
        Item item4 = new Item("cappuccino", 4.5);

        Order order1 = new Order();
        Order order2 = new Order();

        Order order3 = new Order("Panam");
        Order order4 = new Order("Jacklyn");
        Order order5 = new Order("Nero");

        order1.addItem(item3);
        order1.addItem(item2);
        order2.addItem(item1);
        order2.addItem(item4);
        
        order3.addItem(item2);
        order3.addItem(item4);
        order4.addItem(item3);
        order4.addItem(item1);
        order5.addItem(item4);
        order5.addItem(item2);

        order1.setReady(true);
        order1.getStatusMessage();
        order2.setReady(false);
        order2.getStatusMessage();

        System.out.println(order1.getOrderTotal());
        System.out.println(order5.getOrderTotal());

        order1.display();
        order2.display();

        order3.display();
        order4.display();
        order5.display();

    }
}
