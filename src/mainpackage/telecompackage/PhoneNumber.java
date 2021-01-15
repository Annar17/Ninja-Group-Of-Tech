package mainpackage.telecompackage;

public class PhoneNumber {

	private String phone_number;
    private String program_name;
    
    public PhoneNumber(){   //Default values
    	this.phone_number = "xxx-xxx-xxxx";
    	this.program_name= "Default Program Name";
    }
    
    public PhoneNumber(String phoneNumber, String programName) {
        this.phone_number = phoneNumber;
        this.program_name = programName;
    }

    //Getters
    public String getPhone_number() { return phone_number; }
    
    public String getProgram_name() { return program_name; }

    //Setters
    public void setPhone_number(String phoneNumber) { this.phone_number = phoneNumber; }

    public void setProgram_name(String programName) { this.program_name = programName; }
}
