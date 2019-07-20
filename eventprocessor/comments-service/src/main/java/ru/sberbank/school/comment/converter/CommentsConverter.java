package ru.sberbank.school.comment.converter;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import ru.sberbank.school.comment.entity.Comment;
import ru.sberbank.school.feign.model.CommentsModel;

@Component
public class CommentsConverter {

    public CommentsModel convertToModel (@NonNull Comment comment) {
        return CommentsModel.builder()
                .id(comment.getId())
                .newsId(comment.getNewsId())
                .eventId(comment.getEventId())
                .userId(comment.getUserId())
                .body(comment.getBody())
                .timestamp(comment.getTimestamp())
                .build();
    }

    public Comment convertToEntity (@NonNull CommentsModel comment) {
        return Comment.builder()
                .id(comment.getId())
                .newsId(comment.getNewsId())
                .eventId(comment.getEventId())
                .userId(comment.getUserId())
                .body(comment.getBody())
                .timestamp(comment.getTimestamp())
                .build();
    }
}