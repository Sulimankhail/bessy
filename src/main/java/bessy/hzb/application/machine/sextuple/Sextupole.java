package bessy.hzb.application.machine.sextuple;

import bessy.hzb.application.machine.Machine;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SEXTUPOLE")
public class Sextupole {
	//example Sextupole ID:	s4m2d1rl, L = 0.08, K = 27.0435/sxt_scl, N = Nsext, Method = 4;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "sextupole_id")
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

	public Sextupole() {

	}
	public Sextupole(String name,String type, Double strength, Double length, String n) {
		super();
		this.n = n;
		this.name = name;
		this.type = type;
		this.strength = strength;
		this.length = length;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
