package ru.sberbank.school.news.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.school.feign.model.NewsModel;
import ru.sberbank.school.news.service.NewsService;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public NewsModel getNews(@PathVariable long id) {
        return newsService.get(id);
    }

    @PostMapping
    public void createNews(@RequestBody NewsModel newsModel) {
        newsService.create(newsModel);
    }

    @PutMapping
    public void updateNews(@RequestBody NewsModel newsModel) {
        newsService.update(newsModel);
    }

    @DeleteMapping(path = "{id}")
    public void deleteNews(@PathVariable long id) {
        newsService.delete(id);
    }
}
