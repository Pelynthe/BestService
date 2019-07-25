package ru.sberbank.school.news.service;

import ru.sberbank.school.feign.model.NewsModel;

import java.util.List;

public interface NewsService {

    NewsModel get(long id);

    List<NewsModel> getByEvent(long id);

    NewsModel save(NewsModel newsModel);

    @Deprecated
    void update(NewsModel news);

    void delete(long id);
}
