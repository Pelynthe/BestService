package ru.sberbank.school.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.school.feign.model.UserModel;
import ru.sberbank.school.users.service.UsersService;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "user")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping(path = "name/{name}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public UserModel getUserByName(@PathVariable String name) {
        return usersService.get(name);
    }

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public UserModel getUser(@PathVariable long id) {
        return usersService.get(id);
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel userModel) {
        return usersService.save(userModel);
    }

    //use saveUser
    @Deprecated
    @PutMapping
    public void updateUser(@RequestBody UserModel userModel) {
        usersService.update(userModel);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable long id) {
        usersService.delete(id);
    }
}
