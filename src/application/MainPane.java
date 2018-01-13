package application;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public abstract class MainPane extends GridPane{
	
	public MainPane(){
		this.setAlignment(Pos.CENTER);
	}
	public abstract void play(Player player);
	//public abstract void play();

}
