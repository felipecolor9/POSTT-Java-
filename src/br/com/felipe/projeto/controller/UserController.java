package br.com.felipe.projeto.controller;
import java.util.ArrayList;
import br.com.felipe.projeto.model.User;
import br.com.felipe.projeto.model.UserDAO;

public class UserController {
	private ArrayList<User> users;

	public UserController() {UserDAO ud= new UserDAO(); users = ud.findAll();}

	public boolean checkUser(String user, String pass) {
	
		for (User u : users) {
			if (u.getUsername().equals(user) && u.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}
}
