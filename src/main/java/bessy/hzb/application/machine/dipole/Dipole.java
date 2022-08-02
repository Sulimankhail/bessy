package bessy.hzb.application.machine.dipole;
import bessy.hzb.application.machine.Machine;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="DIPOLE")
public class Dipole {

	//example of Bending or Diploe ID: bm2d1r11 , L = 0.152, T = 2.000023775463165, T1 = 5.625000000000000, T2 = 0.000000000000000, K = 0.0, N = Nbend, Method = 4;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "dipole_id")
	private Long id;
	private String t;
	private String t1;
	private String t2;
	private String n;
	private int method;
	private String name;
	private Double length;
	private Double strength;
	private String type;
	@JsonIgnore
	@ManyToMany(mappedBy = "dipoles")
	private Set<Machine> machine = new HashSet<>();

	
    public Dipole() {super();}
	public Dipole(Double length, String t, String t1, String t2, String n, Double strength, int method, String name, String type) {
		super();
		this.t = t;
		this.t1 = t1;
		this.t2 = t2;
		this.n = n;
		this.method = method;
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

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public int getMethod() {
		return method;
	}

	public void setMethod(int method) {
		this.method = method;
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
