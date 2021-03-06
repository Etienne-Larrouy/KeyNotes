package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
	// title
	private RadioButton keywordButton;

	@FXML
	private RadioButton titleButton;

	@FXML
	private RadioButton dateButton;

	@FXML
	private HBox keywordsFilter;

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

				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreviewNote.fxml"));

				ControllerPreviewNote controller = new ControllerPreviewNote(n);
				// Set it in the FXMLLoader
				loader.setController(controller);

				GridPane note = loader.load();

				n.setContainer(note);
				listNote.getChildren().add(note);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Notes.getInstance().getObservableList().addListener((ListChangeListener<Note>) change -> {
			while (change.next()) {
				for (Note remitem : change.getRemoved()) {
					listNote.getChildren().remove(remitem.getContainer());
				}
				for (Note n : change.getAddedSubList()) {
					try {

						FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreviewNote.fxml"));

						ControllerPreviewNote controller = new ControllerPreviewNote(n);
						// Set it in the FXMLLoader
						loader.setController(controller);

						GridPane note = loader.load();

						n.setContainer(note);
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

				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreviewNote.fxml"));

				ControllerPreviewNote controller = new ControllerPreviewNote(n);
				// Set it in the FXMLLoader
				loader.setController(controller);

				GridPane note = loader.load();

				n.setContainer(note);
				listNote.getChildren().add(note);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Notes.getInstance().getObservableList().addListener((ListChangeListener<Note>) change -> {
			while (change.next()) {
				for (Note remitem : change.getRemoved()) {
					listNote.getChildren().remove(remitem.getContainer());
				}
				for (Note n : change.getAddedSubList()) {
					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreviewNote.fxml"));

						ControllerPreviewNote controller = new ControllerPreviewNote(n);
						// Set it in the FXMLLoader
						loader.setController(controller);

						GridPane note = loader.load();

						n.setContainer(note);
						listNote.getChildren().add(note);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		});

		Notes.getInstance().getObservableList().addListener((ListChangeListener<Note>) change -> {
			while (change.next()) {
				for (Note remitem : change.getRemoved()) {
					listNote.getChildren().remove(remitem.getContainer());
				}
				for (Note n : change.getAddedSubList()) {
					try {

						FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreviewNote.fxml"));

						ControllerPreviewNote controller = new ControllerPreviewNote(n);
						// Set it in the FXMLLoader
						loader.setController(controller);

						GridPane note = loader.load();

						n.setContainer(note);
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

				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreviewNote.fxml"));

				ControllerPreviewNote controller = new ControllerPreviewNote(n);
				// Set it in the FXMLLoader
				loader.setController(controller);

				GridPane note = loader.load();

				n.setContainer(note);
				listNote.getChildren().add(note);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Notes.getInstance().getObservableList().addListener((ListChangeListener<Note>) change -> {
			while (change.next()) {
				for (Note remitem : change.getRemoved()) {
					listNote.getChildren().remove(remitem.getContainer());
				}
				for (Note n : change.getAddedSubList()) {
					try {

						FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreviewNote.fxml"));

						ControllerPreviewNote controller = new ControllerPreviewNote(n);
						// Set it in the FXMLLoader
						loader.setController(controller);

						GridPane note = loader.load();

						n.setContainer(note);
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

		if (searchField.getText().isEmpty()) {
			listNote.getChildren().remove(0, listNote.getChildren().size());

			for (Note n : Notes.getInstance().getObservableList()) {
				try {

					FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreviewNote.fxml"));

					ControllerPreviewNote controller = new ControllerPreviewNote(n);
					// Set it in the FXMLLoader
					loader.setController(controller);

					GridPane note = loader.load();

					n.setContainer(note);
					listNote.getChildren().add(note);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			ArrayList<Note> list = new ArrayList<Note>();

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

			// Remove current displayed notes
			if (!list.isEmpty() || ((keywordsSearch.isSelected() || titleSearch.isSelected() || noteSearch.isSelected())
					&& !searchField.getText().isEmpty()))
				listNote.getChildren().remove(0, listNote.getChildren().size());

			for (Note n : list) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreviewNote.fxml"));

					ControllerPreviewNote controller = new ControllerPreviewNote(n);
					// Set it in the FXMLLoader
					loader.setController(controller);

					GridPane note = loader.load();

					n.setContainer(note);
					listNote.getChildren().add(note);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// Some examples to fill the Interface
		

		Note n1 = new Note("Cours de musique","J'ai appris le piano debout");
		n1.addKeyword("Musique");
		n1.addKeyword("Piano");
		n1.addKeyword("Cours");
		
		Note n2 = new Note("Cours de Sport","Le tennis de table c'est g�nial");
		n2.addKeyword("Sport");
		n2.addKeyword("Tennis de table");
		n2.addKeyword("Cours");

		Note n3 = new Note("JavaFX","Cours d'interface de JavaFX");
		n3.addKeyword("JavaFX");
		n3.addKeyword("Java");
		
		Note n4 = new Note("Programmation","C, C++, Java, ...");
		n4.addKeyword("C");
		n4.addKeyword("Java");
		n4.addKeyword("C++");
		
		Note n5 =  new Note("Physique Chimie","P = mg\n, ceci est la formule du Poids");
		n5.addKeyword("Cours");
		n5.addKeyword("Physique");
		
		Notes.getInstance().addNote(n1);
		Notes.getInstance().addNote(n2);
		Notes.getInstance().addNote(n3);
		Notes.getInstance().addNote(n4);
		Notes.getInstance().addNote(n5);

		// Radio button state
		final ToggleGroup group = new ToggleGroup();

		keywordButton.setToggleGroup(group);

		titleButton.setToggleGroup(group);

		dateButton.setToggleGroup(group);

		for (Note n : Notes.getInstance().getObservableList()) {
			try {

				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreviewNote.fxml"));

				ControllerPreviewNote controller = new ControllerPreviewNote(n);
				// Set it in the FXMLLoader
				loader.setController(controller);

				GridPane note = loader.load();

				n.setContainer(note);
				listNote.getChildren().add(note);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Add listener to observable list of notes
		Notes.getInstance().getObservableList().addListener((ListChangeListener<Note>) change -> {
			while (change.next()) {
				for (Note remitem : change.getRemoved()) {
					listNote.getChildren().remove(remitem.getContainer());
				}
				for (Note n : change.getAddedSubList()) {
					try {

						FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreviewNote.fxml"));

						ControllerPreviewNote controller = new ControllerPreviewNote(n);
						// Set it in the FXMLLoader
						loader.setController(controller);

						GridPane note = loader.load();

						n.setContainer(note);
						listNote.getChildren().add(note);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		});

		int i = 0;
		// Display 7 most used keywords
		for (Map.Entry<String, Integer> entry : Notes.getInstance().getKeywords().getObservableMap().entrySet()) {
			Button b = new Button(entry.getKey());

			b.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					filterKeyword(entry.getKey());
				}
			});

			keywordsFilter.getChildren().add(b);
			i++;

			if (i >= 6)
				break;
		}

		// Add listener to observable list of used keywords
		Notes.getInstance().getKeywords().getObservableMap()
		.addListener((MapChangeListener<String, Integer>) change -> {
			// Remove the button linked to the removed keyword
			if (change.wasAdded()) {

				Button b = new Button(change.getKey());

				b.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						filterKeyword(change.getKey());
					}
				});

				boolean exist = false;
				Iterator<Node> iter = keywordsFilter.getChildren().iterator();
				while (iter.hasNext() && !exist) {
					Node kw = iter.next();
					if (((Button) kw).getText().equals(change.getKey())) {
						exist = true;
					}
				}

				if (!exist)
					keywordsFilter.getChildren().add(b);

			}

			// Add the button linked to the added keyword
			else {

				if (change.getValueRemoved() <= 1) {
					Iterator<Node> iter = keywordsFilter.getChildren().iterator();
					while (iter.hasNext()) {
						Node kw = iter.next();
						if (((Button) kw).getText().equals(change.getKey())) {
							iter.remove();
						}
					}
				}
			}

		});
	}

	protected void filterKeyword(String key) {
		listNote.getChildren().remove(0, listNote.getChildren().size());

		ArrayList<Note> list = new ArrayList<Note>();
		// Browse all notes
		for (Note n : Notes.getInstance().getObservableList()) {
			for (String kw : n.getKeywords()) {
				if (key.equals(kw)) {
					list.add(n);
				}
			}
		}

		for (Note n : list) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PreviewNote.fxml"));

				ControllerPreviewNote controller = new ControllerPreviewNote(n);
				// Set it in the FXMLLoader
				loader.setController(controller);

				GridPane note = loader.load();

				n.setContainer(note);
				listNote.getChildren().add(note);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
