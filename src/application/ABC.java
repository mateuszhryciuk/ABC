package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import java.util.*;


public class ABC extends Application {
	
	Anima start = new Anima ();
	ArrayList<Player> players ;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane primaryPane = new BorderPane();
			Scene scene = new Scene(start,600,350);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			Scene primaryScene=new Scene(primaryPane,800,700);
			start.play(primaryStage,primaryScene);
			start=null;
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
