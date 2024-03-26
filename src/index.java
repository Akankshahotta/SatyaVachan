import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.sql.*;

//KEYS to connect with the database
class keys{
	public static String url = "jdbc:mysql://localhost:3306/satyavachan";
	public static String uname = "root";
	public static String pass = "UMESH@2001";
}

//citizen class
class citizen{
	int adCard;
	String name;
	String Email;
	String Pass;
}

//department class
class dept{
	int regID;
	int adCard;
	String name;
	String pass;
	int phno;
	String email;
	int pincode;
}


//index page of the application
public class index extends JFrame {

	index(){
		
		//title
		setTitle("SATYAVACHAN");
		citizen c1 = new citizen();
		
	//NAVBAR Panel
		
		JPanel navBar = new JPanel();
		navBar.setBounds(0,0,1650,80);
		navBar.setBackground(Color.BLACK);
		getContentPane().setBackground(Color.WHITE);
		
		//NAV Buttons panel
		JPanel navButtons = new JPanel();
		navButtons.setBounds(1280,10,800,80);
		navButtons.setBackground(Color.BLACK);
		
		//logo panel
		JPanel logoPanel = new JPanel();
		logoPanel.setBounds(20,20,200,60);
		BufferedImage img;
		
		//adding of image from the location setting up the image size for the logo
		try {
			JLabel pic = new JLabel();
			pic.setBounds(20,20,35,35);
			img = ImageIO.read(new File(Constatnts.Main_logo));
			Image Imag = img.getScaledInstance(pic.getWidth(), pic.getHeight(),pic.CENTER);
			ImageIcon logoIcon = new ImageIcon(Imag);
			pic.setIcon(logoIcon);
			logoPanel.add(pic);
			logoPanel.setBackground(Color.BLACK);
			navBar.add(logoPanel);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		//setting of title label in navbar
		JLabel title = new JLabel("SATYAVACHAN");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Poppins", Font.CENTER_BASELINE,26));
		title.setBounds(720,26,220,30);
		navBar.add(title);
		
		//Home button
		JButton home = new JButton("Home");
		home.setFont(new Font("Poppins", Font.PLAIN, 16));
		home.setForeground(Color.LIGHT_GRAY);
		home.setBorder(null);
		home.setContentAreaFilled(false);
		home.setBounds(20,10,80,40);
		
		//Records Button
		JButton Records = new JButton("Records");
		Records.setFont(new Font("Poppins", Font.PLAIN, 16));
		Records.setForeground(Color.LIGHT_GRAY);
		Records.setBorder(null);
		Records.setContentAreaFilled(false);
		Records.setBounds(80,10,100,40);
		
		//EmergencyNumber Button
		JButton EmergencyNumber = new JButton("Emergency Number");
		EmergencyNumber.setFont(new Font("Poppins", Font.PLAIN, 16));
		EmergencyNumber.setForeground(Color.LIGHT_GRAY);
		EmergencyNumber.setBorder(null);
		EmergencyNumber.setBounds(180,10,160,40);
		
		//setting up nav button
		navButtons.add(EmergencyNumber);
		navButtons.add(Records);
		navButtons.add(home);
		
		navBar.add(navButtons);
		
		navBar.setLayout(null);
		navButtons.setLayout(null);
		add(logoPanel);
		add(navBar);
		
		
		//Function for home button hovering
		home.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
		        home.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        home.setForeground(Color.LIGHT_GRAY);
		    }
		});
		
		
		//Function for Record button hovering
		Records.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
		        Records.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	Records.setForeground(Color.LIGHT_GRAY);
		    }
		});
		
		//Function for EmergencyNumber button hovering
		EmergencyNumber.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				EmergencyNumber.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	EmergencyNumber.setForeground(Color.LIGHT_GRAY);
		    }
		});
		 
	//NAVBAR ENDS
		
		
		
		
	//SignIn Panel
		JPanel SignIn = new JPanel();
		SignIn.setLayout(null);
		SignIn.setBounds(425,150,800,600);
		SignIn.setBackground(Color.BLACK);
		
		//signIn Title Label
		JLabel signInLabel = new JLabel("SIGN IN");
		signInLabel.setFont(new Font("Poppins",Font.PLAIN, 28));
		signInLabel.setForeground(Color.WHITE);
		signInLabel.setBounds(345,20,250,40);
		SignIn.add(signInLabel);
		
		
		//setting up label inside the signin pannel
		
		//adhar card label
		JLabel label1 = new JLabel("ENTER YOUR ADHAR CARD NO");
		label1.setFont(new Font("Poppins",Font.PLAIN, 18));
		label1.setForeground(Color.WHITE);
		label1.setBounds(245,120,300,40);
		SignIn.add(label1);
		
		//adhar card text field
		JTextField tf = new JTextField();
		tf.setBounds(245,160,300,40);
		SignIn.add(tf);
		
		//password label
		JLabel label2 = new JLabel("ENTER YOUR PASSWORD  ");
		label2.setFont(new Font("Poppins",Font.PLAIN, 18));
		label2.setForeground(Color.WHITE);
		label2.setBounds(245,220,300,40);
		SignIn.add(label2);
		
		//password textfield
		JPasswordField tf2 = new JPasswordField();
		tf2.setBounds(245,260,300,40);
		SignIn.add(tf2);
		
		//register button
		JButton register = new JButton("CLICK HERE TO REGISTER");
		register.setFont(new Font("Poppins",Font.PLAIN, 14));
		register.setForeground(Color.LIGHT_GRAY);
		register.setBounds(245,320,300,40);
		register.setBorder(null);
		register.setContentAreaFilled(false);
		
		//register button hovering function
		register.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				register.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	register.setForeground(Color.LIGHT_GRAY);
		    }
		});
		SignIn.add(register);
		
		//citizen button (radio button)
		JRadioButton citizen = new JRadioButton("CITIZEN");
		citizen.setFont(new Font("Poppins", Font.PLAIN, 14));
		citizen.setBounds(245,370,200,40);
		citizen.setForeground(Color.WHITE);
		SignIn.add(citizen);
		
		//office button (radio button)
		JRadioButton officer = new JRadioButton("OFFICER");
		officer.setBounds(460,370,200,40);
		officer.setFont(new Font("Poppins", Font.PLAIN, 14));
		officer.setForeground(Color.WHITE);
		SignIn.add(officer);
		
		
		//adding citizen and officer button to a button group
		ButtonGroup bg = new ButtonGroup();
		bg.add(citizen);
		bg.add(officer);
		
		//sign in button 
		JButton signInButton = new JButton("Sign In");
		signInButton.setBounds(335,420,120,50);
		SignIn.add(signInButton);
		add(SignIn);
		
	//Sign in panel ends
		
	//Register Panel
		
		JPanel Register = new JPanel();
		Register.setLayout(null);
		Register.setBounds(425,150,800,600);
		Register.setBackground(Color.BLACK);
		
		//Register label as subtitle
		JLabel signUpLabel = new JLabel("REGISTER");
		signUpLabel.setFont(new Font("Poppins",Font.PLAIN, 28));
		signUpLabel.setForeground(Color.WHITE);
		signUpLabel.setBounds(345,20,250,40);
		Register.add(signUpLabel);
		
		//Name label
		JLabel Rlabel1 = new JLabel("ENTER YOUR NAME  ");
		Rlabel1.setFont(new Font("Poppins",Font.PLAIN, 12));
		Rlabel1.setForeground(Color.WHITE);
		Rlabel1.setBounds(245,80,300,20);
		Register.add(Rlabel1);
		
		//Name text field
		JTextField Rtf = new JTextField();
		Rtf.setBounds(245,110,300,30);
		Register.add(Rtf);
		
		//Email id label
		JLabel Rlabel2 = new JLabel("ENTER YOUR EMAIL ID  ");
		Rlabel2.setFont(new Font("Poppins",Font.PLAIN, 12));
		Rlabel2.setForeground(Color.WHITE);
		Rlabel2.setBounds(245,150,300,20);
		Register.add(Rlabel2);
		
		//Email text field
		JTextField Rtf2 = new JTextField();
		Rtf2.setBounds(245,180,300,30);
		Register.add(Rtf2);
		
		//Password label
		JLabel Rlabel3 = new JLabel("ENTER YOUR PASSWORD  ");
		Rlabel3.setFont(new Font("Poppins",Font.PLAIN, 12));
		Rlabel3.setForeground(Color.WHITE);
		Rlabel3.setBounds(245,220,300,20);
		Register.add(Rlabel3);
		
		//Password text field
		JTextField Rtf3 = new JTextField();
		Rtf3.setBounds(245,250,300,30);
		Register.add(Rtf3);
		
		//Confirm password label
		JLabel Rlabel4 = new JLabel("CONFIRM YOUR PASSWORD  ");
		Rlabel4.setFont(new Font("Poppins",Font.PLAIN, 12));
		Rlabel4.setForeground(Color.WHITE);
		Rlabel4.setBounds(245,290,300,20);
		Register.add(Rlabel4);
		
		//Confirm password text field
		JTextField Rtf4 = new JTextField();
		Rtf4.setBounds(245,320,300,30);
		Register.add(Rtf4);
		
		// Adhar card label
		JLabel Rlabel5 = new JLabel("ENTER YOUR ADHAR CARD NUMBER ");
		Rlabel5.setFont(new Font("Poppins",Font.PLAIN, 12));
		Rlabel5.setForeground(Color.WHITE);
		Rlabel5.setBounds(245,360,300,20);
		Register.add(Rlabel5);
		
		// Adhar card text field
		JTextField Rtf5 = new JTextField();
		Rtf5.setBounds(245,400,300,30);
		Register.add(Rtf5);
		
		// Log in button 
		JButton login = new JButton("CLICK HERE TO SIGN IN");
		login.setFont(new Font("Poppins",Font.PLAIN, 10));
		login.setForeground(Color.LIGHT_GRAY);
		login.setBounds(245,440,300,20);
		login.setBorder(null);
		login.setContentAreaFilled(false);
		
		// Log in button hovering
		login.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				login.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	login.setForeground(Color.LIGHT_GRAY);
		    }
		});
		
		//Sign up button
		JButton signUpButton = new JButton("Sign Up");
		signUpButton.setBounds(335,480,120,50);
		Register.add(signUpButton);
		
		Register.add(login);
		add(Register);
		Register.setVisible(false);
		
		
		//Show HomePage
		JPanel homePage = new JPanel();
		homePage.setLayout(null);
		homePage.setBounds(250,150,1150,600);
		homePage.setBackground(Color.WHITE);
		
		//Middle logo
		JPanel SecondlogoPanel = new JPanel();
		SecondlogoPanel.setBounds(360,20,420,120);
		BufferedImage img2;
		try {
			JLabel pic2 = new JLabel();
			pic2.setBounds(20,20,400,100);
			img2 = ImageIO.read(new File(Constatnts.Secondary_logo));
			Image Imag2 = img2.getScaledInstance(pic2.getWidth(), pic2.getHeight(),pic2.CENTER);
			ImageIcon logoIcon2 = new ImageIcon(Imag2);
			pic2.setIcon(logoIcon2);
			SecondlogoPanel.add(pic2);
			SecondlogoPanel.setBackground(Color.WHITE);
			homePage.add(SecondlogoPanel);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		String aboutPrj = "<p><b>The basic features of our project are:</b>\n"
				+ "<br>\n"
				+ "Adding New Criminal Record/Official Record.\n"
				+ "<br>\n"
				+ "Modifying Details of the Record.\n"
				+ "<br>\n"
				+ "Deleting a Record.\n"
				+ "<br>\n"
				+ "Search Options.\n"
				+ "<br>\n"
				+ "Registering an Online Complaint.\n"
				+ "<br>\n"
				+ "Accessing Emergency Numbers and <br> Contact Details of Officials.\n"
				+ "<br><br><br>\n"
				+ "</p>";
		
		//about text
		JLabel about = new JLabel("<html>"+aboutPrj+"</html>");
		about.setBounds(420,100,800,400);
		about.setFont(new Font("Poppins",Font.PLAIN, 14));
		homePage.add(about);
		add(homePage);
		homePage.setVisible(false);
		
		//sign in button on home page
		JButton homeSignIn = new JButton("Sign In");
		homeSignIn.setBounds(380,500,200,60);
		homeSignIn.setForeground(Color.RED);
		homeSignIn.setBackground(Color.BLACK);
		homeSignIn.setVisible(false);
		homePage.add(homeSignIn);

		//sign up button on home page
		JButton homeSignUp = new JButton("Sign Up");
		homeSignUp.setBounds(600,500,200,60);
		homeSignUp.setForeground(Color.RED);
		homeSignUp.setBackground(Color.BLACK);
		homeSignUp.setVisible(false);
		homePage.add(homeSignUp);
		
		//sign out button on home page
		JButton homeSignOut = new JButton("Sign Out");
		homeSignOut.setBounds(480,500,200,60);
		homeSignOut.setForeground(Color.RED);
		homeSignOut.setBackground(Color.BLACK);
		homeSignOut.setVisible(false);
		homePage.add(homeSignOut);
		
		//Show record
		JPanel RecordsPanel = new JPanel();
		RecordsPanel.setLayout(null);
		RecordsPanel.setBounds(250,150,1150,600);
		RecordsPanel.setBackground(Color.WHITE);
		
		//Title of the record
		JLabel RecordTitle = new JLabel("FIR REPORTS");
		RecordTitle .setFont(new Font("Poppins",Font.CENTER_BASELINE, 28));
		RecordTitle .setForeground(Color.BLACK);
		RecordTitle .setBounds(485,20,250,40);
		RecordsPanel.add(RecordTitle );
		

		//add record button
		JButton addRecords = new JButton("ADD REPORT");
		addRecords.setBounds(420,200,300,60);
		addRecords.setForeground(Color.RED);
		addRecords.setBackground(Color.BLACK);
		addRecords.setVisible(false);
		RecordsPanel.add(addRecords);
		
		//view record button
		JButton viewRecord = new JButton("VIEW REPORT");
		viewRecord.setBounds(420,300,300,60);
		viewRecord.setForeground(Color.RED);
		viewRecord.setBackground(Color.BLACK);
		viewRecord.setVisible(false);
		RecordsPanel.add(viewRecord);

		
		add(RecordsPanel);
		RecordsPanel.setVisible(false);
		//button Actions
		
		
		//home button function
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SignIn.setVisible(false);
				Register.setVisible(false);
				homePage.setVisible(true);
				RecordsPanel.setVisible(false);
				if(Constatnts.Status) {
					homeSignOut.setVisible(true);
				}else {
					homeSignIn.setVisible(true);
					homeSignUp.setVisible(true);
				}
			}
			
		});
		
		
		//sign in button function
		signInButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					int adCdNo = Integer.parseInt(tf.getText());
					String password = tf2.getText();
					
					if ((tf.getText() == null) || (password == null)) {
						JOptionPane.showMessageDialog(SignIn, "ALL REQUIRED FILLED ARE NOT FILLED.");
					}else {
						
						if(citizen.isSelected()) {
							try {
								
								citizen c2 = LogInCitizen(adCdNo,password); // log in function for citizen
								JOptionPane.showMessageDialog(SignIn, "LOG IN SUCESSFULLY.");
								c1.adCard = adCdNo;
								c1.Pass = password;
								Constatnts.Status = true;
								SignIn.setVisible(false);
								Register.setVisible(false);
								homePage.setVisible(true);
								RecordsPanel.setVisible(false);
								Constatnts.Citizen_status = true;
								Constatnts.officer_status = false;
								
								// check the log in status
								if(Constatnts.Status) {
									homeSignOut.setVisible(true);
									tf.setText("");
									tf2.setText("");
									homeSignIn.setVisible(false);
									homeSignUp.setVisible(false);
								}else {
									homeSignOut.setVisible(false);
									homeSignIn.setVisible(true);
									homeSignUp.setVisible(true);
								}
								
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(SignIn, "PLEASE ENTER CORRECT ADHAR CARD NUMBER AND PASSWORD ");
							}
							
						}else if(officer.isSelected()) {
							
							dept d1 = LogInDepartment(adCdNo,password);// log in function for department official
							
							c1.adCard = adCdNo;
							c1.Pass = password;
							Constatnts.Status = true;
							SignIn.setVisible(false);
							Register.setVisible(false);
							homePage.setVisible(true);
							RecordsPanel.setVisible(false);
							Constatnts.officer_status = true;
							Constatnts.Citizen_status = false;
							
							//check the status of the user log in
							if(Constatnts.Status) {
								homeSignOut.setVisible(true);
								tf.setText("");
								tf2.setText("");
								homeSignIn.setVisible(false);
								homeSignUp.setVisible(false);
							}else {
								homeSignOut.setVisible(false);
								homeSignIn.setVisible(true);
								homeSignUp.setVisible(true);
							}

						}else {
							JOptionPane.showMessageDialog(SignIn, "PLEASE SELECT USER TYPE.");
						}
		
					}
				}
				catch(Exception er){
					JOptionPane.showMessageDialog(SignIn, "PLEASE ENTER CORRECT ADHAR CARD NUMBER. ");
				}
				
			}
			
		});
		
		
		//sighn up button punction
		signUpButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String getNameReg = Rtf.getText();
				String getEmailId = Rtf2.getText();
				String getPassword = Rtf3.getText();
				String getConfPass = Rtf4.getText();
				
				try {
					int adCdNo = Integer.parseInt(Rtf5.getText());
					if (getNameReg == null || getEmailId  == null || getPassword == null || getConfPass == null || Rtf5.getText() == null) {
						JOptionPane.showMessageDialog(Register, "ALL REQUIRED FILLED ARE NOT FILLED.");
					}else {
						if (getPassword.equals(getConfPass)) {
							try {
								
								// register the citizen user
								registerCitizen(getNameReg,adCdNo,getEmailId,getPassword);
								c1.adCard = adCdNo;
								c1.Email = getEmailId;
								c1.name = getNameReg;
								c1.Pass = getPassword;
								Constatnts.Status = true;
								SignIn.setVisible(false);
								Register.setVisible(false);
								homePage.setVisible(true);
								RecordsPanel.setVisible(false);
								Constatnts.Citizen_status = true;
								Constatnts.officer_status = false;
								
								//status of the user log in
								if(Constatnts.Status) {
									homeSignOut.setVisible(true);
									tf.setText("");
									tf2.setText("");
									homeSignIn.setVisible(false);
									homeSignUp.setVisible(false);
								}else {
									homeSignOut.setVisible(false);
									homeSignIn.setVisible(true);
									homeSignUp.setVisible(true);
								}
								
								JOptionPane.showMessageDialog(SignIn, "REGISTERED AND LOG IN SUCESSFULLY.");
							}catch(Exception e4) {
								JOptionPane.showMessageDialog(Register, "ERROR WHILE ADDING YOUR ACCOUNT.");
							}
						}else {
							JOptionPane.showMessageDialog(Register, "PASSWARD AND CONFIRM PASSWORD ARE DIFFRENT.");
						}
					}
					
					
				}
				catch(Exception e3) {
					JOptionPane.showMessageDialog(SignIn, "PLEASE ENTER CORRECT ADHAR CARD NUMBER. ");
				}
				
			}
			
		});
		
		//sign up button function at home page
		homeSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				homePage.setVisible(false);
				SignIn.setVisible(false);
				Register.setVisible(true);
				RecordsPanel.setVisible(false);
			}
			
		});
		
		//sign in button function at home page
		homeSignIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				homePage.setVisible(false);
				SignIn.setVisible(true);
				Register.setVisible(false);
				RecordsPanel.setVisible(false);
				// TODO Auto-generated method stub
				
			}
			
		});
		
		//Records in button function at home page
		Records.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Constatnts.Status) {
					homePage.setVisible(false);
					SignIn.setVisible(false);
					Register.setVisible(false);
					RecordsPanel.setVisible(true);
					
					if (Constatnts.Citizen_status) {
						addRecords.setVisible(true);
						viewRecord.setVisible(true);
					}
					if (Constatnts.officer_status) {
						addRecords.setVisible(false);
						viewRecord.setVisible(true);
					}

				}else {
					JOptionPane.showMessageDialog(Register, "PLEASE SIGN IN");
				}
			}
			
		});
		
		//sign out button function at home page
		homeSignOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				homePage.setVisible(false);
				SignIn.setVisible(true);
				Register.setVisible(false);
				Constatnts.Status = false;
				
				if(Constatnts.Status) {
					homeSignOut.setVisible(true);
					homeSignIn.setVisible(false);
					homeSignUp.setVisible(false);
				}else {
					homeSignIn.setVisible(true);
					homeSignUp.setVisible(true);
					homeSignOut.setVisible(false);
				}
				
			}
			
		});
		
		
		//register function at home page
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignIn.setVisible(false);
				Register.setVisible(true);
			}
		});
		
		//log in function at home page
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Register.setVisible(false);
				SignIn.setVisible(true);
			}
		});
		
		//emergency number function at home page
		EmergencyNumber.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
				    try {
				        File myFile = new File("/Users/umesh/Desktop/SatyaVachan/emergencynumbers.pdf");
				        Desktop.getDesktop().open(myFile);
				    } catch (IOException ex) {
				        // no application registered for PDFs
				    }
				}
			}
		});
		
		
		//add records button function at index page
		addRecords.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addReport FIR_file = new addReport(c1.adCard);
			}
			
		});
		
		//view records button function at index page
		viewRecord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				viewReport view_FIRs = new viewReport(c1.adCard);
			}
			
		});
		
		//FOOTTER
		
		JPanel fotter = new JPanel();
		fotter.setBounds(0,830,1650,100);
		fotter.setBackground(Color.BLACK);
		fotter.setLayout(null);
		String fotterText = "Project By: \n"
				+ "Umesh Kumar(20MIS0187) \n"
				+ "Akanksha Hotta(20MIS0137) ";
		
		//fotter text
		JLabel fotterLabel = new JLabel(fotterText);
		fotterLabel.setForeground(Color.WHITE);
		fotterLabel.setFont(new Font("Poppins", Font.PLAIN, 16));
		fotterLabel.setBounds(580,30,800,20);
		fotter.add(fotterLabel);
		add(fotter);
		
		//FOTTER ENDS
		
		setSize(1650,1080);
		setLayout(null);
		setVisible(true);
		
	}
	
	
	// log in function for officials
	public dept LogInDepartment(int adCard,String password) throws SQLException {
		Connection con = DriverManager.getConnection(keys.url,keys.uname,keys.pass);
		//RESULT SET
		ResultSet rs;
		
		PreparedStatement pst = con.prepareStatement("select * from officer where adCard = ? and pass = ?;");
		pst.setInt(1, adCard);
		pst.setString(2, password);
		rs = pst.executeQuery();
		rs.next();
		dept c1 = new dept();
		
		//decoding details
		c1.regID = rs.getInt("regID");
		c1.adCard = rs.getInt("adCard");
		c1.name = rs.getString("name");
		c1.email = rs.getString("email");
		c1.pass = rs.getString("pass");
		c1.phno = rs.getInt("phno");
		c1.pincode = rs.getInt("pincode");

		con.close();
		return c1;
	}
	
	// log in function for citizen
	public citizen LogInCitizen(int adCard,String password) throws SQLException {
		Connection con = DriverManager.getConnection(keys.url,keys.uname,keys.pass);
		//RESULT SET
		ResultSet rs;
		
		PreparedStatement pst = con.prepareStatement("select * from citizen where adCard = ? and pass = ?;");
		pst.setInt(1, adCard);
		pst.setString(2, password);
		
		rs = pst.executeQuery();
		
		rs.next();
		
		//decoding citizen
		citizen c1 = new citizen();
		c1.adCard = rs.getInt("adCard");
		c1.name = rs.getString("name");
		c1.Email = rs.getString("email");
		c1.Pass = rs.getString("pass");
		con.close();
		return c1;
	}
	
	//register citizen
	public void registerCitizen(String name,int adCard,String Email,String pass) throws SQLException{
		
		Connection con = DriverManager.getConnection(keys.url,keys.uname,keys.pass);
		
		PreparedStatement pst = con.prepareStatement("insert into citizen values(?,?,?,?,?);");
		
		//adding up the data
		pst.setInt(1, adCard);
		pst.setString(2,name);
		pst.setString(3, pass);
		pst.setInt(4,1234567890);
		pst.setString(5, Email);
		
		int i = pst.executeUpdate();
		
		con.close();
	}
	
	
	public static void main(String[] args){
		index obj = new index();
	}
}
