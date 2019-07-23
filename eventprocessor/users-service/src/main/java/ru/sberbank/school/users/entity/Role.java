package ru.sberbank.school.users.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "role", "user"})
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "role")
    private String role;

//    @Column(name = "user_id")
//    private long userId;

    @ManyToOne(fetch = FetchType.LAZY
//            , cascade=CascadeType.ALL
    )
    @JoinColumn(name = "USER_ID")
    private User user;

    public Role(String role, User user) {
        this.role = role;
        this.user = user;
    }
}
