package mchiir.testdocker;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    public User() {}
    public User(final String username) {
        this.username = username;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }

//    public void setId(int id) { this.id = id; }
    public void setUsername(final String username) { this.username = username; }
}
