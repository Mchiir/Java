package Generics;

public class Main {
    public static void main(String[] args) {
        // wrapper classes
        // Integer, Float, String, Boolean,
        GenericList<User> users = new GenericList<>();
        users.add(new User(10));
        users.add(new User(5));
        int comparison = users.get(0).compareTo(users.get(1));
        if (comparison == 0) {
            System.out.println("Users are equal");
        }else if (comparison < 0) {
            System.out.println("User1 is less than User2");
        }else {
            System.out.println("User1 is greater than User2");
        }
    }
}
