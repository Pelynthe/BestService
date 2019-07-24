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
    private UsersRepository usersRepository;

    @Override
    public UserModel get(String userName) {
        Assert.hasLength(userName, "User name must not empty");

        Optional<User> user = usersRepository.findUserByUsername(userName);
        return user.isPresent()
                ? converter.convertToModel(user.get())
                : new UserModel();
    }

    @Override
    public UserModel get(long id) {
        Optional<User> user = usersRepository.findById(id);
        return user.isPresent()
                ? converter.convertToModel(user.get())
                : new UserModel();
    }

    @Transactional
    @Override
    public UserModel save(UserModel userModel) {
        User user = converter.convertToEntity(userModel);
        usersRepository.save(user);
        return converter.convertToModel(user);
    }

    @Transactional
    @Override
    public void update(UserModel userModel) {
        usersRepository.deleteById(userModel.getId());
        usersRepository.save(converter.convertToEntity(userModel));
    }

    @Override
    public void delete(long id) {
        usersRepository.deleteById(id);
    }
}
