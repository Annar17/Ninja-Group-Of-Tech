package mainpackage.servletpackage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mainpackage.DatabaseProcedures;
import mainpackage.telecompackage.PhoneNumber;
import mainpackage.telecompackage.Program;

/**
 * Servlet implementation class PairProgramToClient
 */
@WebServlet("/PairProgramToClientServlet")
public class PairProgramToClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PairProgramToClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseProcedures dP = new DatabaseProcedures();
		List<Program> programList = dP.getPrograms();
		
		request.setAttribute("programList", programList);
		request.getRequestDispatcher("pairProgramToClient.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone_number = request.getParameter("Phone_number");
		String program_name = request.getParameter("Program_name");
		
		String result = null;
		
		DatabaseProcedures dP = new DatabaseProcedures();
		response.setContentType("text/plain");
		
		if (dP.checkClientExists(phone_number)) {
			PhoneNumber phoneNumber = new PhoneNumber(phone_number, program_name);
			result = dP.pairProgramToClient(phoneNumber);
		}
		else {
			result+="\r\nClient does not exist in database!";
		}

		response.getWriter().print(result);
		response.setHeader("Refresh", "3;url=sellersIndex.jsp");
	}

}
