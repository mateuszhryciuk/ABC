package application;


import javafx.scene.text.Text;

//import javafx.util.Duration;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
//import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.event.*;
import javafx.scene.input.KeyCode; 


public class Dodawanie extends Game{
	private Button bottom ;
	private int sum ;
	private int a ;
	private int b;
	VBox gamePane= new VBox();
	private void getNums(){
		
		 a = (int)(Math.random()*9);
		 b = (int)(Math.random()*9);	
		 sum=a+b;
		
	}
	
	private HBox center = new HBox();

	
	private TextField equals = new TextField();
	
	
	
	 Text  top = new Text("punkty:   "+this.getScore());
	 Text question = new Text("?");
	// Text bottom = new Text("podaj wynik");
	 Text NameOfPlayer = new Text("");
	// private Button bottom =  new Button ("nastepne ->");
	
	public Dodawanie(){
	this(0);
	
	}
	public Dodawanie(int highscores){
	//	this();
		this.totalScore=highscores;
		bottom = new Button("nastepne ->") ;
		center.setAlignment(Pos.CENTER);
			equals.setMaxWidth(150);
			equals.setMaxHeight(80.0);
			gameName="Dodawanie";
		//	center.setHgap(5);
		//	center.setVgap(5);
			center.getChildren().addAll(question,equals);
		
			
				
		
		
		this.getChildren().add(gamePane);

		gamePane.setSpacing(60.0);
		gamePane.setAlignment(Pos.CENTER);

		
		
		
		GameFonts font = new GameFonts();
		
		
		top.setFill(Color.web("#C31919"));
		
		
		question.setFont(font.smainfont());
		equals.setFont(font.smainfont());
		top.setFont(font.scorefont());
		//bottom.setFont(font.scorefont());
		NameOfPlayer.setFont(font.labelfont());
		gamePane.getChildren().addAll(top,center,bottom,NameOfPlayer);

		
	
	}
	
	
	
	
	

	
	@Override
	public void play(Player player){
	//	gamePane.setAlignment(Pos.CENTER);
		
   bottom.setOnAction(exp->{
	   
	   this.getNums(); 
		
		
		String ask = a +" + "+b +" = ";
		
		question.setText(ask);
	   
	   
	   
	   
   });
		
	String playerName = player.getName();
	
	gamePane.setOnKeyPressed(e->{
		
		if( e.getCode()==KeyCode.SPACE){
			
			
			this.getNums(); 
			
			
			String ask = a +" + "+b +" = ";
			
			question.setText(ask); }
	}
	);
		
		equals.setOnAction(e2 ->{
			
			String guess = equals.getText().trim();
			//guess.trim();
			int x = Integer.parseInt(guess);
			
		if (this.sum==x){
			
			 this.score++;
			 this.totalScore++;
			 top.setText("punkty:  "+this.getScore()+"/" +getRewardScore());
			 ABC.audioplayer.player.get(27).play();
			 getNums();
			 if ( (this.getScore())==(this.getRewardScore())){  
				 ABC.audioplayer.player.get(29).play();
				 NameOfPlayer.setText("Brawo "+playerName+"!");
				this.setRewardScore((this.getRewardScore())+(this.getFactor()));
				this.resetScore();				 
		
			 }
		}
		
		else {
			ABC.audioplayer.player.get(28).play();	
			
		}
				
		});
		
		
			
			
	
		
	

	 equals.requestFocus();
	   center.requestFocus();
}

}

	

	

