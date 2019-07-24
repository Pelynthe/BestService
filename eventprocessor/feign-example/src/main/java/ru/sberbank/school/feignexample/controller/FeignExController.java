package ru.sberbank.school.feignexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import ru.sberbank.school.feign.client.CommentsClient;
import ru.sberbank.school.feign.client.UsersClient;
import ru.sberbank.school.feign.model.CommentsModel;
import ru.sberbank.school.feign.model.UserModel;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "feign")
@RequiredArgsConstructor
public class FeignExController {

    private final UsersClient usersClient;

    private final CommentsClient commentsClient;

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public UserModel getUserById(@PathVariable long id) {
        return usersClient.getUser(id);
    }

    @GetMapping(path = "event{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<CommentsModel> getCommentsByEvent(@PathVariable long id) {
        return commentsClient.getCommentsByEvent(1L);
    }
}
