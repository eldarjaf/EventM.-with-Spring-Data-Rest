package eldar.datarestdemo.events.controllers;

import eldar.datarestdemo.events.entities.Event;
import eldar.datarestdemo.events.repos.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/events")
public class EventKickOffController {

    @Autowired
    EventRepository eventRepository;

    @PostMapping("/start/{id}")
    public ResponseEntity start(@PathVariable Long id) {
        Event event;
        if (eventRepository.findById(id).isPresent()) {
            event = eventRepository.findById(id).get();
            event.setStarted(true);
            eventRepository.save(event);
        } else {
            throw new ResourceNotFoundException();
        }
        return ResponseEntity.ok(event.getName() + " has started");
    }
}
