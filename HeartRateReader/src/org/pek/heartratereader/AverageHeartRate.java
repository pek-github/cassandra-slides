package org.pek.heartratereader;

public class AverageHeartRate {
	
	private String patientId;
	private String patientLastName;
	private String patientFirstName;
	private String bedId;
	private Integer avgHeartRate;
	
	public String getPatientId() {
		return patientId;
	}
	
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	public String getPatientLastName() {
		return patientLastName;
	}
	
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	
	public String getPatientFirstName() {
		return patientFirstName;
	}
	
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	
	public String getBedId() {
		return bedId;
	}
	
	public void setBedId(String bedId) {
		this.bedId = bedId;
	}
	
	public Integer getAvgHeartRate() {
		return avgHeartRate;
	}
	
	public void setAvgHeartRate(Integer avgHeartRate) {
		this.avgHeartRate = avgHeartRate;
	}
	
}
