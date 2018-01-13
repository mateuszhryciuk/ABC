package application;

//import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.*;
import javafx.scene.text.FontWeight;
//import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
/////import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.media.MediaView;
//import java.io.File;
//import javafx.scene.image.Image;

public class Anima extends Pane{
	
	
		
		public void play (Stage stage , Scene scene){
	
			
		//	Media introSound =  new Media (getClass().getClassLoader().getResource("xylophone.wav").toString());
		//	MediaPlayer mediaPlayer = new MediaPlayer(introSound);
		
			 
			 Line line1 = new Line();
			 line1.setStartX(0);
			 line1.startYProperty().bind(this.heightProperty().divide(2));
			 line1.setEndX(230);
			 line1.endYProperty().bind(this.heightProperty().divide(2));
			 
			 Line line2 = new Line();
			 line2.setStartX(0);
			 line2.startYProperty().bind(this.heightProperty().divide(4));
			 line2.setEndX(359);
			 line2.endYProperty().bind(this.heightProperty().divide(2));
			
			 Line line3 = new Line();
			 line3.setStartX(600);
			 line3.startYProperty().bind(this.heightProperty().divide(2));
			 line3.setEndX(414);
			 line3.endYProperty().bind(this.heightProperty().divide(2));
			 
			 Line lineA = new Line();
			 lineA.setStartX(400);
			 lineA.startYProperty().bind(this.heightProperty().divide(2));
			 lineA.setEndX(220);
			 lineA.endYProperty().bind(this.heightProperty().divide(2));
			 
			 Line lineB = new Line();
			 lineB.setStartX(359);
			 lineB.startYProperty().bind(this.heightProperty().divide(2));
			 lineB.setEndX(279);
			 lineB.endYProperty().bind(this.heightProperty().divide(2));
			 
			 Line lineC = new Line();
			 lineC.setStartX(414);
			 lineC.startYProperty().bind(this.heightProperty().divide(2));
			 lineC.setEndX(334);
			 lineC.endYProperty().bind(this.heightProperty().divide(2));
			 			 			 			 
						 
			 Font font =  Font.font ("SansSerif",FontWeight.BOLD,80);
			 
			Text labelA = new Text("A");
			labelA.setFont(font);
			
			Text labelB= new Text("B");
			labelB.setFont(font);
			
			Text labelC = new Text("C");
			labelC.setFont(font);
			
			
			 
			 PathTransition path1 = new PathTransition();
			 path1.setDuration(Duration.millis(200));
			 path1.setPath(line1);
			 path1.setNode(labelA);
			 
			 FillTransition  fillA = new FillTransition ( Duration.millis(1),labelA,Color.web("#242424"),Color.web("#C00909"));
			 
			 PathTransition path2 = new PathTransition();
			 path2.setDuration(Duration.millis(580));
			 path2.setPath(line2);
	
			 
			 RotateTransition rotate = new RotateTransition();
			 rotate.setDuration(Duration.millis(580));
			 rotate.setByAngle(740);
	
			 
			 ParallelTransition parallel = new ParallelTransition (labelB,path2,rotate);
			 
			 FillTransition  fillB = new FillTransition ( Duration.millis(1),labelB,Color.web("#242424"),Color.web("#4486F4"));
			 
			 PathTransition path3 = new PathTransition();
			 path3.setDuration(Duration.millis(150));
			 path3.setPath(line3);
			 path3.setNode(labelC);
			 
			 FillTransition  fillC = new FillTransition ( Duration.millis(1),labelC,Color.web("#242424"),Color.web("#FABB05"));
			 
			 PathTransition pathA = new PathTransition();
			 pathA.setDuration(Duration.millis(30));
			 pathA.setPath(lineA);
			 pathA.setNode(labelA);
			 
			 PathTransition pathB = new PathTransition();
			 pathB.setDuration(Duration.millis(30));
			 pathB.setPath(lineB);
			 pathB.setNode(labelB);
			 
			 
			 PathTransition pathC = new PathTransition();
			 pathC.setDuration(Duration.millis(30));
			 pathC.setPath(lineC);
			 pathC.setNode(labelC);
			 
			 
			 
			 
		     EventHandler<ActionEvent> eventHandlerC = e ->{
			     this.getChildren().add(labelC); };
			 
			 EventHandler<ActionEvent> eventHandlerB = e ->{
				// mediaPlayer.play();
				 
				 ABC.audioplayer.player.get(26).play();
				 this.getChildren().add(labelB);};
				 
				 EventHandler<ActionEvent> eventHandlerAll = e ->{					 
					 pathA.play();
					 pathB.play();
					 pathC.play();
				
					
					};
					
					EventHandler<ActionEvent> eventHandlerEnd = e ->{
						
					     stage.setScene(scene);
						};

		 KeyFrame KeyFrameC = new KeyFrame(Duration.millis(1),eventHandlerC);
		 KeyFrame KeyFrameB = new KeyFrame(Duration.millis(1),eventHandlerB);
		 KeyFrame KeyFrameAll = new KeyFrame(Duration.millis(1),eventHandlerAll);
		 KeyFrame KeyFrameEnd = new KeyFrame(Duration.millis(3000),eventHandlerEnd);

			 
	
		 Timeline animB = new Timeline (KeyFrameB);
		 Timeline animC = new Timeline(KeyFrameC);
		 Timeline animAll = new Timeline(KeyFrameAll);
		 Timeline animEnd = new Timeline(KeyFrameEnd);
			 
			 this.getChildren().add(labelA);
			 
			 SequentialTransition sTransition1 = new SequentialTransition();
		 sTransition1.getChildren().addAll(path1,fillA,animB,parallel,fillB,animC,path3,fillC,animAll,animEnd);
	
		 sTransition1.play();
		 this.getChildren().add(labelB);
		 			 
			
		}
}
	


