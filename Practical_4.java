package practical_4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class Practical_4 {

    public static void main(String[] args) {
        
        System.out.println("--- 1. LIST DEMO ---");
        List<String> fruitsList = new ArrayList<>();

        fruitsList.add("Apple");
        fruitsList.add("Banana");
        fruitsList.add("Apple"); 

        System.out.println("List of fruits: " + fruitsList);
        System.out.println("First fruit in list: " + fruitsList.get(0));


        System.out.println("\n--- 2. SET DEMO ---");
        Set<String> colorsSet = new HashSet<>();

        colorsSet.add("Red");
        colorsSet.add("Blue");
        colorsSet.add("Red"); 

        System.out.println("Unique colors set: " + colorsSet);


        System.out.println("\n--- 3. MAP DEMO ---");
        Map<String, Integer> studentScoresMap = new HashMap<>();

      
        studentScoresMap.put("Alice", 90);
        studentScoresMap.put("Bob", 85);
        studentScoresMap.put("Alice", 95); 

        System.out.println("All Scores: " + studentScoresMap);
        System.out.println("Bob's Score: " + studentScoresMap.get("Bob"));
    }
}
