package mainpackage.userspackage;

public class Users {

	private String username, name, surname, password, address, email, category;
    static int usersCounter;

    public Users(String username, String name, String surname, String password, String address, String email, String category) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.address = address;
        this.email = email;
        this.category = category;
        usersCounter++;   //Αύξηση κατα 1 του αριθμού των Users.
    }

    public Users(String category) { //Called when creating client, seller, admin objects.
    	usersCounter++;
    	this.category = category;
    }; 
    
    public Users() {
    	usersCounter++;   //Αύξηση κατα 1 του αριθμού των Users.
    	System.out.println("User has been created successfully!");
    }

    //Getters
    public String getUsername() { return username; }

    public String getName() { return name; }

    public String getSurname() { return surname; }

    public String getPassword() { return password; }

    public String getAddress() { return address; }

    public String getEmail() { return email; }

    public String getCategory() { return category; }

    public int getUsersCounter() { return usersCounter; }

    //Setters
    public void setUsername(String username) { this.username = username; }

    public void setName(String name) { this.name = name; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setPassword(String password) { this.password = password; }

    public void setAddress(String address) { this.address = address; }

    public void setEmail(String email) { this.email = email; }

    public void setCategory(String category) { this.category = category; }

    //Login
    public void Login() { System.out.println("You have logged in successfully!"); }

    //Register
    public void Register() { System.out.println("Your registration is completed successfully!"); }

    //Logout
    public void Logout() { System.out.print("You have logged out.Byee!"); }
    
    //Μεθοδος επικυρωσης σωστης μορφης του email
    public boolean isEmailValid(String em) {
    	String pattern = "^[A-Za-z][A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}";
    	try { return em.matches(pattern);}
    	catch (NullPointerException e) { return false;}
    }
	
    public static boolean isAFMValid(String afm) {  //Για να ειναι φανερο σε ολες τις κλασεις
		String pattern = "\\d{9}"; 
		try { return afm.matches(pattern);} 
		catch (NullPointerException e) { return false; }
	}
    
    public static boolean isTelValid(String pN) {
		String pattern = "69(\\d{8})";
		try { return pN.matches(pattern);} 
		catch (NullPointerException e) { return false; }
	}
}

