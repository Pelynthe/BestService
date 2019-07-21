package ru.sberbank.school.event.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sberbank.school.event.converter.EventConverter;
import ru.sberbank.school.event.entity.Event;
import ru.sberbank.school.event.repository.EventRepository;
import ru.sberbank.school.feign.model.EventModel;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventConverter converter;
    @Autowired
    private EventRepository repository;

    @Override
    public EventModel get(long id) {
        Optional<Event> comment = repository.findById(id);
        return comment.isPresent()
                ? converter.convertToModel(comment.get())
                : new EventModel();
    }

    @Override
    public void create(EventModel eventModel) {
        repository.save(converter.convertToEntity(eventModel));
    }

    @Transactional
    @Override
    public void update(EventModel event) {
        repository.deleteById(event.getId());
        repository.save(converter.convertToEntity(event));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}