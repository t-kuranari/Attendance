package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttendanceDAO;
import entity.AttendanceBean;

/**
 * Servlet implementation class AttendanceSearchServlet
 */
@WebServlet("/attendance_search")
public class AttendanceSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttendanceSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String dateStr = request.getParameter("date");
		Date dateNull = null;
		AttendanceDAO aDAO = new AttendanceDAO();
		List<AttendanceBean> searchList;
		try {
			if (dateStr != null && !dateStr.isEmpty()) {
				Date date = Date.valueOf(dateStr);
				searchList = aDAO.searchAttendance(date);
			} else {
				searchList = aDAO.searchAttendance(dateNull);
			}
			request.setAttribute("searchList", searchList);
			RequestDispatcher rd = request.getRequestDispatcher("/attendance_index.jsp");
			rd.forward(request, response);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
