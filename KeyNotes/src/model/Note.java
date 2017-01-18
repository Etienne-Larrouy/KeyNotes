package model;

import java.util.ArrayList;

public class Note {
	private String Title;
	private String Texte;
	private ArrayList<String> keywords = new ArrayList<String>();
	
	/* Getters and setters*/
	public String getTitle() {
		return Title;
	}

	
	public void setTitle(String title) {
		Title = title;
	}


	public String getTexte() {
		return Texte;
	}


	public void setTexte(String texte) {
		Texte = texte;
	}


	public ArrayList<String> getKeywords() {
		return keywords;
	}
	
	public void addKeyword(String kw){
		this.keywords.add(kw);
	}
	
	public static void main(String []args){
		
	}
}
