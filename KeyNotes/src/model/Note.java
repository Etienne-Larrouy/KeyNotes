package model;

import java.util.ArrayList;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Note {
	private StringProperty title = new SimpleStringProperty();
	private StringProperty texte = new SimpleStringProperty();
	private ArrayList<String> keywords = new ArrayList<String>();
	
	public Note(String title, String texte){
		this.setTexte(texte);
		this.setTitle(title);
	}
	
	/* Getters and setters*/
	public final String getTitle() {
		return this.title.get();
	}

	public void setTitle(String title) {
		this.title.set(title);
	}

	public StringProperty getTitleProperty() {
		return this.title;
	}
	
	public StringProperty getTexteProperty() {
		return this.texte;
	}

	public final String getTexte() {
		return this.texte.get();
	}


	public void setTexte(String texte) {
		this.texte.set(texte);
	}


	public ArrayList<String> getKeywords() {
		return keywords;
	}
	
	public void addKeyword(String kw){
		this.keywords.add(kw);
	}

}
