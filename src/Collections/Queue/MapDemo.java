package Collections.Queue;

import Collections.Customer;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Customer> map = new HashMap<>();
        var c1 = new Customer("Jack", "e1");
        var c2 = new Customer("Jane", "e2");
        map.put(c1.getEmail(), c1); // Similar to Objects in js, dictionaries in c++, ...
        map.put(c2.getEmail(), c2); // js objects are Hash tables/maps under the hood

        var unknown = new Customer("Unknown", "");
        // let's search for a customer
        // this have Big O(1), unlike searching loop with Big O(n)
        var customer = map.get("e1"); // Search using key (email)
        var customer2 = map.getOrDefault("e10", unknown); // return unknown cus if 401

        var exists = map.containsKey("e10");
        var refinement = map.replace("e1", new Customer("Mugisha", (map.get("e1")).getEmail() ));
        System.out.println(customer);
        System.out.println(customer2);
        System.out.println(map);

        map.keySet().forEach(System.out::println);
        map.entrySet().forEach(System.out::println); // getValue(), getKey()
        map.values().forEach(System.out::println);
    }
}
