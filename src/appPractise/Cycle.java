package appPractise;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cycle {
	private int cycleId;
	private Date fromDate;
	private Date toDate;
	private String cycleDescription;
	
	
	public Cycle() {
		super();
	}
	
	public Cycle(Date fromDate, Date toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	
	public Cycle(int cycleId, Date fromDate, Date toDate) {
		this(fromDate, toDate);
		this.cycleId = cycleId;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getCycleId() {
		return cycleId;
	}

	public void setCycleId(int cycleId) {
		this.cycleId = cycleId;
	}

	public String getCycleDescription() {
		return cycleDescription;
	}

	public void setCycleDescription(String cycleDescription) {
		this.cycleDescription = cycleDescription;
	}
	
	
}
