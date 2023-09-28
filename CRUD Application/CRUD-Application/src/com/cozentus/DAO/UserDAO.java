package com.cozentus.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cozentus.CRUD.User;

public class UserDAO {
	
	private String DRIVER_NAME= "com.mysql.cj.jdbc.Driver";
	private String URL= "jdbc:mysql://localhost:3306/CRUD";
	private String USERNAME= "root";
	private String PASSWORD= "password";	
	
	private static final String INSERT_USER = "insert into user(id,name,gender,email) values(?,?,?,?);";
	private static final String ALL_USERS = "select * from user;";
	private static final String UPDATE_USER = "update user set name=?,gender=?,email=? where id=?;";
	private static final String DELETE_USERS = "delete from user where id=?;";
	private static final String FETCH_USERS_BY_ID= "select * from user where id=?;";
	
	protected Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER_NAME);
			con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} 
		catch (Exception e) {}
		return con;
	}
	
	/* Inserting or Adding user data */
	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USER);
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(INSERT_USER);){
			ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setString(3, user.getGender());
			ps.setString(4, user.getEmail());
			ps.executeUpdate();
		}
		catch(Exception e) {}
	}
	
	/* Fetching user data by ID */
	public User selectUserById(int id) throws SQLException {
		System.out.println(FETCH_USERS_BY_ID);
		User user =  null;
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(FETCH_USERS_BY_ID);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				user = new User(id,name,gender,email);
			}
		}
		catch(Exception e) {}
		return user;
	}
	
	/* Selecting all user data */
	public List<User> selectAllusers() throws SQLException {
		System.out.println(ALL_USERS);
		List<User> users = new ArrayList<>();
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(ALL_USERS)) {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				users.add(new User(id,name,gender,email));
			}
		}
		catch(Exception e) {}
		return users;
	}
	
	/* Updating user data */
	public boolean updateUser(User user) throws SQLException {
		System.out.println(UPDATE_USER);
		boolean updt;
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATE_USER)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getGender());
			ps.setString(3, user.getEmail());
			ps.setInt(4, user.getId());
			updt=ps.executeUpdate()>0;
		}
		/*catch(Exception e) {}*/
		return updt;
	}
	
	/* Deleting user data */
	public boolean deleteUser(int id) throws SQLException {
		System.out.println(DELETE_USERS);
		boolean del=false;
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(DELETE_USERS)) {
				ps.setInt(1, id);
				del=ps.executeUpdate()>0;
		}
		catch(Exception e) {}
		return del;
	}
}
