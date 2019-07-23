package ru.sberbank.school.users.entity;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "password")
    private String password;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY
//            ,cascade=CascadeType.PERSIST
    )
//    @JoinTable(name = "roles")
    @BatchSize(size = 100)
    private List<Role> roles = new ArrayList<>();
}