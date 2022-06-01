package Service;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Entities.Notification;
import Entities.User;
import Managers.UserService;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("notifications")
public class NotificationRESTService {

	@EJB
	private UserService userService;
	
	@GET
	@Path("{id}")
	public Set<Notification> getUserNotifications(@PathParam("id")int id){
		User user = userService.findUserbyid(id);
		Set<Notification> check = user.getNotification();
		if(check == null)
			throw new InternalServerErrorException();
		return check;
	}
}
