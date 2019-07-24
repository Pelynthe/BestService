package ru.sberbank.school.event.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.school.event.entity.Event;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    @Query(
            value = "select * from events e order by timestamp desc limit 20",
            nativeQuery = true)
    List<Event> getLatest20Events();
}