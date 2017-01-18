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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Keywords;
import model.Note;
import model.Notes;

public class Controller implements  Initializable{

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
	protected void handleSubmitButton1Action(ActionEvent event) {
		actiontarget.setText("Button pressed maggle");
	}


	protected void search(ActionEvent event) {
		// TODO
	}

	@FXML
	protected void addNote(ActionEvent event) {
		Note n2 = new Note("Titre de la note2", "Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.");		
		lNotes.addNote(n2);
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
		
		Keywords kw = new Keywords("Course", "Programming", "JavaFx");
		Note n1 = new Note("Titre de la note", "Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.");		
		
		lNotes = new Notes(n1);

		lNotes.getObservableList().addListener((ListChangeListener<Note>) change ->{
			while(change.next()){
//				 for (Note remitem : change.getRemoved()) {
//					 System.out.println("suppr");
//                 }
                 for (Note n : change.getAddedSubList()) {
                     try {
     					
     					GridPane note = FXMLLoader.load(getClass().getResource("../view/Note.fxml"));
     					
     					((Label)note.getChildren().get(1)).setText(n.getTexte());
     					((Label)note.getChildren().get(0)).setText(n.getTitle());
     				
     					n.getTexteProperty().bindBidirectional(((Label)note.getChildren().get(1)).textProperty());
     					n.getTitleProperty().bindBidirectional(((Label)note.getChildren().get(0)).textProperty());

     					listNote.getChildren().add(note);
     				} catch (IOException e) {
     					e.printStackTrace();
     				}
                 }
				
			}
		});
	}

}
