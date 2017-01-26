package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Note;
import model.Notes;

public class ControllerNewNote {

	@FXML
	private TextField title;

	@FXML
	private TextArea content;

	@FXML
	private Text statusbar;

	@FXML
	protected void newNote(ActionEvent event) {
		if (title.getText().isEmpty()) {
			statusbar.setText("Title cannot be empty");
		} else if (content.getText().isEmpty()) {
			statusbar.setText("Content cannot be empty");
		} else {
			Notes.getInstance().addNote(
					new Note(title.getText(), content.getText(), Notes.getInstance().getObservableList().size()));
			
			Stage stage = (Stage) title.getScene().getWindow();
			stage.close();
		}



	}

	@FXML
	protected void handleReturn(ActionEvent event) {

	}
}
