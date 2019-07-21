package ru.sberbank.school.event.entity;

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
@Table(name = "comments")
public class Event {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "news_id")
    private long newsId;

    @Column(name = "event_id")
    private long eventId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "body")
    private String body;

    @CreationTimestamp
    @Column(name = "timestamp")
    private Timestamp timestamp;
}