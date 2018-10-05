package atm;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Close_Account extends JFrame implements ActionListener{
	
	JTextField txtuser=new JTextField(25);
	JPasswordField txtpass=new JPasswordField(25);
	JLabel lbluser=new JLabel("User Name: ");
	JLabel lblpass=new JLabel("Pin Number");
	JButton btnOk=new JButton("Back to Menu");
	JButton btnDel=new JButton("Close Account");
	

	Connection conn = null;
	//ResultSet rs;
	Statement state= null;
	PreparedStatement pst = null;
	public Close_Account(){
		
		JPanel pane=new JPanel();
		pane.setLayout(null);
		//----Adding Components into your Frame
		pane.add(txtuser);
		pane.add(txtpass);
		pane.add(lbluser);
		pane.add(lblpass);	
		pane.add(btnOk);
		pane.add(btnDel);
		//-----Setting the location of the components
		lbluser.setBounds(10,20,80,20);
		lblpass.setBounds(10,40,80,20);
		txtuser.setBounds(100,20,100,20);
		txtpass.setBounds(100,40,100,20);
		btnOk.setBounds(80,120,140,20);
		btnDel.setBounds(100,70,100,20);
		//-----Adding the an actionlistener to the buttons
		btnOk.addActionListener(this);
		btnDel.addActionListener(this);
		
	
			btnOk.setToolTipText("Click To Back to Menu");
		setContentPane(pane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lbl = new JLabel(new ImageIcon("back.jpg"));
		
		lbl.setBounds(0,0,250,200);
		pane.add(lbl);


        }	
	public void actionPerformed(ActionEvent e){
		Object source=e.getSource();
		
		if(source==btnOk){
	ATM_Panel panel = new ATM_Panel();
	panel.setSize(330,300);
	panel.setVisible(true);
	panel.setResizable(false);
	panel.setLocation(200,200);
	dispose();				
						
						
			}else if(source==btnDel){
			try{
				
				
				state=conn.createStatement();
				String strUser="";
				String strPass="";
				
				ResultSet rset=state.executeQuery("SELECT * FROM tbl_list WHERE UserName='"+txtuser.getText()+"'");
				while(rset.next()){
					strUser=rset.getString(1);
					strPass=rset.getString(5);
				}
				
				if(strUser.equals(txtuser.getText())){
					if(strPass.equals(txtpass.getText())){
						
						pst = conn.prepareStatement("DELETE * FROM tbl_list WHERE UserName ='"+ txtuser.getText() + "'");
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Your Account has been successfully Deleted.","ATM",JOptionPane.INFORMATION_MESSAGE);
						txtuser.requestFocus(true);
					//	clear();
					//	st.close();
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
	}
	
	public static void main(String[]args){
		Close_Account log=new Close_Account();
		
		log.setLocation(400,250);
		log.setSize(250,200);
		log.setTitle("Blocking Account");
		log.setResizable(false);
		log.setVisible(true);
		
	
}
}