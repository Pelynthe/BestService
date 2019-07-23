package ru.sberbank.school.users.converter;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import ru.sberbank.school.feign.model.UserModel;
import ru.sberbank.school.users.entity.Role;
import ru.sberbank.school.users.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsersConverter {

    public UserModel convertToModel(@NonNull User user) {
        return UserModel.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .roles(user.getRoles().stream().map(r -> r.getRole()).collect(Collectors.toList()))
                .build();
    }

    public User convertToEntity(@NonNull UserModel userModel) {

//        User user = new User();
//        user.setId(userModel.getId());

        return User.builder()
                .id(userModel.getId())
                .username(userModel.getUsername())
                .email(userModel.getEmail())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .password(userModel.getPassword())
//                .roles(userModel.getRoles().stream()
//                        .map(role -> new Role(role, user))
//                        .collect(Collectors.toList())
//                )
                .roles(userModel.getRoles().stream()
                        .map(r -> {
                            Role role = new Role();
                            role.setRole(r);
                            return role;
                        })
                        .collect(Collectors.toList())
                )
                .build();



/*        User user = User.builder()
                .id(userModel.getId())
                .username(userModel.getUsername())
                .email(userModel.getEmail())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .password(userModel.getPassword())
                .build();

        List<Role> roles = new ArrayList<>();
        for (String s : userModel.getRoles()) {
//            roles.add(new Role(0L, s, user));
        }
        user.setRoles(roles);
        return user;*/
    }

    public List<Role> convertRolesToEntity(@NonNull long userId, @NonNull UserModel userModel) {
        User user = new User();
        user.setId(userId);
        return userModel.getRoles().stream()
                .map(r -> new Role(0L, r, user))
                .collect(Collectors.toList());
    }

}