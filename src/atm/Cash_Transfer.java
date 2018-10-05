package atm;



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Cash_Transfer extends JFrame implements ActionListener{
	
	JPasswordField txtuser=new JPasswordField(25);
	JTextField txttransfer=new JTextField(25);
	JTextField txtwid=new JTextField(25);
	
	JPasswordField txtuser2=new JPasswordField(25);
	JTextField txttransfer2=new JTextField(25);
	JTextField txtwid2=new JTextField(25);
	
	JLabel lbluser=new JLabel("Pin Number: ");
	JLabel lbltransfer=new JLabel("Transfer: ");
	JLabel lblwid=new JLabel("Balanced: ");
	
	JLabel lbluser2=new JLabel("Account No.: ");
	JLabel lbltransfer2=new JLabel("Balanced: ");
	JLabel lblwid2=new JLabel("Balanced: ");
	
	JButton btnOk=new JButton("Back to Menu");
	JButton btnTransfer=new JButton("Transfer");
	JButton btnRegister2=new JButton("Balance");
	
//	JLabel lbltransferTo = new JLabel("Transfer to");
	JLabel lblyour = new JLabel("Your Account");
	JLabel lblReciever = new JLabel("Reciever Account");
	
        
	PreparedStatement ps;
        Connection conn;
	Statement state;
	PreparedStatement pst;
	ResultSet rset;
	
	public Cash_Transfer(){
		super("Transfer Fund Transaction");
		JPanel pane=new JPanel();
		pane.setLayout(null);
		//----Adding Components into your Frame
		pane.add(txtuser);
 		pane.add(txttransfer);
 		pane.add(txtwid);
		pane.add(lbluser);
 		pane.add(lbltransfer);
 		pane.add(lblwid);	
 		pane.add(txtuser2);
 		pane.add(txttransfer2);
 		pane.add(txtwid2);
		pane.add(lbluser2);
 		pane.add(lbltransfer2);
 		pane.add(lblwid2);	
		pane.add(btnOk);
		pane.add(btnTransfer);
		pane.add(btnRegister2);
	//	pane.add(lbltransferTo);
		pane.add(lblyour);
		pane.add(lblReciever);
		//-----Setting the location of the components
		lbluser.setBounds(10,40,80,20);
 		lbltransfer.setBounds(10,60,80,20);
 		lblwid.setBounds(600,80,80,20);
		txtuser.setBounds(100,40,100,20);
 		txttransfer.setBounds(600,80,100,20);
 		txtwid.setBounds(100,60,100,20);
 		
 		lbluser2.setBounds(270,40,80,20);
 		lbltransfer2.setBounds(270,60,80,20);
 		lblwid2.setBounds(670,80,80,20);
		txtuser2.setBounds(350,40,100,20);
 		txttransfer2.setBounds(650,80,100,20);
 		txtwid2.setBounds(350,60,100,20);
 		
 	//	lbltransferTo.setBounds(200,10,140,20);
 		lblyour.setBounds(100,10,140,20);
 		lblReciever.setBounds(350,10,140,20);
 		
		btnOk.setBounds(175,140,140,20);
		btnTransfer.setBounds(100,110,100,20);
		btnRegister2.setBounds(350,110,100,20);
		//-----Adding the an actionlistener to the buttons
		btnOk.addActionListener(this);
		btnTransfer.addActionListener(this);
		btnRegister2.addActionListener(this);
			txttransfer.setEditable(false);
			txttransfer2.setEditable(false);
			txtwid2.setEditable(false);
		setContentPane(pane);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		pane.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "Transfer Transaction"));
		
		btnTransfer.setToolTipText("Click First then Enter Your Money to Transfer");
		btnRegister2.setToolTipText("Click To display balance");
		btnOk.setToolTipText("Back to Menu");
		
		
		btnOk.setForeground(Color.yellow);
		btnTransfer.setForeground(Color.yellow);
		btnOk.setBackground(Color.black);
		btnTransfer.setBackground(Color.black);
		btnRegister2.setBackground(Color.black);
		btnRegister2.setForeground(Color.yellow);
		
		
		lblyour.setForeground(Color.red);
		lblReciever.setForeground(Color.red);
		
		JLabel image = new JLabel(new ImageIcon("images\newback.jpg"));
		pane.add(image);
		image.setBounds(0,0,500,250);
		//connection
				
		
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

		}else if(source==btnTransfer){
		
			try{
				try{
                                    conn=CreateDB.getConnection();
                                    state= conn.createStatement();	
					pst = CreateDB.getConnection().prepareStatement("SELECT * FROM tbl_list WHERE password ='"+txtuser.getText()+"'");
					
						while(rset.next()){
						txttransfer.setText(rset.getString(2));
							int a = Integer.parseInt(txttransfer.getText());
							int b = Integer.parseInt(txtwid.getText());
							
							if(a<b){
								JOptionPane.showMessageDialog(null,"Insufficient funds","ATM",JOptionPane.INFORMATION_MESSAGE);
								txtwid.setText("");
								}else{
									if(b<10){
										JOptionPane.showMessageDialog(null,"The Minimum cash you can Transfer is $10","ATM",JOptionPane.INFORMATION_MESSAGE);
								
									}else{
							int sum = a-b;
							txttransfer.setText((sum+""));
							//txtwid.setText("");
						JOptionPane.showMessageDialog(null,"You Transfered "+b,"ATM",JOptionPane.INFORMATION_MESSAGE);
				ps = conn.prepareStatement("UPDATE tbl_list SET AccBal = '" + txtuser.getText() + "',Initial_Dep = '" + sum +  "'WHERE Password = '" + txtuser.getText() + "'");
		
				rset=ps.executeQuery();
				txtuser.requestFocus(true);
							}
							}
						}
					state.close();
				
				}catch(NumberFormatException nfe){
								JOptionPane.showMessageDialog(null,"Enter now the amount to Transfer","ATM",JOptionPane.INFORMATION_MESSAGE);
							
							}
				
				}catch(SQLException s){
					System.out.println("No record found!\n\n\n");
					System.out.println("SQL Error" + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
									}
				
				catch(Exception x){
					System.out.println("Error" + x.toString()+" " + x.getMessage());
								}
			
				
			
		}else if(source == btnRegister2){
						try{
				try{
                                    conn=CreateDB.getConnection();
                                    state= conn.createStatement();	
					
                                        String sql = "Select * from tbl_list where Password =? +txtuser2.getText()+";
                                        conn=CreateDB.getConnection();
                                        ps=conn.prepareStatement(sql);
					
						while(rset.next()){
						txttransfer2.setText(rset.getString(2));
							int c = Integer.parseInt(txttransfer2.getText());
							int d = Integer.parseInt(txtwid.getText());
							int sum = c+d;
							txtwid2.setText((sum+""));
							txttransfer.setText("");
							txtwid.setText("");
				
				ps = conn.prepareStatement("UPDATE tbl_list SET Password = '" + txtuser2.getText() + "',Initial_Dep = '" + sum +  "'WHERE Password = '" + txtuser2.getText() + "'");
				
				ps.executeUpdate();
				txtuser2.requestFocus(true);
							}
					state.close();
				
				}catch(NumberFormatException nfe){
								JOptionPane.showMessageDialog(null,"Enter now the amount to Transfer","ATM",JOptionPane.INFORMATION_MESSAGE);
							
							}
				
				}catch(SQLException s){
					System.out.println("No record found!\n\n\n");
					System.out.println("SQL Error" + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
									}
				
				catch(Exception x){
					System.out.println("Error" + x.toString()+" " + x.getMessage());
								}
			
			
		}
	}
	
	public static void main(String[]args){
		Cash_Transfer log=new Cash_Transfer();
		
		log.setLocation(400,250);
		log.setSize(500,250);
		log.setResizable(false);
		log.setVisible(true);
		
	
	}
}