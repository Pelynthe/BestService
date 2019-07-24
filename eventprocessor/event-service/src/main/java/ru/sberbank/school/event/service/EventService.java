package ru.sberbank.school.event.service;

import ru.sberbank.school.feign.model.EventModel;

import java.util.List;

public interface EventService {

    EventModel get(long id);

    List<EventModel> get();

    EventModel save(EventModel user);

    @Deprecated
    void update(EventModel user);

    void delete(long id);
}
