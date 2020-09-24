package eldar.datarestdemo.events.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Participant extends AbstractEntity {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;
	private Boolean checkedIn;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "ID", nullable = false, updatable = false) // @JoinColumn(name = "event_id") or
	private Event event; 														  // use referencedColumnName = "ID"

	@Override
	public boolean equals(Object o) {
		return Objects.equals(id, ((Participant)o).id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
