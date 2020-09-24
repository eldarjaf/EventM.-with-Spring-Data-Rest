package eldar.datarestdemo.events.repos;

import eldar.datarestdemo.events.entities.Organizer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer,Long> {

}
