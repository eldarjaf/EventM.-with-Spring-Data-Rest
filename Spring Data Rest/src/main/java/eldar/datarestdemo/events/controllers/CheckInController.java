package eldar.datarestdemo.events.controllers;

import eldar.datarestdemo.events.entities.Participant;
import eldar.datarestdemo.events.exceptions.AlreadyCheckedInException;
import eldar.datarestdemo.events.repos.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestController
@RequestMapping("/events")
public class CheckInController {

    @Autowired
    ParticipantRepository participantRepository;

    @PostMapping("/checkin/{id}")
    public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id,
                                               PersistentEntityResourceAssembler assembler){
        Participant participant;
        if (participantRepository.findById(id).isPresent()) {
            participant = participantRepository.findById(id).get();
            if(participant.getCheckedIn()){
                throw new AlreadyCheckedInException("Already checked in participant");
            }
            participant.setCheckedIn(true);
            participantRepository.save(participant);
        } else {
            throw new ResourceNotFoundException();
        }

        return ResponseEntity.ok(assembler.toFullResource(participant)); // to return as HAL resource
    }
}
