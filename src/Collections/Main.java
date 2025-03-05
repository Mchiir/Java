package Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Kamali", "e3"));
        customers.add(new Customer("Umwali", "e2"));
        customers.add(new Customer("Gitore", "e1"));
        customers.add(new Customer("Mugabo", "e4"));

        // Collections.sort(customers);// make sure Customer class implements comparable
        Collections.sort(customers, new EmailComparator());// make sure Customer class implements comparable
        System.out.println(customers);
    }
}
