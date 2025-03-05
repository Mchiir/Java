package StudentAppJson;

public class Student {
    private int line;
    private String name;
    private int age;

    // Getters and Setters
    public int getLine() { return line; }
    public void setLine(int line) { this.line = line; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Student{" +
                "line=" + line +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}