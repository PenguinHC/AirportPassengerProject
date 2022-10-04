package Passenger;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;
import javax.xml.crypto.Data;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

public class Passenger_Ticket {


	public JFrame frame;
	public JTable table;
	public JTextField firstname1;
	public JTextField emailaddress1;
	public JTextField telephone1;
	public JTextField txtweCantWait;
	public JTextField lastname1;

	public long telephoneNo;
	public int bag;
	public Date date;
	public int ticketnum;
	public ArrayList<People> passengers = new ArrayList<People>();

	/**
	 * Launch the application.
	 */

	public boolean checkEnteredDataForName(String fName, String lName)
	{
		if(fName.length() <= 2) {
			return false;
		}

		if(lName.length() <= 2) {
			return false;
		}
		return true;
	}

	public boolean checkEmail(String emailAddress)
	{
		String emailRegex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(emailRegex);
		if(pattern.matcher(emailaddress1.getText()).matches()) {

			return true;
		}

		return false;
	}



	public boolean checkIfDataEntered(String fName, String lName, String emailAddress, long telenum, int bag, Date date)
	{
		boolean pass = false;
		
        if (fName.isBlank() || lName.isBlank() || emailAddress.isBlank() || telenum==0 || bag == 0|| date ==null) {
			pass = false;
		
		}
		else 
		{
			

			ticketnum = generateTicketNum();
			pass = true;
		}
		return pass;
	}

	public int generateTicketNum()
	{
		Random rand = new Random();
		int aa = 10000000 + rand.nextInt(90000000);
		if(aa<0) aa= aa*-1;

		return aa;
	}



	private void ticketpurchase()
	{
		JOptionPane.showMessageDialog(frame, firstname1.getText() + " :" + " Thank You For Your Purchase." + " Your Ticket Number is " + ticketnum ,"Success", JOptionPane.INFORMATION_MESSAGE);
	}


	public static void main(String[] args) {
		


		ArrayList<String> seatdata = new ArrayList<String>();

		seatdata.add("1A");
		seatdata.add("6A");
//		seatdata.add("11A");


		ArrayList<String> returnseatdata = new ArrayList<String>();

		returnseatdata.add("1A");
		returnseatdata.add("6A");
//		returnseatdata.add("11A");


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Passenger_Ticket window = new Passenger_Ticket(seatdata,returnseatdata);
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Passenger_Ticket(ArrayList<String> seatdata,ArrayList<String>returnseatdata) {
		if(seatdata.size() > 0 && returnseatdata.size() > 0) {
			initialize(seatdata,returnseatdata);	
		}
		
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize(ArrayList<String> seatdata,ArrayList<String>returnseatdata) {
		//Before The User Can Enter Their Details, A Welcome Message Appears  
		frame = new JFrame();
		frame.setResizable(false);
		String myMSG = "Welcome To The Passenger Booking System";
		ImageIcon welcomeImage = new ImageIcon("images.png");
		JOptionPane.showMessageDialog(null, myMSG, "Dream a little dream", 0, welcomeImage);

		frame.setTitle("Welcome to Brunel City Aiport");
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		ImageIcon image = new ImageIcon("images.jpg");
		frame.setIconImage(image.getImage());
		frame.setBounds(500, 500, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(6, 62, 771, 12);
		frame.getContentPane().add(separator_1);


		// The Following Combo Box Allow The User To Check In Their Number Of Bags
		JComboBox bag1 = new JComboBox();
		bag1.setFont(new Font("PT Sans", Font.PLAIN, 18));
		bag1.setModel(new DefaultComboBoxModel(new String[] {"Luggage", "0", "1", "2", "3", "4", "5","6","7","8","9","10"}));
		bag1.setBounds(91, 365, 141, 63);
		frame.getContentPane().add(bag1);

		JLabel numberOfBags = new JLabel("Bags");
		numberOfBags.setFont(new Font("PT Sans", Font.PLAIN, 26));
		numberOfBags.setBounds(16, 369, 63, 43);
		frame.getContentPane().add(numberOfBags);

		JLabel departuredSeat = new JLabel("Seat Departing");
		departuredSeat.setFont(new Font("PT Sans", Font.PLAIN, 26));
		departuredSeat.setBounds(277, 360, 188, 61);
		frame.getContentPane().add(departuredSeat);

		JLabel returnSeats = new JLabel("Seat Arriving");
		returnSeats.setFont(new Font("PT Sans", Font.PLAIN, 26));
		returnSeats.setBounds(277, 409, 188, 61);
		frame.getContentPane().add(returnSeats);

		JComboBox departseat1 = new JComboBox();
		departseat1.setFont(new Font("PT Sans", Font.PLAIN, 18));
		departseat1.setModel(new DefaultComboBoxModel());
		for(int i = 0; i<seatdata.size(); i++)
			departseat1.addItem(seatdata.get(i));

		System.out.println(seatdata.size());
		departseat1.setBounds(475, 355, 177, 57);
		frame.getContentPane().add(departseat1);

		JComboBox returnseat1 = new JComboBox();
		returnseat1.setFont(new Font("PT Sans", Font.PLAIN, 18));
	//	returnseat1.setModel(new DefaultComboBoxModel(new String[] {"Choose Seat", "1A", "1B", "1C"}));
		for(int i = 0; i<returnseatdata.size(); i++)
			returnseat1.addItem(returnseatdata.get(i));
		returnseat1.setBounds(475, 427, 177, 43);
		frame.getContentPane().add(returnseat1);

		Border border = BorderFactory.createTitledBorder("Passport Details");

		//Produces A Image Of The Brunel-Logo
		ImageIcon image1 = new ImageIcon("images.png");
		JLabel brunelImage = new JLabel();
		brunelImage.setIcon(image1);
		brunelImage.setBounds(703, 78, 274, 245);
		frame.getContentPane().add(brunelImage);

		//Title Of Booking Form
		JLabel lblNewLabel = new JLabel("Passenger Details");
		lblNewLabel.setBounds(211, 6, 327, 57);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("PT Sans", Font.PLAIN, 40));

		JLabel lblNewLabel_5 = new JLabel("* AS ENTERED ON THE PASSPORT");
		lblNewLabel_5.setFont(new Font("PT Sans", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(471, 170, 207, 16);
		frame.getContentPane().add(lblNewLabel_5);
		lblNewLabel_5.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_5.setForeground(Color.RED);

		//Allows The User To Enter Their First Name
		JLabel firstName = new JLabel("First Name");
		firstName.setBounds(6, 97, 120, 35);
		frame.getContentPane().add(firstName);
		firstName.setFont(new Font("PT Sans", Font.PLAIN, 26));

		//Allows The User To Enter Their Last Name
		JLabel lastName = new JLabel("Last Name");
		lastName.setBounds(6, 144, 130, 32);
		frame.getContentPane().add(lastName);
		lastName.setFont(new Font("PT Sans", Font.PLAIN, 26));

		//Allows The User To Enter Their Email Address
		JLabel emailAddress = new JLabel("Email Address");
		emailAddress.setBounds(6, 186, 177, 32);
		frame.getContentPane().add(emailAddress);
		emailAddress.setFont(new Font("PT Sans", Font.PLAIN, 26));

		//Allows The User To Enter Their Telephone  Number
		JLabel telephone = new JLabel("Telephone");
		telephone.setFont(new Font("PT Sans", Font.PLAIN, 26));
		telephone.setBounds(6, 278, 163, 32);
		frame.getContentPane().add(telephone);


		JLabel dateOfBirth = new JLabel("Date Of Birth");
		dateOfBirth.setBounds(6, 230, 163, 32);
		frame.getContentPane().add(dateOfBirth);
		dateOfBirth.setFont(new Font("PT Sans", Font.PLAIN, 26));

		firstname1 = new JTextField();
		firstname1.setBounds(191, 86, 274, 43);
		frame.getContentPane().add(firstname1);
		firstname1.setColumns(10);


		emailaddress1 = new JTextField();
		emailaddress1.setColumns(10);
		emailaddress1.setBounds(191, 183, 274, 43);
		frame.getContentPane().add(emailaddress1);

		//Has been used to organise the booking form to make it more presentable 
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(6, 350, 687, 12);
		frame.getContentPane().add(separator);

		telephone1 = new JTextField();
		telephone1.setColumns(10);
		telephone1.setBounds(191, 280, 274, 43);
		frame.getContentPane().add(telephone1);

		//image of a airplane seat
		ImageIcon image2 = new ImageIcon("newseat.jpeg");
		JLabel seat = new JLabel();
		seat.setIcon(image2);
		seat.setBounds(6, 446, 267, 226);
		frame.getContentPane().add(seat);

		txtweCantWait = new JTextField();
		txtweCantWait.setForeground(Color.RED);
		txtweCantWait.setText("\"We can't wait to welcome you\"");
		txtweCantWait.setBounds(285, 551, 207, 26);
		frame.getContentPane().add(txtweCantWait);
		txtweCantWait.setColumns(10);

		//Allows The User To Enter Their DOB
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setMaxSelectableDate(new Date());
		dateChooser.setBounds(191, 230, 274, 43);
		frame.getContentPane().add(dateChooser);

		// The 'Enter' Acts as a method for verification to check all fields are completed and correct resulting in a Ticket Number
		//The Following Code Deals with Error Handling If Sections Are Missing

		JButton Enter = new JButton("Enter");
		Enter.setFont(new Font("PT Sans", Font.PLAIN, 22));
		Enter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println(firstname1.getText());
				JFrame newFrame = new JFrame("JOptionPane showMessageDialog example");

				String emailRegex = "^(.+)@(.+)$"; 
				Pattern pattern = Pattern.compile(emailRegex);

				checkEnteredDataForName(firstname1.getText(), lastname1.getText());

				if(firstname1.getText().length() <= 2) {
					JOptionPane.showMessageDialog(newFrame, "First Name Must be longer than two characters", "Warning", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(lastname1.getText().length() <= 2) {
					JOptionPane.showMessageDialog(newFrame, "Last Name Must be longer than two characters", "Warning", JOptionPane.ERROR_MESSAGE);
					return;
				}

				checkEmail(emailaddress1.getText());

				if(!pattern.matcher(emailaddress1.getText()).matches()) {
					JOptionPane.showMessageDialog(newFrame, "PLease enter email correctly", "Warning", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String teleNum;
				teleNum = telephone1.getText();
				try {
					telephoneNo = Long.parseLong(teleNum);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(newFrame, "Number is invalid please enter correct number", "Warning", JOptionPane.ERROR_MESSAGE);
				}

				bag = bag1.getSelectedIndex();

				date = dateChooser.getDate();

					

				//Error Handling
				boolean	valid = checkIfDataEntered(firstname1.getText(),lastname1.getText(),emailaddress1.getText(),telephoneNo,bag,date);
				if(!valid)	{		

					JOptionPane.showMessageDialog(newFrame, "PLease Complete All Required Fields", "Warning", JOptionPane.ERROR_MESSAGE);
				}



				if(valid ==true)
				{
					ticketpurchase();
				}



				int seat = departseat1.getSelectedIndex();
				boolean found = false;

				int choosendeparture = 0;
				int choosenreturn = 0; 

			

				if(seatdata.size()>0 && returnseatdata.size() > 0 && valid) {
					People passenger = new People(firstname1.getText(),lastname1.getText(),emailaddress1.getText(),telephone1.getText(),bag,date,ticketnum,departseat1.getSelectedItem().toString(),returnseat1.getSelectedItem().toString());
					passengers.add(passenger);
					
					passenger.file();
					
					try {seatdata.remove(choosendeparture);
					//This will call the system again for another passenger
					returnseatdata.remove(choosenreturn);
					
					frame.setVisible(false);
					Passenger_Ticket window = new Passenger_Ticket(seatdata,returnseatdata);
					try {
						window.frame.setVisible(true);
					} catch (Exception E) {
						for(People i:passengers) {
							i.printAll();
						}
						System.exit(0);
					}


					} catch (Exception E) {
						E.printStackTrace();


					}

				} 


			}
			


			});
		Enter.setBounds(810, 565, 131, 43);
		frame.getContentPane().add(Enter);
		lastname1 = new JTextField();
		lastname1.setColumns(10);
		lastname1.setBounds(191, 133, 274, 43);
		frame.getContentPane().add(lastname1);

		// Will "Reset the following text fields"
		JButton reset = new JButton("Reset");
		reset.setFont(new Font("PT Sans", Font.PLAIN, 22));
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstname1.setText(null);
				lastname1.setText(null);
				emailaddress1.setText(null);
				telephone1.setText(null);


			}
		});
		reset.setBounds(628, 565, 149, 43);
		frame.getContentPane().add(reset);

	}
}




