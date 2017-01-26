package model;

import java.util.ArrayList;

import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Note {
	private StringProperty title = new SimpleStringProperty();
	private StringProperty texte = new SimpleStringProperty();
	private ArrayList<String> keywords = new ArrayList<String>();
	
	ObservableList<String> observableListKeywords = FXCollections.observableList(keywords);
	
	private int id;
	
	public Note(String title, String texte, int id){
		this.setTexte(texte);
		this.setTitle(title);
		this.id = id;
	}
	
	/* Getters and setters*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
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
		this.observableListKeywords.add(kw);
	}

	public ObservableList<String> getObservableListKeywords() {
		return this.observableListKeywords;
	}

}
