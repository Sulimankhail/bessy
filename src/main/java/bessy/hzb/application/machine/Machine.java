package bessy.hzb.application.machine;


import java.util.*;

import javax.persistence.*;

import bessy.hzb.application.machine.beamPosition.BeamPositions;
import bessy.hzb.application.machine.dipole.Dipole;
import bessy.hzb.application.machine.drift.Drift;
import bessy.hzb.application.machine.quadrupole.Quadrupole;
import bessy.hzb.application.machine.sequencer.Sequencer;
import bessy.hzb.application.machine.sextuple.Sextupole;

@Entity
@Table(name="MACHINE")
public class Machine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "machine_id")
	private Long id;

    @ManyToMany()
    @JoinTable(name = "machine_dipole", 
    joinColumns = @JoinColumn(name = "machine_id"), 
    inverseJoinColumns = @JoinColumn(name = "dipole_id"))   
	private Set<Dipole> dipoles = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "machine_quadrupole", 
    joinColumns = @JoinColumn(name = "machine_id"), 
    inverseJoinColumns = @JoinColumn(name = "quadrupole_id"))   
	private Set<Quadrupole> quadrupoles = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "machine_sextupole", 
    joinColumns = @JoinColumn(name = "machine_id"), 
    inverseJoinColumns = @JoinColumn(name = "sextupole_id"))   
	private Set<Sextupole> sextupoles = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "machine_drift", 
    joinColumns = @JoinColumn(name = "machine_id"), 
    inverseJoinColumns = @JoinColumn(name = "drift_id"))   
	private Set<Drift> drifts = new HashSet<>();

	public List<Sequencer> getSequences() {
		return sequences;
	}

	@OneToMany
	private List<Sequencer> sequences = new ArrayList<>();

	@OneToMany
	private List<BeamPositions> beamPositions = new ArrayList<>();
	private String name;
	private String description;
	private Double length = 0.0;




	public Machine(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Machine() {

	}


	public void addDipole( Dipole dipole){
		dipoles.add(dipole);
	}
	public void addDevice(Object device) {
		if ("dipole".equals(device.getClass())) {
			dipoles.add((Dipole) device);
		}
	}
	void updateMachineLenght(Double length){
		this.length = this.length + length;
	}
	public void addSextupole(Sextupole sextupole) {
		sextupoles.add(sextupole);
	}
	public void addDrift(Drift drift) {
		drifts.add(drift);
	}
	public void addQuadrupole(Quadrupole quadrupole) {
		quadrupoles.add(quadrupole);
	}
	// getters and setters if required

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Dipole> getDipoles() {
		return dipoles;
	}

	public Set<Quadrupole> getQuadrupole() {
		return quadrupoles;
	}

	public Set<Sextupole> getSextupole() {
		return sextupoles;
	}

	public Set<Drift> getDrift() {
		return drifts;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public void addSequence(Sequencer sequencer) {
		sequences.add(sequencer);
	}

	public void addBeamPositions(BeamPositions beamPS){
		beamPositions.add(beamPS);
	}

	public List<BeamPositions> getBeamPositions() {
		return beamPositions;
	}

	public void setBeamPositions(List<BeamPositions> beamPositions) {
		this.beamPositions = beamPositions;
	}
}
