package com.programmingfree.springservice.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtility {
 private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
             Properties prop = new Properties();
                InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                System.out.println(driver);
                String url = prop.getProperty("url");
                System.out.println(url);
                String user = prop.getProperty("user");
                System.out.println(user);
                String password = prop.getProperty("password");
                System.out.println(password);
                Class.forName(driver);
                connection = DriverManager.getConnection(
    					"jdbc:mysql://localhost:3306/taskmanager",
    					"root", "root");
                
                
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            return connection;
        }

    }

}