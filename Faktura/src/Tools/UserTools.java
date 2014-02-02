package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Data.User;

public class UserTools {
	
	public static User createUser(String user, String password){
		return new User(user, password);
	}
	
	public static boolean compareLoginData(String user, String password){
		try {
			comparUserWithDB(user, Encrypter.Password((password)));
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public User getUser(String user, String password){
		return null;
	}
	
	public static boolean saveUserData(User user){
		
		try {
			storeUser(user.getUserName(), Encrypter.Password(user.getPassword()));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteUser(User user){
		return false;
	}
	
	private static  void storeUser(String name, String password) throws SQLException, ClassNotFoundException {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:/Users/Mel_T/Dropbox/Faktura_SFi/account.accdb","","");
	         
		Statement st=con.createStatement();
		String name_ = name;
		String password_ = password;
		int i = st.executeUpdate("insert into account(name,password) values('"+name_+"','"+password_+"')");
		//System.out.println("Row is added");
	           
		st.close();
		con.close();

	}
	private static void comparUserWithDB(String name, String password) throws SQLException, ClassNotFoundException{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:/Users/Mel_T/Dropbox/Faktura_SFi/account.accdb","","");
      
        Statement st=con.createStatement();
        st.execute("select * from account");
       // st.execute("select * from account where user = '"+name+"' and password = '"+password+"';");
		ResultSet rs = st.getResultSet(); // get any Result that came from our query

        if (rs != null){
        	while ( rs.next() ){
        		String names = rs.getString("Name");
        		String passworts = rs.getString("password");
        		if(name.equals(names) && password.equals(passworts) )
        			System.out.println("Name: " + names + " ID: "+passworts);
        		else
        			System.out.println("inkorrekte Logindaten");
        	}
        }
        st.close();
        con.close();
         
	}
}
