package ru.sberbank.school.users.converter;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import ru.sberbank.school.users.entity.User;
import ru.sberbank.school.users.model.UserModel;

@Component
public class UsersConverter {

    public UserModel convertToModel (@NonNull User user) {
        return UserModel.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public User convertToEntity (@NonNull UserModel user) {
        return User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}