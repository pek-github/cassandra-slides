package org.pek.heartratewriter.db;

import org.pek.heartratewriter.data.HeartRateSample;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;

public class HeartRateSampleDao {

	private Session session;
	private HeartRateSample sample;
	
	public HeartRateSampleDao (HeartRateSample sample) {
		this.sample = sample;
	}
	
	public void insert() {
		String query = makeQuery();

		/* retrieve the session to the cluster */		
		session = CassandraAccess.getSession();
		
		/* Since our cluster has only one node,
		   we use a Consistency Level of 1 */
		Statement statement 
			= new SimpleStatement(query).setConsistencyLevel(ConsistencyLevel.ONE);
		
		/* execute the statement */
		session.execute(statement);
		
		
//		session.execute(query);
	}
	
	private String makeQuery() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT INTO hospital.heart_rate_by_patient_and_time ( ")
		  .append("patient_id, patient_last_name, patient_first_name, bed_id, ")
		  .append("when_date, when_day_minutes, heart_rate ")
		  .append(") VALUES ('")
		  .append(sample.getPatientId())
		  .append("', '")
		  .append(sample.getPatientLastName())
		  .append("', '")
		  .append(sample.getPatientFirstName())
		  .append("', '")
		  .append(sample.getBedId())
		  .append("', '")
		  .append(sample.getWhenDate())
		  .append("', ")
		  .append(sample.getWhenDayMinutes())
		  .append(", ")
		  .append(sample.getHeartRate())
		  .append(")");
		
		return sb.toString();
	}
	
/**
// Query sample:  
INSERT INTO
hospital.heart_rate_by_patient_and_time (
	patient_id, patient_last_name, patient_first_name, 
	bed_id,
	when_date, when_day_minutes,
	heart_rate
) VALUES ('12111988K45', 'summers', 'alex',
		  'E45',
		  '2016-04-25+0000', 452,
		  90
);   
   	
*/	
}
