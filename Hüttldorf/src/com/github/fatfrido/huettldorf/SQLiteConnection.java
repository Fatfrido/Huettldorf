package com.github.fatfrido.huettldorf;

import java.sql.*;
import javax.swing.*;

public class SQLiteConnection {
	Connection conn = null;
	public static Connection dbConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\maxig_000\\OneDrive\\Documents\\Huettldorf\\Products.sqlite");
			JOptionPane.showMessageDialog(null, "Connection successful");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
