package Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 9, 8, 6, 10, 7};
        int[] numbers2 = {3, 2, 4, 5, 6, 9, 1, 8, 10, 7};
        var firstSort = new Sort(numbers);
        System.out.println(
                firstSort + "\nIterations: "+ firstSort.getIterations()
                + "\nOperations: "+ firstSort.getOperations()
        );
    }
}