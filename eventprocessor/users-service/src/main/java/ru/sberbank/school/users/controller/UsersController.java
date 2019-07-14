package ru.sberbank.school.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.school.users.model.UserModel;
import ru.sberbank.school.users.service.UsersService;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "user")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

/*    @GetMapping(path = "{name}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public UserModel getUserByName(@PathVariable String name) {
        return usersService.getByName(name);
    }*/

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public UserModel getUser(@PathVariable long id) {
        return usersService.get(id);
    }

    @PostMapping
    public void createUser(@RequestBody UserModel userModel) {
        usersService.create(userModel);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@RequestBody UserModel userModel) {
        usersService.update(userModel);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable long id) {
        usersService.delete(id);
    }
}
