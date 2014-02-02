package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {
	private String dbPath;
	private String dbUser = "";
	private String dbPassword = "";
	private Connection con;
	private Statement st;
	
	public DBConnection(String path, String user, String password){
		this.dbPath = path;
		this.dbUser = user;
		this.dbPassword = password;
	}
	
	public boolean connect(){
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+dbPath,dbUser,dbPassword);
			st=con.createStatement();
			return true;
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean disconnect(){
		try {
			st.close();
			con.close();
			return true;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet selectData(String query){
		 try {
			st.execute(query);
			return st.getResultSet();
		 } 
		 catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insertData(String query){
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
			return true;
		} 
		catch (SQLException e) {
			return false;
		}
	}
	
	public boolean updateData(String query){
		return false;
	}
	
	public boolean deleteData(String query){
		return false;
	}
}
