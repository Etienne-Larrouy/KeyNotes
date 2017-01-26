package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Note;

public class ControllerNote implements Initializable {

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

	@FXML
	protected void editNote(ActionEvent event) {
		Stage stage = null;
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/EditNote.fxml"));

		stage = (Stage) title.getScene().getWindow();

		ControllerEditNote controller = new ControllerEditNote(currentNote, stage);
		// Set it in the FXMLLoader
		loader.setController(controller);

		try {
			root = (Parent) loader.load();

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		title.setText(currentNote.getTitle());
		content.setText(currentNote.getTexte());
	}
}
