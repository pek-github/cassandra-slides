package org.pek.heartratereader.db;

import org.pek.heartratereader.AverageHeartRate;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;

public class AverageHeartRateDao {

	private Session session;
	private AverageHeartRate avgHeartRate;
	
	public AverageHeartRateDao (String patientId, String date) {
		String query = 
			basicQuery(patientId) + 
            "AND when_date = '" + date + "'";
		
		executeQuery(query);
	}

	public AverageHeartRateDao (String patientId, String date, Integer fromHour, Integer toHour) {
		String fromMinutes = hourToMinutes(fromHour);
		String toMinutes = hourToMinutes(toHour);
		
		String query = 
			basicQuery(patientId) + 
            "AND when_date = '" + date + "' " +
		    "AND when_day_minutes >= " + fromMinutes + " " +
		    "AND when_day_minutes <= " + toMinutes + " ";
		
		executeQuery(query);
	}
	
	public AverageHeartRateDao (String patientId, String fromDate, String toDate) {
		String query = 
			basicQuery(patientId) + 
            "AND when_date >= '" + fromDate + "' " +
            "AND when_date <= '" + toDate + "' ";

		executeQuery(query);
	}
	
	
	private String basicQuery (String patientId) {
		return
			"SELECT patient_id, patient_last_name, patient_first_name, bed_id, avg(heart_rate) AS avg_hr " + 
	        "FROM hospital.heart_rate_by_patient_and_time " +
	        "WHERE patient_id = '" + patientId + "' ";
	}

	private String hourToMinutes (Integer hour) {
		Integer minutes = hour * 60;
		return minutes.toString();
	}
	
	private void executeQuery (String query) {
		/* retrieve the session to the cluster */
		session = CassandraAccess.getSession();
	
		/* Since our Cluster has only one Node,
		   and KeySpace 'hospital' has a Replication Factor of 3,
		   we use a Consistency Level of 1
		*/
		Statement statement 
			= new SimpleStatement(query).setConsistencyLevel(ConsistencyLevel.ONE);
		
		/* execute the statement */
		ResultSet result = session.execute(statement);
		
		/* this query will return one row */
		Row row = result.one();
		avgHeartRate = (row == null) ? null : process(row);
	}
	
	private AverageHeartRate process (Row row) {
		AverageHeartRate ahr = new AverageHeartRate();
		
		ahr.setPatientId(row.getString("patient_id"));
		ahr.setPatientLastName(row.getString("patient_last_name"));
		ahr.setPatientFirstName(row.getString("patient_first_name"));
		ahr.setBedId(row.getString("bed_id"));
		ahr.setAvgHeartRate(row.getInt("avg_hr"));
		
		return ahr;
	}

	
	public AverageHeartRate getAverageHeartRate() {
		return avgHeartRate;
	}
	
}
