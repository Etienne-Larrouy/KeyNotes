package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {
	@FXML protected Text actiontarget;

	@FXML 
	protected void handleSubmitButton1Action(ActionEvent event) {
		actiontarget.setText("Button pressed maggle");
	}

}
