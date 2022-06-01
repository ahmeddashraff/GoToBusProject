package Entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Station
 *
 */
@Entity
@NamedQuery(name="findAllStations", query ="select s from Station s")
public class Station implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer station_id;
	private String name;
	private Double longitude;
	private Double latitude;
	private static final long serialVersionUID = 1L;

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
	
}
