package ru.sberbank.school.event.service;

import ru.sberbank.school.feign.model.EventModel;

import java.util.List;

public interface EventService {

    EventModel get(long id);

    List<EventModel> get();

    List<EventModel> getNext(long id);

    List<EventModel> getPrevious(long id);

    EventModel save(EventModel user);

    @Deprecated
    void update(EventModel user);

    void delete(long id);
}
