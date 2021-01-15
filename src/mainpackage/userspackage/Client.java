package mainpackage.userspackage;

public class Client extends Users{

	private final String afm;
    private String phone_number, property;

    public Client(String afm) {
    	super("Client");
		this.afm = afm;
		//Default values
		this.setUsername("username");
		this.setName("name");
		this.setSurname("surname");
		this.setPassword("123");
		this.setAddress("address");
		this.setEmail("email@gmail.com");
        this.phone_number = "xxx-xxx-xxxx";
        this.property = "-";
    }

    public Client(String afm, String phoneNumber, String property) {
    	super("Client");
    	this.afm = afm;
    	this.phone_number = phoneNumber;
        this.property = property;
        //Default values
        this.setUsername("username");
		this.setName("name");
		this.setSurname("surname");
		this.setPassword("123");
		this.setAddress("address");
		this.setEmail("email@gmail.com");
    }

    public Client(String username, String name, String surname, String password, String address, String email, String afm, String phoneNumber, String property) {
    	super(username, name, surname, password, address, email, "Client");
    	this.afm = afm;
    	this.phone_number = phoneNumber;
    	this.property = property;
    }
    
    //Getters
    public String getAfm() { return this.afm; }

    public String getPhone_number() { return this.phone_number; }

    public String getProperty() { return this.property;}

    //Setters

    public void setPhoneNumber(String phoneNumber) { this.phone_number = phoneNumber; }

    public void setProperty( String property) { this.property = property; }

    //Show bill
    public void ShowBill(String phoneNumber) { System.out.println("The bill for phone number: " + phoneNumber + " is: "); }

    //Show call log
    public void CallLog(String phoneNumber) { System.out.println("The call log for phone number: " + phoneNumber+ " is: "); }

    //Pay bill
    public void PayBill(String phoneNumber) { System.out.println("The bill for phone number: " + phoneNumber + " has been paid!"); }

    //Request plan change
    public void PlanChange(String afm, String phoneNumber, String property) {
        System.out.println("Customer with:\n " + "AFM: " + afm + "\n Phone number: " + phoneNumber + "\n Property: " + property + "\nrequested a change of plan."); }

    //Change password
    public void PasswordChange() { System.out.println("Changing password...Completed!");};
}

