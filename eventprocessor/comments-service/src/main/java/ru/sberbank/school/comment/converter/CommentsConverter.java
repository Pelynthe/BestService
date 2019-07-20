package ru.sberbank.school.comment.converter;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import ru.sberbank.school.comment.entity.Comment;
import ru.sberbank.school.feign.model.CommentsModel;

@Component
public class CommentsConverter {

    public CommentsModel convertToModel (@NonNull Comment user) {
        return CommentsModel.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public Comment convertToEntity (@NonNull CommentsModel user) {
        return Comment.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}