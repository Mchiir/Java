package CAT;

public interface Student {
    int numberOfStudents = 318;
    void storeStudents();
    void getStudents();

    default void print(){
        System.out.println("NUmber of students.");
    }
    static void getOld(){
        System.out.println("Old student number");
    }
}

