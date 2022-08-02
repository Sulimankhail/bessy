package bessy.hzb.application.machine.drift;

import bessy.hzb.application.machine.Machine;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DRIFT")
public class Drift {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "drift_id")
	private Long id;
	private String name;
	private Double length;
	private Double strength;
	private String type;

	public Drift() {

	}

	@JsonIgnore
	@ManyToMany(mappedBy = "drifts")
	private Set<Machine> machine = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Drift(String name, Double length, Double strength, String type) {
		super();
		this.name = name;
		this.type = type;
		this.strength = strength;
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getStrength() {
		return strength;
	}

	public void setStrength(Double strength) {
		this.strength = strength;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
