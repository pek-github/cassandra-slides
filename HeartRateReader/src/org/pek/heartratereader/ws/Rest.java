package org.pek.heartratereader.ws;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.pek.heartratereader.AverageHeartRate;
import org.pek.heartratereader.db.AverageHeartRateDao;

@Path("heartrates")
public class Rest {

	@GET
    @Path("patients/{id}/date/{date}")
	@Produces(MediaType.APPLICATION_JSON)
    public AverageHeartRate getAvgRateForDate (@PathParam("id") String patientId,
    								 		   @PathParam("date") String date,
								 	           @QueryParam("fromHour") Integer fromHour,
							 	 	           @QueryParam("toHour") Integer toHour) {
		
		AverageHeartRateDao dao =
			(fromHour != null && toHour != null) 
			? new AverageHeartRateDao(patientId, parseDate(date), fromHour, toHour)
			: new AverageHeartRateDao(patientId, parseDate(date));
		
    	return dao.getAverageHeartRate();
    }
	
	@GET
    @Path("patients/{id}/dates/{from}/{to}")
	@Produces(MediaType.APPLICATION_JSON)
    public AverageHeartRate getAvgRateForDates (@PathParam("id") String patientId,
    								  		    @PathParam("from") String fromDate,
    								            @PathParam("to") String toDate) {
		
		AverageHeartRateDao dao =
			new AverageHeartRateDao(patientId, parseDate(fromDate), parseDate(toDate));
		
		return dao.getAverageHeartRate();
    }
	
	@GET
	@Path("/test")
	public String someTest() {
		return "Success 3.14159";
	}

	private String parseDate (String date) {
		try {
			SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");		
			SimpleDateFormat sdfOut = new SimpleDateFormat("yyyy-MM-dd+0000");
			
		    Date dateObj = sdfIn.parse(date);
		    return sdfOut.format(dateObj);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
		
}
