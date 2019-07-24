package ru.sberbank.school.news.service;

import ru.sberbank.school.feign.model.NewsModel;

import java.util.List;

public interface NewsService {

    NewsModel get(long id);

    List<NewsModel> getByEvent(long id);

    void create(NewsModel news);

    void update(NewsModel news);//TODO нужен?

    void delete(long id);
}
