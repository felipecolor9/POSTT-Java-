package br.com.felipe.projeto.model;

public class User {
    private int id;
    private String completeName;
    private String username;
    private String password;

    public User() {

    }

    public User(String cmpn, String usrn, String psw) {
    	this.completeName = cmpn;
        this.username = usrn;
        this.password = psw;
    }

    public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}