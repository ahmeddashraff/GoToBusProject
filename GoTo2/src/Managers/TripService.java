package Managers;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Trip;

@Stateless
public class TripService {

	@PersistenceContext
	private EntityManager em;
	
	public void addTrip(Trip trip) {
		
		em.persist(trip);
	}
	

	
	public Trip findTripbyid (int id)
    {
        return em.find(Trip.class, id);
    }

	public List<Trip> searchTrips(String from_station, String to_station) {
        TypedQuery<Trip> query = em.createNamedQuery("findAllTrips", Trip.class);
        query.setParameter("from_station", from_station);
        query.setParameter("to_station", to_station);
        return query.getResultList();
	}
}
