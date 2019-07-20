package ru.sberbank.school.comment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.school.comment.entity.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

//    Optional<UserModel> findUserByUsernameIn(String username);
//    Comment findUserByUsernameIn(String username);
}