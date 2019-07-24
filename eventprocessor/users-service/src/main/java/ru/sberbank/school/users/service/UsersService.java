package ru.sberbank.school.users.service;

import ru.sberbank.school.feign.model.UserModel;

public interface UsersService {

    UserModel get(String userName);

    UserModel get(long id);

    UserModel save(UserModel user);

    void update(UserModel user);

    void delete(long id);
}
