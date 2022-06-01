package Entities;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Entity implementation class for Entity: searchTrip
 *
 */
@Entity

public class SearchTrip implements Serializable {

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date from_date;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date to_date;
	private Integer from_station;
	private Integer to_station;   
	@Id
	private Integer search_id;
	private static final long serialVersionUID = 1L;

	public SearchTrip() {
		super();
	}   
	public Date getFrom_date() {
		return this.from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}   
	public Date getTo_date() {
		return this.to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}   
	public Integer getFrom_station() {
		return this.from_station;
	}

	public void setFrom_station(Integer from_station) {
		this.from_station = from_station;
	}   
	public Integer getTo_station() {
		return this.to_station;
	}

	public void setTo_station(Integer to_station) {
		this.to_station = to_station;
	}   
	public Integer getSearch_id() {
		return this.search_id;
	}

	public void setSearch_id(Integer search_id) {
		this.search_id = search_id;
	}
   
}
