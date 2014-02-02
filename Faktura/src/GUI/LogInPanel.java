package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import Tools.Encrypter;
import Tools.UserTools;

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
				//UserTools.saveUserData(UserTools.createUser(textField.getText(), passwordField.getText()));
					UserTools.compareLoginData(textField.getText(), passwordField.getText());
			}});
		btnLogin.setBounds(30, 84, 89, 23);
		add(btnLogin);

	}
	
	
}
