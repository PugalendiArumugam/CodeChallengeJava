package LeetCode.Playground;

import java.util.*;

public class Test3Collections {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        map.put("A", 5);
        map.put("B", 7);
        map.put("C", 3);
        map.put("D", 1);
        map.put("E", 2);
        map.put("F", 8);
        map.put("G", 4);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        //System.out.println(sortedMap);
        SortMapUsingStream();
    }

    public static void SortMapUsingStream(){
        //Creating a hashmap (fruit name -> key, price -> value)
        Map<String, Integer> hashmap = new HashMap<>();

        //Inserting elements
        hashmap.put("Avocado", 80);
        hashmap.put("Honeydew", 60);
        hashmap.put("Blueberries", 45);
        hashmap.put("Cranberries", 60);
        hashmap.put("Mango", 75);

        //Using forEach loop to print the elements
        //Before sorting
        System.out.println("The original array before sorting:");
        hashmap.forEach((key,value)->System.out.println(key + " -> " + value));

        //Sorting in the reversed order
        System.out.println("\nAfter sorting in decreasing order of their prices:");

        //Using stream() method on entrySet,
        //followed by sorted method that uses comparingByValue().reversed()
        //to print the elements in the decreasing order of their prices, and
        //finally, forEach with a lambda expression to get key and value separately
        hashmap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                .forEach((fruit)->System.out.println(fruit.getKey() + " -> " + fruit.getValue()));

    }
}
