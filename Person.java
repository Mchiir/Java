package app.oop.NatioSense;

public class Person {
    private String name;
    private String email;
    private String telephone;
    public Person(String name, String email, String telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", email=" + email + ", telephone=" + telephone + "]";
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
