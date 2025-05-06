package study.spring_security.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
            this.name = name;
    }
    public String getName() {
        return name;
    }
}
