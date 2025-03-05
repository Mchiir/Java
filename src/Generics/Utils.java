package Generics;

public class Utils { // Non-generic class
    public static <T extends Comparable<T>> T max(T a, T b) { // Generic method
        // is a and b strings compare according to length
        return (a.compareTo(b) > 0) ? a : b;
    }

    public static <K, V> void print(K key, V value){ // Multiple-type parameters
        System.out.println(key +":"+ value);
    }

    public static void printUser(User user){
        System.out.println(user);
    }
    //print users list
    // class CAP#1 {} extends User{}
    // class Instructor extends User {}
    // ? : Wildcard character(Uknown type) used to pass generic types
    public static void addToTheList (GenericList<? super User> users){
     GenericList<Object> temp = new GenericList<>();
     temp.add(users.get(0));
    }

    public static void readFromUserList(GenericList<? extends User> users){
        GenericList<Object> temp = new GenericList<>();
        Object x = users.get(0);
        System.out.println(x);
    }
}
