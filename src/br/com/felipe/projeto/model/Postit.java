package br.com.felipe.projeto.model;

public class Postit {
	private int id;
	private int idUser;
	private String name;
	private String desc;

	public Postit() {

	}

	public Postit(String name, String desc, int idUser) {
		this.name = name;
		this.desc = desc;
		this.idUser = idUser;
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}
