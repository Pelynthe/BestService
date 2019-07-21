package ru.sberbank.school.event.service;

import ru.sberbank.school.feign.model.EventModel;

public interface EventService {

    EventModel get(long id);

    void create(EventModel user);

    void update(EventModel user);

    void delete(long id);
}
