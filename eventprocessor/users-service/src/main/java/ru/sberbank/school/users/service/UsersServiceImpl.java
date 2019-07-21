package ru.sberbank.school.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.sberbank.school.feign.model.UserModel;
import ru.sberbank.school.users.converter.UsersConverter;
import ru.sberbank.school.users.entity.User;
import ru.sberbank.school.users.repository.UsersRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersConverter converter;
    @Autowired
    private UsersRepository repository;

    @Override
    public UserModel get(String userName) {
        Assert.hasLength(userName, "User name must not empty");

        Optional<User> user = repository.findUserByUsername(userName);
        return user.isPresent()
                ? converter.convertToModel(user.get())
                : new UserModel();
    }

    @Override
    public UserModel get(long id) {
        Optional<User> user = repository.findById(id);
        return user.isPresent()
                ? converter.convertToModel(user.get())
                : new UserModel();
    }

    @Override
    public void create(UserModel user) {
        repository.save(converter.convertToEntity(user));
    }

    @Transactional
    @Override
    public void update(UserModel user) {
        repository.deleteById(user.getId());
        repository.save(converter.convertToEntity(user));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
