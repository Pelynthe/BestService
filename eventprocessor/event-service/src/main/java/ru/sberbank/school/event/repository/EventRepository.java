package ru.sberbank.school.event.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.school.event.entity.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}