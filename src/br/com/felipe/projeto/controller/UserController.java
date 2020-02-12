package br.com.felipe.projeto.controller;

import java.util.ArrayList;

import br.com.felipe.projeto.model.User;
import br.com.felipe.projeto.model.UserDAO;

public class UserController {
	private ArrayList<User> users;

	public UserController() {
		UserDAO ud = new UserDAO();
		users = ud.findAll();
	}

	public boolean checkLogin(String user, String pass) {

		for (User u : users) {
			if (u.getUsername().equals(user) && u.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkRegister(String name, String user, String pass1, String pass2) {
		if (checkPasswRegister(pass1, pass2) && checkUserName(user)) {
			addUser(name, user, pass1);
			return true;
		}
		return false;
	}

	private boolean checkPasswRegister(String pass1, String pass2) {
		if (pass1.equals(pass2) && !(pass1.isEmpty() || pass2.isEmpty())) {
			return true;
		}
		return false;
	}

	private boolean checkUserName(String user) {

		for (User u : users) {
			if (u.getUsername().equals(user)) {
				return false;
			}

		}
		return true;
	}

	private void addUser(String newAccName, String newAccUser, String newAccPass) {
		UserDAO ucdAdd = new UserDAO();
		User account = new User(newAccName, newAccUser, newAccPass);
		ucdAdd.save(account);
	}
	
	
	public int getActualUserId(String username) {
		UserDAO ud = new UserDAO();
		return ud.findId(username);
	}
	
}
