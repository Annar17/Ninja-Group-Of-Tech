package mainpackage.servletpackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mainpackage.DatabaseProcedures;
import mainpackage.telecompackage.Bill;

/**
 * Servlet implementation class ViewClientsBillServlet
 */
@WebServlet("/ViewClientsBillServlet")
public class ViewClientsBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewClientsBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Bill clientsBill = null;
		
		DatabaseProcedures dP = new DatabaseProcedures();
		HttpSession session = request.getSession(true);
		String category = (String) session.getAttribute("Category");
		
		if(category.equals("Seller")) {
			String phone_number = request.getParameter("Phone_number");
			
			if (dP.checkClientIsPairedToProgram(phone_number)) {
				clientsBill = dP.getClientsBill(phone_number);
				session.setAttribute("selectedClient", "TRUE");
				request.setAttribute("selectedClient", "TRUE");
				request.setAttribute("clientsBill", clientsBill);
				request.getRequestDispatcher("viewClientsBill.jsp").forward(request, response);
			}
			else {
				session.setAttribute("selectedClient", "FALSE");
				response.getWriter().print("Could not find user billing details for the given phonenumber");
				response.setHeader("Refresh", "3;url=viewClientsBill.jsp");
			}
		}else if(category.equals("Client")){  //
			String phone_number = (String) session.getAttribute("Phone_number");
			
			if (dP.checkClientIsPairedToProgram(phone_number)) {
				clientsBill = dP.getClientsBill(phone_number);
				request.setAttribute("clientsBill", clientsBill);
				request.getRequestDispatcher("viewBill.jsp").forward(request, response);
			}
			else {
				response.getWriter().print("Could not find user billing details for the given phonenumber");
				response.setHeader("Refresh", "3;url=clientsIndex.jsp");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("Printing client's details....\nDONE!");
		response.setHeader("Refresh", "3;url=sellersIndex.jsp");
	}

}
