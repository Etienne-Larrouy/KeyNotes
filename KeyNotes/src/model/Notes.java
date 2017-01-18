package model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Notes {
	// Use Java Collections to create the List.
	List<Note> listNotes = new ArrayList<Note>();

	// Now add observability by wrapping it with ObservableList.
	ObservableList<Note> observableListNotes = FXCollections.observableList(listNotes);

	// Constructor with multiple keywords
	public Notes(Note... n) {
		for (int i = 0; i < n.length; i++) {
			this.addNote(n[i]);
		}
	}

	// Add keyword to the observable map
	public void addNote(Note n) {
		this.observableListNotes.add(n);
	}

	public ObservableList<Note> getObservableList() {
		return observableListNotes;
	}
}
