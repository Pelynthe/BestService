package ru.sberbank.school.news.service;

import ru.sberbank.school.feign.model.NewsModel;

public interface NewsService {

    NewsModel get(int idEvent);//TODO получить все новости за мероприятие?

    NewsModel get(long id);

    void create(NewsModel news);

    void update(NewsModel news);//TODO нужен?

    void delete(long id);
}
