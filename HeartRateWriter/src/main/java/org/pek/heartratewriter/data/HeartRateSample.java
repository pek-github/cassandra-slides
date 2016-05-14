package org.pek.heartratewriter.data;

import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;

public class HeartRateSample {
	
	private String patientId;
	private String patientLastName;
	private String patientFirstName;
	private String bedId;
	
	private String whenDate; //	with format: '2016-04-25+0000'
	private Integer whenDayMinutes;
	private Integer heartRate;
	
	
	public HeartRateSample (String patientId,
							String patientLastName,
							String patientFirstName,
							String bedId,
							ZonedDateTime when,
							Integer heartRate) {
		
		DateInfo w = new DateInfo(when);
		
		this.patientId = patientId;
		this.patientLastName = patientLastName;
		this.patientFirstName = patientFirstName;
		this.bedId = bedId;
		this.whenDate = w.getDate();
		this.whenDayMinutes = w.getMinutes();
		this.heartRate = heartRate;
	}

	public String getPatientId() {
		return patientId;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public String getBedId() {
		return bedId;
	}

	public String getWhenDate() {
		return whenDate;
	}

	public Integer getWhenDayMinutes() {
		return whenDayMinutes;
	}

	public Integer getHeartRate() {
		return heartRate;
	}

	@Override
	public String toString() {
		return "HeartRateSample [patientId=" + patientId 
				+ ", patientLastName=" + patientLastName 
				+ ", patientFirstName=" + patientFirstName
				+ ", bedId=" + bedId 
				+ ", whenDate=" + whenDate
				+ ", whenDayMinutes=" + whenDayMinutes 
				+ ", heartRate=" + heartRate + "]";
	}
	
	// ------------------------------------------
	
	private static class DateInfo {
		
		private static final DateTimeFormatter FORMATTER 
			= DateTimeFormatter.ofPattern("yyyy-MM-ddZ");
		
		private String infoDate;
		private Integer infoDayMinutes;
		
		private DateInfo (ZonedDateTime t) {
			infoDate = date(t);
			infoDayMinutes = minutes(t);
		}
		
		private String date (final ZonedDateTime t) {
			return t.format(FORMATTER);
		}
		
		private Integer minutes (final ZonedDateTime t) {
			return t.getHour() * 60 + t.getMinute();
		}
		
		private String getDate() {
			return infoDate;
		}
		
		private Integer getMinutes() {
			return infoDayMinutes;
		}
	}
	
}
