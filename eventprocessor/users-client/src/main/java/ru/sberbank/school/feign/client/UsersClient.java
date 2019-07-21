package ru.sberbank.school.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.school.feign.model.UserModel;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@FeignClient(name = "users-service")
public interface UsersClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/name/{name}", produces = APPLICATION_JSON_UTF8_VALUE)
	UserModel getUserByName(@PathVariable("name") String name);

	@RequestMapping(method = RequestMethod.GET, value = "/user/{userId}", produces = APPLICATION_JSON_UTF8_VALUE)
	UserModel getUser(@PathVariable("userId") long userId);

	@RequestMapping(method = RequestMethod.POST, value = "/user")
	void createUser(UserModel user);

	@RequestMapping(method = RequestMethod.PUT, value = "/user")
	void updateUser(UserModel user);

	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{userId}")
	void deleteUser(@PathVariable("userId") long userId);
}
