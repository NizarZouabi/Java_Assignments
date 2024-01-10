public class CafeJava {
    public static void main(String[] args) {

        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        double mochaPrice = 3.5;
        double dripCoffeePrice = 2.5;
        double lattePrice = 6.0;
        double cappuccinoPrice = 4.5;

        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        System.out.println(generalGreeting + customer1);
        System.out.println(customer1 + pendingMessage);
        if (isReadyOrder4 == true) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappuccinoPrice);
        } else {
            System.out.println(customer4 + pendingMessage);
        }
        System.out.println(customer2 + readyMessage);
        System.out.println(displayTotalMessage + lattePrice * 2);
        if (isReadyOrder2 == false) {
            System.out.println(customer2 + pendingMessage);
        } else {
            System.out.println(customer2 + readyMessage);
        }
        System.out.println(customer3 + readyMessage);
        System.out.println(displayTotalMessage + (lattePrice - dripCoffeePrice));
    }
}