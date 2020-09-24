package eldar.datarestdemo.events.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Organizer extends AbstractEntity {

	private String name;

	@OneToMany(mappedBy = "organizer")
	private Set<Event> events;

	@Override
	public boolean equals(Object o) {
		return Objects.equals(id, ((Organizer)o).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
