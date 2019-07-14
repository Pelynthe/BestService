package ru.sberbank.school.feignexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import ru.sberbank.school.feign.client.UsersClient;
import ru.sberbank.school.feign.model.UserModel;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "feign")
@RequiredArgsConstructor
public class FeignExController {

    private final UsersClient usersClient;

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public UserModel getUserById(@PathVariable long id) {
        return usersClient.getUser(id);
    }
}
