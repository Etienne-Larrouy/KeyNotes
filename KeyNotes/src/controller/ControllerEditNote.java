package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Note;

public class ControllerEditNote implements Initializable{

	private ArrayList<String> removedKeywords = new ArrayList<String>();
	private Stage stage;
	private Note currentNote;

	@FXML
	private HBox keywords_container;

	@FXML
	private TextField title;

	@FXML
	private TextField keyword;

	@FXML
	private TextArea content;

	@FXML
	private Text statusbar;

	public ControllerEditNote(Note n, Stage s) {
		this.currentNote = n;
		this.stage = s;
	}

	@FXML
	public void addKeyword(ActionEvent event){
		Button b = new Button("x");
		HBox hbox = new HBox(new Label(keyword.getText()), b);
		if(!this.currentNote.getKeywords().contains(keyword.getText())){
			b.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					keywords_container.getChildren().remove(hbox);
					
				}
			});

			keywords_container.getChildren().add(hbox);
		}
	}


	@FXML
	public void saveChanges(ActionEvent event){
		if(title.getText().isEmpty()){
			statusbar.setText("Title cannot be empty");
		}
		else if(content.getText().isEmpty()){
			statusbar.setText("Content cannot be empty");
		}
		else{
			this.currentNote.setTitle(title.getText());
			this.currentNote.setTexte(content.getText());

			int i = 0;
			for(Node kw : keywords_container.getChildren()){
				if(i>1){
					if(!this.currentNote.getKeywords().contains(((Label)(((HBox)kw).getChildren().get(0))).getText())){
						this.currentNote.addKeyword(((Label)(((HBox)kw).getChildren().get(0))).getText());
					}
				}
				i++;
			}
			
			for(String kw : removedKeywords){
				this.currentNote.removeKeyword(kw);
			}

		}

		try {

			Parent root = null;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Note.fxml"));

			ControllerNote controller = new ControllerNote(currentNote);
			// Set it in the FXMLLoader
			loader.setController(controller);

			root = (Parent) loader.load();

			Scene scene = new Scene(root);
			this.stage.setScene(scene);
			this.stage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		title.setText(currentNote.getTitle());
		content.setText(currentNote.getTexte());

		for(String kw : currentNote.getKeywords()){
			Button b = new Button("x");
			HBox hbox = new HBox(new Label(kw), b);

			b.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					removedKeywords.add(kw);
					keywords_container.getChildren().remove(hbox);
					currentNote.getObservableListKeywords().remove(kw);
				}
			});

			keywords_container.getChildren().add(hbox);
		}

	}

}
