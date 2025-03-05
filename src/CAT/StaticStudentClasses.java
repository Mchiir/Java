package CAT;

public class StaticStudentClasses {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }
    public StaticStudentClasses(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "Firstname= "+ firstName + ", Lastname= " + lastName;
    }
}