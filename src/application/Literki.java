package application;


import javafx.scene.text.Text;
//import javafx.util.Duration;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;



public class Literki extends Game{
	
	
	 Text  top = new Text("punkty:   "+this.getScore());
	 Text  center = new Text("?");
     Text bottom = new Text("Wciśnij literkę");
	 StringArray text = new StringArray();
	
	

	 
	
	
	public Literki (){
		

		gameName="Literki";
	VBox gamePane= new VBox();
	
	this.getChildren().add(gamePane);

	gamePane.setSpacing(60.0);

	
	
	
	GameFonts font = new GameFonts();

	center.setFont(font.mainfont());
	top.setFont(font.scorefont());
	bottom.setFont(font.labelfont());
	gamePane.getChildren().addAll(center,bottom);
	
	}

	
	@Override
	public void play(Player player){

	
	
	center.setOnKeyPressed(e->{
		
		
	    String newest = e.getText();
	    
	    if (!((newest.charAt(0)-97<0)||(newest.charAt(0)-97>25))){
		 center.setText(newest.toUpperCase());
		 this.score++;
		 top.setText("punkty:  "+this.getScore()+"/" +getRewardScore());
		 bottom.setText(text.getText(newest.charAt(0)-97));
		 
	
		ABC.audioplayer.player.get((newest.charAt(0)-97)).play();
		e.consume();

	
	    }
			
	});
	

	
	center.requestFocus();

	
	}

}
