package ru.sberbank.school.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.sberbank.school.users.converter.UsersConverter;
import ru.sberbank.school.users.entity.User;
import ru.sberbank.school.users.model.UserModel;
import ru.sberbank.school.users.repository.UsersRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository repository;
    private final UsersConverter converter;

    @Override
    public UserModel getByName(String userName) {
        Assert.hasLength(userName, "User name must not be empty");

//        User user = repository.findUserByUsernameIn(userName);
//        return converter.convertToModel(user);
        return null;
    }

    @Override
    public UserModel getById(long id) {
        Optional<User> user = repository.findById(id);
        user.ifPresent(converter::convertToModel);
        return user.isPresent()
                ? converter.convertToModel(user.get())
                : new UserModel();
    }

    @Override
    public boolean create(UserModel user) {
        return false;
    }

    @Override
    public boolean update(UserModel user) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
