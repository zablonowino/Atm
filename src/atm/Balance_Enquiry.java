package atm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Balance_Enquiry extends JFrame implements ActionListener{
	
	JPasswordField txtuser=new JPasswordField(25);
	JTextField txtpass=new JTextField(25);
	JLabel lbluser=new JLabel("Pin Number: ");
	JLabel lblbal=new JLabel("Balanced");
	JButton btnOk=new JButton("Back to Menu");
	JButton btnbal=new JButton("Show Balance");
	

	Connection cn;
	ResultSet rset;
	Statement st;
	
	public Balance_Enquiry(){
		
		JPanel pane=new JPanel();
		pane.setLayout(null);
		//----Adding Components into your Frame
		pane.add(txtuser);
		pane.add(txtpass);
		pane.add(lbluser);
		pane.add(lblbal);	
		pane.add(btnOk);
		pane.add(btnbal);
		//-----Setting the location of the components
		lbluser.setBounds(10,20,80,20);
		lblbal.setBounds(10,40,80,20);
		txtuser.setBounds(100,20,100,20);
		txtpass.setBounds(100,40,100,20);
		btnOk.setBounds(80,120,140,20);
		btnbal.setBounds(100,70,100,20);
		//-----Adding the an actionlistener to the buttons
		btnOk.addActionListener(this);
		btnbal.addActionListener(this);
		
		txtpass.setEditable(false);
		btnOk.setToolTipText("Click To Back to Main Menu");
			
		btnOk.setForeground(Color.yellow);
		btnbal.setForeground(Color.yellow);
		btnOk.setBackground(Color.black);
		btnbal.setBackground(Color.black);

		setContentPane(pane);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//
		//JLabel lbl = new JLabel(new ImageIcon("back.jpg"));
		
		//lbl.setBounds(0,0,250,200);
		//pane.add(lbl);

		
		
	}
	
	public void actionPerformed(ActionEvent e){
		Object source=e.getSource();
		
		if(source==btnOk){
			ATM_Panel panel = new ATM_Panel();
			panel.setSize(330,300);
			panel.setVisible(true);
			panel.setResizable(false);
			panel.setLocation(400,250);
			dispose();				
						
						
		}else if(source==btnbal){
			try{
				st= cn.createStatement();	
					ResultSet rs=st.executeQuery("SELECT * FROM tbl_list WHERE Pin ='"+txtuser.getText()+"'");
						while(rs.next()){
							txtpass.setText(rs.getString(9));
						
						JOptionPane.showMessageDialog(null,"Record Found.","ATM System",JOptionPane.INFORMATION_MESSAGE);
					
						}
					st.close();
				}
				catch(SQLException s){
					System.out.println("No record found!\n\n\n");
					System.out.println("SQL Error" + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
				}
				catch(Exception x){
					System.out.println("Error" + x.toString()+" " + x.getMessage());
				}
			
		}
	}
	
	public static void main(String[]args){
		Balance_Enquiry log=new Balance_Enquiry();
		
		log.setLocation(400,250);
		log.setSize(270,200);
		log.setTitle("Balance Inquiry");
		log.setResizable(false);
		log.setVisible(true);
		
	
	}
}