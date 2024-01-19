package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttendanceDAO;
import entity.AttendanceBean;

/**
 * Servlet implementation class AttendanceRegisterServlet
 */
@WebServlet("/attendance_register")
public class AttendanceRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendanceRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String employeeId = request.getParameter("employeeId");
		Date date = Date.valueOf(request.getParameter("date"));
		Time startTime = Time.valueOf(request.getParameter("startTime") + ":00");
		Time endTime = Time.valueOf(request.getParameter("endTime") + ":00");
		Time breakTime = Time.valueOf(request.getParameter("breakTime") + ":00");
		Time workTime = Time.valueOf(request.getParameter("workTime") + ":00");
		
		AttendanceBean ab = new AttendanceBean();
		ab.setEmployeeId(employeeId);
		ab.setDate(date);
		ab.setStartTime(startTime);
		ab.setEndTime(endTime);
		ab.setBreakTime(breakTime);
		ab.setWorkTime(workTime);
		try {
			AttendanceDAO aDAO = new AttendanceDAO();
			aDAO.registerAttendance(ab);
			response.sendRedirect(request.getContextPath() + "/attendance_index");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("error", "エラーがが発生しました。");
			response.sendRedirect(request.getContextPath() + "/attendance_register");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
