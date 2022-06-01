package Service;

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
import Entities.Trip;
import Entities.User;
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
	
	@POST
	public Response CreateTrip(Trip trip) {
		ResponseBuilder builder;
		try {

			tripService.addTrip(trip);
			builder = Response.ok();
			
		}catch (Exception e) {
			throw new InternalServerErrorException(e);
		}
		return builder.build();
		
	}
	
	@POST
	@Path("booktrip")
	public Response bookTrip(Booking book) {
		ResponseBuilder builder;
		
		Trip trip = tripService.findTripbyid(book.getTrip_id());
		User user = userService.findUserbyid(book.getUser_id());
		
		System.out.println(user.getUsername() + " el trips :" + user.getTrips());
		
		//Set<Trip> tempT = user.getTrips();
		//tempT.add(trip);
		
		//Set<User> tempU = trip.getUsers();
		//tempU.add(user);
		trip.addUser(user);
		
		//user.setTrips(tempT);
		//trip.setUsers(tempU);


		userService.updateUser(user);
		System.out.println(user.getUsername() + " el trips :" + user.getTrips());
		builder = Response.ok();
		return builder.build();
		
	}
	
	@GET
	@Path("{id}")
	public Trip getTripById(@PathParam("id")int id) {
		return tripService.findTripbyid(id);
	}
	
	
}
