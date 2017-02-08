package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Note;
import model.Notes;

public class ControllerNewNote {

	@FXML
	private TextField title;

	@FXML
	private TextArea content;

	@FXML
	private Text statusbar;
	
	@FXML
	private TextField keyword;
	
	@FXML
	private HBox keywords_container;

	@FXML
	protected void newNote(ActionEvent event) {
		if (title.getText().isEmpty()) {
			statusbar.setText("Title cannot be empty");
		} else if (content.getText().isEmpty()) {
			statusbar.setText("Content cannot be empty");
		} else {
			Note n = new Note(title.getText(), content.getText(), Notes.getInstance().getObservableList().size());
			Notes.getInstance().addNote(n);
			
			int i = 0;
			for(Node kw : keywords_container.getChildren()){
				if(i>1){
					n.addKeyword(((Label)(((HBox)kw).getChildren().get(0))).getText());
					Notes.getInstance().getKeywords().addKeyword(((Label)(((HBox)kw).getChildren().get(0))).getText());
				}
				i++;
			}
			
			Stage stage = (Stage) title.getScene().getWindow();
			stage.close();
		}

	}
	
	
	@FXML
	public void addKeyword(ActionEvent event){
		Button b = new Button("x");
		HBox hbox = new HBox(new Label(keyword.getText()), b);
		
		b.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent actionEvent) {
		    	keywords_container.getChildren().remove(hbox);
		    }
		});
		
		keywords_container.getChildren().add(hbox);
	}


	
	@FXML
	protected void handleReturn(ActionEvent event) {

	}
}
