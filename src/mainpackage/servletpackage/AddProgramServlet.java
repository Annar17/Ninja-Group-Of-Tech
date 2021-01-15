package mainpackage.servletpackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mainpackage.DatabaseProcedures;
import mainpackage.telecompackage.Program;

/**
 * Servlet implementation class AddProgramServlet
 */
@WebServlet("/AddProgramServlet")
public class AddProgramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProgramServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String program_name = request.getParameter("Program_name");
		String internet = request.getParameter("Internet");
		String minutes = request.getParameter("Minutes");
		String sms = request.getParameter("Sms");
		int cost = Integer.parseInt(request.getParameter("Cost"));
		
		Program program = new Program(program_name, internet, minutes, sms, cost);
		
		DatabaseProcedures dP = new DatabaseProcedures();
		String result = dP.addProgram(program);
		response.setContentType("text/plain");
		response.getWriter().print(result);
		response.setHeader("Refresh", "3;url=adminsIndex.jsp");
	}

}
