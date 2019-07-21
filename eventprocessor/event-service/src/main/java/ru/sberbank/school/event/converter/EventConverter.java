package ru.sberbank.school.event.converter;

import lombok.NonNull;
import org.springframework.stereotype.Component;
import ru.sberbank.school.event.entity.Event;
import ru.sberbank.school.feign.model.EventModel;

@Component
public class EventConverter {

    public EventModel convertToModel (@NonNull Event event) {
        return EventModel.builder()
                .id(event.getId())
                .newsId(event.getNewsId())
                .eventId(event.getEventId())
                .userId(event.getUserId())
                .body(event.getBody())
                .timestamp(event.getTimestamp())
                .build();
    }

    public Event convertToEntity (@NonNull EventModel comment) {
        return Event.builder()
                .id(comment.getId())
                .newsId(comment.getNewsId())
                .eventId(comment.getEventId())
                .userId(comment.getUserId())
                .body(comment.getBody())
                .timestamp(comment.getTimestamp())
                .build();
    }
}