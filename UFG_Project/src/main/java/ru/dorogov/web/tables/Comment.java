package ru.dorogov.web.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Comment {
    public Comment(String text) {
        this.text = text;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String text;
    private Date date = new Date();
}
