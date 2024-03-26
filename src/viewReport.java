import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;

public class viewReport extends JFrame{

	viewReport(int adCdID){
		//NAVBAR
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
				
		//VIEW 
				 
		JPanel view = new JPanel();
		view.setLayout(null);
		view.setBounds(385,115,920,670);
		view.setBackground(Color.WHITE);
		
		JLabel header1 = new JLabel("VIEW REPORT");
		header1.setFont(new Font("Poppins", Font.PLAIN, 20));
		header1.setForeground(Color.WHITE);
		header1.setBounds(20,30,300,20);
		view.add(header1);
		
		JLabel subheader1 = new JLabel("ALL THE FIRs");
		subheader1.setFont(new Font("Poppins", Font.PLAIN, 12));
		subheader1.setForeground(Color.WHITE);
		subheader1.setBounds(20,38,300,50);
		view.add(subheader1);
		
		String column[] = {"FIR ID","SUBJECT","STATUS"};
		String data[][] = new String[100][100];
		int ct = 0;
		
		try {
			Connection con = DriverManager.getConnection(keys.url,keys.uname,keys.pass);
			
			PreparedStatement pst = con.prepareStatement("select * from FIRDetail where adCdCit = ?;");
			if(Constatnts.officer_status) {
				pst = con.prepareStatement("select * from FIRDetail where adCdOff = ?;");
			}
			pst.setInt(1,adCdID);
			ResultSet rs;
			rs = pst.executeQuery();
			while(rs.next()) {
				String ft = rs.getString("FIRID");
				String sd = rs.getString("subject");
				String td = rs.getString("status");
				String temp[] = {ft,sd,td};
				data[ct] = temp;
				ct++;
			}
			con.close();
			
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(view, "UNABLE TO LOAD DATA");
		}
		
		
		
		JTable firTable = new JTable(data,column){
	         public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	          }
	       };
		firTable.setBounds(0,100,920,670);
		firTable.setShowGrid(true);
		firTable.getColumnModel().getColumn(0).setPreferredWidth(80);
		firTable.getColumnModel().getColumn(2).setPreferredWidth(170);
		firTable.getColumnModel().getColumn(1).setPreferredWidth(670);
		firTable.getTableHeader().setBackground(Color.black);
		firTable.getTableHeader().setForeground(Color.WHITE);
		firTable.getTableHeader().setFont(new Font("Poppins", Font.PLAIN, 24));
		firTable.setRowHeight(40);
		firTable.setFont(new Font("Poppins", Font.PLAIN, 18));
		firTable.setBackground(Color.WHITE);
		firTable.setGridColor(Color.BLACK);
		
		JScrollPane sp = new JScrollPane(firTable);
		sp.setSize(900,600);
		sp.setBounds(0,100,900,670);
		view.add(sp);
		
		
		view.add(viewNav);
		view.setVisible(true);
		add(view);
		firTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int FIRID = Integer.parseInt(data[firTable.getSelectedRow()][0]);
				RecordsView rv = new RecordsView(FIRID);
				dispose();
			}
			
		});
		
		//endBody
		
		//FOOTTER
		
		JPanel fotter = new JPanel();
		fotter.setBounds(0,830,1650,100);
		fotter.setBackground(Color.BLACK);
		fotter.setLayout(null);
		String fotterText = "Project By: \n"
				+ "Umesh Kumar(20MIS0187) \n"
				+ "Akanksha Hotta(20MIS0137) ";
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
