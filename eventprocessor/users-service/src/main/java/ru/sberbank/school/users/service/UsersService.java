package ru.sberbank.school.users.service;

import ru.sberbank.school.feign.model.UserModel;

import java.util.List;

public interface UsersService {

    UserModel get(String userName);

    UserModel get(long id);

    List<UserModel> get(List<Long> ids);

    UserModel save(UserModel user);

    void update(UserModel user);

    void delete(long id);
}
