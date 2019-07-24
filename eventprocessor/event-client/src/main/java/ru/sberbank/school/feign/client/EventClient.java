package ru.sberbank.school.feign.client;

import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sberbank.school.feign.model.EventModel;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@FeignClient(name = "event-service")
public interface EventClient {

	@RequestMapping(method = GET, value = "/event/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	EventModel getEvent(@NonNull @PathVariable("id") long Id);

	@RequestMapping(method = POST, value = "/event")
	EventModel saveEvent(@NonNull EventModel event);

	@Deprecated
	@RequestMapping(method = POST, value = "/event")
	void createEvent(@NonNull EventModel event);

	@Deprecated
	@RequestMapping(method = PUT, value = "/event")
	void updateEvent(@NonNull EventModel event);

	@RequestMapping(method = DELETE, value = "/event/{id}")
	void deleteEvent(@NonNull @PathVariable("id") long id);
}