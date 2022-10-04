package Passenger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;


public class People {
	
	
	public String fName;
	public String lName;
	
	public String emailaddress1;
	public String telephone1;
	
	public int bag;
	public Date date;
	public int ticketnum;
	public String seatdata;
	public String returnseatdata;
	
	public People(String fName, String lName, String emailaddress1, String telephone1, int bag, Date date, int ticketnum,
			String seatdata, String returnseatdata) {
		super();
		ArrayList<String> passengers = new ArrayList<String>();
		this.fName = fName;
		this.lName = lName;
		this.emailaddress1 = emailaddress1;
		this.telephone1 = telephone1;
		this.bag = bag;
		this.date = date;
		this.ticketnum = ticketnum;
		this.seatdata = seatdata;
		this.returnseatdata = returnseatdata;
		String s = String.valueOf(bag);
		String output = date.toString();  
		String ticket = String.valueOf(ticketnum);

		passengers.add(fName); passengers.add(lName); passengers.add(emailaddress1); passengers.add(telephone1);  passengers.add(s); passengers.add(output);
		passengers.add(ticket);
		try {
			FileWriter file = new FileWriter("sample.csv");
			PrintWriter write = new PrintWriter(file);
			for(String str: passengers) {
				write.println(str);
			}
		}
		catch(IOException exe) {
			System.out.println("Cant create a file");
		}
	}
	
	public void printAll() {
		
		
		System.out.println("First Name: "+fName);
		System.out.println("Last Name: "+lName);
		System.out.println("Email Address: "+emailaddress1);
		System.out.println("Telephone: "+telephone1);
		System.out.println("Number Of Bags:"+bag);
		System.out.println("Ticket Number: "+ ticketnum);
		System.out.println("Departure Seat: " + seatdata);
		System.out.println("Return Seat: "+ returnseatdata);
		
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmailaddress1() {
		return emailaddress1;
	}

	public void setEmailaddress1(String emailaddress1) {
		this.emailaddress1 = emailaddress1;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public int getBag() {
		return bag;
	}

	public void setBag(int bag) {
		this.bag = bag;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTicketnum() {
		return ticketnum;
	}

	public void setTicketnum(int ticketnum) {
		this.ticketnum = ticketnum;
	}

	public String getSeatdata() {
		return seatdata;
	}

	public void setSeatdata(String seatdata) {
		this.seatdata = seatdata;
	}

	public String getReturnseatdata() {
		return returnseatdata;
	}

	public void setReturnseatdata(String returnseatdata) {
		this.returnseatdata = returnseatdata;
	}
	public void file() {
		String s = String.valueOf(bag);
		String output = date.toString();  
		String ticket = String.valueOf(ticketnum);
		 ArrayList<String> passengers = new ArrayList<String>();
		 passengers.add(this.getfName()); passengers.add(this.getlName()); passengers.add(this.getEmailaddress1()); passengers.add(this.getTelephone1());  passengers.add(s); passengers.add(output);
		passengers.add(ticket);
		try {
			FileWriter file = new FileWriter("sample.csv");
			PrintWriter write = new PrintWriter(file);
			for(String str: passengers) {
				write.println(str);
			}
			write.close();
		}
		catch(IOException exe) {
			System.out.println("Cant create a file");
		}
	}
	

	
}
