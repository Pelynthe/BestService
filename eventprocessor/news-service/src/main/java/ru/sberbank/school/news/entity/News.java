package ru.sberbank.school.news.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;

import java.sql.Timestamp;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "news")
public class News {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "id_event")
    private int idEvent;

    @Column(name = "text")
    private String text;

    @CreationTimestamp
    @Column(name = "timestamp")
    private Timestamp timestamp;
}