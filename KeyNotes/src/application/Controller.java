package application;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {
	@FXML protected Text actiontarget;

	@FXML 
	protected void handleSubmitButton1Action(ActionEvent event) {
		actiontarget.setText("Button pressed maggle");
	}
	
	@FXML 
	protected List<Note> search(ActionEvent event) {
		
		return null;
	}
	
	@FXML 
	protected List<Note> addNote(ActionEvent event) {
		
		return null;
	}
	
	@FXML 
	protected List<Note> addKeyword(ActionEvent event) {
		
		return null;
	}
	
	@FXML 
	protected List<Note> modifyNote(ActionEvent event) {
		
		return null;
	}
	
	@FXML 
	protected List<Note> deleteNote(ActionEvent event) {
		
		return null;
	}

}
