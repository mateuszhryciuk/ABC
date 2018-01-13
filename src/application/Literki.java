package application;


import javafx.scene.text.Text;
//import javafx.util.Duration;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
//import javafx.scene.shape.Line;

//import com.sun.org.apache.xerces.internal.util.Status;

//import javafx.animation.PathTransition;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.layout.FlowPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.media.MediaPlayer.Status;


public class Literki extends Game{
	
	
	 Text  top = new Text("punkty:   "+this.getScore());
	 Text  center = new Text("?");
     Text bottom = new Text("Wciśnij literkę");
	 StringArray text = new StringArray();
	
	

	 
	
	
	public Literki (){
		
	//	this.rewardScore=reward;
	
	

		gameName="Literki";
	VBox gamePane= new VBox();
	
	this.getChildren().add(gamePane);
//	this.setAlignment(Pos.CENTER);
	//this.setVgap(30);
	gamePane.setSpacing(60.0);
//	gamePane.setAlignment(Pos.CENTER);
	
	
	
	GameFonts font = new GameFonts();
	//String score = Integer.toString(this.getScore());
//	Text player=new Text(ABC.who.getName());
	
	//player.setFont(font.scorefont());
	center.setFont(font.mainfont());
	top.setFont(font.scorefont());
	bottom.setFont(font.labelfont());
	gamePane.getChildren().addAll(center,bottom);
	
	}

	
	@Override
	public void play(Player player){
		
	//	String playerName = player.getName();
		
		
		
	 
//	 
//	 Line line1 = new Line();
//	 line1.setStartX(0);
//	 line1.startYProperty().bind(this.heightProperty().divide(2));
//	 line1.setEndX(230);
//	 line1.endYProperty().bind(this.heightProperty().divide(2));
//	
//	 PathTransition path1 = new PathTransition();
//	 path1.setDuration(Duration.millis(200));
//	 path1.setPath(line1);
//	
	
	
	center.setOnKeyPressed(e->{
		
		
	    String newest = e.getText();
	    
	    if (!((newest.charAt(0)-97<0)||(newest.charAt(0)-97>25))){
		 center.setText(newest.toUpperCase());
		 this.score++;
		 top.setText("punkty:  "+this.getScore()+"/" +getRewardScore());
		 bottom.setText(text.getText(newest.charAt(0)-97));
		 
		// System.out.println((newest.charAt(1)));
		ABC.audioplayer.player.get((newest.charAt(0)-97)).play();
		e.consume();
//		Status  status = ABC.audioplayer.player.getStatus();
		
	
	    }
			
	});
	
//	center.setOnKeyReleased(e->{
//		
//		gamePane.setCenter(center);
//		gamePane.setTop(top);
//	});
	
	center.requestFocus();
//	bottom.requestFocus();
    // top.requestFocus();
	
	}

}
