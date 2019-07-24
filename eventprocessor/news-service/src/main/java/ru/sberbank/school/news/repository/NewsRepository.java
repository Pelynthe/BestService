package ru.sberbank.school.news.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.school.news.entity.News;

import java.util.List;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {

    List<News> findNewsByEventId(long eventId);

}