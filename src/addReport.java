import javax.swing.*;

import static java.awt.Image.SCALE_SMOOTH;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;

class FIR implements Runnable{
	String fullName;
	String gender;
	String dob;
	String Crtadd;
	String homeAdd;
	
	int phno;
	String email;
	int pinCode;
	int otherPhno;
	String fatherName;
	String motherName;
	
	String subject;
	String dOoc;
	String addInciden;
	String convict;
	String witName;
	String descr;
	String evidDet;
	
	int adCard;
	String profic;
	String evidPath;
	Blob blob1;
	Blob blob2;
	public void postData() throws SQLException, FileNotFoundException {
		//insert into FIR(fullName,gen,dob,Crtadd,homeAdd,phno,email,pinCode,otherPhno,fatherName,motherName,subject,dOoc,addInciden,convict,witName,descr,evidDet,adCd,profic,evidimg) values("1","2","3","4","5",6,"7",8,9,"10","11","12","13","14","15","16","17","18",19,20,21);
		Connection con = DriverManager.getConnection(keys.url,keys.uname,keys.pass);
		String sta = "insert into FIR(fullName,gen,dob,Crtadd,homeAdd,phno,email,pinCode,otherPhno,fatherName,motherName,subject,dOoc,addInciden,convict,witName,descr,evidDet,adCd,profic,evidimg) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement pst = con.prepareStatement(sta);
		pst.setString(1, fullName);	
		pst.setString(2, gender);	
		pst.setString(3, dob);	
		pst.setString(4, Crtadd);
		pst.setString(5, homeAdd);	
		pst.setInt(6, phno);
		pst.setString(7, email);	
		pst.setInt(8, pinCode);
		pst.setInt(9, otherPhno);
		pst.setString(10, fatherName);
		pst.setString(11, motherName);
		pst.setString(12, subject);
		pst.setString(13, dOoc);
		pst.setString(14, addInciden);
		pst.setString(15, convict);
		pst.setString(16, witName);
		pst.setString(17, descr);
		pst.setString(18, evidDet);
		pst.setInt(19, adCard);
		

		InputStream in1 = new FileInputStream(profic);
		InputStream in2 = new FileInputStream(evidPath);
		
		pst.setBlob(20, in1);
		pst.setBlob(21, in2);	
		int i = pst.executeUpdate();
		PreparedStatement pst3 = con.prepareStatement("select adCard from officer where pincode = ?;");
		pst3.setInt(1, pinCode);
		ResultSet rs = pst3.executeQuery();
		int adCof = 2;
		if(rs.next()) {
			adCof = rs.getInt("adCard"); 
		}
		
		PreparedStatement pst2 = con.prepareStatement("insert into FIRDetail(subject,status,adCdCit,adCdOff) values(?,?,?,?);");
		pst2.setString(1, subject);
		pst2.setString(2, "REPORTED");
		pst2.setInt(3, adCard);
		pst2.setInt(4, adCof);
		
		int j = pst2.executeUpdate();
		con.close();
	}
	public void fetchData(int FIRID) throws SQLException {
		Connection con = DriverManager.getConnection(keys.url,keys.uname,keys.pass);
		PreparedStatement pst = con.prepareStatement("select * from FIR where FIRID = ?");
		pst.setInt(1, FIRID);
		ResultSet rs = pst.executeQuery();
		rs.next();
		fullName = rs.getString("fullName");
		gender = rs.getString("gen");
		dob = rs.getString("dob");
		Crtadd = rs.getString("Crtadd");
		homeAdd = rs.getString("homeAdd");
		phno = rs.getInt("phno");
		email = rs.getString("email");
		pinCode = rs.getInt("pinCode");
		otherPhno = rs.getInt("otherPhno");
		fatherName = rs.getString("fatherName");
		motherName = rs.getString("motherName");
		subject = rs.getString("subject");
		dOoc = rs.getString("dOoc");
		addInciden = rs.getString("addInciden");
		convict = rs.getString("convict");
		witName = rs.getString("witName");
		descr = rs.getString("descr");
		evidDet = rs.getString("evidDet");
		adCard = rs.getInt("adCd");
		
		blob1 = rs.getBlob("profic");
		blob2 = rs.getBlob("evidimg");
		
		
		con.close();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int FIRID = 1;
		Connection con;
		try {
			con = DriverManager.getConnection(keys.url,keys.uname,keys.pass);
			PreparedStatement pst = con.prepareStatement("select * from FIR where FIRID = ?");
			pst.setInt(1, FIRID);
			ResultSet rs = pst.executeQuery();
			rs.next();
			fullName = rs.getString("fullName");
			gender = rs.getString("gen");
			dob = rs.getString("dob");
			Crtadd = rs.getString("Crtadd");
			homeAdd = rs.getString("homeAdd");
			phno = rs.getInt("phno");
			email = rs.getString("email");
			pinCode = rs.getInt("pinCode");
			otherPhno = rs.getInt("otherPhno");
			fatherName = rs.getString("fatherName");
			motherName = rs.getString("motherName");
			subject = rs.getString("subject");
			dOoc = rs.getString("dOoc");
			addInciden = rs.getString("addInciden");
			convict = rs.getString("convict");
			witName = rs.getString("witName");
			descr = rs.getString("descr");
			evidDet = rs.getString("evidDet");
			adCard = rs.getInt("adCd");
			
			blob1 = rs.getBlob("profic");
			blob2 = rs.getBlob("evidimg");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


public class addReport extends JFrame {

	addReport(int adCdID){
		
		System.out.println(adCdID);
		FIR report = new FIR();
		report.adCard = adCdID;
		//NAVBAR
		JPanel navBar = new JPanel();
		
		navBar.setBounds(0,0,1650,80);
		navBar.setBackground(Color.BLACK);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		JPanel navButtons = new JPanel();
		navButtons.setBounds(1340,10,800,80);
		navButtons.setBackground(Color.BLACK);
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBounds(20,20,200,60);
		BufferedImage img;
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
		
		JLabel title = new JLabel("SATYAVACHAN");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Poppins", Font.CENTER_BASELINE,26));
		title.setBounds(720,26,220,30);
		navBar.add(title);
		
		JButton home = new JButton("EXIT");
		home.setFont(new Font("Poppins", Font.CENTER_BASELINE, 20));
		JButton EmergencyNumber = new JButton("Emergency Number");
		EmergencyNumber.setFont(new Font("Poppins", Font.PLAIN, 16));
		home.setForeground(Color.LIGHT_GRAY);
		EmergencyNumber.setForeground(Color.LIGHT_GRAY);
		home.setBorder(null);

		EmergencyNumber.setBorder(null);
		home.setContentAreaFilled(false);
		EmergencyNumber.setContentAreaFilled(false);
		home.setBounds(20,10,80,40);
		EmergencyNumber.setBounds(110,10,160,40);
		navButtons.add(EmergencyNumber);
		
		navButtons.add(home);
		navBar.add(navButtons);
		
		navBar.setLayout(null);
		navButtons.setLayout(null);
		add(logoPanel);
		add(navBar);
		
		
		
		home.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
		        home.setForeground(Color.RED);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        home.setForeground(Color.LIGHT_GRAY);
		    }
		});
		
		EmergencyNumber.addMouseListener(new MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				EmergencyNumber.setForeground(Color.WHITE);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	EmergencyNumber.setForeground(Color.LIGHT_GRAY);
		    }
		});
		
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				// TODO Auto-generated method stub
				
			}
			
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		//NAVBAR ENDS
		
		//viewNAV
		
		JPanel viewNav = new JPanel();
		viewNav.setLayout(null);
		viewNav.setBounds(0,0,920,100);
		viewNav.setBackground(Color.BLACK);
		viewNav.setVisible(true);
		
		//BODY
		
		//VIEW 1
		 
		JPanel view1 = new JPanel();
		view1.setLayout(null);
		view1.setBounds(385,115,920,670);
		view1.setBackground(Color.WHITE);
		
		
		JLabel header1 = new JLabel("PERSONAL INFORMATION");
		header1.setFont(new Font("Poppins", Font.PLAIN, 20));
		header1.setForeground(Color.WHITE);
		header1.setBounds(20,30,300,20);
		view1.add(header1);
		
		JLabel subheader1 = new JLabel("ADD YOUR DETAILS");
		subheader1.setFont(new Font("Poppins", Font.PLAIN, 12));
		subheader1.setForeground(Color.WHITE);
		subheader1.setBounds(20,38,300,50);
		view1.add(subheader1);
		
		JButton nextBt1 = new JButton("NEXT >");
		nextBt1.setFont(new Font("Poppins", Font.PLAIN, 14));
		nextBt1.setForeground(Color.BLUE);
		nextBt1.setBounds(760,26,100,50);
		view1.add(nextBt1);
		
		view1.add(viewNav);
		add(view1);
		view1.setVisible(true);
		
		JLabel fullname = new JLabel("FULL NAME ");
		fullname.setFont(new Font("Poppins", Font.PLAIN, 16));
		fullname.setBounds(20,135,150,20);
		view1.add(fullname);
		
		JTextField fullnamefield = new JTextField();
		fullnamefield.setBounds(18,160,400,28);
		fullnamefield.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view1.add(fullnamefield);
		
		JLabel Gender = new JLabel("GENDER ");
		Gender.setFont(new Font("Poppins", Font.PLAIN, 16));
		Gender.setBounds(20,200,150,20);
		view1.add(Gender);
		
		JRadioButton m = new JRadioButton("Male");
		m.setFont(new Font("Poppins",Font.PLAIN,12));
		m.setBounds(18,220,80,30);
		view1.add(m);
		
		JRadioButton f = new JRadioButton("Female");
		f.setFont(new Font("Poppins",Font.PLAIN,12));
		f.setBounds(98,220,100,30);
		view1.add(f);
		
		JRadioButton others = new JRadioButton("OTHERS");
		others.setFont(new Font("Poppins",Font.PLAIN,12));
		others.setBounds(198,220,120,30);
		view1.add(others);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(m);
		bg.add(f);
		bg.add(others);
		
		JLabel DOB = new JLabel("DATE OF BIRTH (DD/MM/YYYY)");
		DOB.setFont(new Font("Poppins", Font.PLAIN, 16));
		DOB.setBounds(20,260,300,20);
		view1.add(DOB);
		
		JTextField DOBFIeld = new JTextField();
		DOBFIeld.setBounds(18,290,400,28);
		DOBFIeld.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view1.add(DOBFIeld);
		
		JLabel imge = new JLabel("UPLOAD PROFILE PIC");
		imge.setFont(new Font("Poppins", Font.PLAIN, 14));
		imge.setBounds(500,260,150,20);
		view1.add(imge);
		
		JButton imgBut = new JButton("CLICK HERE");
		imgBut.setForeground(Color.BLUE);
		imgBut.setBounds(498,290,150,28);
		view1.add(imgBut);
		
		JLabel Address = new JLabel("CURRENT ADDRESS");
		Address.setFont(new Font("Poppins", Font.PLAIN, 16));
		Address.setBounds(20,330,300,20);
		view1.add(Address);
		
		JTextArea AddressFIeld = new JTextArea();
		AddressFIeld.setBounds(18,360,400,60);
		AddressFIeld.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view1.add( AddressFIeld);
		
		JLabel homeAddress = new JLabel("HOME ADDRESS");
		homeAddress.setFont(new Font("Poppins", Font.PLAIN, 16));
		homeAddress.setBounds(500,330,300,20);
		view1.add(homeAddress);
		
		JTextArea homeAddressFIeld = new JTextArea();
		homeAddressFIeld.setBounds(498,360,400,60);
		homeAddressFIeld.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view1.add( homeAddressFIeld);
		
		JLabel phno = new JLabel("PHONE NUMBER");
		phno.setFont(new Font("Poppins", Font.PLAIN, 16));
		phno.setBounds(20,430,300,20);
		view1.add(phno);
		
		JTextField phnoFIeld = new JTextField();
		phnoFIeld.setBounds(18,460,400,28);
		phnoFIeld.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view1.add(phnoFIeld);
		
		JLabel phno2 = new JLabel("OTHER PHONE NUMBER (if any)");
		phno2.setFont(new Font("Poppins", Font.PLAIN, 16));
		phno2.setBounds(500,430,300,20);
		view1.add(phno2);
		
		JTextField phnoFIeld2 = new JTextField();
		phnoFIeld2.setBounds(498,460,400,28);
		phnoFIeld2.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view1.add(phnoFIeld2);
		
		JLabel email = new JLabel("EMAIL ID");
		email.setFont(new Font("Poppins", Font.PLAIN, 16));
		email.setBounds(20,500,300,20);
		view1.add(email);
		
		JTextField emailFIeld = new JTextField();
		emailFIeld.setBounds(18,530,400,28);
		emailFIeld.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view1.add(emailFIeld);
		
		JLabel fatherName = new JLabel("FATHER'S NAME ");
		fatherName.setFont(new Font("Poppins", Font.PLAIN, 16));
		fatherName.setBounds(500,500,300,20);
		view1.add(fatherName);
		
		JTextField fatherNameFIeld = new JTextField();
		fatherNameFIeld.setBounds(498,530,400,28);
		fatherNameFIeld.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view1.add(fatherNameFIeld);
		
		JLabel pinCd = new JLabel("PIN CODE");
		pinCd.setFont(new Font("Poppins", Font.PLAIN, 16));
		pinCd.setBounds(20,570,300,20);
		view1.add(pinCd);
		
		JTextField pinCdFIeld = new JTextField();
		pinCdFIeld.setBounds(18,600,400,28);
		pinCdFIeld.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view1.add(pinCdFIeld);
		
		JLabel mothername = new JLabel("MOTHER'S NAME");
		mothername.setFont(new Font("Poppins", Font.PLAIN, 16));
		mothername.setBounds(500,570,300,20);
		view1.add(mothername);
		
		JTextField mothernameFIeld = new JTextField();
		mothernameFIeld.setBounds(498,600,400,28);
		mothernameFIeld.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view1.add(mothernameFIeld);
		
		
		JPanel profileImage = new JPanel();
		profileImage.setLayout(null);
		profileImage.setBounds(680,120,200,200);
		
		
		
		
		imgBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser uploadImage = new JFileChooser();
				int res = uploadImage.showOpenDialog(null);
				if(res == JFileChooser.APPROVE_OPTION) {
					File filePath = new File(uploadImage.getSelectedFile().getAbsolutePath());
					String pathString = filePath.getAbsolutePath();
					report.profic = pathString;
					System.out.println(pathString);
					String chSr = pathString.substring(pathString.length()-3);
					System.out.println(chSr);
					if (chSr.contains("png") || chSr.contains("peg") || chSr.contains("jpg")) {
						//TODO
						BufferedImage imge1;
						try {
							JLabel pic = new JLabel();
							pic.setBounds(0,0,200,400);
							imge1 = ImageIO.read(new File(pathString));
							Image Imag = imge1.getScaledInstance(pic.getWidth(), pic.getHeight(),pic.CENTER);
							ImageIcon profpic = new ImageIcon(Imag);
							System.out.println(profpic.getImage());
							pic.setIcon(profpic);
							profileImage.add(pic);
							view1.add(profileImage);
						}catch(Exception e1) {
							JOptionPane.showMessageDialog(view1, " UNABLE TO LOAD ");
						}
					}else {
						JOptionPane.showMessageDialog(view1, "PLEASE UPLOAD JPG , JPEG OR PNG FILE. ");
					}
					
				}
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		//view2
		
		JPanel view2 = new JPanel();
		view2.setLayout(null);
		view2.setBounds(385,115,920,670);
		view2.setBackground(Color.WHITE);
		
		JLabel header2 = new JLabel("REPRORT FIR");
		header2.setFont(new Font("Poppins", Font.PLAIN, 20));
		header2.setForeground(Color.WHITE);
		header2.setBounds(20,30,300,20);
		view2.add(header2);
		
		JLabel subheader2 = new JLabel("ADD YOUR COMPLAIN");
		subheader2.setFont(new Font("Poppins", Font.PLAIN, 12));
		subheader2.setForeground(Color.WHITE);
		subheader2.setBounds(20,38,300,50);
		view2.add(subheader2);
		
		JButton nextBt2 = new JButton("NEXT >");
		nextBt2.setFont(new Font("Poppins", Font.PLAIN, 14));
		nextBt2.setForeground(Color.BLUE);
		nextBt2.setBounds(760,26,100,50);
		view2.add(nextBt2);
		
		JButton backBt2 = new JButton("< BACK");
		backBt2.setFont(new Font("Poppins", Font.PLAIN, 14));
		backBt2.setForeground(Color.BLUE);
		backBt2.setBounds(620,26,100,50);
		view2.add(backBt2);
		
		JLabel Subject = new JLabel("SUBJECT");
		Subject.setFont(new Font("Poppins", Font.PLAIN, 16));
		Subject.setBounds(20,135,150,20);
		view2.add(Subject);
		
		JTextArea subjectField1 = new JTextArea();
		subjectField1.setBounds(18,160,400,40);
		subjectField1.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view2.add(subjectField1);
		
		JLabel subjectinfo = new JLabel("Enter only short description within 100 words");
		subjectinfo.setFont(new Font("Poppins", Font.PLAIN, 14));
		subjectinfo.setBounds(20,204,400,20);
		view2.add(subjectinfo);
		
		JLabel dateR = new JLabel("DATE OF OCCURANCE (DD/MM/YYYY)");
		dateR.setFont(new Font("Poppins", Font.PLAIN, 16));
		dateR.setBounds(20,260,300,20);
		view2.add(dateR);
		
		JTextField drfield = new JTextField();
		drfield.setBounds(18,290,400,28);
		drfield.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view2.add(drfield);
		
		JLabel AddressI = new JLabel("ADDRESS OF INCIDENT");
		AddressI.setFont(new Font("Poppins", Font.PLAIN, 16));
		AddressI.setBounds(20,330,300,20);
		view2.add(AddressI);
		
		JTextArea AddressIFIeld = new JTextArea();
		AddressIFIeld.setBounds(18,360,400,60);
		AddressIFIeld.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view2.add( AddressIFIeld);
		
		JLabel complaintAgainst = new JLabel("COMPLAINT AGAINST (If known)");
		complaintAgainst.setFont(new Font("Poppins", Font.PLAIN, 16));
		complaintAgainst.setBounds(20,430,300,20);
		view2.add(complaintAgainst);
		
		JTextField CAFIeld = new JTextField();
		CAFIeld.setBounds(18,460,400,28);
		CAFIeld.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view2.add(CAFIeld);
		
		JLabel PC = new JLabel("PIN CODE");
		PC.setFont(new Font("Poppins", Font.PLAIN, 16));
		PC.setBounds(20,500,300,20);
		view2.add(PC);
		
		JTextField PCF = new JTextField();
		PCF.setBounds(18,530,400,28);
		PCF.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view2.add(PCF);
		
		JLabel witness = new JLabel("WITNESS NAME (If any)");
		witness.setFont(new Font("Poppins", Font.PLAIN, 16));
		witness.setBounds(20,570,300,20);
		view2.add(witness);
		
		JTextField witnessFIeld = new JTextField();
		witnessFIeld.setBounds(18,600,400,28);
		witnessFIeld.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view2.add(witnessFIeld);
		
		JLabel FullDesc = new JLabel("FULL DESCRIPTION");
		FullDesc.setFont(new Font("Poppins", Font.PLAIN, 16));
		FullDesc.setBounds(500,135,150,20);
		view2.add(FullDesc);
		
		JTextArea FulldescField = new JTextArea();
		FulldescField.setBounds(498,160,400,445);
		FulldescField.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view2.add(FulldescField);
		
		
		
		JLabel Descinfo = new JLabel("Enter whole description of incidient descriptively");
		Descinfo.setFont(new Font("Poppins", Font.PLAIN, 14));
		Descinfo.setBounds(500,607,400,20);
		view2.add(Descinfo);
		
		
		add(view2);
		view2.setVisible(false);
		
		
		//view3
		
		JPanel view3 = new JPanel();
		view3.setLayout(null);
		view3.setBounds(385,115,920,670);
		view3.setBackground(Color.WHITE);
		
		JLabel header3 = new JLabel("REPRORT FIR");
		header3.setFont(new Font("Poppins", Font.PLAIN, 20));
		header3.setForeground(Color.WHITE);
		header3.setBounds(20,30,300,20);
		view3.add(header3);
		
		JLabel subheader3 = new JLabel("ADD EVIDENCE");
		subheader3.setFont(new Font("Poppins", Font.PLAIN, 12));
		subheader3.setForeground(Color.WHITE);
		subheader3.setBounds(20,38,300,50);
		view3.add(subheader3);
		
		JButton submit = new JButton("SUBMIT");
		submit.setFont(new Font("Poppins", Font.BOLD, 14));
		submit.setForeground(Color.RED);
		submit.setBounds(760,26,100,50);
		view3.add(submit);
		
		JButton backBt3 = new JButton("< BACK");
		backBt3.setFont(new Font("Poppins", Font.PLAIN, 14));
		backBt3.setForeground(Color.BLUE);
		backBt3.setBounds(620,26,100,50);
		view3.add(backBt3);
		
		JLabel evidenceDetail = new JLabel("EVIDENCE DETAIL");
		evidenceDetail.setFont(new Font("Poppins", Font.PLAIN, 16));
		evidenceDetail.setBounds(20,135,150,20);
		view3.add(evidenceDetail);
		
		JTextArea evidetField = new JTextArea();
		evidetField.setBounds(18,160,400,40);
		evidetField.setBorder(BorderFactory.createLineBorder(Color.darkGray));
		view3.add(evidetField);
		
		JLabel UpldEvid = new JLabel("UPLOAD EVIDENCE");
		UpldEvid.setFont(new Font("Poppins", Font.PLAIN, 16));
		UpldEvid.setBounds(20,210,300,20);
		view3.add(UpldEvid);
		
		JButton evidButton = new JButton("CLICK HERE");
		evidButton.setForeground(Color.BLUE);
		evidButton.setBounds(20,240,150,28);
		view3.add(evidButton);
		
		JPanel evidDetail = new JPanel();
		evidDetail.setLayout(null);
		evidDetail.setBounds(50,290,800,340);
		
		
		evidButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser uploadImage = new JFileChooser();
				int res = uploadImage.showOpenDialog(null);
				if(res == JFileChooser.APPROVE_OPTION) {
					File filePath = new File(uploadImage.getSelectedFile().getAbsolutePath());
					String pathString = filePath.getAbsolutePath();
					System.out.println(pathString);
					report.evidPath = pathString;
					String chSr = pathString.substring(pathString.length()-3);
					System.out.println(chSr);
					if (chSr.contains("png") || chSr.contains("peg") || chSr.contains("jpg")) {
						//TODO
						BufferedImage imge1;
						try {
							JLabel pic = new JLabel();
							pic.setBounds(0,0,800,340);
							imge1 = ImageIO.read(new File(pathString));
							Image Imag = imge1.getScaledInstance(pic.getWidth(), pic.getHeight(),pic.CENTER);
							ImageIcon profpic = new ImageIcon(Imag);
							System.out.println(profpic.getImage());
							pic.setIcon(profpic);
							evidDetail.add(pic);
							view3.add(evidDetail);
						}catch(Exception e1) {
							JOptionPane.showMessageDialog(view1, "UNABLE TO LOAD ");
						}
					}else {
						JOptionPane.showMessageDialog(view1, "PLEASE UPLOAD JPG , JPEG OR PNG FILE. ");
					}
					
				}
				
			}
			
		});
		
		add(view3);
		view3.setVisible(false);
		
		
		
		
		nextBt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				report.fullName = fullnamefield.getText();
				report.dob = DOBFIeld.getText();
				report.Crtadd = AddressFIeld.getText();
				report.homeAdd = homeAddressFIeld.getText();
				try {
					report.phno = Integer.parseInt(phnoFIeld.getText());
					report.otherPhno = Integer.parseInt(phnoFIeld2.getText());
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(view1, "PLEASE ENTER CORRECT PHONE NUMBER ");
				}
				report.email = emailFIeld.getText();
				
				report.fatherName = fatherNameFIeld.getText();
				report.motherName = mothernameFIeld.getText();
				if(m.isSelected()) {
					report.gender = "Male";
				}else if(f.isSelected()) {
					report.gender = "Female";
				}else if(others.isSelected()){
					report.gender = "OTHERS";
				}else {
					JOptionPane.showMessageDialog(view1, "PLEASE FILL ALL THE DETAIL");
				}
				if(report.fullName == null || report.dob == null || report.Crtadd == null || report.homeAdd == null || report.email == null) {
					JOptionPane.showMessageDialog(view1, "PLEASE FILL ALL THE DETAIL");
				}
				else if(pinCdFIeld.getText().length() != 7) {
					JOptionPane.showMessageDialog(view1, "PLEASE ENTER CORRECT PIN CODE ");
				}else {
					view2.add(viewNav);
					view1.setVisible(false);
					view2.setVisible(true);
				}
			}
			
		});
		
		backBt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
				view1.add(viewNav);
				view1.setVisible(true);
				view2.setVisible(false);
				
			}
			
		});
		
		nextBt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				report.subject = subjectField1.getText();
				report.dOoc = drfield.getText();
				report.addInciden = AddressIFIeld.getText();
				report.convict = CAFIeld.getText();
				try {
					report.pinCode = Integer.parseInt(PCF.getText());
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(view1, "PLEASE ENTER CORRECT PIN CODE ");
				}
				report.witName = witnessFIeld.getText();
				report.descr = FulldescField.getText();
				
				if(report.subject == null || report.dOoc == null || report.addInciden == null || report.convict == null || report.witName == null || report.descr == null) {
					JOptionPane.showMessageDialog(view1, "PLEASE FILL ALL THE DETAIL");
				}else if(PCF.getText().length() != 7) {
					JOptionPane.showMessageDialog(view1, "PLEASE ENTER CORRECT PIN CODE ");
				}else {
					view3.add(viewNav);
					view2.setVisible(false);
					view3.setVisible(true);
				}
			}
			
		});
		
		backBt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view2.add(viewNav);
				view2.setVisible(true);
				view3.setVisible(false);
				
			}
			
		});
		
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				report.evidDet = evidetField.getText();
				
				if(report.evidDet == null) {
					JOptionPane.showMessageDialog(view1, "PLEASE FILL ALL THE DETAIL");
				}else {
					try {
						report.postData();
						JOptionPane.showMessageDialog(view1, " SUCESSFULLY FIR REGISTERED ");
						dispose();
					}catch(Exception e4) {
						JOptionPane.showMessageDialog(view1, "UNABALE TO POST DATA ");
						System.out.println(e4);
					}
				}
				
			}
			
		});
		
		
		
		//BODY ENDS
		
		
		//FOOTTER
		
		JPanel fotter = new JPanel();
		fotter.setBounds(0,830,1650,100);
		fotter.setBackground(Color.BLACK);
		fotter.setLayout(null);
		String fotterText = "Project By: \n"+ "Umesh Kumar(20MIS0187) \n"+ "Akanksha Hotta(20MIS0137) ";
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

	
}
