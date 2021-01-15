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
import mainpackage.telecompackage.PhoneNumber;
import mainpackage.telecompackage.Program;

/**
 * Servlet implementation class ChangeClientsProgramServlet
 */
@WebServlet("/ChangeClientsProgramServlet")
public class ChangeClientsProgramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeClientsProgramServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone_number = request.getParameter("Phone_number");
		DatabaseProcedures dP = new DatabaseProcedures();
		List<Program> programList = dP.getPrograms();
		HttpSession session = request.getSession(true);
		session.setAttribute("clientsPhoneNumber", phone_number);
		
		if(dP.checkClientIsPairedToProgram(phone_number)) {
			PhoneNumber phone_Num = dP.getClientsProgram(phone_number);
			session.setAttribute("selectedClient", "TRUE");
			request.setAttribute("programList", programList);
			request.setAttribute("phone_number", phone_Num);
			request.getRequestDispatcher("changeClientsProgram.jsp").forward(request, response);
		}
		else {
			session.setAttribute("selectedClient", "FALSE");
			response.getWriter().print("The client is not paired with a program.");
			response.setHeader("Refresh", "3;url=searchClientsProgram.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String phone_number = (String) session.getAttribute("clientsPhoneNumber");
		String program_name = (String) request.getParameter("Program_name");
		DatabaseProcedures dP = new DatabaseProcedures();
		
		String result = dP.changeClientsProgram(phone_number, program_name); 
		response.getWriter().print(result);
		response.setHeader("Refresh", "3;url=sellersIndex.jsp");
		
		session.removeAttribute("clientsPhoneNumber");
		session.removeAttribute("selectedClient");
	}

}
