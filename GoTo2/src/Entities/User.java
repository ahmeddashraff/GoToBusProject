package Entities;

import java.io.Serializable;
import java.lang.String;
import java.util.Set;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@NamedQuery(name="findAllUsers", query ="select e from User e")
@NamedQuery(name="findUserToLogin", query ="select e from User e Where e.username = :un AND e.password = :pw ")
public class User implements Serializable {


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	
	private String username;
	private String password;
	private String full_name;
	private String role;
	private static final long serialVersionUID = 1L;
	

	@ManyToMany(mappedBy="users", fetch=FetchType.EAGER)
	private Set<Trip> trips;

	public User() {
		super();
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFull_name() {
		return this.full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		User other = (User) obj;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}*/

	public Integer getId() {
		return this.user_id;
	}
	
	public void setId(Integer id) {
		this.user_id = id;
	}
	
	public void setTrips(Set<Trip> trips) {
		this.trips = trips;
	}
	
	public Set<Trip> getTrips() {
		return this.trips;
	}
	
	public void addtrip(Trip t)
	{
		this.trips.add(t);
	}

}
