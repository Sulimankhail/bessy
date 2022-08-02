package bessy.hzb.application.machine.quadrupole;

import bessy.hzb.application.machine.Machine;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "QUADRUPOLE")
public class Quadrupole {
	// example of a Quadrupole is: ID: q3m2d1r, L = 0.25, K = -2.02322285, N =
	// Nquad, Method = 4;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quadrupole_id")
	private Long id;
	private Double method;
	private String n;
	private String name;
	private Double length;
	private Double strength;
	private String type;
	@JsonIgnore
	@ManyToMany(mappedBy = "quadrupoles")
	private Set<Machine> machine = new HashSet<>();
	public Quadrupole() {

	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Quadrupole(String name, Double length, Double strength, String type) {
		super();
		this.name = name;
		this.type = type;
		this.strength = strength;
		this.length = length;
	}

	public Double getMethod() {
		return method;
	}

	public void setMethod(Double method) {
		this.method = method;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public Set<Machine> getMachine() {
		return machine;
	}

	public void setMachine(Set<Machine> machine) {
		this.machine = machine;
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
