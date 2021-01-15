package mainpackage.telecompackage;

public class Call {

	private String phone_n_sender, phone_n_recipient, duration, date, start_call_time;
	
	public Call() {   //Default values
    	this.phone_n_sender = "xxx-xxx-xxxx";
        this.phone_n_recipient = "yyy-yyy-yyyy";
        this.duration = "-";
        this.date = "year-month-day";
        this.start_call_time = "-";
    }

    public Call(String phoneNumberSender, String phoneNumberRecipient, String duration, String date, String startCallTime) {
    	this.phone_n_sender = phoneNumberSender;
        this.phone_n_recipient = phoneNumberRecipient;
        this.duration = duration;
        this.date = date;
        this.start_call_time = startCallTime;
    }   
    
    //Getters
    public String getPhone_n_sender() { return this.phone_n_sender; }

    public String getPhone_n_recipients() { return this.phone_n_recipient; }

    public String getDuration() { return this.duration;  }

    public String getDate() { return this.date; }

    public String getStart_call_time() { return this.start_call_time; }

    //Setters
    public void setPhone_n_sender(String phoneNumberSender) { this.phone_n_sender = phoneNumberSender; }

    public void setPhone_n_recipients(String phoneNumberRecipient) { this.phone_n_recipient = phoneNumberRecipient; }

    public void setDuration(String duration) { this.duration = duration; }

    public void setDate(String date) { this.date = date; }

    public void setStart_call_time(String start_call_time) { this.start_call_time = start_call_time; }

    public void viewCallDetails() {
        System.out.println("Call details: \n Sender: " + this.phone_n_sender + 
        		"\n Recipient: " + this.phone_n_recipient + "\n Duration: " + 
        		this.duration + "\n Date: " + this.date + "\n Start call time: " + this.start_call_time);
    }
}

