package br.com.felipe.projeto.controller;

import br.com.felipe.projeto.model.Postit;
import java.util.ArrayList;

public class PostitController {
    ArrayList <Postit> postlist = new ArrayList<Postit>();
    private static PostitController instance;

    public PostitController() {

    }

    public static PostitController getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new PostitController();
            return instance;
        }
    }

    public boolean addPostit(String postitName, String postitDescription) {
        Postit p = new Postit(postitName, postitDescription);
        postlist.add(p);
        return true;
    }
    public ArrayList<Postit> getList() {
        return postlist;
    }

	
}
