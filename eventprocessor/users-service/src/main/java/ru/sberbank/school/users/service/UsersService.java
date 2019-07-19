package ru.sberbank.school.users.service;

import ru.sberbank.school.feign.model.UserModel;

public interface UsersService {

    UserModel get(String accountName);

    UserModel get(long id);

    boolean create(UserModel user);

    boolean update(UserModel user);

    boolean delete(long id);
}
