package ru.sberbank.school.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.school.feign.model.EventModel;
import ru.sberbank.school.event.service.EventService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "comments")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public EventModel getComment(@PathVariable long id) {
        return eventService.get(id);
    }

    @GetMapping(path = "news{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<EventModel> getCommentsByNews(@PathVariable long id) {
        return eventService.getByNews(id);
    }

    @GetMapping(path = "event{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<EventModel> getCommentsByEvent(@PathVariable long id) {
        return eventService.getByEvent(id);
    }

    @PostMapping
    public void createComment(@RequestBody EventModel EventModel) {
        eventService.create(EventModel);
    }

    @PutMapping
    public void updateComment(@RequestBody EventModel EventModel) {
        eventService.update(EventModel);
    }

    @DeleteMapping(path = "{id}")
    public void deleteComment(@PathVariable long id) {
        eventService.delete(id);
    }
}
