package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import Tools.EncryptDecrypt;
import Tools.EncryptDecrypt_;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LogInPanel extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LogInPanel() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(41, 11, 257, 20);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(41, 42, 257, 20);
		add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//EncryptDecrypt_.createPassword("a","a");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					//EncryptDecrypt_.authenticatePassword("admin","admin");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				doDBStuff();
			
			
			
			}});
		btnLogin.setBounds(30, 84, 89, 23);
		add(btnLogin);

	}
	
	private void doDBStuff() {
		  try{
	           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	           Connection con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:/tutorial/kontakte.mdb","","");
	         
	           Statement st=con.createStatement();
	           String name="roseindia";
	           String address="delhi";
	           int i=st.executeUpdate("insert into user(username,password) values('"+name+"','"+address+"')");
	           System.out.println("Row is added");
	           }
	        catch(Exception e){
	            System.out.println("does not added:"+e);
	        }
         
     
	}
}
