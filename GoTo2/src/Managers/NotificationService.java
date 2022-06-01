package Managers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Notification;

@Stateless
public class NotificationService {
	
	@PersistenceContext
	private EntityManager em;
	
	public void addNotification(Notification notification) {
		em.persist(notification);
	}

}
