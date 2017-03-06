package view;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try { 
			Pane page = FXMLLoader.load(Main.class.getResource("../view/Accueil.fxml"));
			Scene scene = new Scene(page);
			scene.setRoot(page);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("KeyNotes");
			primaryStage.setMinWidth(600.0);
			primaryStage.setMinHeight(400.0);
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
