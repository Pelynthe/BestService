package ru.sberbank.school.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.school.event.service.EventService;
import ru.sberbank.school.feign.model.EventModel;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public EventModel getEvent(@PathVariable long id) {
        return eventService.get(id);
    }

    @PostMapping
    public void createEvent(@RequestBody EventModel EventModel) {
        eventService.create(EventModel);
    }

    @PutMapping
    public void updateEvent(@RequestBody EventModel EventModel) {
        eventService.update(EventModel);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEvent(@PathVariable long id) {
        eventService.delete(id);
    }
}
