package ru.sberbank.school.users.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "users")
public class User {

    @Id
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