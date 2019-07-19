package ru.sberbank.school.news.entity;

import lombok.*;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.TABLE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = TABLE, generator = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "id_event")
    private int idEvent;

    @Column(name = "text")
    private String text;

    @Column(name = "datetime")
    private Date datetime;
}