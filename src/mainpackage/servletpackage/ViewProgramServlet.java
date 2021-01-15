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
import mainpackage.telecompackage.Program;

/**
 * Servlet implementation class ViewProgramServlet
 */
@WebServlet("/ViewProgramServlet")
public class ViewProgramServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProgramServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseProcedures dP = new DatabaseProcedures();
		List<Program> programList = dP.getPrograms();
		
		HttpSession session = request.getSession(true);
		String category = (String) session.getAttribute("Category");
		
		if(category.equals("Seller")) {
			request.setAttribute("programList", programList);
			request.getRequestDispatcher("viewPrograms.jsp").forward(request, response);
		}
		else if(category.equals("Admin")){
			session.setAttribute("selectedProgram", "FALSE"); 
			request.setAttribute("programList", programList);
			request.getRequestDispatcher("changeProgramDetails.jsp").forward(request, response);
		}
		else{
			response.getWriter().print("Login Failed!");
        	response.setHeader("Refresh", "3;url=login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
