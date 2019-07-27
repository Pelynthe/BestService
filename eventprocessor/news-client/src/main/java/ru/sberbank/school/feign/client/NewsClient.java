package ru.sberbank.school.feign.client;

import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.school.feign.model.NewsModel;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@FeignClient(name = "news-service")
public interface NewsClient {

	@RequestMapping(method = RequestMethod.GET, value = "/news/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	NewsModel getNews(@NonNull @PathVariable("Id") long id);

	@RequestMapping(method = RequestMethod.GET, value = "/news/event{id}", produces = APPLICATION_JSON_UTF8_VALUE)
	List<NewsModel> getNewsByEvent(@NonNull @PathVariable("id") long id);

	@RequestMapping(method = RequestMethod.POST, value = "/news")
	NewsModel saveNews(@NonNull NewsModel news);

	@Deprecated
	@RequestMapping(method = RequestMethod.PUT, value = "/news")
	void updateNews(@NonNull NewsModel news);

	@RequestMapping(method =  RequestMethod.DELETE, value = "/news/{id}")
	void deleteNews(@NonNull @PathVariable("Id") long id);
}
