package Service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import java.util.List;

import Entities.User;
import Managers.UserService;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("user")
public class UserRESTService {
	
	@EJB
	private UserService userService;
	
	@POST
	public Response register(User user) {
		ResponseBuilder builder;
		userService.addUser(user);
		builder = Response.ok();
		return builder.build();
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserAllUsers()
    {
        return userService.getAllUsers();

    }
	
	@POST
	@Path("login")
	public Response login(User user) {
		ResponseBuilder builder  = Response.serverError();
		for(User e : userService.getAllUsers()) {
			if (e.getUsername().equals(user.getUsername()) && e.getPassword().equals(user.getPassword())) {
				builder = Response.ok();
				break;
			}else
				builder = Response.status(Response.Status.BAD_REQUEST);	
		}
		return builder.build();
	}
	
	/*@GET
    @Path("{id}")
    public User getID (@PathParam("id")int id)
    {
        return userService.findUserbyid(id);
    }*/


}
