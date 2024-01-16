package com.ignek.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ignek.crud.connection.DBConnection;
import com.ignek.crud.constance.EmployeeConstance;
import com.ignek.crud.dto.Employee;

public class EmployeeDao {
	public static void preparedMethod(Employee employee, PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, employee.getFirstName());
			preparedStatement.setString(2, employee.getLastName());
			preparedStatement.setString(3, employee.getEmail());
			preparedStatement.setString(4, employee.getContact());
			preparedStatement.setString(5, employee.getGender());
			preparedStatement.setString(6, employee.getCourse());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getMethod(Employee employee, ResultSet resultSet) {
		try {
			employee.setId(resultSet.getInt(1));
			employee.setFirstName(resultSet.getString(2));
			employee.setLastName(resultSet.getString(3));
			employee.setEmail(resultSet.getString(4));
			employee.setContact(resultSet.getString(5));
			employee.setGender(resultSet.getString(6));
			employee.setCourse(resultSet.getString(7));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int save(Employee employee) {
		int status = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstance.SAVE_QUERY);
			preparedMethod(employee, preparedStatement);
			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int update(Employee employee) {
		int status = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstance.UPDATE_QUERY);
			preparedMethod(employee, preparedStatement);
			preparedStatement.setInt(7, employee.getId());

			status = preparedStatement.executeUpdate();

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int delete(int Sid) {

		int status = 0;
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstance.DELETE_QUERY);
			preparedStatement.setInt(1, Sid);
			status = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Employee getEmpById(int Sid) {
		Employee employee = new Employee(Sid, null, null, null, null, null, null);

		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstance.SELECT_BY_ID);
			preparedStatement.setInt(1, Sid);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				getMethod(employee, resultSet);
			}
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return employee;
	}

	public static List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<>();

		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(EmployeeConstance.SELECT_ALL_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee(EmployeeConstance.DEFAULT_INTEGER, null, null, null, null, null, null);
				getMethod(employee, resultSet);
				list.add(employee);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
