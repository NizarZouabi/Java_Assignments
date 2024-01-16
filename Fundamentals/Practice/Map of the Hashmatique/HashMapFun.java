import java.util.HashMap;
import java.util.Set;

public class HashMapFun {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("World, Hold on", "Look inside, you'll find a deeper love, The kind that only comes from high above");
        hashMap.put("Toxicity", "Conversion, software version 7.0");
        hashMap.put("A Decade in Blue", "i'm blue Da ba dee da ba di");
        hashMap.put("Bury the Light", "I am the storm that is approaching");

        String track = hashMap.get("Bury the Light");
        System.out.println(track);

        Set<String> keys = hashMap.keySet();
        for(String key : keys) {
            System.out.println("\n Track: " + key + ", Lyrics: " + hashMap.get(key));
        }
    }
}