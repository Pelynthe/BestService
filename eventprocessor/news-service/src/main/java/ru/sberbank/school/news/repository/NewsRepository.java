package ru.sberbank.school.news.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.school.news.entity.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {

//    Optional<UserModel> findUserByUsernameIn(String username);
//    User findUserByUsernameIn(String username);
}