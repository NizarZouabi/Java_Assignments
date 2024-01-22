public class CoffeedoreTest {

    public static void main(String[] args) {

        CoffeeKiosk coffeedore = new CoffeeKiosk();

        Item item1 = new Item("mocha", 3.50, 0);
        Item item2 = new Item("drip coffee", 2.50, 1);
        Item item3 = new Item("latte", 5.00, 2);
        Item item4 = new Item("cappuccino", 4.50, 3);
        Item item5 = new Item("muffin", 4.00, 4);

        coffeedore.addMenuItem(item1);
        coffeedore.addMenuItem(item2);
        coffeedore.addMenuItem(item3);
        coffeedore.addMenuItem(item4);
        coffeedore.addMenuItem(item5);

        coffeedore.newOrder();
        coffeedore.addMenuItem();
    }

}
