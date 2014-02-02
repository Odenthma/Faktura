package Tools;

import java.sql.ResultSet;
import java.sql.SQLException;

import Data.User;

public class UserTools {
	
	public static User createUser(String user, String password){
		return new User(user, password);
	}
	
	public static boolean compareLoginData(String user, String password){
		
			try {
				return comparUserWithDB(user, Encrypter.Password(password));
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		
		
	}
	
	public User getUser(String user, String password){
		return null;
	}
	
	public static boolean saveUserData(User user){
		
		return false;
	}
	
	public boolean deleteUser(User user){
		return false;
	}
	
	public static boolean  storeUser(String name, String password)  {
		DBConnection connection = new DBConnection("C:/Users/Mel_T/Dropbox/Faktura_SFi/account.accdb","","");
		boolean successful;
		
		connection.connect();
		successful = connection.insertData("insert into account(name,password) values('"+name+"','"+Encrypter.Password(password)+"')");
		connection.disconnect();
		
		return successful;
	}
	
	private static boolean comparUserWithDB(String name, String password) throws SQLException, ClassNotFoundException{
		DBConnection connection = new DBConnection("C:/Users/Mel_T/Dropbox/Faktura_SFi/account.accdb","","");
		connection.connect();
		ResultSet rs = connection.selectData("select * from account where name = '"+name+"'");
		
		if (rs != null){
			try {
				while ( rs.next() ){
					String names = rs.getString("Name");
					String passworts = rs.getString("password");
					
	        		if(name.equals(names) && password.equals(passworts) ){
//							System.out.println("Name: " + names + " ID: "+passworts);
							connection.disconnect(); 
	        				return true;
	        		}
	        		else{
//							System.out.println("inkorrekte Logindaten");
							connection.disconnect(); 
							return false;
					}
				}
			}
	        catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				connection.disconnect(); 
				return false;
			}
		}
		connection.disconnect(); 
		return false;
	}
}
