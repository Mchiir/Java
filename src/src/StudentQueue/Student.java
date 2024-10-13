package StudentQueue;

public class Student {
    private Integer id;
    private String Name;
    private char gender;

    public Student(Integer id, String Name, char gender) {
        this.id = id;
        this.Name = Name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", Name=" + Name + ", gender=" + gender + "]";
    }
}
