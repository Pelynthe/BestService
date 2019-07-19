package ru.sberbank.school.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.sberbank.school.feign.model.NewsModel;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@FeignClient(name = "news-service")
public interface NewsClient {

	@RequestMapping(method = RequestMethod.GET, value = "/news/{newsId}", produces = APPLICATION_JSON_UTF8_VALUE)
	NewsModel getNews(@PathVariable("newsId") long newsId);

	@RequestMapping(method = RequestMethod.POST, value = "/news")
	void createNews(NewsModel news);

	@RequestMapping(method = RequestMethod.PUT, value = "/news/{newsId}")
	void updateNews(@PathVariable("newsId") long newsId, NewsModel news);//TODO не уверен что он нужен

	@RequestMapping(method = RequestMethod.DELETE, value = "/news/{newsId}")
	void deleteNews(@PathVariable("newsId") long newsId);
}
