package Managers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Station;
import Entities.User;

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

	public boolean checkIfStationExists(String name) {
        TypedQuery<Station> query = em.createNamedQuery("findAllStations", Station.class);
        for(Station s : query.getResultList())
        {
        	if(s.getName().equals(name))
        	{
        		return true;
        	}
        }
        return false;   
	}
}