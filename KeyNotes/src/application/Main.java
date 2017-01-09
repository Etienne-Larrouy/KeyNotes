package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try { 
			AnchorPane page = (AnchorPane) FXMLLoader.load(Main.class.getResource("../Keynotes.fxml"));
			Scene scene = new Scene(page);
			scene.setRoot(page);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("KeyNotes");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void show(){
		System.out.println("SALUT");
	}
	public static void main(String[] args) {
		launch(args);
	}
}
