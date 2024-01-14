import java.util.Date;
import java.text.SimpleDateFormat;
public class AlfredQuotes {
    
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH");
        int hour = Integer.parseInt(timeFormat.format(new Date()));

        String dayPeriod;
        if (hour >= 0 && hour < 12) {
            dayPeriod = "morning";
        } else if (hour >= 12 && hour < 18) {
            dayPeriod = "afternoon";
        } else {
            dayPeriod = "evening";
        }

        return String.format("Good %s %s, lovely to see you again", dayPeriod, name);
    }

    public String guestGreeting(String name, String dayPeriod) {

        if (dayPeriod.equalsIgnoreCase("morning")) {
            return String.format("Good morning %s, lovely to see you", name);
        } else if (dayPeriod.equalsIgnoreCase("afternoon")) {
            return String.format("Good afternoon %s, lovely to see you", name);
        } else {
            return String.format("Good evening %s, lovely to see you", name);
        }
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "The current date is " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        int alexis = conversation.indexOf("Alexis");
        int alfred = conversation.indexOf("Alfred");

        if (alexis != -1) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (alfred != -1) {
            return "At your service. As you wish, naturally.";
        } else {
            return "Right. And with that I shall retire.";
        }
    }
}

