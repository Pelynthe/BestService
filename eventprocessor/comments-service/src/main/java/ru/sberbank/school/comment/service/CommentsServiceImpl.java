package ru.sberbank.school.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbank.school.comment.converter.CommentsConverter;
import ru.sberbank.school.comment.entity.Comment;
import ru.sberbank.school.comment.repository.CommentsRepository;
import ru.sberbank.school.feign.model.CommentsModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService {

    private final CommentsConverter converter;
    @Autowired
    private CommentsRepository repository;

    @Override
    public CommentsModel get(long id) {
        Optional<Comment> comment = repository.findById(id);
        return comment.isPresent()
                ? converter.convertToModel(comment.get())
                : new CommentsModel();
    }

    @Override
    public List<CommentsModel> getByNews(long id) {
        List<Comment> comments = repository.findCommentsByNewsId(id);

        return comments.stream()
                .map(converter::convertToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentsModel> getByEvent(long id) {
        return null;
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
