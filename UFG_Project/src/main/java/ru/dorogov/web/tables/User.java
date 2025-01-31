package ru.dorogov.web.tables;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User implements Accessible {

    public User(String name, String surname, String mail) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String surname;
    @Column(length = 70)
    String mail;
    boolean access = access();

    @Override
    public boolean access() {
        return true;
    }
}