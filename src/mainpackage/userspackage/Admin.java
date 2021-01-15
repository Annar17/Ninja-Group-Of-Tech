package mainpackage.userspackage;

import mainpackage.telecompackage.Program;

public class Admin extends Users {

	 private final String afm;
	 private String phone_number, property;

	 public Admin(String afm){ //constructor
		 super("Admin");
		 this.afm = afm;
		 this.phone_number = "xxx-xxx-xxxx";
		 this.property = "Employee";
	 }
	 
	 public Admin(String afm, String phoneNumber){ //constructor
			super("Admin");
			this.afm = afm; 
			this.phone_number = phoneNumber;
			this.property = "Employee";
		}

	 //Getters
	 public String getAfm() {return this.afm;}
	 
	 public String getPhone_number(){ return this.phone_number; }
	 
	 public String getProperty() { return this.property; }
  
	 //Setters
	 public void setPhoneNumber(String phoneNumber) { this.phone_number = phoneNumber;}
	 
	 public void setProperty( String property) { this.property = property; }

	 public void createUser(String username, String name, String surname, String password, String address, String email, String category) {
		 System.out.println("Users before:" + usersCounter);
		 if (category == "seller") { 
			 Seller s = new Seller("768594325");
			 s.setUsername(username); s.setName(name); s.setSurname(surname); s.setPassword(password);
			 s.setAddress(address); s.setEmail(email); s.setCategory(category);
			 System.out.println("Username: "+s.getUsername()+ "\nName: "+s.getName()+ "\nSurname: "+s.getSurname()+
					 "\nPassword: "+s.getPassword()+ "\nAddress: "+s.getAddress()+ "\nEmail: "+ s.getEmail()+ "\nCategory: " + s.getCategory());
		 }  
		 else if (category == "client") { 
	    	 Client c = new Client("574836524");
	    	 c.setUsername(username); c.setName(name); c.setSurname(surname); c.setPassword(password);
			 c.setAddress(address); c.setEmail(email); c.setCategory(category);
			 System.out.println("Username: "+c.getUsername()+ "\nName: "+c.getName()+ "\nSurname: "+c.getSurname()+
					 "\nPassword: "+c.getPassword()+ "\nAddress: "+c.getAddress()+ "\nEmail: "+ c.getEmail()+ "\nCategory: " + c.getCategory());
	     }
	     else if (category == "admin") { 
	    	 Admin a = new Admin("768574531");
	    	 a.setUsername(username); a.setName(name); a.setSurname(surname); a.setPassword(password);
			 a.setAddress(address); a.setEmail(email); a.setCategory(category);
			 System.out.println("Username: "+a.getUsername()+ "\nName: "+a.getName()+ "\nSurname: "+a.getSurname()+
					 "\nPassword: "+a.getPassword()+ "\nAddress: "+a.getAddress()+ "\nEmail: "+ a.getEmail()+ "\nCategory: " + a.getCategory());
	     }
	     System.out.println("Users now: " + usersCounter);
	  } 

	 public void updateUser(String afm, String category)
	 {
		 if (category == null) {System.out.println("User updated successfully");}
	     else if (category == "seller") {System.out.println("Seller updated successfully");}
	     else if (category == "client") {System.out.println("Client updated successfully");}
	     else if (category == "admin") {System.out.println("Admin updated successfully");}
	 }
	 
	 public void deleteUser(String afm, String category)
	 {
		 System.out.println("Users before: " + usersCounter);
		 usersCounter--;
		 System.out.println("Users now: " + usersCounter);
		 //Search for User with the afm given and then delete him.
		 if (category == null) {System.out.println("User deleted successfully");}
	     else if (category == "seller") {System.out.println("Seller deleted successfully");}
	     else if (category == "client") {System.out.println("Client deleted successfully");}
	     else if (category == "admin") {System.out.println("Admin deleted successfully");}
	 }

	 public void searchUser(String afm)
	 {
		 //Check if user with the given afm exists and if so then print the message.
		 System.out.println("Details of user with AFM: "+afm+ ":...");
	 }

	 //proboli stoixeiwn twn xrhstwn kai to xrostoumeno poso
	 public void viewUsers()
	 {
		System.out.println("List of users and the amount they owe!"); 
	 }

	 public void createNewProgram(String programName, String internet, String minutes, String sms, int cost){
		 System.out.println("New program setted");
		 Program p = new Program();
		 p.setProgram_name(programName);
		 p.setInternet(internet);
		 p.setMinutes(minutes);
		 p.setSms(sms);
		 p.setCost(cost);
	     System.out.println("Success!\nProgram name: " + p.getProgram_name() + 
	    		 "\nInternet: " + p.getInternet() + 
	    		 "\nMinutes: " + p.getMinutes() +
	    		 "\nSMS: " + p.getSms() +
	    		 "\nCost: " + p.getCost());
	    }
	    
}
