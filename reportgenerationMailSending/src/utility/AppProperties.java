package utility;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class AppProperties 
{
	public static Connection myCon=null;
	private static FileInputStream fis=null;
	
	static String database=null;
	static String table=null;
	
	static
	{
		try 
		{
			System.out.println("hi");
			Class.forName("com.mysql.jdbc.Driver");	
			String classPath = "C:\\Users\\Manish Maurya\\Office Projects Research\\reportgenerationMailSending\\src\\config\\config.properties";
			fis = new FileInputStream(classPath); //"Reached to File, Now Started Pointing it
			Properties p = new Properties();
			p.load(fis);
			
			String url = p.getProperty("url");		
			String userName = p.getProperty("userName");
			String password = p.getProperty("password");
			
			database = p.getProperty("db");
			table = p.getProperty("table");
			
			myCon= DriverManager.getConnection(url+database,userName ,password);
			System.out.println("Connection Established...");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
