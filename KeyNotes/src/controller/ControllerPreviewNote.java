package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Note;

public class ControllerPreviewNote implements Initializable {

	@FXML
	private Label NotePreview_title;

	@FXML
	private Label NotePreview_note;

	private Note currentNote;

	public ControllerPreviewNote(Note n) {
		this.currentNote = n;
	}

	@FXML
	public void openTask(MouseEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Note.fxml"));

		ControllerNote controller = new ControllerNote(this.currentNote);
		// Set it in the FXMLLoader
		loader.setController(controller);

		stage = new Stage();
		stage.setMinHeight(400);
		stage.setMinWidth(600);
		stage.setTitle(this.currentNote.getTitle());

		root = (Parent) loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		this.NotePreview_title.textProperty().bind(this.currentNote.getTitleProperty());
		this.NotePreview_note.textProperty().bind(this.currentNote.getTexteProperty());
	}
}
