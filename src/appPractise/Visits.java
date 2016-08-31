package appPractise;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Visits {

	private int id;
	private int doctorId;
	private int userId ;
	private Date date;
	private String comments;
	private int cycleId;
	
	public Visits(int id, int doctorId, int userId, Date date, int cycleId, String comments) {
		this(doctorId, userId, date, cycleId, comments);
		this.id = id;
		
	}
	
	public Visits(int doctorId, int userId, Date date, int cycleId, String comments) {
		super();
		this.cycleId = cycleId;
		this.doctorId = doctorId;
		this.userId = userId;
		this.date = date;
		this.comments = comments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	public int getCycleId() {
		return cycleId;
	}
	public void setCycleId(int cycleId) {
		this.cycleId = cycleId;
	}
	@Override
	public String toString() {
		return "Visits [id=" + id + ", doctorId=" + doctorId + ", userId=" + userId + ", date=" + date + ", comments="
				+ comments + "]";
	}
	

	public String getDateFormated() {
		if(date!=null) {
			DateFormat formatter =new SimpleDateFormat("dd/MM/yyyy");
			return formatter.format(date);
		} else {
			return null;
		}
	}
	
}
