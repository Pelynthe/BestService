package ru.sberbank.school.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.school.feign.model.CommentsModel;
import ru.sberbank.school.comment.service.CommentsService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "comments")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public CommentsModel getComment(@PathVariable long id) {
        return commentsService.get(id);
    }

    @GetMapping(path = "news{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<CommentsModel> getCommentsByNews(@PathVariable long id) {
        return commentsService.getByNews(id);
    }

    @GetMapping(path = "event{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<CommentsModel> getCommentsByEvent(@PathVariable long id) {
        return commentsService.getByEvent(id);
    }

    @PostMapping
    public void createComment(@RequestBody CommentsModel CommentsModel) {
        commentsService.create(CommentsModel);
    }

    @PutMapping
    public void updateComment(@RequestBody CommentsModel CommentsModel) {
        commentsService.update(CommentsModel);
    }

    @DeleteMapping(path = "{id}")
    public void deleteComment(@PathVariable long id) {
        commentsService.delete(id);
    }
}
