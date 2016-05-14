package org.pek.heartratewriter.data;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Random;

public class Generator {

	private String patientId;
	private String patientLastName;
	private String patientFirstName;
	private String bedId;
	
	private PrimitiveIterator.OfInt randomHeartRatesGenerator;

	private static Integer MIN_HEART_RATE = 55;
	private static Integer MAX_HEART_RATE = 105;	
	
	
	public Generator (String patientId,
					  String patientLastName,
			          String patientFirstName,
			          String bedId) {
		
		this.patientId = patientId;
		this.patientLastName = patientLastName;
		this.patientFirstName = patientFirstName;
		this.bedId = bedId;
		
		randomHeartRatesGenerator 
			= (new Random()).ints(MIN_HEART_RATE, MAX_HEART_RATE + 1).iterator();
	}	
	
	public List<HeartRateSample> generate (ZonedDateTime from,
										   ZonedDateTime to,
										   Integer minutesStep) {
		
		List<HeartRateSample> samples = new ArrayList<>();
		
		for (ZonedDateTime current = from;
			!current.isAfter(to);
			current = current.plusMinutes(minutesStep)) {
		
			HeartRateSample sample = 
				new HeartRateSample(patientId,
									patientLastName,
									patientFirstName,
									bedId,
									current,
									randomHeartRatesGenerator.nextInt());
			
			samples.add(sample);	
		}
		
		return samples;
	}
	
}
