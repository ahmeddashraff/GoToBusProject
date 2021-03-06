package Entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.Set;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Trip
 *
 */
@Entity

@NamedQuery(name="findAllTrips", query ="select t from Trip t Where t.from_station = :from_station AND t.to_station = :to_station")

public class Trip implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trip_id;

	private String from_station;
	private String to_station;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="TripXUser",
		joinColumns=@JoinColumn(name="trip_id"),
		inverseJoinColumns=@JoinColumn(name="user_id"))
	private Set<User> users;
	
	
	private Integer available_seats;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date departure_time;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date arrival_time;   
	

	
	private static final long serialVersionUID = 1L;

	
	public Trip() {
		super();
	}   
	
	public String getFrom_station() {
		return this.from_station;
	}

	public void setFrom_station(String from_station) {
		this.from_station = from_station;
	}   
	public String getTo_station() {
		return this.to_station;
	}

	public void setTo_station(String to_station) {
		this.to_station = to_station;
	}
	
	public Integer getAvailable_seats() {
		return this.available_seats;
	}

	public void setAvailable_seats(Integer available_seats) {
		this.available_seats = available_seats;
	}   
	public Date getDeparture_time() {
		return this.departure_time;
	}

	public void setDeparture_time(Date departure_time) {
		this.departure_time = departure_time;
	}   
	public Date getArrival_time() {
		return this.arrival_time;
	}

	public void setArrival_time(Date arrival_time) {
		this.arrival_time = arrival_time;
	}   
	public Integer getTrip_id() {
		return this.trip_id;
	}

	public void setTrip_id(Integer trip_id) {
		this.trip_id = trip_id;
	}
   
	public Set<User> getUsers(){
		return this.users;
	}
	
	public void setUsers(Set<User> users){
		this.users = users;
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
}
