package CAT;

public class Students implements Student  {

    @Override
    public void storeStudents() {
        System.out.println("Students stored successfully.");
    }

    @Override
    public void getStudents() {
        System.out.println(numberOfStudents);
    }

    public static void main(String[] args) {
        new Students().print(); // default interface methods require new instance of implimiting class
        System.out.println(Student.numberOfStudents); // static interface variables are accessed by interface name
        Student.getOld();

    }
}

