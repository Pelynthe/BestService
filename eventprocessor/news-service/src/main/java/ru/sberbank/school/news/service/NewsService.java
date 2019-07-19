package ru.sberbank.school.news.service;

import ru.sberbank.school.feign.model.NewsModel;

public interface NewsService {

    NewsModel get(int idEvent);//TODO получить все новости за мероприятие?

    NewsModel get(long id);

    boolean create(NewsModel news);

    boolean update(NewsModel news);//TODO нужен?

    boolean delete(long id);
}
