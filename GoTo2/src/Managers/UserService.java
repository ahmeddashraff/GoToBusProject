package Managers;


import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

import Entities.Station;
import Entities.User;

@Stateless
public class UserService {
	

	@PersistenceContext
	private EntityManager em;

	public void addUser(User user) {
		
		em.persist(user);
	}

	public void updateUser(User user) {

		em.merge(user);
	}
	
	public List<User> getAllUsers() {
        TypedQuery<User> query = em.createNamedQuery("findAllUsers", User.class);
        return query.getResultList();
    }
	
	public User findUserbyid (int id)
    {
        return em.find(User.class, id);
    }

}