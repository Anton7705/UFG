package ru.dorogov.web.tables;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Application {

    public Application(String title, String body, String applicationStatus, Client client, User user) {
        this.title = title;
        this.body = body;
        this.applicationStatus = applicationStatus;
        this.client = client;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    String body;
    String applicationStatus;
    private Date date = new Date();
    @OneToOne(targetEntity = Client.class)
    @JoinColumn(name = "client")
    Client client;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user")
    User user; // исполнитель (может лучше много юзеров на 1 задачу)
    @OneToOne(targetEntity = Comment.class)
    @JoinColumn(name = "comment")
    Comment comment;
}
