package ru.sberbank.school.event.service;

import ru.sberbank.school.feign.model.EventModel;

public interface EventService {

    EventModel get(long id);

    EventModel save(EventModel user);

    void update(EventModel user);

    void delete(long id);
}
