package ru.sberbank.school.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.sberbank.school.feign.model.UserModel;
import ru.sberbank.school.users.converter.UsersConverter;
import ru.sberbank.school.users.entity.Role;
import ru.sberbank.school.users.entity.User;
import ru.sberbank.school.users.repository.RoleRepository;
import ru.sberbank.school.users.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersConverter converter;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RoleRepository roleRepository;

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
    public void create(UserModel userModel) {

        usersRepository.save(converter.convertToEntity(userModel));

        long userId = get(userModel.getUsername()).getId();

        User user = new User();
        user.setId(userId);

        for (String s : userModel.getRoles()) {
            Role role = new Role();
            role.setRole(s);
            role.setUser(user);
            roleRepository.save(role);
        }
    }

    @Transactional
    @Override
    public void update(UserModel userModel) {
        usersRepository.deleteById(userModel.getId());
        usersRepository.save(converter.convertToEntity(userModel));
//        roleRepository.saveAll(converter.convertRolesToEntity(userModel));
    }

    @Override
    public void delete(long id) {
        usersRepository.deleteById(id);
    }
}
