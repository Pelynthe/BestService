package ru.sberbank.school.event.service;

import ru.sberbank.school.feign.model.EventModel;

import java.util.List;

public interface EventService {

    EventModel get(long id);

    List<EventModel> getByNews(long id);

    List<EventModel> getByEvent(long id);

    void create(EventModel user);

    void update(EventModel user);

    void delete(long id);
}
