package mainpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mainpackage.userspackage.Client;
import mainpackage.userspackage.Seller;
import mainpackage.userspackage.Users;
import mainpackage.telecompackage.Bill;
import mainpackage.telecompackage.Call;
import mainpackage.telecompackage.PhoneNumber;
import mainpackage.telecompackage.Program;

public class DatabaseProcedures { //DAO

	private final String url = "jdbc:postgresql://localhost:5432/DB_Telikh-Ergasia-2020";
	private final String user = "postgres";
	private final String password = "anna123";
	private final String dbDriver = "org.postgresql.Driver";
	
	public DatabaseProcedures() {	}
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public String insertUser(Object user) {
		
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String result = "User has been inserted successfully!";
		String query = "INSERT INTO users(username, name, surname, password, address, email, category, afm, phone_number, property) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setString(1, ((Users) user).getUsername());
			ps.setString(2, ((Users) user).getName());
			ps.setString(3, ((Users) user).getSurname());
			ps.setString(4, ((Users) user).getPassword());
			ps.setString(5, ((Users) user).getAddress());
			ps.setString(6, ((Users) user).getEmail());
			ps.setString(7, ((Users) user).getCategory());
			String category = ((Users) user).getCategory();
			if(category.equals("Client")){
				ps.setString(8, ((Client) user).getAfm());
				ps.setString(9, ((Client) user).getPhone_number());
				ps.setString(10, ((Client) user).getProperty());
			}else if(category.equals("Seller")) {
				ps.setString(8, ((Seller) user).getAfm());
				ps.setString(9, ((Seller) user).getPhone_number());
				ps.setString(10, ((Seller) user).getProperty());
			}
			
			ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			result = "User insertion failed! \r\nCheck the database connection or check if there is already a client with the same afm and telephone or username!";
			e.printStackTrace();	
		} 
		return result;
	}
	
	public List<Program> getPrograms(){
		
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String query = "SELECT * FROM program;";
		List<Program> programList = new ArrayList<Program>();
		
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while ( resultSet.next() ) {
				String program_name = resultSet.getString("program_name");
				String internet = resultSet.getString("internet");
				String minutes = resultSet.getString("minutes");
				String sms = resultSet.getString("sms");
		        int cost = resultSet.getInt("cost");
		        
		        Program p = new Program(program_name, internet, minutes, sms, cost);
		        programList.add(p);
		      }
		    resultSet.close();
		    statement.close();
		    connection.close();
		    return programList;
		} catch (SQLException e) {
			e.printStackTrace();
			return programList;	
		}
	}
	
	public boolean checkClientExists(String phone_number) {
		
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		boolean result = false;
		String query = "SELECT username, phone_number FROM users WHERE phone_number = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, phone_number);    
			ResultSet resultSet = ps.executeQuery();
			
			if ( resultSet.next() ) {
				result = true;
		    }
			else {
				result = false;
			}
			
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();	
		} 
		return result;
	}
		
	public String pairProgramToClient(PhoneNumber phoneNumber) {
		
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String result = "Client has been paired to a program successfully!";
		PreparedStatement ps;
		
		try {
			String query1 = "INSERT INTO phone_number(phone_number, program_name) VALUES (?, ?);";
			ps= connection.prepareStatement(query1);
			ps.setString(1, phoneNumber.getPhone_number());
			ps.setString(2, phoneNumber.getProgram_name());
	
			ps.executeUpdate();
			ps.close();
			
			String query2 = "INSERT INTO debt(phone_number, debt) VALUES (?, ?);";
			ps= connection.prepareStatement(query2);
			ps.setString(1, phoneNumber.getPhone_number());
			ps.setString(2, "0");
	
			ps.executeUpdate();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			result = "Client-Program pairing has failed!";
			e.printStackTrace();	
		} 
		return result;
		
	}

	public boolean loginValidation(String username, String password) {
		
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		boolean result = false;
		String query = "SELECT username, password FROM users WHERE username = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username); 
			ResultSet resultSet = ps.executeQuery();
			
			if ( resultSet.next() ) {
				String pass = resultSet.getString("password");
				System.out.println(2+pass);
				if(pass.equals(password)) {
					result = true;
				}
				else {
					result = false;
				}
		    }
			else {
				result = false;
			}
			
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();	
		} 
		return result;
	}
	
	public String getClientCategory(String username) {
		
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String result = "";
		String query = "SELECT username, category FROM users WHERE username = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);  
			ResultSet resultSet = ps.executeQuery();
			
			if ( resultSet.next() ) {
				result = resultSet.getString("category");
		    }
			else {
				result = "Failed";
			}
			
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();	
		} 
		return result;
	}
	
	public Bill getClientsBill(String phone_number) {
		
		String username="", afm="", program_name="", monthly_payments="", previous_debt=""; 
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		PreparedStatement ps;
		ResultSet resultSet;
		
		try {
			String query1 = "SELECT username, afm FROM users WHERE phone_number = ?";
			ps = connection.prepareStatement(query1);  //Get username from database/table users.
			ps.setString(1, phone_number);  
			resultSet = ps.executeQuery();
			
			if ( resultSet.next() ) {
				username = resultSet.getString("username");
				afm = resultSet.getString("afm");
		      }
		    resultSet.close();
		    ps.close();
		    
		    String query2 = "SELECT program_name FROM phone_number WHERE phone_number = ?";
		    ps = connection.prepareStatement(query2);  //Get program name from database/table phone_number.
			ps.setString(1, phone_number);  
			resultSet = ps.executeQuery();
			
			if ( resultSet.next() ) {
				program_name = resultSet.getString("program_name");
		      }
		    resultSet.close();
		    ps.close();
		    
		    String query3 = "SELECT cost FROM program WHERE program_name = ?";
		    ps = connection.prepareStatement(query3);  //Get program cost from database/table program.
			ps.setString(1, program_name);  
			resultSet = ps.executeQuery();
			
			if ( resultSet.next() ) {
				monthly_payments = String.valueOf(resultSet.getInt("cost"));
		      }
		    resultSet.close();
		    ps.close();
		    
		    String query4 = "SELECT debt FROM debt WHERE phone_number = ?";
		    ps = connection.prepareStatement(query4);  //Get previous_debt from database/table debt.
			ps.setString(1, phone_number);  
			resultSet = ps.executeQuery();
			
			if ( resultSet.next() ) {
				previous_debt = resultSet.getString("debt");
		      }
		    resultSet.close();
		    ps.close();

		    Bill bill = new Bill(phone_number, username, afm, program_name, monthly_payments, previous_debt);
		    
		    connection.close();
		    return bill;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;	
		}
	}
	
	public boolean checkClientIsPairedToProgram(String phone_number) {
		
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		boolean result = false;
		String query = "SELECT phone_number FROM phone_number WHERE phone_number = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, phone_number);    
			ResultSet resultSet = ps.executeQuery();
			
			if ( resultSet.next() ) {
				result = true;
		    }
			else {
				result = false;
			}
			
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();	
		} 
		return result;
	}
	
	public PhoneNumber getClientsProgram(String phone_number) {
		
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String program_name = "";
		String query = "SELECT program_name FROM phone_number WHERE phone_number = ?";
		PhoneNumber phone_Num = new PhoneNumber();
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, phone_number);  
			ResultSet resultSet = ps.executeQuery();
			
			if ( resultSet.next() ) {
				program_name = resultSet.getString("program_name");
				phone_Num.setPhone_number(phone_number);
				phone_Num.setProgram_name(program_name);	
		    }
			
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();	
		} 
		return phone_Num;
	}
	
	public String changeClientsProgram(String phone_number, String program_name) {
		
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String result = "";
		String query = "UPDATE phone_number SET program_name = ? WHERE phone_number = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, program_name);
			ps.setString(2, phone_number);
			int resultSet = ps.executeUpdate();
			
			if ( resultSet == 1) {
				result = "Client's program has updated successfully.";
		    }
			else {
				result = "Client's program update has failed.";
			}
			
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();	
		} 
		return result;
	}
	
	public String addProgram(Program program) {
		
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String result = "";
		String query = "INSERT INTO program(program_name, internet, minutes, sms, cost) VALUES (?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setString(1, program.getProgram_name());
			ps.setString(2, program.getInternet());
			ps.setString(3, program.getMinutes());
			ps.setString(4, program.getSms());
			ps.setInt(5, program.getCost());
			
			ps.executeUpdate();
			ps.close();
			result += "Program has been added successfully!";
			connection.close();
		} catch (SQLException e) {
			result += "Program insertion failed! \r\nCheck the database connection or check if there is already a program with the same name!";
			e.printStackTrace();	
		} 
		return result;
	}
	
	public Program getProgram(String pn) {
		
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String query = "SELECT program_name, internet, minutes, sms, cost FROM program WHERE program_name = ?";
		Program program = new Program();
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, pn);  
			ResultSet resultSet = ps.executeQuery();
			
			if ( resultSet.next() ) {
				String program_name= resultSet.getString("program_name");
				String internet = resultSet.getString("internet");
				String minutes = resultSet.getString("minutes");
				String sms = resultSet.getString("sms");
				int cost = resultSet.getInt("cost");
				
				program.setProgram_name(program_name);
				program.setInternet(internet);
				program.setMinutes(minutes);
				program.setSms(sms);
				program.setCost(cost);
		    }
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();	
		} 
		return program;
	}

	public String updateProgram(Program p) {
		
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String result = "";
		String query = "UPDATE program SET internet = ?, minutes = ?, sms = ?, cost = ? WHERE program_name = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, p.getInternet());
			ps.setString(2, p.getMinutes());
			ps.setString(3, p.getSms());
			ps.setInt(4, p.getCost());
			ps.setString(5, p.getProgram_name());
			
			int resultSet = ps.executeUpdate();
			
			if ( resultSet == 1) {
				result = "Program has updated successfully.";
		    }
			else {
				result = "Program update has failed.";
			}
			
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();	
		} 
		return result;
		
		
		
		
	}

	public String getPhoneNumber(String username) {
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String result = "";
		String query = "SELECT phone_number FROM users WHERE username = ?;";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);    
			ResultSet resultSet = ps.executeQuery();
			
			if ( resultSet.next() ) {
				result = resultSet.getString("phone_number");
		    }
			else {
				result = "No username found with given phone_number";
			}
			
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();	
		} 
		return result;
	}	

	public String payBill(String phone_number) {
		
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		String result = "Waiting for connection with bank.....Transaction completed successfully!";
		String query = "UPDATE debt SET debt = ? WHERE phone_number = ?;";
		
		try {
			PreparedStatement ps= connection.prepareStatement(query);
			ps.setString(1, "0");
			ps.setString(2, phone_number);
			ps.executeUpdate();
			
			ps.close();
			connection.close();
			
		} catch (SQLException e) {
			result = "Transaction failed! \r\nPlease try again!";
			e.printStackTrace();	
		} 
		return result;
	}

	public List<Call> getCallLogs(String phone_number) {
		String phone_n_sender="", phone_n_recipient="", duration="", date="", start_call_time=""; 
		this.loadDriver(dbDriver);
		Connection connection = this.getConnection();
		List<Call> callList = new ArrayList<Call>();
		PreparedStatement ps;
		ResultSet resultSet;
		
		try {
			String query1 = "SELECT phone_n_sender, phone_n_recipient, duration, date, start_call_time FROM calls WHERE phone_n_sender = ?;";
			ps = connection.prepareStatement(query1);
			ps.setString(1, phone_number);
			resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				phone_n_sender = resultSet.getString("phone_n_sender");
				phone_n_recipient = resultSet.getString("phone_n_recipient");
				duration = resultSet.getString("duration");
				date = resultSet.getString("date");
				start_call_time = resultSet.getString("start_call_time");
				Call call = new Call(phone_n_sender, phone_n_recipient, duration, date, start_call_time);
				callList.add(call);
		    }
			resultSet.close();
		    ps.close();
		    
		    String query2 = "SELECT phone_n_sender, phone_n_recipient, duration, date, start_call_time FROM calls WHERE phone_n_recipient = ?;";
		    ps = connection.prepareStatement(query2);
			ps.setString(1, phone_number);
			resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				phone_n_sender = resultSet.getString("phone_n_sender");
				phone_n_recipient = resultSet.getString("phone_n_recipient");
				duration = resultSet.getString("duration");
				date = resultSet.getString("date");
				start_call_time = resultSet.getString("start_call_time");
				Call call = new Call(phone_n_sender, phone_n_recipient, duration, date, start_call_time);
				callList.add(call);
		    }
			resultSet.close();
		    ps.close();
		    connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return callList;
	}
	
}
