package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Notes;

public class ControllerPreviewNote{

	@FXML
	private Text NotePreview_id;

	@FXML
	public void openTask(MouseEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Note.fxml"));


		ControllerNote controller = new ControllerNote(Notes.getInstance().getObservableList().get(Integer.parseInt(NotePreview_id.getText())));
		// Set it in the FXMLLoader
		loader.setController(controller);

		stage = new Stage();

		root = (Parent)loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}


