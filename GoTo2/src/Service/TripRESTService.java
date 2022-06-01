package Service;

import java.util.Date;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


import Entities.Booking;
import Entities.Notification;
import Entities.Trip;
import Entities.User;
import Managers.NotificationService;
import Managers.StationService;
import Managers.TripService;
import Managers.UserService;
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("trip")
public class TripRESTService {

	@EJB
	private TripService tripService;
	
	@EJB
	private UserService userService;
	
	@EJB
	private NotificationService notificationService;
	
	@EJB
	private StationService stationService;
	
	/*@POST
	public Response CreateTrip(Trip trip) {
		ResponseBuilder builder;
		try {
				
			tripService.addTrip(trip);
			builder = Response.ok();
			
		}catch (Exception e) {
			throw new InternalServerErrorException(e);
		}
		return builder.build();
		
	}*/
	
	@POST
	public Response CreateTrip(Trip trip) {
		ResponseBuilder builder;
		
		if(stationService.checkIfStationExists(trip.getFrom_station()) && stationService.checkIfStationExists(trip.getTo_station())){
			tripService.addTrip(trip);
			builder = Response.ok();
			return builder.build();
		}else {
			
			builder = Response.serverError();
			return builder.build();
		}
	}
	
	@POST
	@Path("booktrip")
	public Response bookTrip(Booking book) {
		Date date = new Date();
	    
		ResponseBuilder builder;
		String message;
		Notification noti = new Notification();
		
		Trip trip = tripService.findTripbyid(book.getTrip_id());
		User user = userService.findUserbyid(book.getUser_id());
		
		if(trip.getAvailable_seats()<1) {
			message = "Sorry, Trip " + trip.getFrom_station() +" to " + trip.getTo_station() + " have no available seats";
			noti.setMessage(message);
			noti.setNotification_datetime(date);
			noti.setNuser(user);
			notificationService.addNotification(noti);
			
			builder = Response.serverError();
			return builder.build();
		}else {
		trip.setAvailable_seats(trip.getAvailable_seats() - 1);
		trip.addUser(user);
		message = "You have booked trip from " + trip.getFrom_station() +" to " + trip.getTo_station() + " successfully";
		noti.setMessage(message);
		noti.setNotification_datetime(date);
		noti.setNuser(user);
		notificationService.addNotification(noti);
		
		builder = Response.ok();
		return builder.build();
		}
	}
	
	@GET
	@Path("{id}")
	public Trip getTripById(@PathParam("id")int id) {
		return tripService.findTripbyid(id);
	}
	
	@GET
	@Path("/viewtrips/{id}")
	public Set<Trip> viewUserTrips(@PathParam("id")int id){
		User user = userService.findUserbyid(id);
		Set<Trip> check = user.getTrips();
		if(check == null)
			throw new InternalServerErrorException();
		return check;
	}
}
