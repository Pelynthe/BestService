package ru.sberbank.school.users.feign;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.school.users.model.UserModel;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserClient {

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	UserModel createUser(UserModel user);

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	List<UserModel> getUsers();

	@RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
	UserModel getUser(@PathVariable("userId") Long userId);

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
	UserModel updateUser(@PathVariable("userId") Long userId, UserModel user);

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
	void deleteUser(@PathVariable("userId") Long userId);
}
