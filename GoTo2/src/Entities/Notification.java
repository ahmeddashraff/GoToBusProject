package Entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Notification
 *
 */
@Entity

public class Notification implements Serializable {

	@JsonIgnore   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer notification_id;
	private String message;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date notification_datetime;
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User nuser;

	public Notification() {
		super();
	}   
	public Integer getNotification_id() {
		return this.notification_id;
	}

	public void setNotification_id(Integer notification_id) {
		this.notification_id = notification_id;
	}   
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}   
	public Date getNotification_datetime() {
		return this.notification_datetime;
	}

	public void setNotification_datetime(Date notification_datetime) {
		this.notification_datetime = notification_datetime;
	}
	
	public User getNuser() {
		return this.nuser;
	}
	
	public void setNuser(User nuser) {
		this.nuser = nuser;
	}
   
}
