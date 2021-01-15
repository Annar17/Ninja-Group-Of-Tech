package mainpackage.userspackage;

public class Seller extends Users{

	private final String afm;
	private String phone_number, property;
	
	public Seller(String afm){ //constructor
		super("Seller");
		this.afm = afm;
		this.phone_number = "xxx-xxx-xxxx";
		this.property = "Employee";
	}
	
	public Seller(String afm, String phoneNumber){ //constructor
		super("Seller");
		this.afm = afm; 
		this.phone_number = phoneNumber;
		this.property = "Employee";
	}
	
	public Seller(String username, String name, String surname, String password, String address, String email, String afm, String phoneNumber, String property) {
    	super(username, name, surname, password, address, email, "Seller");
    	this.afm = afm;
    	this.phone_number = phoneNumber;
    	this.property = "Employee";
    }
	
	// Getters
	public String getAfm() { return this.afm; }
	
	public String getPhone_number() { return this.phone_number; }
	
	public String getProperty() { return this.property; }
	
	// Setters, NO SETTER for AFM since AFM is final.
	public void setPhoneNumber(String phoneNumber) { this.phone_number = phoneNumber; }
	
	public void setProperty( String property) { this.property = property; }
		
	//METHODS
	public void registerNewClient() { //���������� ���� ������
		//����������� Client ����������
		System.out.println("You have registered a new Client.");
	}
	
	public void clientAccountBill() { //������ ���������� �������
		System.out.println("This is the Client's Bill.");
	}
	
	public void changeClientDetails() { //������ ���������(���������, email, ��������, ��������, ���������) ������
		System.out.println("You can now start changing Client's details.");
	}
	
	public void changeClientAddress() { //������ ���������� ������
		System.out.println("Client's address changed.");
	}
	
	public void changeClientEmail() { //������ email ������
		System.out.println("Client's email changed.");
	}
	
	public void changeClientPhoneNumber() { //������ ��������� ������
		System.out.println("Client's phone number changed.");
	}
	
	public void changeClientProperty() { //������ �������� ������ (Student, Unemployed, Elderly, Other)
		System.out.println("Client's property changed.");
	}
	
	public void changeClientProgram() { //������ ������������ ������
		System.out.println("Client's program changed.");
	}
	
	
}
