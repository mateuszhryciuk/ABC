package application;


import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import java.util.*;
import javafx.scene.control.Button;

public class Welcome extends GridPane {
	
	public Welcome(ArrayList<Player> players,Player who){
		
		
		this.setAlignment(Pos.CENTER);
		
		GameFonts font = new GameFonts();
		
		
		VBox gamePane= new VBox();
		TextField center = new TextField();
	
	
		center.setAlignment(Pos.CENTER);
		center.setMaxWidth(500);
		
		
		this.getChildren().add(gamePane);

		gamePane.setSpacing(40.0);
	gamePane.setAlignment(Pos.CENTER);
		
		
	
		
		
		Text  top = new Text("Witaj, poniżej wpisz swoje imię");
		//Text  center = new Text("?");
		Text bottom = new Text("");
		center.setFont(font.mainfont());
		top.setFont(font.scorefont());
		bottom.setFont(font.scorefont());
		Button start = new Button("start");
		start.setOnAction(e->{
			 ABC.setPane(ABC.who.getGame(0));
			
		});
		
		
		Button button = new Button("Dodaj mnie do listy uczniów");
		button.setOnAction(e->{
			
	
			top.setText("Podaj imię !");
			center.setText("imie");
			gamePane.getChildren().remove(button);
		
			
			center.setOnAction(ex -> {
				
				boolean wrongName=false;
				
				String name = center.getText();
				
				for ( int l =0 ;l<players.size();l++ ){
					if ( players.get(l).getName().equals(name)){
						
						wrongName=true;
						break;
					}
					
				}
				
				if(wrongName) {bottom.setText("Pod tym imieniem już ktoś jest zalogowany...");}
				else{
				players.add(new Player(name));
				ABC.menuBar.getMenus().clear();
				ABC.setWho(players.get(players.size()-1));
				//who=null;
				bottom.setText("Witaj " + name.toUpperCase() +"!");
				ABC.loadMenu(players);
				gamePane.getChildren().remove(top);
			gamePane.getChildren().add(start);
				}
				
				
				 
				
				
				
			});
			
			
			
			
			
		});
		
		gamePane.getChildren().addAll(top,center,bottom,button);
		

		center.setOnAction(e -> 
				{
					
					 String name = center.getText().trim();
					 
				//	 bottom.setText(""+players.get(2).getName());
					 
					 for ( int i=0;i< players.size();i++){
						 
						 String temp= players.get(i).getName().trim();
						 
					 if (temp.equals(name)) {
						 
						 ABC.setWho(players.get(i));
						 
						 
						 if (gamePane.getChildren().contains(button)) gamePane.getChildren().remove(button);
//							 
					
							// top.setText("");
						//	 bottom.setText("Witaj ponownie "+temp.toUpperCase()+"!");
						 gamePane.getChildren().remove(top);
							 bottom.setText("Witaj ponownie "+ABC.who.getName()+"!");
						//	 ABC.setGame(ABC.who.gameList.get(0));
							 ABC.menuBar.getMenus().clear();
							 ABC.loadMenu(players);
							 gamePane.getChildren().add(start);
							// top.setText("");
							 
							 
					 }
					
					 
					 
					 else {
						 
						 top.setText("Nie ma takiego ucznia ! ");
					//	 gamePane.getChildren().add(button);
						 
						 
					 }
					 
				
							
							 
						 
						 
						 
				 }
				
			
			
		});
	
		bottom.requestFocus();
		top.requestFocus();
		gamePane.requestFocus();
		
	}
	
	
	
	

}
