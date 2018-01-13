package application;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class HighScore extends MainPane{
	
	
	public HighScore(Player player){
		this.play(player);
	}
	
	
	public void play(Player player){
		
		
		String playerName =  player.getName();
		VBox Pane= new VBox();
		
		
		
	
			
			
			
		
		
		
		for ( int i = 1 ; i<player.gameListSize();i++){
		
		
		
		this.getChildren().add(Pane);
//		this.setAlignment(Pos.CENTER);
		//this.setVgap(30);
		Pane.setSpacing(60.0);
//		gamePane.setAlignment(Pos.CENTER);
		

		Text  top = new Text(player.getGame(i).gameName);
		Text  center = new Text(Integer.toString(player.getGame(i).getTotalScore()));
		Text bottom = new Text();
		
		
		
		
		GameFonts font = new GameFonts();
		//String score = Integer.toString(this.getScore());
//		Text player=new Text(ABC.who.getName());
		
		center.setFill(Color.web("#707070"));
		
		//player.setFont(font.scorefont());
		center.setFont(font.mainfont());
		bottom.setFont(font.scorefont());
		top.setFont(font.labelfont());
		Pane.getChildren().addAll(top,center,bottom);
		
		
		
		
		
		
		
	}
	}
}

