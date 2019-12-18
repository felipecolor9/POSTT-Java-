package br.com.felipe.projeto.model;

public class User {
    private int cod;
    private String username;
    private String password;

    public User() {

    }

    public User(String usrn, String psw) {
        this.username = usrn;
        this.password = psw;
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

    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }

}