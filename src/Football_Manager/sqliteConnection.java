package Football_Manager;

import java.sql.*;
import javax.swing.*;

public class sqliteConnection 
{
	Connection conn = null;
	
	public static Connection dbConnector()
	{
		
		
		try 
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Yuval_David\\Desktop\\יובל\\פרוייקט מנגר\\Logindatabase.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	public static Connection this_game()
	{
		
		
		try 
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Yuval_David\\Desktop\\יובל\\פרוייקט מנגר\\Yuval.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
