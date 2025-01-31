package ru.dorogov.web.tables;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Client implements Accessible {

    public Client(String name, String mail, Company company, String surname) {
        this.name = name;
        this.mail = mail;
        this.company = company;
        this.surname = surname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String surname;
    String mail;
    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "company")
    Company company;
    boolean access = access();
    @Override
    public boolean access() {
        return false;
    }
}
