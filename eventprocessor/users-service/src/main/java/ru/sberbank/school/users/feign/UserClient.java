package ru.sberbank.school.users.feign;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.school.users.model.UserModel;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

//@FeignClient(name = "user-service")
public interface UserClient {

	@RequestMapping(method = POST, value = "/users")
	UserModel createUser(UserModel user);

	@RequestMapping(method = GET, value = "/users/{userId}")
	UserModel getUser(@PathVariable("userId") Long userId);

	@RequestMapping(method = PUT, value = "/users/{userId}")
	UserModel updateUser(@PathVariable("userId") Long userId, UserModel user);

	@RequestMapping(method = DELETE, value = "/users/{userId}")
	void deleteUser(@PathVariable("userId") Long userId);
}
