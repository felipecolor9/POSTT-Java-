package br.com.felipe.projeto.model;

public class Postit {
	private int idPostit;
	private int idUser;
	private String name;
	private String desc;

	public Postit() {

	}

	public Postit(String name, int idUser,String desc) {
		this.name = name;
		this.idUser = idUser;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getIdPostit() {
		return idPostit;
	}

	public void setIdPostit(int idPostit) {
		this.idPostit = idPostit;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
