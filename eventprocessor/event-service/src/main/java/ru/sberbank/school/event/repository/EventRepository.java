package ru.sberbank.school.event.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.school.event.entity.Event;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findCommentsByNewsId(long newsId);

    List<Event> findCommentsByEventId(long eventId);
}