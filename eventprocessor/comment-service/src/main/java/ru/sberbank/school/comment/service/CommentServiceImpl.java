package ru.sberbank.school.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import ru.sberbank.school.comment.converter.CommentConverter;
import ru.sberbank.school.comment.entity.Comment;
import ru.sberbank.school.comment.repository.CommentRepository;
import ru.sberbank.school.feign.model.CommentModel;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repository;
    private final CommentConverter converter;

    @Override
    public CommentModel get(String userName) {
        Assert.hasLength(userName, "Comment name must not be empty");

//        Comment user = repository.findUserByUsernameIn(userName);
//        return converter.convertToModel(user);
        return null;
    }

    @Override
    public CommentModel get(long id) {
        Optional<Comment> user = repository.findById(id);
        return user.isPresent()
                ? converter.convertToModel(user.get())
                : new CommentModel();
    }

    @Override
    public boolean create(CommentModel user) {
        return false;
    }

    @Override
    public boolean update(CommentModel user) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
