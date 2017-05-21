package com.servlet.dao.business;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.servlet.dao.UserDAO;
import com.servlet.model.User;

public class UserDAOBusiness implements UserDAO {

	@Override
	public User findUser(Connection conn, String email, String password) {
		String sql = "SELECT u.email, u.password FROM user AS u WHERE u.email = ? AND u.password + ?";

		PreparedStatement prestate;
		try {
			prestate = conn.prepareStatement(sql);
			prestate.setString(1, email);
			prestate.setString(2, password);
			ResultSet result = prestate.executeQuery();

			if (result.next()) {
				String role = result.getString("role");
				User user = new User();
				user.setEmail(email);
				user.setPassword(password);
				user.setRole(role);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User findUser(Connection conn, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listUserWithRole(Connection conn, String role) {
		String sql = "SELECT u.id, u.email, u.name, u.role, u.created_at FROM user AS u WHERE u.role = ?";
		PreparedStatement prestate;
		List<User> userList = new ArrayList<User>();
		try {
			prestate = conn.prepareStatement(sql);
			prestate.setString(1, role);
			ResultSet result = prestate.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String email = result.getString("email");
				String name = result.getString("name");
				String created_at = result.getString("create_date");
				User user = new User();
				user.setId(id);
				user.setEmail(email);
				user.setName(name);
				user.setCreated_at(created_at);
				userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> listAllUser(Connection conn) {
		String sql = "SELECT SELECT u.id, u.email, u.name, u.role, u.created_at FROM user AS u";
		PreparedStatement prestate;
		List<User> userListAll = new ArrayList<User>();

		try {
			prestate = conn.prepareStatement(sql);
			ResultSet result = prestate.executeQuery();

			if (result.next()) {
				int id = result.getInt("id");
				String email = result.getString("email");
				String name = result.getString("name");
				String role = result.getString("role");
				String created_at = result.getString("create_date");
				User user = new User();
				user.setId(id);
				user.setEmail(email);
				user.setName(name);
				user.setRole(role);
				user.setCreated_at(created_at);
				userListAll.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createUser(Connection conn, User user) {
		String sql = "INSERT INTO user(email, name, password, role, enabled,created_at) VALUES (?, ?, ?, ?, 1, ?)";
		try {
			PreparedStatement prestate = conn.prepareStatement(sql);
			prestate.setString(1, user.getEmail());
			prestate.setString(2, user.getName());
			prestate.setString(3, user.getPassword());
			prestate.setString(4, user.getRole());
			prestate.setString(5, user.getCreated_at());
			
			prestate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void upadateUser(Connection conn, User user) {
		// String sql = "UPDATE user set name =?, update_at =? where id =? ";

	}

	@Override
	public void deleteUser(Connection conn, int id) {
		String sql = "DELETE Product where id = ?";

		try {
			PreparedStatement prestate = conn.prepareStatement(sql);
			prestate.setInt(1, id);
			prestate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
