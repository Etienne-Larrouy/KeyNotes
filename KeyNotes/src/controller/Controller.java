package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
	private TextField searchField;

	@FXML
	private Pane main;

	@FXML
	private ToggleButton keywordsSearch;

	@FXML
	private ToggleButton noteSearch;

	@FXML
	private ToggleButton titleSearch;

	@FXML
	private FlowPane listNote;

	@FXML
	//title
	private RadioButton keywordsButton1;

	@FXML
	private RadioButton keywordsButton;

	@FXML
	//date
	private RadioButton keywordsButton2;

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

	@FXML
	protected void orderByTitle(ActionEvent event) {
		
		listNote.getChildren().remove(0, listNote.getChildren().size());

		ArrayList<Note> list = new ArrayList<Note>();

		// Browse all notes
		for (Note n : Notes.getInstance().getObservableList()) {
			list.add(n);
		}
		
		Collections.sort(list, NoteComparator.compareToTitle());
		Notes.getInstance().setListToObserve(list);


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

	@FXML
	protected void orderByKeywords(ActionEvent event) {
		
		listNote.getChildren().remove(0, listNote.getChildren().size());
		
		ArrayList<Note> list = new ArrayList<Note>();
		
		// Browse all notes
		for (Note n : Notes.getInstance().getObservableList()) {
			list.add(n);
		}
		
		Collections.sort(list, NoteComparator.compareToKeywords());
		Notes.getInstance().setListToObserve(list);


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

	@FXML
	protected void orderByDate(ActionEvent event) {

		listNote.getChildren().remove(0, listNote.getChildren().size());
		
		ArrayList<Note> list = new ArrayList<Note>();
	
		// Browse all notes
		for (Note n : Notes.getInstance().getObservableList()) {
			list.add(n);
		}
		
		Collections.sort(list, NoteComparator.compareToDate());
		Notes.getInstance().setListToObserve(list);		


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

	@FXML
	protected void handleSearch(ActionEvent event) {
		ArrayList<Note> list = new ArrayList<Note>();

		// Remove current displayed notes
		if (!searchField.getText().isEmpty()
				&& (keywordsSearch.isSelected() || titleSearch.isSelected() || noteSearch.isSelected())) {
			listNote.getChildren().remove(0, listNote.getChildren().size());
		}
		// Browse all notes
		for (Note n : Notes.getInstance().getObservableList()) {
			// Search depending on which search button is selected
			if (keywordsSearch.isSelected()) {
				for (String kw : n.getKeywords()) {
					if (kw.contains(searchField.getText())) {
						list.add(n);
					}
				}
			}

			if (titleSearch.isSelected()) {
				if (n.getTitle().contains(searchField.getText())) {
					list.add(n);
				}
			}

			if (noteSearch.isSelected()) {
				if (n.getTexte().contains(searchField.getText())) {
					list.add(n);
				}
			}
		}

		for (Note n : list) {
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Radio button state
		final ToggleGroup group = new ToggleGroup();

		keywordsButton1.setToggleGroup(group);

		keywordsButton.setToggleGroup(group);

		keywordsButton2.setToggleGroup(group);

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
