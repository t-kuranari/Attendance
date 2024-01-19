package entity;
import java.sql.Date;
import java.sql.Time;

public class AttendanceBean {
	private int id;
	private String employeeId;
	private Date date;
	private Time startTime;
	private Time endTime;
	private Time breakTime;
	private Time workTime;
	
	// コンストラクタ
	public AttendanceBean() {
	    // デフォルトコンストラクタ
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	public Time getBreakTime() {
		return breakTime;
	}
	public void setBreakTime(Time breakTime) {
		this.breakTime = breakTime;
	}
	
	public Time getWorkTime() {
		return workTime;
	}
	public void setWorkTime(Time workTime) {
		this.workTime = workTime;
	}
}

