package Service;


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
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response;


import Entities.Station;
import Managers.StationService;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("station")
public class StationRESTService {
	
	@EJB
	StationService stationService;

	@POST
	public Response CreateStation(Station station) {
		ResponseBuilder builder;
		if (stationService.checkIfStationExists(station.getName())||station.getLatitude() > 90 || station.getLatitude() < -90 || station.getLongitude() > 180 || station.getLongitude() <-180)
	
			throw new InternalServerErrorException();
		else {
			stationService.addStation(station);
			builder = Response.ok();
			return builder.build();
		}
	}
	
	@Path("{id}")
	@GET
    public Station getStationById(@PathParam("id")int id)
    {
        return stationService.getStationById(id);
    }
}