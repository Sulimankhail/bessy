package bessy.hzb.application.machine.sequencer;

import bessy.hzb.application.machine.Machine;

import javax.persistence.*;

@Entity
public class Sequencer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long deviceId;
	private String type;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="machine_Id")
	private Machine machine;
	private String name;
	private Double l;
	private int n;

	private Double locationStart;

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	private Double locationEnd;

	// USAGE of DTO Pattern to store the sequencer for machine
	public Sequencer(Long deviceId, Double locationStart, Double locationEnd, String type, String name, Double l, int n) {
		this.deviceId = deviceId;
		this.locationStart = locationStart;
		this.locationEnd = locationEnd;
		this.type = type;
		this.name = name;
		this.l = l;
		this.n = n;
	}

	public Sequencer() {

	}

	public Sequencer(Long id, Double length, double locationEnd, Class<Object> aClass) {
	}


	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Double getLocationStart() {
		return locationStart;
	}

	public void setLocationStart(Double locationStart) {
		this.locationStart = locationStart;
	}

	public Double getLocationEnd() {
		return locationEnd;
	}

	public void setLocationEnd(Double locationEnd) {
		this.locationEnd = locationEnd;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getL() {
		return l;
	}

	public void setL(Double l) {
		this.l = l;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}
