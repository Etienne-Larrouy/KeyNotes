package model;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Notes{
	// Use Java Collections to create the List.
	List<Note> listNotes = new ArrayList<Note>();
	
	Keywords kw;

	// Now add observability by wrapping it with ObservableList.
	ObservableList<Note> observableListNotes;

	private static Notes notesInstance = new Notes(new Note("Titre de la note",
			"Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis."));

	public static Notes getInstance() {
		return notesInstance;
	}

	// Constructor with multiple keywords
	public Notes(Note... n) {
		kw = new Keywords();
		observableListNotes = FXCollections.observableArrayList(listNotes);
		for (int i = 0; i < n.length; i++) {
			this.addNote(n[i]);
		}
	}

	// Add keyword to the observable map
	public void addNote(Note n) {
		this.observableListNotes.add(n);
	}
	
	// Get keywords
	public Keywords getKeywords() {
		return this.kw;
	}

	public ObservableList<Note> getObservableList() {
		return observableListNotes;
	}

	public void setListToObserve(ArrayList<Note> list) {

		observableListNotes = FXCollections.observableArrayList(list);
	}

	public void removeNote(Note n) {
		System.out.println("Remove");
		n.getObservableListKeywords().clear();
		observableListNotes.remove(n);
	}

}
