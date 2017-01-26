package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Keywords;
import model.Note;
import model.Notes;

public class Controller implements Initializable {

	Notes lNotes;

	@FXML
	private Text actiontarget;

	@FXML
	private Label texteNote;

	@FXML
	private Label titleNote;

	@FXML
	private Pane main;

	@FXML
	private FlowPane listNote;

	@FXML
	protected void createNote(ActionEvent event) {
		Stage stage = null;
		Parent root = null;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/NewNote.fxml"));
		try {
			root = (Parent) loader.load();
			stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void search(ActionEvent event) {
		// TODO
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Keywords kw = new Keywords("Course", "Programming", "JavaFx");

		for (Note n : Notes.getInstance().getObservableList()) {
			try {

				GridPane note = FXMLLoader.load(getClass().getResource("../view/PreviewNote.fxml"));

				((Label) note.getChildren().get(1)).setText(n.getTexte());
				((Label) note.getChildren().get(0)).setText(n.getTitle());
				((Text) note.getChildren().get(2)).setText(Integer.toString(n.getId()));

				n.getTexteProperty().bindBidirectional(((Label) note.getChildren().get(1)).textProperty());
				n.getTitleProperty().bindBidirectional(((Label) note.getChildren().get(0)).textProperty());

				listNote.getChildren().add(note);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Notes.getInstance().getObservableList().addListener((ListChangeListener<Note>) change -> {
			while (change.next()) {
				for (Note remitem : change.getRemoved()) {
					listNote.getChildren().remove(remitem.getId());
				}
				for (Note n : change.getAddedSubList()) {
					try {

						GridPane note = FXMLLoader.load(getClass().getResource("../view/PreviewNote.fxml"));

						((Label) note.getChildren().get(1)).setText(n.getTexte());
						((Label) note.getChildren().get(0)).setText(n.getTitle());
						((Text) note.getChildren().get(2)).setText(Integer.toString(n.getId()));

						n.getTexteProperty().bindBidirectional(((Label) note.getChildren().get(1)).textProperty());
						n.getTitleProperty().bindBidirectional(((Label) note.getChildren().get(0)).textProperty());

						listNote.getChildren().add(note);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		});
	}

}
