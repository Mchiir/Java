package Collections.Iterable;

public class Main {
    public static void main(String[] args){
        var list = new GenericList<String>();
        list.add("a");
        list.add("b");
        var iterator = list.iterator();
        for (var item : list){
            System.out.println(item);
        }
    }
}