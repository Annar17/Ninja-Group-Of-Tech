package mainpackage.telecompackage;

public class Program {

	private String program_name, internet, minutes, sms;
	private int cost;

    public Program() {
        //Default values
        this.program_name = "Default Program Name";
        this.internet = "-";
        this.minutes = "-";
        this.sms = "-";
        this.cost = 0;
    }

    public Program(String programName, String internet, String minutes, String sms, int cost) {
    	 this.program_name = programName;
         this.internet = internet;
         this.minutes = minutes;
         this.sms = sms;
         this.cost = cost;
    }

    //Getters
    public String getProgram_name() { return program_name; }

    public String getInternet() { return internet; }
    
    public String getMinutes() { return minutes; }
    
    public String getSms() { return sms; }

    public int getCost() { return cost; }

    //Setters
    public void setProgram_name(String programName) { this.program_name = programName; }

	public void setInternet(String internet) { this.internet = internet; }

	public void setMinutes(String minutes) { this.minutes = minutes; }

	public void setSms(String sms) { this.sms = sms; }

	public void setCost(int cost) { this.cost = cost; }

    //View current program
    public void ViewProgram(){
        System.out.println("Current program: \nProgram Name: " + this.getProgram_name() + 
        			"\nInternet: " + this.getInternet() + 
        			"\nMinutes: " + this.getInternet() + 
        			"\nSMS: " + this.getMinutes() +
        			"\nCost: " + this.getCost());
    }
}

