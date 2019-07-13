package ru.sberbank.school.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.sberbank.school.users.converter.UsersConverter;
import ru.sberbank.school.users.entity.User;
import ru.sberbank.school.users.model.UserModel;
import ru.sberbank.school.users.repository.UsersRepository;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

//    private final UsersRepository repository;
    private final UsersConverter converter;

    @Override
    public UserModel findByName(String userName) {
        Assert.hasLength(userName, "User name must not be empty");

//        User user = repository.findUserByUsernameIn(userName);
//        return converter.convertToModel(user);
        return null;
    }

    @Override
    public UserModel findById(long id) {
        System.out.println("EEy!");
//        return null;
        return UserModel.builder()
                .id(1)
                .username("asd")
                .email("asd")
                .firstName("asd")
                .lastName("asd")
                .build();
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
