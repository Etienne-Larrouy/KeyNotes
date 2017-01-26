package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import model.Note;

public class ControllerNote implements Initializable{

	private Note currentNote;
	
	@FXML
	private Label title;
	
	@FXML
	private TextArea content;
	
	@FXML
	private HBox keywords_container;

	public ControllerNote(Note t) {
		this.currentNote = t;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		title.setText(currentNote.getTitle());
		content.setText(currentNote.getTexte());
	}
}
