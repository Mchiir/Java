package StudentManagement;

public class Student {
    private String name;
    private int age;
    private double score;
    
    public Student(String name, int age, double score) {
        setName(name);
        setAge(age);
        setScore(score);
    }

    public void display(String[] names){
        if ( names.length > 1 ){
            System.out.println("New students :");
            for (String name : names ) {
                System.out.println(name);
            }
            System.out.println("Has been registed successfully.\n");
        }else {
            System.out.println("New student "+ this.getName() + " Has been registed successfully.\n");
        }
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Please set the name.");
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 6)
            throw new IllegalArgumentException("The child is not old enough to attend primary school.");
        this.age = age;
    }

    private double getScore() {
        return score;
    }

    private void setScore(double score) {
        if (score < 30)
            throw new IllegalArgumentException("The child's score is too low, repeat required.");
        this.score = score;
    }
}
