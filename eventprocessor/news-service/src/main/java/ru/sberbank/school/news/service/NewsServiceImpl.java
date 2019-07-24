package ru.sberbank.school.news.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sberbank.school.feign.model.NewsModel;
import ru.sberbank.school.news.converter.NewsConverter;
import ru.sberbank.school.news.entity.News;
import ru.sberbank.school.news.repository.NewsRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsConverter converter;

    @Autowired
    private NewsRepository repository;

    @Override
    public NewsModel get(long id) {
        Optional<News> news = repository.findById(id);
        return news.isPresent()
                ? converter.convertToModel(news.get())
                : new NewsModel();
    }

    @Override
    public List<NewsModel> getByEvent(long id) {
        List<News> news = repository.findNewsByEventId(id);

        return  news.stream()
                .map(converter::convertToModel)
                .collect(Collectors.toList());
    }

    @Override
    public void create(NewsModel news) {
        repository.save(converter.convertToEntity(news));
    }

    @Override
    public void update(NewsModel news) {
        repository.deleteById(news.getId());
        repository.save(converter.convertToEntity(news));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
