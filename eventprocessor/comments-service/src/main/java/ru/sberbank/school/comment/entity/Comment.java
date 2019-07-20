package ru.sberbank.school.comment.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

import static javax.persistence.GenerationType.TABLE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = TABLE, generator = "increment")
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
    @UpdateTimestamp
    @Column(name = "timestamp")
    private String timestamp;
}