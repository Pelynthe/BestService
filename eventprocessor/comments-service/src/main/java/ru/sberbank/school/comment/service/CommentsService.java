package ru.sberbank.school.comment.service;

import ru.sberbank.school.feign.model.CommentsModel;

import java.util.List;

public interface CommentsService {

    CommentsModel get(long id);

    List<CommentsModel> getByNews(long id);

    List<CommentsModel> getByEvent(long id);

    boolean create(CommentsModel user);

    boolean update(CommentsModel user);

    boolean delete(long id);
}
