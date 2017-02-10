package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;

public class Note{
	private StringProperty title = new SimpleStringProperty();
	private StringProperty texte = new SimpleStringProperty();
	private ArrayList<String> keywords = new ArrayList<String>();
	
	private ObservableList<String> observableListKeywords = FXCollections.observableList(keywords);
	
	private Date date;
	private GridPane setContainer;
	
	public Note(String title, String texte){
		this.setTexte(texte);
		this.setTitle(title);
		this.date = Calendar.getInstance().getTime();
		
		observableListKeywords.addListener((ListChangeListener<String>) change -> {
			while(change.next()){
                if (change.wasRemoved()) {
                    for (String removedKeyword : change.getRemoved()) {
                    	Notes.getInstance().getKeywords().removeKeyword(removedKeyword);
                    }
                }
			}
		});
	}
	
	/* Getters and setters*/
	
	public Date getDate() {
		return date;
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
		Notes.getInstance().getKeywords().addKeyword(kw);
	}

	public ObservableList<String> getObservableListKeywords() {
		return this.observableListKeywords;
	}

	public int compareToTitle(Note o) {
		return this.getTitle().compareTo(o.getTitle());
	}
	
	public int compareToDate(Note o) {
		return this.getDate().compareTo(o.getDate());
	}
	
	
	public int compareToKeywords(Note o) {
		return ((Integer) this.getKeywords().size()).compareTo((Integer)o.getKeywords().size());
	}

	public void removeKeyword(String kw) {
		this.observableListKeywords.remove(kw);
	}

	public void setContainer(GridPane note) {
		this.setContainer = note;
	}
	
	public GridPane getContainer() {
		return this.setContainer;
	}
	

}
