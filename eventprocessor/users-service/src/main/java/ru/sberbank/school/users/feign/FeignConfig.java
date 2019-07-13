package ru.sberbank.school.users.feign;/*
package ru.sberbank.school.users.feign;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sberbank.school.users.feign.UserClient;


@Configuration
public class FeignConfig {

	@Value("${feign.userclient.url}")
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
