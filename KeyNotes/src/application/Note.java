package application;

import java.util.ArrayList;

public class Note {
	private String Title;
	private String Texte;
	private ArrayList<Keyword> keywords = new ArrayList<Keyword>();
	
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


	public ArrayList<Keyword> getKeywords() {
		return keywords;
	}
	
	public void addKeyword(Keyword kw){
		this.keywords.add(kw);
	}
	
	public static void main(String []args){
		
	}
}
