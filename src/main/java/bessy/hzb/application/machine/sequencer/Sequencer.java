package bessy.hzb.application.machine.sequencer;

import bessy.hzb.application.machine.Machine;

import javax.persistence.*;

@Entity
@Table(name = "SEQUENCER")
public class Sequencer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long deviceId;
	private String deviceType;
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="machine_Id")
	private Machine machine;


	private Double locationStart;
	private Double locationEnd;

	// USAGE of DTO Pattern to store the sequencer for machine
	public Sequencer(Long deviceId, Double locationStart, Double locationEnd, String deviceType) {
		this.deviceId = deviceId;
		this.locationStart = locationStart;
		this.locationEnd = locationEnd;
		this.deviceType = deviceType;
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

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
}
