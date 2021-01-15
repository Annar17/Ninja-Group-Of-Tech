package mainpackage.servletpackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mainpackage.DatabaseProcedures;
import mainpackage.telecompackage.Call;



/**
 * Servlet implementation class CallLogsServlet
 */
@WebServlet("/CallLogsServlet")
public class CallLogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallLogsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	HttpSession session = request.getSession(true);
		
		DatabaseProcedures dP = new DatabaseProcedures();
		String phone_number = (String) session.getAttribute("Phone_number");
		
		if (dP.checkClientExists(phone_number)) {
			List<Call> callList = dP.getCallLogs(phone_number);
			request.setAttribute("callList", callList);
			request.getRequestDispatcher("callLogs.jsp").forward(request, response);
		}
		else {
			response.getWriter().print("Could not find call details for the given phonenumber.");
			response.setHeader("Refresh", "3;url=clientsIndex.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("Printing your call logs....\nDONE!");
		response.setHeader("Refresh", "3;url=clientsIndex.jsp");
	}

}
