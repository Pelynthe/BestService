package ru.sberbank.school.comment.service;

import ru.sberbank.school.feign.model.CommentModel;

public interface CommentService {

    CommentModel get(String accountName);

    CommentModel get(long id);

    boolean create(CommentModel user);

    boolean update(CommentModel user);

    boolean delete(long id);
}
