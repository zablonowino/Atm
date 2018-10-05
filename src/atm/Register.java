package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

 public class Register extends JFrame implements ActionListener{
	
	
	public static void main(String[]args){
	Register panel = new Register();
	panel.setSize(370,400);
	panel.setVisible(true);
	panel.setResizable(false);
	panel.setLocation(400,250);
	}
	
	
	Font f1 = new Font("", Font.BOLD, 10);
	JLabel lblUser = new JLabel("User Name ",JLabel.RIGHT);	
	JLabel lblFName = new JLabel("First Name ",JLabel.RIGHT);
	JLabel lblVPin = new JLabel("Verify Pin Number ",JLabel.RIGHT);
	JLabel lblLName = new JLabel("Last Name ",JLabel.RIGHT);
	JLabel lblPin = new JLabel("Pin Number ",JLabel.RIGHT);
	//JLabel lblNatID = new JLabel("National ID ",JLabel.RIGHT);
	JLabel lblCash = new JLabel("Initial Deposit ",JLabel.RIGHT);
	
	
	
	JTextField txtUser = new JTextField(20);
	JTextField txtFName= new JTextField(20);
	JTextField txtLName = new JTextField(20);
	JPasswordField txtPin= new JPasswordField(4);
	JPasswordField txtVPin = new JPasswordField(4);
	//JTextField txtNatID = new JTextField(20);
	JTextField txtCash = new JTextField(20);
	
	JButton btnCret = new JButton(("Register"));
	
	
	
	Connection conn=null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement pst=null;


	
	public void clear(){
		
		txtUser.setText("");
		txtFName.setText("");
		txtPin.setText("");
		txtLName.setText("");
		txtVPin.setText("");
               // txtNatID.setText("");
                
	}
	
	public Register() {
		super("Banking Solutions");
	
		JPanel pane = new JPanel();
		pane.setLayout(null);
		
		
		
		lblUser.setBounds(5,50,120,25);
		pane.add(lblUser);
		txtUser.setBounds(125,50,150,25);
		pane.add(txtUser);
		
		lblFName.setBounds(5,85,120,25);
		pane.add(lblFName);
		txtFName.setBounds(125,85,150,25);
		pane.add(txtFName);
		
		lblLName.setBounds(5,120,120,25); 
		pane.add(lblLName);
		txtLName.setBounds(125,120,150,25); 
		pane.add(txtLName);
		
		lblPin.setBounds(5,155,120,25);
		pane.add(lblPin);
		txtVPin.setBounds(125,155,150,25);
		pane.add(txtVPin);
		
		lblVPin.setBounds(5,190,120,25);
		pane.add(lblVPin);
		txtPin.setBounds(125,190,150,25); 
		pane.add(txtPin);	
		
		//lblNatID.setBounds(5,225,120,25);
		//pane.add(lblNatID);
             //   txtNatID.setBounds(125,120,150,25); 
		//pane.add(txtNatID);
		//txtNatID.setBounds(125,120,150,25);
		//pane.add(txtNatID);	
		lblCash.setBounds(5,275,120,25);
		pane.add(lblCash);
		txtCash.setBounds(125,275,100,25);
		pane.add(txtCash);
			
		btnCret.setBounds(129,310,120,35);
		pane.add(btnCret);
		btnCret.addActionListener(this);
	
	
		JLabel lbl = new JLabel(new ImageIcon("background.gif"));
		
		lbl.setBounds(0,0,370,400);
		pane.add(lbl);
		
		setContentPane(pane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "User Registration"));
		
		
	}

			public void actionPerformed(ActionEvent e){

				Object source = e.getSource();
				if(source == btnCret){
                                    try{
                                        
                                    
	/**pst.setString(1, txtUser.getText());
	pst.setString(1, txtFName.getText());
	pst.setString(3, txtPin.getText());
	pst.setString(4, txtLName.getText());
	pst.setString (5, txtCash.getText());
        
        pst.executeUpdate();**/

		
	/**if((suser.length()==0 || sname.length()==0 || spin.length()==0 || slname.length()==0 || svpass.length()==0 )){
    					JOptionPane.showMessageDialog(null,"Some Fields are empty","WARNING",JOptionPane.WARNING_MESSAGE);
    				}
    else{
    		if(spin.equals(svpass)){
    			boolean xx = false;**/
    			
	
				
                                //st = CreateDB.getConnection();
                                conn = CreateDB.getConnection();
                                st= conn.createStatement();
                //rs=st.executeQuery("SELECT * FROM tbl_list WHERE Password = '");
					
						
								
	
				st= CreateDB.getConnection().createStatement();
                                st=conn.createStatement();
				
						
				pst = CreateDB.getConnection().prepareStatement("INSERT INTO tbl_list(UserName,FirstName,LastName,Password,Initial_Dep)VALUES(?,?,?,?,?)");		
				pst.setString(1,txtUser.getText());	
				pst.setString(2,txtFName.getText());
				pst.setString(3,txtLName.getText());
				pst.setString(4,txtPin.getText());
				//pst.setString(5,txtVPin.getText());
				//pst.setString(6,txtNatID.getText());
				pst.setString(5,txtCash.getText());
				
				
				//pst.executeUpdate();
                                //pst=conn.prepareStatement(sql);
                                pst.executeUpdate();
                                
                                if (txtVPin.getText() == null ? txtPin.getText() != null : !txtVPin.getText().equals(txtPin.getText())){
                        getToolkit().beep(); 
                      JOptionPane.showMessageDialog(this,"Passwords mismatch!");
                    txtPin.setBackground(Color.pink); 
                    txtVPin.setBackground(Color.pink); 
                    
               }else{
                    
               pst.executeUpdate(); 
               JOptionPane.showMessageDialog(this,txtUser.getText()+" Congratulations, Account Created");
               
                }
                              //  clear();
				
			
				//JOptionPane.showMessageDialog(null,"Account Created Succesfully.","ATM",JOptionPane.INFORMATION_MESSAGE);
				//txtUser.requestFocus(true);
				//st.close();
				clear();
				
				Login log=new Login();
					log.setLocation(400,250);
					log.setSize(250,150);
					log.setTitle("Log-In");
					log.setResizable(false);
					log.setVisible(true);
					dispose();
				}
				//}

				catch(SQLException sqlEx){
				JOptionPane.showMessageDialog(this,sqlEx.getMessage());
				}
						
					}
				}
				
				
    							

				
				
				
				
				
				
				
				}	
					
                                
                        
 