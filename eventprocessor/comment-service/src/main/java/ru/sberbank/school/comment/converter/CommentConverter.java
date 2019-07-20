package ru.sberbank.school.comment.converter;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import ru.sberbank.school.comment.entity.Comment;
import ru.sberbank.school.feign.model.CommentModel;

@Component
public class CommentConverter {

    public CommentModel convertToModel (@NonNull Comment user) {
        return CommentModel.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public Comment convertToEntity (@NonNull CommentModel user) {
        return Comment.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}