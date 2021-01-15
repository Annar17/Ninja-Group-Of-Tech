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
 * Servlet implementation class PayBillServlet
 */
@WebServlet("/PayBillServlet")
public class PayBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Bill clientsDebt = null;
		DatabaseProcedures dP = new DatabaseProcedures();
		String phone_number = (String) session.getAttribute("Phone_number");
		
		if (dP.checkClientIsPairedToProgram(phone_number)) {
			clientsDebt = dP.getClientsBill(phone_number);
			request.setAttribute("clientsDebt", clientsDebt);
			request.getRequestDispatcher("payBill.jsp").forward(request, response);
		}
		else {
			response.getWriter().print("Could not find user billing details for the given phonenumber");
			response.setHeader("Refresh", "3;url=clientsIndex.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String phone_number = (String) session.getAttribute("Phone_number");
		
		DatabaseProcedures dP = new DatabaseProcedures();
		
		if(dP.checkClientIsPairedToProgram(phone_number)) {
			String result = dP.payBill(phone_number);
			response.setContentType("text/plain");
			response.getWriter().print(result);
			response.setHeader("Refresh", "3;url=clientsIndex.jsp");
		}else {
			response.getWriter().print("Not paired to a program. Please contact us!");
			response.setHeader("Refresh", "3;url=clientsIndex.jsp");
		}
	}

}
