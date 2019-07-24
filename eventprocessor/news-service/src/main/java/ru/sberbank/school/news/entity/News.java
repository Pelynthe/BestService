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

    @Column(name = "event_id")
    private long eventId;

    @Column(name = "headline")
    private String headline;

    @Column(name = "body")
    private String body;

    @CreationTimestamp
    @Column(name = "timestamp")
    private Timestamp timestamp;
}