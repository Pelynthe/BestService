/*
package ru.sberbank.school.users.users;

import users.Feign;
import users.Logger;
import users.jackson.JacksonDecoder;
import users.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.netflix.users.support.SpringMvcContract;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sberbank.school.users.users.UserClient;


@Configuration
public class FeignConfig {

	@Value("${users.userclient.url}")
	String userClientUrl;

	@Bean
	UserClient userClient() {
		return Feign.builder()
			.contract(new SpringMvcContract())
			.encoder(new JacksonEncoder())
			.decoder(new JacksonDecoder())
			.logger(new Logger.ErrorLogger())
			.logLevel(Logger.Level.FULL)
			.target(UserClient.class, userClientUrl);
	}
}
*/
