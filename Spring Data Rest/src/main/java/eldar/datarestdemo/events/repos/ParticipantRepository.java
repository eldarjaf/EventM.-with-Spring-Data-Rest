package eldar.datarestdemo.events.repos;

import eldar.datarestdemo.events.entities.Participant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant,Long> {
    
}
