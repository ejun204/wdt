package com.platformance.wdt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
@Controller
public class WdtApplication {

	public static void main(String[] args) {

		SpringApplication.run(WdtApplication.class, args);
		// Create a variable for the connection string.
		String connectionUrl ="jdbc:sqlserver:dbpadinstance.cdpfajomg88b.ap-northeast-2.rds.amazonaws.com;databaseName=DBPAD_DEV_MEMBER;user=myuser;password=1q2w3e4r";

		try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
			String SQL = "SELECT * FROM TB_Member_INFO";
			ResultSet rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				System.out.println(rs.getString("ID") + " " + rs.getString("Password"));
			}
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

