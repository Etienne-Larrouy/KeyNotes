package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Note  implements Comparable<Note>{
	private StringProperty title = new SimpleStringProperty();
	private StringProperty texte = new SimpleStringProperty();
	private ArrayList<String> keywords = new ArrayList<String>();
	
	ObservableList<String> observableListKeywords = FXCollections.observableList(keywords);
	
	private int id;
	
	private Date date;
	
	public Note(String title, String texte, int id){
		this.setTexte(texte);
		this.setTitle(title);
		this.id = id;
		this.date = Calendar.getInstance().getTime();
	}
	
	/* Getters and setters*/
	
	public Date getDate() {
		return date;
	}
	
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

	@Override
	public int compareTo(Note o) {
		return this.getTitle().compareTo(o.getTitle());
	}

}
