package ru.sberbank.school.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import ru.sberbank.school.comment.converter.CommentsConverter;
import ru.sberbank.school.comment.entity.Comment;
import ru.sberbank.school.comment.repository.CommentsRepository;
import ru.sberbank.school.feign.model.CommentsModel;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository repository;
    private final CommentsConverter converter;

    @Override
    public CommentsModel get(String userName) {
        Assert.hasLength(userName, "Comment name must not be empty");

//        Comment user = repository.findUserByUsernameIn(userName);
//        return converter.convertToModel(user);
        return null;
    }

    @Override
    public CommentsModel get(long id) {
        Optional<Comment> user = repository.findById(id);
        return user.isPresent()
                ? converter.convertToModel(user.get())
                : new CommentsModel();
    }

    @Override
    public boolean create(CommentsModel user) {
        return false;
    }

    @Override
    public boolean update(CommentsModel user) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
