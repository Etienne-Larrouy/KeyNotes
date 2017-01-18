package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.MapChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Keywords;
import model.Note;
import model.Notes;

public class Controller implements  Initializable{
	@FXML
	private Text actiontarget;
	
	@FXML
	private Label texteNote;

	@FXML
	private Label titleNote;
	
	@FXML
	private Pane main;

	@FXML
	private GridPane note;
	
	@FXML
	private FlowPane listNote;

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
		
		System.out.println("lol");
		Keywords kw = new Keywords("Course", "Programming", "JavaFx");
		Note n = new Note("Titre de la note", "Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.");		
		
		kw.getObservableList().addListener((MapChangeListener<String, Integer>) change ->{
			try {
				note = FXMLLoader.load(getClass().getResource("../view/Note.fxml"));
				n.getTexteProperty().bindBidirectional(texteNote.textProperty());
				n.getTitleProperty().bindBidirectional(titleNote.textProperty());
				
				listNote.getChildren().add(note);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}

}
