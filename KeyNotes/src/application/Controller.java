package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {
	@FXML private Text actiontarget;

	@FXML protected void handleSubmitButtonAction(ActionEvent event) {
		actiontarget.setText("Button pressed maggle");
	}

}
