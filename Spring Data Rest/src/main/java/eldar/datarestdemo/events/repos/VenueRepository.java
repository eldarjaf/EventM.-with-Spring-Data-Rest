package eldar.datarestdemo.events.repos;

import eldar.datarestdemo.events.entities.Venue;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VenueRepository extends PagingAndSortingRepository<Venue,Long> {
    
}
