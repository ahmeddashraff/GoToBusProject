package Managers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Station;

@Stateless
public class StationService {

	
	@PersistenceContext
	private EntityManager em;
	
	public void addStation(Station station) {
		
		em.persist(station);
	}

	public void updateUser(Station station) {
		em.merge(station);
		
	}
	

	public Station getStationById(int id) {
		return em.find(Station.class, id);
	}
}