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
        Optional<Event> comment = repository.findById(id);
        return comment.isPresent()
                ? converter.convertToModel(comment.get())
                : new EventModel();
    }

    @Override
    public List<EventModel> getByNews(long id) {
        List<Event> events = repository.findCommentsByNewsId(id);

        return events.stream()
                .map(converter::convertToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventModel> getByEvent(long id) {
        List<Event> events = repository.findCommentsByEventId(id);

        return events.stream()
                .map(converter::convertToModel)
                .collect(Collectors.toList());
    }

    @Override
    public void create(EventModel comment) {
        repository.save(converter.convertToEntity(comment));
    }

    @Transactional
    @Override
    public void update(EventModel comment) {
        repository.deleteById(comment.getId());
        repository.save(converter.convertToEntity(comment));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}