package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Note;

public class Controller implements  Initializable{
	@FXML
	private Text actiontarget;
	
	@FXML
	private Pane main;
	
	@FXML
	private BorderPane note;

	@FXML
	protected void handleSubmitButton1Action(ActionEvent event) {
		actiontarget.setText("Button pressed maggle");
	}


	protected void search(ActionEvent event) {
		// TODO
	}

	protected void addNote(ActionEvent event) {
		// TODO
	}

	protected void addKeyword(ActionEvent event) {
		// TODO
	}

	protected void modifyNote(ActionEvent event) {
		// TODO
	}

	protected void displayNote(MouseEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Note.fxml"));
			Parent root1;
			root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	protected List<Note> deleteNote(ActionEvent event) {

		return null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
