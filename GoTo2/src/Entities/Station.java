package Entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Set;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Station
 *
 */
@Entity

public class Station implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer station_id;
	private String name;
	private Double longitude;
	private Double latitude;
	private static final long serialVersionUID = 1L;
	
	
	@OneToMany(mappedBy="from_station", fetch=FetchType.EAGER)
	private Set<Trip> tripsfrom;
	
	@OneToMany(mappedBy="to_station", fetch=FetchType.EAGER)
	private Set<Trip> tripsto;

	public Station() {
		super();
	}   
	public Integer getStation_id() {
		return this.station_id;
	}

	public void setStation_id(Integer station_id) {
		this.station_id = station_id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}   
	public Double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Set<Trip> getTripsFrom() {
		return this.tripsfrom;
	}
   
	public void setTripsFrom(Set<Trip> trips) {
		this.tripsfrom = trips;
	}
	
	public Set<Trip> getTripsTo() {
		return this.tripsto;
	}
   
	public void setTripsTo(Set<Trip> trips) {
		this.tripsto = trips;
	}
}
