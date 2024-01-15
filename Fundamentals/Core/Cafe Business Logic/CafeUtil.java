import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal(int numWeeks) {
        // int numWeeks = 10;
        int streakGoal = 0;
        for (int i = 1; i <= numWeeks; i++) {
            // System.out.println(streakGoal);
            streakGoal += i;
        }
        return streakGoal;
    }
    
    public double getOrderTotal(double[] lineItems) {
        double total = 0;
        for (double item : lineItems) {
            total += item;
            // System.out.println(total);
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menu) {
        for (int i = 0; i < menu.size(); i++) {
            System.out.printf("%d %s \n", i, menu.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String username = System.console().readLine();
        System.out.printf("Hello, %s! \n", username);
        int numPeople = customers.size();
        System.out.printf("There are %d people in front of you \n", numPeople);
        customers.add(username);
        System.out.println(customers);
    }
    
}
