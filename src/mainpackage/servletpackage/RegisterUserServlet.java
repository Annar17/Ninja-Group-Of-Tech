package mainpackage.servletpackage;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mainpackage.DatabaseProcedures;
import mainpackage.userspackage.Client;
import mainpackage.userspackage.Seller;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public String getHash(String unhashed, String salt) {
        // Hash the password.
		
        final String toHash = salt + unhashed + salt;
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            return "00000000000000000000000000000000";
        }
        messageDigest.update(toHash.getBytes(), 0, toHash.length());
        String hashed = new BigInteger(1, messageDigest.digest()).toString(16);
        if (hashed.length() < 32) {
            hashed = "0" + hashed;
        }
        return hashed.toUpperCase();
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		String surname = request.getParameter("Surname");
		String username = request.getParameter("Username");
		SecureRandom random = new SecureRandom();
		byte bytes[]= new byte[20];
		random.nextBytes(bytes);
		String password = getHash(request.getParameter("Password"),random.toString());
		String address = request.getParameter("Address");
		String email = request.getParameter("Email");
		String afm = request.getParameter("AFM");
		String phone_number = request.getParameter("Phone Number");
		String property = request.getParameter("Property");
		
		HttpSession session = request.getSession(true);
		String category = (String) session.getAttribute("Category");
		DatabaseProcedures dP = new DatabaseProcedures();
		
		if(category.equals("Seller")) {
			Client client = new Client(username, name, surname, password, address, email, afm, phone_number, property);
			String result = dP.insertUser(client);
			response.setContentType("text/plain");
			response.getWriter().print(result);
			response.setHeader("Refresh", "3;url=sellersIndex.jsp");
		}
		else if(category.equals("Admin")){
			Seller seller = new Seller(username, name, surname, password, address, email, afm, phone_number, property);
			String result = dP.insertUser(seller);
			response.setContentType("text/plain");
			response.getWriter().print(result);
			response.setHeader("Refresh", "3;url=adminsIndex.jsp");
		}
		else{
			response.getWriter().print("Login Failed!");
        	response.setHeader("Refresh", "3;url=login.jsp");
		}

	}

}
