import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;


public class RecordsView extends JFrame {

	RecordsView(int FIRID){
		System.out.println(FIRID);
		
		
		FIR report = new FIR();
		try {
			report.fetchData(FIRID);
		} catch (SQLException e1) {
			System.out.println(e1);
			JOptionPane.showMessageDialog(this, "UNABLE FETCH THE DATA");
		}
		
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
		
		JPanel view1 = new JPanel();
		view1.setLayout(null);
		view1.setBounds(385,115,920,670);
		view1.setBackground(Color.WHITE);
		
		
		JLabel header1 = new JLabel("PERSONAL INFORMATION");
		header1.setFont(new Font("Poppins", Font.PLAIN, 20));
		header1.setForeground(Color.WHITE);
		header1.setBounds(20,30,300,20);
		view1.add(header1);
		
		JLabel subheader1 = new JLabel("DETAILS OF COMPLAINER");
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
		
		JLabel fullnamefield = new JLabel(report.fullName);
		fullnamefield.setBounds(20,160,400,28);
		fullnamefield.setFont(new Font("Poppins", Font.PLAIN, 16));
		view1.add(fullnamefield);
		
		JLabel Gender = new JLabel("GENDER ");
		Gender.setFont(new Font("Poppins", Font.PLAIN, 16));
		Gender.setBounds(20,200,150,20);
		view1.add(Gender);
		
		JLabel m = new JLabel(report.gender);
		m.setFont(new Font("Poppins",Font.PLAIN,12));
		m.setBounds(20,220,80,30);
		view1.add(m);
		
		JLabel DOB = new JLabel("DATE OF BIRTH (DD/MM/YYYY)");
		DOB.setFont(new Font("Poppins", Font.PLAIN, 16));
		DOB.setBounds(20,260,300,20);
		view1.add(DOB);
		
		JLabel DOBFIeld = new JLabel(report.dob);
		DOBFIeld.setBounds(18,290,400,28);
		DOBFIeld.setFont(new Font("Poppins", Font.PLAIN, 16));
		view1.add(DOBFIeld);

		JLabel Address = new JLabel("CURRENT ADDRESS");
		Address.setFont(new Font("Poppins", Font.PLAIN, 16));
		Address.setBounds(20,330,300,20);
		view1.add(Address);
		
		JLabel AddressFIeld = new JLabel(report.Crtadd);
		AddressFIeld.setBounds(18,360,400,60);
		AddressFIeld.setFont(new Font("Poppins", Font.PLAIN, 16));
		view1.add( AddressFIeld);
		
		JLabel homeAddress = new JLabel("HOME ADDRESS");
		homeAddress.setFont(new Font("Poppins", Font.PLAIN, 16));
		homeAddress.setBounds(500,330,300,20);
		view1.add(homeAddress);
		
		JLabel homeAddressFIeld = new JLabel(report.homeAdd);
		homeAddressFIeld.setBounds(498,360,400,60);
		homeAddressFIeld.setFont(new Font("Poppins", Font.PLAIN, 16));
		view1.add( homeAddressFIeld);
		
		JLabel phno = new JLabel("PHONE NUMBER");
		phno.setFont(new Font("Poppins", Font.PLAIN, 16));
		phno.setBounds(20,430,300,20);
		view1.add(phno);
		
		JLabel phnoFIeld = new JLabel(Integer.toString(report.phno));
		phnoFIeld.setBounds(18,460,400,28);
		phnoFIeld.setFont(new Font("Poppins", Font.PLAIN, 16));
		view1.add(phnoFIeld);
		
		JLabel phno2 = new JLabel("OTHER PHONE NUMBER (if any)");
		phno2.setFont(new Font("Poppins", Font.PLAIN, 16));
		phno2.setBounds(500,430,300,20);
		view1.add(phno2);
		
		JLabel phnoFIeld2 = new JLabel(Integer.toString(report.otherPhno));
		phnoFIeld2.setBounds(498,460,400,28);
		phnoFIeld2.setFont(new Font("Poppins", Font.PLAIN, 16));
		view1.add(phnoFIeld2);
		
		JLabel email = new JLabel("EMAIL ID");
		email.setFont(new Font("Poppins", Font.PLAIN, 16));
		email.setBounds(20,500,300,20);
		view1.add(email);
		
		JLabel emailFIeld = new JLabel(report.email);
		emailFIeld.setBounds(18,530,400,28);
		emailFIeld.setFont(new Font("Poppins", Font.PLAIN, 16));
		view1.add(emailFIeld);
		
		JLabel fatherName = new JLabel("FATHER'S NAME ");
		fatherName.setFont(new Font("Poppins", Font.PLAIN, 16));
		fatherName.setBounds(500,500,300,20);
		view1.add(fatherName);
		
		JLabel fatherNameFIeld = new JLabel(report.fatherName);
		fatherNameFIeld.setBounds(498,530,400,28);
		fatherNameFIeld.setFont(new Font("Poppins", Font.PLAIN, 16));
		view1.add(fatherNameFIeld);
		
		JLabel pinCd = new JLabel("PIN CODE");
		pinCd.setFont(new Font("Poppins", Font.PLAIN, 16));
		pinCd.setBounds(20,570,300,20);
		view1.add(pinCd);
		
		JLabel pinCdFIeld = new JLabel(Integer.toString(report.pinCode));
		pinCdFIeld.setBounds(18,600,400,28);
		pinCdFIeld.setFont(new Font("Poppins", Font.PLAIN, 16));
		view1.add(pinCdFIeld);
		
		JLabel mothername = new JLabel("MOTHER'S NAME");
		mothername.setFont(new Font("Poppins", Font.PLAIN, 16));
		mothername.setBounds(500,570,300,20);
		view1.add(mothername);
		
		JLabel mothernameFIeld = new JLabel(report.motherName);
		mothernameFIeld.setBounds(498,600,400,28);
		mothernameFIeld.setFont(new Font("Poppins", Font.PLAIN, 16));
		view1.add(mothernameFIeld);
		
		
		JPanel profileImage = new JPanel();
		profileImage.setLayout(null);
		profileImage.setBounds(680,120,200,200);
		
		
		
		File f=new File("/Users/umesh/Desktop/SatyaVachan/profic.png");
		try {
			FileOutputStream fs=new FileOutputStream(f);
			byte b[] = report.blob1.getBytes(1, (int)report.blob1.length());
			fs.write(b);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			System.out.println(e2);
		}
		
		BufferedImage img1;
		try {
			JLabel pic = new JLabel();
			pic.setBounds(0,0,200,200);
			img1 = ImageIO.read(new File("/Users/umesh/Desktop/SatyaVachan/profic.png"));
			Image Imag = img1.getScaledInstance(pic.getWidth(), pic.getHeight(),pic.CENTER);
			ImageIcon profIcon = new ImageIcon(Imag);
			pic.setIcon(profIcon);
			profileImage.add(pic);
			profileImage.setBackground(Color.WHITE);
			view1.add(profileImage);
		} catch (IOException e) {
			System.out.println(e);
		}
		view1.add(profileImage);
		
		//view2
		
				JPanel view2 = new JPanel();
				view2.setLayout(null);
				view2.setBounds(385,115,920,670);
				view2.setBackground(Color.WHITE);
				
				JLabel header2 = new JLabel("FIR REPORT");
				header2.setFont(new Font("Poppins", Font.PLAIN, 20));
				header2.setForeground(Color.WHITE);
				header2.setBounds(20,30,300,20);
				view2.add(header2);
				
				JLabel subheader2 = new JLabel("COMPLAINS");
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
				
				JLabel subjectField1 = new JLabel(report.subject);
				subjectField1.setBounds(18,160,400,40);
				subjectField1.setFont(new Font("Poppins", Font.PLAIN, 16));
				view2.add(subjectField1);
				
				JLabel dateR = new JLabel("DATE OF OCCURANCE (DD/MM/YYYY)");
				dateR.setFont(new Font("Poppins", Font.PLAIN, 16));
				dateR.setBounds(20,260,300,20);
				view2.add(dateR);
				
				JLabel drfield = new JLabel(report.dOoc);
				drfield.setBounds(18,290,400,28);
				drfield.setFont(new Font("Poppins", Font.PLAIN, 16));
				view2.add(drfield);
				
				JLabel AddressI = new JLabel("ADDRESS OF INCIDENT");
				AddressI.setFont(new Font("Poppins", Font.PLAIN, 16));
				AddressI.setBounds(20,330,300,20);
				view2.add(AddressI);
				
				JLabel AddressIFIeld = new JLabel(report.addInciden);
				AddressIFIeld.setBounds(18,360,400,60);
				AddressIFIeld.setFont(new Font("Poppins", Font.PLAIN, 16));
				view2.add( AddressIFIeld);
				
				JLabel complaintAgainst = new JLabel("COMPLAINT AGAINST (If known)");
				complaintAgainst.setFont(new Font("Poppins", Font.PLAIN, 16));
				complaintAgainst.setBounds(20,430,300,20);
				view2.add(complaintAgainst);
				
				JLabel CAFIeld = new JLabel(report.convict);
				CAFIeld.setBounds(18,460,400,28);
				CAFIeld.setFont(new Font("Poppins", Font.PLAIN, 16));
				view2.add(CAFIeld);
				
				JLabel PC = new JLabel("PIN CODE");
				PC.setFont(new Font("Poppins", Font.PLAIN, 16));
				PC.setBounds(20,500,300,20);
				view2.add(PC);
				
				JLabel PCF = new JLabel(Integer.toString(report.pinCode));
				PCF.setBounds(18,530,400,28);
				PCF.setFont(new Font("Poppins", Font.PLAIN, 16));
				view2.add(PCF);
				
				JLabel witness = new JLabel("WITNESS NAME (If any)");
				witness.setFont(new Font("Poppins", Font.PLAIN, 16));
				witness.setBounds(20,570,300,20);
				view2.add(witness);
				
				JLabel witnessFIeld = new JLabel(report.witName);
				witnessFIeld.setBounds(18,600,400,28);
				witnessFIeld.setFont(new Font("Poppins", Font.PLAIN, 16));
				view2.add(witnessFIeld);
				
				JLabel FullDesc = new JLabel("FULL DESCRIPTION");
				FullDesc.setFont(new Font("Poppins", Font.PLAIN, 16));
				FullDesc.setBounds(500,135,150,20);
				view2.add(FullDesc);
				
				JLabel FulldescField = new JLabel(report.descr);
				FulldescField.setBounds(498,160,400,445);
				FulldescField.setFont(new Font("Poppins", Font.PLAIN, 16));
				view2.add(FulldescField);
				
				
				
				add(view2);
				view2.setVisible(false);
				
				//view3
				
				JPanel view3 = new JPanel();
				view3.setLayout(null);
				view3.setBounds(385,115,920,670);
				view3.setBackground(Color.WHITE);
				
				JLabel header3 = new JLabel("FIR DETAILS");
				header3.setFont(new Font("Poppins", Font.PLAIN, 20));
				header3.setForeground(Color.WHITE);
				header3.setBounds(20,30,300,20);
				view3.add(header3);
				
				JLabel subheader3 = new JLabel("EVIDENCE INFORMATION");
				subheader3.setFont(new Font("Poppins", Font.PLAIN, 12));
				subheader3.setForeground(Color.WHITE);
				subheader3.setBounds(20,38,300,50);
				view3.add(subheader3);
				
				String stat[] = {"REPORTED","OPEN","CLOSED","RE-OPEN"};
				
				JComboBox submit = new JComboBox(stat);
				submit.setFont(new Font("Poppins", Font.PLAIN, 14));
				submit.setForeground(Color.RED);
				submit.setBounds(750,26,100,50);
				submit.setSize(150,50);
				view3.add(submit);
				
				if(Constatnts.officer_status) {
					submit.setVisible(true);
				}
				else {
					submit.setVisible(false);
				}
				
				JButton backBt3 = new JButton("< BACK");
				backBt3.setFont(new Font("Poppins", Font.PLAIN, 14));
				backBt3.setForeground(Color.BLUE);
				backBt3.setBounds(620,26,100,50);
				view3.add(backBt3);
				
				JLabel evidenceDetail = new JLabel("EVIDENCE DETAIL");
				evidenceDetail.setFont(new Font("Poppins", Font.PLAIN, 16));
				evidenceDetail.setBounds(20,135,150,20);
				view3.add(evidenceDetail);
				
				JLabel evidetField = new JLabel(report.evidDet);
				evidetField.setBounds(18,160,400,40);
				evidetField.setFont(new Font("Poppins", Font.PLAIN, 16));
				view3.add(evidetField);
				
				JLabel UpldEvid = new JLabel("UPLOAD EVIDENCE");
				UpldEvid.setFont(new Font("Poppins", Font.PLAIN, 16));
				UpldEvid.setBounds(20,210,300,20);
				view3.add(UpldEvid);
				
				
				JPanel evidDetail = new JPanel();
				evidDetail.setLayout(null);
				evidDetail.setBounds(50,290,800,340);
				
				File f1=new File("/Users/umesh/Desktop/SatyaVachan/evid.png");
				try {
					FileOutputStream fs1=new FileOutputStream(f1);
					byte b1[] = report.blob2.getBytes(1, (int)report.blob2.length());
					fs1.write(b1);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					System.out.println(e2);
				}
				
				BufferedImage img2;
				try {
					JLabel pic2 = new JLabel();
					pic2.setBounds(0,0,800,340);
					img2 = ImageIO.read(new File("/Users/umesh/Desktop/SatyaVachan/evid.png"));
					Image Imag = img2.getScaledInstance(pic2.getWidth(), pic2.getHeight(),pic2.CENTER);
					ImageIcon evidIcon = new ImageIcon(Imag);
					pic2.setIcon(evidIcon);
					evidDetail.add(pic2);
					evidDetail.setBackground(Color.WHITE);
					view3.add(evidDetail);
				} catch (IOException e) {
					System.out.println(e);
				}
				
				view3.add(evidDetail);		
			add(view3);
			view3.setVisible(false);
				
		
		nextBt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view1.setVisible(false);
				view2.setVisible(true);
				view2.add(viewNav);
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
				view2.setVisible(false);
				view3.setVisible(true);
				view3.add(viewNav);
			}
			
		});
		backBt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				view2.setVisible(true);
				view3.setVisible(false);
				view2.add(viewNav);
			}
			
		});
		
		submit.addItemListener( new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				int st = submit.getSelectedIndex();
				Connection con;
				try {
					con = DriverManager.getConnection(keys.url,keys.uname,keys.pass);
					PreparedStatement pst = con.prepareStatement("UPDATE FIRDetail SET status = ? WHERE FIRID = ?;");
					pst.setString(1, stat[st]);
					pst.setInt(2, FIRID);
					int i = pst.executeUpdate();
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
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
