package ru.sberbank.school.event.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.school.event.service.EventService;
import ru.sberbank.school.feign.model.EventModel;

import java.util.List;

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

    @GetMapping(path = "latest", produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<EventModel> getEvents(@PathVariable long id) {
        return eventService.get();
    }

    @PostMapping(produces = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public EventModel saveEvent(@NonNull @RequestBody EventModel EventModel) {
        return eventService.save(EventModel);
    }

    @Deprecated
    @PostMapping
    public void createEvent(@RequestBody EventModel EventModel) {
        eventService.save(EventModel);
    }

    @Deprecated
    @PutMapping
    public void updateEvent(@RequestBody EventModel EventModel) {
        eventService.update(EventModel);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEvent(@PathVariable long id) {
        eventService.delete(id);
    }
}
