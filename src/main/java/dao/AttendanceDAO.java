package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.AttendanceBean;

public class AttendanceDAO {
	
	public void registerAttendance(AttendanceBean attendance) throws ClassNotFoundException {
		String sql = "INSERT INTO attendances (employee_id, date, start_time, end_time, break_time, work_time) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
		
			pstmt.setString(1, attendance.getEmployeeId());
			pstmt.setDate(2, attendance.getDate());
			pstmt.setTime(3, attendance.getStartTime());
			pstmt.setTime(4, attendance.getEndTime());
			pstmt.setTime(5, attendance.getBreakTime());
			pstmt.setTime(6, attendance.getWorkTime());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<AttendanceBean> AttendanceList() throws ClassNotFoundException {
		String sql = "SELECT * FROM attendances";
		List<AttendanceBean> AttendanceList = new ArrayList<AttendanceBean>();
		try (Connection con = ConnectionManager.getConnection();
		     PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ResultSet res = pstmt.executeQuery();
		    while (res.next()) {
				AttendanceBean AB = new AttendanceBean();
				AB.setId(res.getInt("id"));
				AB.setEmployeeId(res.getString("employee_id"));
				AB.setDate(res.getDate("date"));
				AB.setStartTime(res.getTime("start_time"));
				AB.setEndTime(res.getTime("end_time"));
				AB.setBreakTime(res.getTime("break_time"));
				AB.setWorkTime(res.getTime("work_time"));
		    	AttendanceList.add(AB);
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AttendanceList;
	}
	
	public List<AttendanceBean> searchAttendance(Date date) throws ClassNotFoundException {
		List<AttendanceBean> searchList = new ArrayList<>();
		String sql = "SELECT id, employee_id, date, start_time, end_time, break_time, work_time FROM attendances";
		if (date != null) {
			sql += " WHERE date = ?";
		}
		
		try (Connection con = ConnectionManager.getConnection();
		     PreparedStatement pstmt = con.prepareStatement(sql)) {
			if (date != null) {
				pstmt.setDate(1, date);
			}
		
			ResultSet res = pstmt.executeQuery();
		
			while (res.next()) {
				AttendanceBean AB = new AttendanceBean();
				AB.setId(res.getInt("id"));
				AB.setEmployeeId(res.getString("employee_id"));
				AB.setDate(res.getDate("date"));
				AB.setStartTime(res.getTime("start_time"));
				AB.setEndTime(res.getTime("end_time"));
				AB.setBreakTime(res.getTime("break_time"));
				AB.setWorkTime(res.getTime("work_time"));
				searchList.add(AB);
			}
			return searchList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchList;
	}

}
