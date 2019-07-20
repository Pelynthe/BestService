package ru.sberbank.school.comment.service;

import ru.sberbank.school.feign.model.CommentsModel;

public interface CommentsService {

    CommentsModel get(String accountName);

    CommentsModel get(long id);

    boolean create(CommentsModel user);

    boolean update(CommentsModel user);

    boolean delete(long id);
}
