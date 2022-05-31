package Managers;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Trip;
import Entities.User;

@Stateless
public class TripService {

	@PersistenceContext
	private EntityManager em;
	
	public void addTrip(Trip trip) {
		
		em.persist(trip);
	}
	
	public List<Trip> searchTrips() {
        TypedQuery<Trip> query = em.createNamedQuery("findAllTrips", Trip.class);
        return query.getResultList();
    }
}
