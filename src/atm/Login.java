package atm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JTextField txtuser=new JTextField(25);
	JPasswordField txtpass=new JPasswordField(25);
	JLabel lbluser=new JLabel("Username: ");
	JLabel lblpass=new JLabel("Pin Number: ");
	JButton btnOk=new JButton("OK");
	JButton btnRegister=new JButton("Register");
	//JButton btnBlock = new JButton("Lock Account >>");

	Connection cn;
	ResultSet rs;
	Statement st;
	PreparedStatement ps;
        
	public Login(){
		
		JPanel pane=new JPanel();
		pane.setLayout(null);
		//----Adding Components into the Frame
		pane.add(txtuser);
		pane.add(txtpass);
		pane.add(lbluser);
		pane.add(lblpass);	
		pane.add(btnOk);
		pane.add(btnRegister);
		lbluser.setBounds(10,20,80,20);
		lblpass.setBounds(10,40,80,20);
		txtuser.setBounds(100,20,100,20);
		txtpass.setBounds(100,40,100,20);
		btnOk.setBounds(50,70,75,20);
		btnRegister.setBounds(125,70,83,20);
		btnOk.addActionListener(this);
		btnRegister.addActionListener(this);
		
			

		setContentPane(pane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			JLabel lbl = new JLabel(new ImageIcon("back.jpg"));
		
		lbl.setBounds(0,0,250,150);
		pane.add(lbl);

	}
	
	public void actionPerformed(ActionEvent e){
		Object source=e.getSource();
		
		if(source==btnOk){
			try{
                            String sql = "Select * from tbl_list where Username =? and Password = ?";
                            
                                cn = CreateDB.getConnection();
                                ps = cn.prepareStatement(sql);
                                ps.setString(1, txtuser.getText());
                                ps.setString(2, txtpass.getText());
                                
                                rs=ps.executeQuery();
                                
                                if(rs.next()){JOptionPane.showMessageDialog(null, "Welcome!!");
                                
                                }
                            
				String str1=txtuser.getText();
				String str2=txtpass.getText();
				if((str1.length()==0 || str2.length()==0)){
    					JOptionPane.showMessageDialog(null,"Warning","Processing Error",JOptionPane.WARNING_MESSAGE);
    				}
    				else{
				st=cn.createStatement();
				String strUser="";
				String strPass="";
				
				ResultSet rs=st.executeQuery("SELECT * FROM tbl_list WHERE UserName='"+str1+"'");
				while(rs.next()){
					strUser=rs.getString(1);
					strPass=rs.getString(4);
				}
				
				
				
				
				
				st.close();
		
				if(strUser.equals(str1)){
					if(strPass.equals(str2)){
						
					
    					
						JOptionPane.showMessageDialog(null,"Welcome "+txtuser.getText(),"Welcome",JOptionPane.INFORMATION_MESSAGE);
						
						ATM_Panel panel = new ATM_Panel();
						panel.setSize(330,300);
						panel.setVisible(true);
						panel.setResizable(false);
						panel.setLocation(400,250);
						dispose();
						
					
					}else{
						JOptionPane.showMessageDialog(null,"Please Insert Correct Password!","Security Pass",JOptionPane.WARNING_MESSAGE);
						txtpass.requestFocus(true);
					}
				}else{
					JOptionPane.showMessageDialog(null,"Username is incorrect!","Security Pass",JOptionPane.WARNING_MESSAGE);
					txtuser.requestFocus(true);
				}
    				}	
			}catch(SQLException w){
			}
		}else if(source==btnRegister){
			
				Register panel = new Register();
				panel.setSize(370,400);
				panel.setVisible(true);
				panel.setResizable(false);
				panel.setLocation(400,250);
				dispose();
		
		}
		
	/*	else if(source == btnBlock){
			
			int n=JOptionPane.showConfirmDialog(null,"If you lock this account,you cannot access this Anymore.Are you sure you want to Lock this account?","Warning",JOptionPane.YES_NO_OPTION);
			if(n==JOptionPane.YES_OPTION){
			
		try{
				
				
				st=cn.createStatement();
				String strUser="";
				String strPass="";
				
				ResultSet rs=st.executeQuery("SELECT * FROM 
				
				 WHERE UserName='"+txtuser.getText()+"'");
				while(rs.next()){
					strUser=rs.getString(1);
					strPass=rs.getString(5);
				}
				
				if(strUser.equals(txtuser.getText())){
					if(strPass.equals(txtpass.getText())){
						
						ps = cn.prepareStatement("DELETE FROM tbl_Info WHERE UserName ='"+ txtuser.getText() + "'");
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Your Account has been successfully Lock.","ATM",JOptionPane.INFORMATION_MESSAGE);
						txtuser.requestFocus(true);
					
					txtuser.setText("");
					txtpass.setText("");
					}else{
						JOptionPane.showMessageDialog(null,"Username found but the Pin Number is incorrect!","Security Pass",JOptionPane.WARNING_MESSAGE);
						txtpass.requestFocus(true);
					}
				}else{
					JOptionPane.showMessageDialog(null,"Username is incorrect!","Security Pass",JOptionPane.WARNING_MESSAGE);
					txtuser.requestFocus(true);
				}
					}
					catch(SQLException s){
					System.out.print("SQL statement is not executed!");
				}
						catch(Exception j){
						j.printStackTrace();
				}
			
			}
			}*/
	}
	
	public static void main(String[]args){
		Login log=new Login();
		
		log.setLocation(400,250);
		log.setSize(250,150);
		log.setTitle("Login");
		log.setResizable(false);
		log.setVisible(true);
		
	
	}
}