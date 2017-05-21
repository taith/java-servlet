package com.servlet.dao;

import java.sql.Connection;
import java.util.List;

import com.servlet.model.User;

public interface UserDAO {
	public User findUser(Connection conn, String email, String password);
	public User findUser(Connection conn, String email);
	public List<User> listUserWithRole(Connection conn, String role);
	public List<User> listAllUser(Connection conn);
	public void createUser(Connection conn, User user);
	public void upadateUser(Connection conn, User user);
	public void deleteUser(Connection conn, int id);
}
