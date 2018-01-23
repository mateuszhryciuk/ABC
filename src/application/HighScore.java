package application;

//import java.util.Arrays;
import java.util.Collections;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class HighScore extends MainPane{
	VBox Pane= new VBox();
	
	
	public HighScore(){
		
	//	VBox Pane= new VBox();
	//	this.getChildren().add(Pane);
		Pane.setSpacing(3.0);
		
		
	}
	
	
	public void play(Player player){
		
		Pane.getChildren().clear();
		String playerName =  player.getName();
		this.setAlignment(Pos.TOP_CENTER);
		
		for ( int i = 0 ; i<ABC.players.size();i++){
			
			ABC.players.get(i).updatePlayerScore();			
		}
		
		Collections.sort(ABC.players);
			
		
		
		int j=0;
		for ( int i = ABC.players.size()-1;i>=0;i--){
			j++;
		
		
		
	//	this.getChildren().add(Pane);
	
	//	this.setVgap(5);
	//	Pane.setSpacing(5.0);
//		gamePane.setAlignment(Pos.CENTER);
		Text pos = new Text(""+j+".");
			Text  top = new Text(ABC.players.get(i).getName());
		Text  center1 = new Text(player.getGame(1).getName()+" : "+(ABC.players.get(i).getGame(1).getTotalScore()));
		Text  center2 = new Text(player.getGame(2).getName()+" : "+(ABC.players.get(i).getGame(2).getTotalScore()));
		Text  center3 = new Text(player.getGame(3).getName()+" : "+(ABC.players.get(i).getGame(3).getTotalScore()));
		Text  bottom = new Text("");
	//	Text  ncenter = new Text(ABC.players.get(i).getGame(0).gameName);
	//	Text  nbottom = new Text(Integer.toString(ABC.players.get(i).getGame(1).getTotalScore()));
	
		
		
		
		
		GameFonts font = new GameFonts();
		//String score = Integer.toString(this.getScore());
//		Text player=new Text(ABC.who.getName());
		
		if(playerName.equals(ABC.players.get(i).getName())) {top.setFill(Color.web("#D70000"));}
		
		center1.setFill(Color.web("#707070"));
		center2.setFill(Color.web("#707070"));
		center3.setFill(Color.web("#707070"));
		pos.setFill(Color.web("#707070"));
		//player.setFont(font.scorefont(aa));
		pos.setFont(font.smainfont());
		center1.setFont(font.scorefont());
		center2.setFont(font.scorefont());
		center3.setFont(font.scorefont());
	//	bottom.setFont(font.scorefont());
		top.setFont(font.labelfont());
		
		//this.setAlignment(Pos.CENTER);
		
		//ScrollPane scroll = new ScrollPane();
		Pane.getChildren().addAll(pos,top,center1,center2,center3,bottom);
		//scroll.setContent(Pane);
		Pane.setAlignment(Pos.CENTER);
		ScrollPane scroll = new ScrollPane(Pane);
		scroll.setFitToWidth(true);
		scroll.setPrefSize(600, 600);
		

		this.getChildren().add(scroll);
		
		
		
		
		
		
	}
	}
}

