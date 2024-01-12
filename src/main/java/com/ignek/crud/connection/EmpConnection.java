package com.ignek.crud.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.ignek.crud.constance.EmployeeConstance;

public class EmpConnection {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(EmployeeConstance.DRIVER);
			connection = DriverManager.getConnection(EmployeeConstance.DATABASE, EmployeeConstance.SQL_USER_NAME,
					EmployeeConstance.SQL_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

}
