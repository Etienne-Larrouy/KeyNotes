package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
	@FXML
	Button button1;
	
	@FXML protected void handleSubmitButton1Action(ActionEvent event) {
		button1.setText("Button pressed maggle");
    }

}
