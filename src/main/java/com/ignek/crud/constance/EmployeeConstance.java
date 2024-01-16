package com.ignek.crud.constance;

public class EmployeeConstance {

	public static final String DRIVER = "com.mysql.jdbc.Driver";

	public static final String SQL_USER_NAME = "root";

	public static final String DATABASE = "jdbc:mysql://localhost:3306/students";

	public static final String SQL_PASSWORD = "root";

	public static final String FIRST_NAME = "firstName";

	public static final String LAST_NAME = "lastName";

	public static final String EMAIL = "email";

	public static final String CONTACT = "contact";

	public static final String GENDER = "gender";

	public static final String COURSE = "course";

	public static final String ID = "id";

	public static final String BLANK = "";

	public static final String SAVE_QUERY = "insert into student_details(firstName,lastName,email,contact,gender,course)values(?,?,?,?,?,?)";

	public static final String UPDATE_QUERY = "update student_details set firstName=? , lastName=? , email=? , contact=? , gender=? , course=? where id=?";

	public static final String DELETE_QUERY = "delete from student_details where id=?";

	public static final String SELECT_BY_ID = "select * FROM student_details where id=?";

	public static final String SELECT_ALL_QUERY = "select * from student_details";

	public static final String EDIT_ID = "editId";

	public static final String DELETE_ID = "deleteId";

	public static final String EMPLOYEE = "employee";

	public static final int DEFAULT_INTEGER = 0;

	public static final String LIST = "list";

	public static final String SUCCESS_SAVE = "Record saved successfully!!";

	public static final String SUCCESS_UPDATE = "Record Updated successfully!!";

}
