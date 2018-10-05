package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

 public class ATM_Panel extends JFrame implements ActionListener{
	
	
	public static void main(String[]args){
	ATM_Panel panel = new ATM_Panel();
	panel.setSize(330,300);
	panel.setVisible(true);
	panel.setResizable(false);
	panel.setLocation(400,250);
	}
	
	JButton btnBals = new JButton("Bal.Inquiry");
	JButton btnDep = new JButton("Deposit");
	JButton btnWid = new JButton("Withdraw");
	JButton btntrans = new JButton("Transfer");
	JButton btnLogOut = new JButton("logout");
	
	
	Connection cn;
	Statement st;
	PreparedStatement ps;
	




	
	public ATM_Panel() {
		super("ATM");
	
		JPanel pane = new JPanel();
		pane.setLayout(null);
		
	 	
	
	  	
			
		btnBals.setBounds(15,60,100,25);
		pane.add(btnBals);
		btnBals.addActionListener(this);
		btnBals.setForeground(Color.yellow);
		btnBals.setBackground(Color.black);
		
		btntrans.setBounds(15,120,100,25);
		pane.add(btntrans);
		btntrans.addActionListener(this);	
		btntrans.setForeground(Color.yellow);
		btntrans.setBackground(Color.black);
		
		btnDep.setBounds(210,60,100,25);
		pane.add(btnDep);
		btnDep.addActionListener(this);
		btnDep.setForeground(Color.yellow);
		btnDep.setBackground(Color.black);

		btnWid.setBounds(210,120,100,25);
		pane.add(btnWid);
		btnWid.addActionListener(this);	
		btnWid.setForeground(Color.yellow);	
		btnWid.setBackground(Color.black);
		
		btnLogOut.setBounds(125,190,80,25);
		pane.add(btnLogOut);
		btnLogOut.addActionListener(this);
		
		
		JLabel lbl = new JLabel(new ImageIcon("back.jpg"));
		
		lbl.setBounds(0,0,330,300);
		pane.add(lbl);
		
		setContentPane(pane);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		pane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Select Transaction"));
		
		
	}

			public void actionPerformed(ActionEvent e){

				Object source = e.getSource();
				
				if(source == btnBals){			
				
					Balance_Enquiry be=new Balance_Enquiry();
		
					be.setLocation(400,250);
					be.setSize(250,200);
					be.setTitle("Balance Inquiry");
					be.setResizable(false);
					be.setVisible(true);
					dispose();
				}
				if(source == btnDep){
				
					Cash_Deposit log=new Cash_Deposit();
	
					log.setLocation(400,250);
					log.setSize(250,200);
					log.setResizable(false);
					log.setVisible(true);
					dispose();
				}
				if(source == btnWid){
					WDraw_trans log=new WDraw_trans();
		
					log.setLocation(400,250);
					log.setSize(250,200);
					log.setResizable(false);
					log.setVisible(true);

					dispose();
				
				}	
			
				if(source == btntrans){
					Cash_Transfer log=new Cash_Transfer();
			
					log.setLocation(400,250);
					log.setSize(500,250);
					log.setResizable(false);
					log.setVisible(true);
					dispose();		
				}
				
		
				if(source == btnLogOut){
					
					int n=JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
					//		JOptionPane.showMessageDialog(null,"Good Bye","ATM",JOptionPane.INFORMATION_MESSAGE);
					//		System.exit(0);
						Login log=new Login();
		
						log.setLocation(400,250);
						log.setSize(250,150);
						log.setTitle("Log-In");
						log.setResizable(false);
						log.setVisible(true);
						dispose();
						}
				}	
       }
 
 }