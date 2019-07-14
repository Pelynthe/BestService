package ru.sberbank.school.users.service;

import ru.sberbank.school.users.model.UserModel;

public interface UsersService {

    UserModel getByName(String accountName);

    UserModel getById(long id);

    boolean create(UserModel user);

    boolean update(UserModel user);

    boolean delete(long id);
}
