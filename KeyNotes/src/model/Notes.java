package model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Notes{
	// Use Java Collections to create the List.
	List<Note> listNotes = new ArrayList<Note>();

	// Now add observability by wrapping it with ObservableList.
	ObservableList<Note> observableListNotes;

	private static Notes notesInstance = new Notes(new Note("Titre de la note",
			"Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.",
			0));

	public static Notes getInstance() {
		return notesInstance;
	}

	// Constructor with multiple keywords
	public Notes(Note... n) {

		observableListNotes = FXCollections.observableArrayList(listNotes);
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

	public void setListToObserve(ArrayList<Note> list) {

		observableListNotes = FXCollections.observableArrayList(list);
	}

	public void removeNote(Note n) {
		observableListNotes.remove(n);
	}

}
