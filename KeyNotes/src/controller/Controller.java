package controller;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Note;

public class Controller {
	@FXML
	protected Text actiontarget;

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
	protected void displayNote(MouseEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Note.fxml"));
			Parent root1;
			root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	protected List<Note> deleteNote(ActionEvent event) {

		return null;
	}

}
