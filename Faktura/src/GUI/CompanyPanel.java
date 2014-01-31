package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;

public class CompanyPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CompanyPanel() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(41, 104, 89, 23);
		add(btnNewButton);

	}

}
