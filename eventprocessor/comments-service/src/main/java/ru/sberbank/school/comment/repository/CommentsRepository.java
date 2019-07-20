package ru.sberbank.school.comment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.school.comment.entity.Comment;

import java.util.List;

@Repository
public interface CommentsRepository extends CrudRepository<Comment, Long> {

    List<Comment> findCommentsByNewsId(long newsId);

    List<Comment> findCommentsByEventId(long eventId);
}