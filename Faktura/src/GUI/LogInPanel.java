package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import Tools.UserTools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
//				UserTools.saveUserData(UserTools.createUser(textField.getText(), passwordField.getText()));
//				
				if(UserTools.compareLoginData(textField.getText(), passwordField.getText())){
					System.out.println("login successful!");
				}
				else
					System.out.println("login not successful!");
					
			}
		});
		btnLogin.setBounds(30, 84, 89, 23);
		add(btnLogin);
		
		JButton btnCreate = new JButton("create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(UserTools.storeUser(textField.getText(), passwordField.getText()))
					System.out.println("User wurder erfolgreich erstellt!");
				else
					System.out.println("User bereits vorhanden!");
			}
		});
		btnCreate.setBounds(141, 84, 89, 23);
		add(btnCreate);
	}
}
