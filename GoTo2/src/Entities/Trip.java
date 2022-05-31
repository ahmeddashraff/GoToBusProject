package Entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Trip
 *
 */
@Entity

@NamedQuery(name="findAllTrips", query ="select e from User e")

public class Trip implements Serializable {

	
	//@ManyToOne
	//@JoinColumn(name="fromStation")
	private Station from_station;
	
	//@ManyToOne
	//@JoinColumn(name="toStation")
	private Station to_station;
	
	
	private Integer available_seats;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date departure_time;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date arrival_time;   
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trip_id;
	
	private static final long serialVersionUID = 1L;

	
	public Trip() {
		super();
	}   
	public Station getFrom_station() {
		return this.from_station;
	}

	public void setFrom_station(Station from_station) {
		this.from_station = from_station;
	}   
	public Station getTo_station() {
		return this.to_station;
	}

	public void setTo_station(Station to_station) {
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
   
}
