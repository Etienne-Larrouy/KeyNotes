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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Note;

public class ControllerEditNote implements Initializable{

	private Stage stage;
	private Note currentNote;
	
	@FXML
	private TextField title;
	
	@FXML
	private TextArea content;
	
	@FXML
	private Text statusbar;
	
	public ControllerEditNote(Note n, Stage s) {
		this.currentNote = n;
		this.stage = s;
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
	}

}
