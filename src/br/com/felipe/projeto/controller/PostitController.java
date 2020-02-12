package br.com.felipe.projeto.controller;

import br.com.felipe.projeto.model.Postit;
import br.com.felipe.projeto.model.PostitDAO;

import java.util.ArrayList;

public class PostitController {
	
    public PostitController() {

    }

    public boolean addPostit( String postitName, String postitDescription,int postitUserId) {
        PostitDAO pdao = new PostitDAO();
    	Postit p = new Postit(postitName, postitDescription,postitUserId); //2 como id provisório
        return pdao.save(p);
    }
   
    public ArrayList<Postit> getUserPosts(int userId) {
		PostitDAO pdao = new PostitDAO();
		return pdao.findbyUserID(userId);
    }
}
