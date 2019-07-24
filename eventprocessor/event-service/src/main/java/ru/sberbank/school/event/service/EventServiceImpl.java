package ru.sberbank.school.event.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sberbank.school.event.converter.EventConverter;
import ru.sberbank.school.event.entity.Event;
import ru.sberbank.school.event.repository.EventRepository;
import ru.sberbank.school.feign.model.EventModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventConverter converter;
    @Autowired
    private EventRepository repository;

    @Override
    public EventModel get(long id) {
        Optional<Event> event = repository.findById(id);
        return event.isPresent()
                ? converter.convertToModel(event.get())
                : new EventModel();
    }

    @Override
    public List<EventModel> get() {
//        List<Event> events = repository.getLatestEvents();
//        return events.stream().map(converter::convertToModel).collect(Collectors.toList());
        return null;
    }

    @Transactional
    @Override
    public EventModel save(EventModel eventModel) {
        Event event = converter.convertToEntity(eventModel);
        repository.save(event);
        return converter.convertToModel(event);
    }

    @Deprecated
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