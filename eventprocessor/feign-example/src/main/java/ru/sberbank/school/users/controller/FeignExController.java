package ru.sberbank.school.feign.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.school.feign.feign.UsersClient;
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
