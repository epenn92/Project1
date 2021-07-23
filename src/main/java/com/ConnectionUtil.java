package com;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;

public class ConnectionUtil {

	public static Connection getConnection() {
		
		Properties props = new Properties();
//		FileInputStream fis = null;
		Connection con = null;
		InputStream in;
		try {
//			fis = new FileInputStream("db.properties");
			in= ConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties");
//			props.load(in);
			if (in != null) {
				props.load(in);
			} else {
				System.out.println("Can't find file");
			}
			
			
			//load driver class from db properties
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			
			// create the connection
			con = DriverManager.getConnection(props.getProperty("DB_URL"),
				props.getProperty("DB_USERNAME"),
				props.getProperty("DB_PASSWORD"));
			} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return con;
		}
}

