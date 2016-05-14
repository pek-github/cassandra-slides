package org.pek.heartratewriter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.pek.heartratewriter.data.Generator;
import org.pek.heartratewriter.data.HeartRateSample;
import org.pek.heartratewriter.db.HeartRateSampleDao;

public class Main {

	public static void main (String[] args) throws Exception {
		
		welcome();
		
		populateAlex();
		populateJane();
		populateJordan();
		
		goodbye();
	}

	private static void welcome() {
		String msg 
			= "C* Table 'hospital.heart_rate_by_patient_and_time' "
				+ "is populated with sample data";
		
		System.out.println(msg);
		System.out.println();
	}
	
	private static void goodbye() {
		String msg 
			= "C* Table 'hospital.heart_rate_by_patient_and_time' "
				+ "is now populated";
		
		System.out.println();
		System.out.println(msg);
	}
	
	private static void populateAlex() throws Exception {
		populate("12111988K45", "summers", "alex", "E45", 
				"2016-04-25T00:00:02+00:00", "2016-04-26T00:00:04+00:00", 1);		
	}
	
	private static void populateJane() throws Exception {
		populate("17101991S49", "rain", "jane", "G45", 
				"2016-04-24T00:00:02+00:00", "2016-04-26T00:00:04+00:00", 5);		
	}
	
	private static void populateJordan() throws Exception {
		populate("02041985S49", "flow", "jordan", "D28", 
				"2016-04-24T00:00:02+00:00", "2016-04-27T00:00:09+00:00", 60);
	}
	
	private static void populate (String patientId,
								  String patientLastName,
							  	  String patientFirstName,
							  	  String bedId, 
							  	  String from, 
							  	  String to,
						  	  	  Integer minutesStep) throws InterruptedException {

		Generator generator 
			= new Generator(patientId, patientLastName, patientFirstName, bedId);
		
		ZonedDateTime f = makeDate(from);
		ZonedDateTime t = makeDate(to);
		
		for (HeartRateSample sample : generator.generate(f, t, minutesStep)) {
			HeartRateSampleDao dao = new HeartRateSampleDao(sample);
			dao.insert();
			Thread.sleep(20);
		}
		
	}
	
	private static ZonedDateTime makeDate (String date) {
		return ZonedDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
	} 
	
}
