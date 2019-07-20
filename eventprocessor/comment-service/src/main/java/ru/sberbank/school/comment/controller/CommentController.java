package ru.sberbank.school.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.school.feign.model.CommentModel;
import ru.sberbank.school.comment.service.CommentService;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

/*    @GetMapping(path = "{name}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public CommentModel getUserByName(@PathVariable String name) {
        return commentService.getByName(name);
    }*/

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public CommentModel getUser(@PathVariable long id) {
        return commentService.get(id);
    }

    @PostMapping
    public void createUser(@RequestBody CommentModel CommentModel) {
        commentService.create(CommentModel);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@RequestBody CommentModel CommentModel) {
        commentService.update(CommentModel);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable long id) {
        commentService.delete(id);
    }
}
