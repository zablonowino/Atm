package atm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class WDraw_trans extends JFrame implements ActionListener{
	
	JPasswordField txtuser=new JPasswordField(25);
	JTextField txtpass=new JTextField(25);
	JTextField txtwid=new JTextField(25);
	JLabel lbluser=new JLabel("Pin Number: ");
	JLabel lblpass=new JLabel("WithDraw: ");
	JLabel lblwid=new JLabel("Balanced: ");
	JButton btnOk=new JButton("Back to Menu");
	JButton btnRegister=new JButton("Withdraw");
	

	Connection conn;
	//ResultSet rs;
	Statement state;
	PreparedStatement ps;
	public WDraw_trans(){
		super("Withdraw Transaction");
		
		JPanel pane=new JPanel();
		pane.setLayout(null);
		//----Adding Components into your Frame
		pane.add(txtuser);
 		pane.add(txtpass);
 		pane.add(txtwid);
		pane.add(lbluser);
 		pane.add(lblpass);
 		pane.add(lblwid);	
		pane.add(btnOk);
		pane.add(btnRegister);
		//-----Setting the location of the components
		lbluser.setBounds(10,20,80,20);
 		lblpass.setBounds(10,40,80,20);
 		lblwid.setBounds(600,60,80,20);
		txtuser.setBounds(100,20,100,20);
 		txtpass.setBounds(600,60,100,20);
 		txtwid.setBounds(100,40,100,20);
 		
		btnOk.setBounds(80,120,140,20);
		btnRegister.setBounds(100,90,100,20);
		//-----Adding the an actionlistener to the buttons
		btnOk.addActionListener(this);
		btnRegister.addActionListener(this);
		
		txtpass.setEditable(false);
		btnOk.setToolTipText("Click To Back to Menu");
		btnOk.setForeground(Color.yellow);
		btnRegister.setForeground(Color.yellow);
		btnOk.setBackground(Color.black);
		btnRegister.setBackground(Color.black);

		setContentPane(pane);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		

		
		pane.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "Withdraw Transaction"));
		
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
	panel.setLocation(400,250);
	dispose();

		}else if(source==btnRegister){
		//	btnRegister.setText("Withdraw");
			
			try{
				try{
                                        conn=CreateDB.getConnection();
                                        state= conn.createStatement();	
					ResultSet rs=state.executeQuery("SELECT * FROM tbl_list WHERE Password ='"+txtuser.getText()+"'");
						while(rs.next()){
							txtpass.setText(rs.getString(9));
							int a = Integer.parseInt(txtpass.getText());
							int b = Integer.parseInt(txtwid.getText());
							
							
							if(a<b){
							//	if(b<10){
								
							//	if(b>100)
								
									JOptionPane.showMessageDialog(null,"Transaction cannot process","ATM",JOptionPane.INFORMATION_MESSAGE);
							txtwid.setText("");
							//}else{
							//	JOptionPane.showMessageDialog(null,"Transaction c s","ATM",JOptionPane.INFORMATION_MESSAGE);
							//}
							
							}else{
								if(b<10){
									JOptionPane.showMessageDialog(null,"The Minimum cash you can withdraw is $10","ATM",JOptionPane.INFORMATION_MESSAGE);
								
								}else{
								
							
							int sum = a-b;
						
							txtpass.setText((sum+""));
							txtwid.setText("");
							JOptionPane.showMessageDialog(null,"You WithDraw "+b,"ATM",JOptionPane.INFORMATION_MESSAGE);
								
				ps = conn.prepareStatement("UPDATE tbl_list SET Password = '" + txtuser.getText() + "',ct = '" + sum +  "'WHERE Password = '" + txtuser.getText() + "'");
				ps.executeUpdate();
				txtuser.requestFocus(true);
							}
							}
							}
					state.close();
					}catch(NumberFormatException nfe){
								JOptionPane.showMessageDialog(null,"Enter now the amount to withdraw","ATM",JOptionPane.INFORMATION_MESSAGE);
							
							}
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
                public static void displayBalance(double x)
    {
        System.out.printf("\nYour Current Balance is $%.2f\n", x);
    }

    public static double deposit(double x, double y)
    {
        double depositAmt = y, currentBal = x;
        double newBalance = depositAmt + currentBal;

        System.out.printf("Your New Balance is $%.2f\n",  newBalance);

        return newBalance;
    }

    public static double withdraw(double x, double y)
    {
        double withdrawAmt = y, currentBal = x, newBalance;

        newBalance = currentBal - withdrawAmt;
        System.out.printf("Your New Balance is %.2f\n",newBalance);

        return newBalance;  
    }
	
	
	public static void main(String[]args){
		WDraw_trans log=new WDraw_trans();
		
		log.setLocation(400,250);
		log.setSize(250,200);
		log.setResizable(false);
		log.setVisible(true);
		
	
	}
}