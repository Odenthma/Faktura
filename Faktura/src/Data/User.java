package Data;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User {
	
	/** The user name. */
	private String userName;
	
	/** The Password. */
	private String Password;
	
	/** The berechtigung. */
	private int berechtigung;
	
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		Password = password;
	}
	
	/**
	 * Gets the berechtigung.
	 *
	 * @return the berechtigung
	 */
	public int getBerechtigung() {
		return berechtigung;
	}
	
	/**
	 * Sets the berechtigung.
	 *
	 * @param berechtigung the new berechtigung
	 */
	public void setBerechtigung(int berechtigung) {
		this.berechtigung = berechtigung;
	}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param userName the user name
	 * @param password the password
	 */
	public User(String userName, String password){
		this.userName = userName;
		this.Password = password;
	}
	
}
