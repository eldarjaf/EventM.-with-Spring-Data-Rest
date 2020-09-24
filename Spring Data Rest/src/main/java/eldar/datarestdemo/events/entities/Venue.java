package eldar.datarestdemo.events.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Venue extends AbstractEntity {

	private String name;
	private String streetAddress;
	private String streetAddress2;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	
	public Long getResourceId() {
		return this.id;
	}

	@Override
	public boolean equals(Object o) {
		return Objects.equals(id, ((Venue)o).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
