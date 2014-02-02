package Data;

public class User {
	private String userName;
	private String Password;
	private int berechtigung;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getBerechtigung() {
		return berechtigung;
	}
	public void setBerechtigung(int berechtigung) {
		this.berechtigung = berechtigung;
	}
	
	public User(String userName, String password){
		this.userName = userName;
		this.Password = password;
	}
	
}
