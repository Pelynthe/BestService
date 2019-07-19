package ru.sberbank.school.news.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbank.school.feign.model.NewsModel;
import ru.sberbank.school.news.converter.NewsConverter;
import ru.sberbank.school.news.entity.News;
import ru.sberbank.school.news.repository.NewsRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService { //TODO заполнить

    @Autowired
    private NewsRepository repository;
    private final NewsConverter converter;

    @Override
    public NewsModel get(int idEvent) {
        return null;
    }

    @Override
    public NewsModel get(long id) {
        Optional<News> news = repository.findById(id);
        return news.isPresent()
                ? converter.convertToModel(news.get())
                : new NewsModel();
    }

    @Override
    public boolean create(NewsModel news) {
        return false;
    }

    @Override
    public boolean update(NewsModel news) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
