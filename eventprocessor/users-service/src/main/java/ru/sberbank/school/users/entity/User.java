package ru.sberbank.school.users.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.GenerationType.TABLE;

@Data
@Builder
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "users")
//@SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 5)
public class User {

    @Id
//    @GeneratedValue(strategy = SEQUENCE, generator = "USERS_SEQ")
    @GeneratedValue(strategy = TABLE, generator = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}