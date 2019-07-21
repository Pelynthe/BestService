package ru.sberbank.school.feign.client;

import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sberbank.school.feign.model.EventModel;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@FeignClient(name = "comments-service")
public interface EventClient {

	@RequestMapping(method = GET, value = "/comments/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	EventModel getComment(@NonNull @PathVariable("Id") long Id);

	@RequestMapping(method = GET, value = "/comments/news{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	List<EventModel> getCommentsByNews(@NonNull @PathVariable("id") long id);

	@RequestMapping(method = GET, value = "/comments/event{Id}", produces = APPLICATION_JSON_UTF8_VALUE)
	List<EventModel> getCommentsByEvent(@NonNull @PathVariable("id") long id);

	@RequestMapping(method = POST, value = "/comments")
	void createComment(@NonNull EventModel comment);

	@RequestMapping(method = PUT, value = "/comments")
	void updateComment(@NonNull EventModel comment);

	@RequestMapping(method = DELETE, value = "/comments/{id}")
	void deleteComment(@NonNull @PathVariable("id") long id);
}