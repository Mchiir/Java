package Generics;

public class MainUserClass {
    public static void main(String[] args) {
//        var user1 = new User(10);
//        var user2 = new User(20);
//        System.out.println(Utils.max(user1, user2));
//        System.out.println(Utils.max(1, 2));
//        System.out.println(Utils.max("abakuru", "abana"));
//        Utils.print("John", 20); // MTP using method
//        Utils.print("Kalisa", 30); // MTP using method
//        new KeyValuePairs<>("Karara", 40); // MTP using generic class
//        User user3 = new Instructor(10);
//        Utils.printUser(new User(40));
//        Utils.printUser(new Instructor(30));

        GenericList<User> users = new GenericList<User>();
        var instructors = new GenericList<Instructor>();
        users.add(new Instructor(30));
        users.add(new Instructor(40));
        users.add(new Instructor(50));
        Utils.addToTheList(users);
        Utils.readFromUserList(users);
    }
}