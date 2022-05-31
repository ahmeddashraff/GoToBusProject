package Service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import Entities.Trip;
import Managers.TripService;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("trip")
public class TripRESTService {

	@EJB
	private TripService tripService;
	
	@POST
	public Response CreateTrip(Trip trip) {
		ResponseBuilder builder;
		try {
			Trip newtrip = new Trip();
			newtrip.setArrival_time(trip.getArrival_time());
			newtrip.setAvailable_seats(trip.getAvailable_seats());
			newtrip.setDeparture_time(trip.getDeparture_time());
			newtrip.setFrom_station(trip.getFrom_station());
			newtrip.setTo_station(trip.getTo_station());
			newtrip.setTrip_id(trip.getTrip_id());
			tripService.addTrip(newtrip);
			builder = Response.ok();
			
		}catch (Exception e) {
			throw new InternalServerErrorException(e);
		}
		return builder.build();
		
	}
	
	
}
