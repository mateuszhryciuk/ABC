
package application;


import javafx.scene.text.Text;
//import javafx.util.Duration;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
////import javafx.scene.shape.Line;
//import javafx.animation.PathTransition;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.layout.FlowPane;
//import javafx.scene.layout.VBox;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.event.*;
import javafx.scene.input.KeyCode; 


public class ZgadujLiterki extends Game{
	
	 private int keyCode;
	private int playsound(){
		
		 int temp = (int)(Math.random()*26);
	
		ABC.audioplayer.player.get(temp).play();
		
		return temp;
	}
	
	 StringArray text = new StringArray();
	 Text  top = new Text("punkty:   "+this.getScore());
	 Text  center = new Text("?");
	 Text bottom = new Text("zgadnij literkę");
	 Text NameOfPlayer = new Text("");
	
	public ZgadujLiterki(){
		
		//this.setRewardScore(10);
		gameName="Zgaduj Literki";
		
		
	
	
	
	
	
	VBox gamePane= new VBox();
	
	this.getChildren().add(gamePane);
//	this.setAlignment(Pos.CENTER);
	//this.setVgap(30);
	gamePane.setSpacing(60.0);
//	gamePane.setAlignment(Pos.CENTER);
	
	
	
	GameFonts font = new GameFonts();
	//String score = Integer.toString(this.getScore());
//	Text player=new Text(ABC.who.getName());
	
	top.setFill(Color.web("#C31919"));
	
	//player.setFont(font.scorefont());
	center.setFont(font.mainfont());
	top.setFont(font.scorefont());
	bottom.setFont(font.labelfont());
	NameOfPlayer.setFont(font.labelfont());
	gamePane.getChildren().addAll(top,center,bottom,NameOfPlayer);
	
	}

	
	
	 
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
	
	@Override
	public void play(Player player){
	String playerName = player.getName();
	
	center.setOnKeyPressed(e->{
		//int temp=0;
		if(e.getCode()==KeyCode.SPACE){
		this.keyCode=playsound();
		}else {
			 String newest = e.getText();
			 if (!((newest.charAt(0)-97<0)||(newest.charAt(0)-97>25))){
		
			    	if (this.keyCode==(newest.charAt(0)-97)){
			    //	System.out.println(temp);
				 center.setText(newest.toUpperCase());
				 this.score++;
				 this.totalScore++;
				 
				 top.setText("punkty:  "+this.getScore()+"/" +getRewardScore());
				 NameOfPlayer.setText("");
				 bottom.setText(text.getText(newest.charAt(0)-97));
				 ABC.audioplayer.player.get(27).play();
				 this.keyCode=99;
				 if ( (this.getScore())==(this.getRewardScore())){ 
					 ABC.audioplayer.player.get(29).play();
					 NameOfPlayer.setText("Brawo "+playerName+"!");
					this.setRewardScore((this.getRewardScore())+(this.getFactor()));
					this.resetScore();
				 }
			    	}else { ABC.audioplayer.player.get(28).play();
}
			
			
			
		}
		
		
		
//	int temp;
	   
	    
//	    gamePane.addEventFilter(KeyEvent.KEY_PRESSED, event->{
//            if (event.getCode() == KeyCode.SPACE) { int temp=playsound();
//                System.out.println("GOOD");
	    
	   
		 
		// System.out.println((newest.charAt(1)));
	//	ABC.audioplayer.player.get((newest.charAt(0)-97)+1).play();
	
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
