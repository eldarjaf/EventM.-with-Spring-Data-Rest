package eldar.datarestdemo.events.entities.projections;

import eldar.datarestdemo.events.entities.Venue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "virtual", types = {Venue.class})
public interface StreetAddressProjection {

    @Value("#{target.streetAddress} #{target.streetAddress2}")
    String getCompleteStreetAddress();
}
