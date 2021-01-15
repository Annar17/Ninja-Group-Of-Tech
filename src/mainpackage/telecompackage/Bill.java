package mainpackage.telecompackage;

import java.util.Calendar;

public class Bill {

	private String phone_number, current_month, username, afm, program_name, monthly_payments, previous_debt, total_payments;
	
	public Bill(String phone_number, String username, String afm, String program_name, String monthly_payments, String previous_debt) {  //constructor
		this.phone_number = phone_number;
		this.current_month = this.getMonth();
		this.username = username;
		this.afm = afm;
		this.program_name = program_name;
		this.monthly_payments = monthly_payments;
		this.previous_debt = previous_debt;
		this.total_payments = String.valueOf(Integer.valueOf(monthly_payments)+Integer.valueOf(previous_debt));
	}
	
	
	// style="border: 0;"
	public String getPhone_number() {
		return phone_number;
	}
	public String getCurrent_month() {
		return current_month;
	}
	public String getUsername() {
		return username;
	}
	public String getAfm() {
		return afm;
	}
	public String getProgram_name() {
		return program_name;
	}
	public String getMonthly_payments() {
		return monthly_payments;
	}
	public String getPrevious_debt() {
		return previous_debt;
	}
	public String getTotal_payments() {
		return total_payments;
	}


	private String getMonth() {  //Finds the name of the current month.    
        String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};

        Calendar cal = Calendar.getInstance();
        String month = monthName[cal.get(Calendar.MONTH)];
        return month;
    }
}