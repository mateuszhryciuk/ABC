package application;


 import javafx.scene.text.Font;
 import javafx.scene.text.FontWeight;

 
public class GameFonts {
	 
	 public Font mainfont (){
		 
		 Font font =  Font.font ("SansSerif",FontWeight.BOLD,80);
		 
		 return font;
	 }
	 
 public Font smainfont (){
		 
		 Font font =  Font.font ("SansSerif",FontWeight.BOLD,50);
		 
		 return font;
	 }

	 
 public Font scorefont (){
		 
		 Font font =  Font.font ("SansSerif",FontWeight.BOLD,15);
		
		 
		 
		 return font;
	 }
 
 public Font labelfont (){
	 
	 Font font =  Font.font ("Times New Roman",FontWeight.BOLD,30);
	 
	 return font;
 }

}
