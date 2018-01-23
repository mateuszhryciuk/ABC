package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import java.util.*;
import java.io.*;

import javafx.application.Platform;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import javafx.scene.control.SeparatorMenuItem;

import javafx.scene.image.Image;


public class ABC extends Application {
	Anima start = new Anima ();
	public static AudioPlayer audioplayer =  new AudioPlayer();
	public static BorderPane root = new BorderPane();
	  public static MenuBar menuBar = new MenuBar();
	  public static File savedData= new File ("scores.txt");
	  public static ArrayList<Player> players =new ArrayList<Player>();

	
	public static Player who = null;
	public static void setWho(Player player){
		
		who = player;
	}
	
	public static void  setPane(BorderPane root , MainPane pane){
		
		 root.setCenter(pane);
		
		    pane.play(who);
	}
	
	public static void  setPane(MainPane pane){
		
		 
		root.setCenter(pane);
		    pane.play(who);
	}
	
	public static void loadMenu( ArrayList<Player> players){
		
		
		

	
	    Menu fileMenu = new Menu("Uczeń");
	    Menu whoiswho= new Menu();
	   if ( ABC.who==null) { whoiswho.setText("uczeń niezalogowany");}
	    else {whoiswho.setText("uczeń : "+ABC.who.getName().toUpperCase());}

	    ArrayList<MenuItem> menuItem =  new ArrayList<>();
	    
	
	    
	    for ( int i=0;i<players.size();i++){
	    	
	    	String itemName = players.get(i).getName();
	    	
	    	menuItem.add( new MenuItem(itemName));
	    }

	    MenuItem newMenuItem = new MenuItem("kolejny uczeń");
	    newMenuItem.setOnAction(e -> root.setCenter(new Welcome(players,ABC.who)));
	    MenuItem exitMenuItem = new MenuItem("Zapis wyników i wyjście");
	    exitMenuItem.setOnAction(e -> {
	    	
   	try {
	    
   
   		FileWriter fw =  new FileWriter(savedData);
 
   	    PrintWriter writer = new PrintWriter(fw);
	
	    String data = new String();
	    
	    for (int i=0;i<players.size();i++){
	    	data=players.get(i).getName()+","+players.get(i).getGame(1).getName()+","+players.get(i).getGame(1).getTotalScore()+","+players.get(i).getGame(2).getTotalScore()+","+players.get(i).getGame(3).getTotalScore();
	    	writer.println(data);
	    	
	    }
	  writer.println("---Date---"+new Date());
	//savedData.delete();                                                                             //     kasowanie danych
	   writer.close();
	    
	    
	    
	    
	    	} catch(Exception ex){
	    		ex.printStackTrace();
	    		
	    	}
	    		
	    			
	    	
	    			Platform.exit();}
	    			
	
	    		
	    		);
	    


	    fileMenu.getItems().addAll( newMenuItem,
	        new SeparatorMenuItem(), exitMenuItem);

	    Menu gameMenu = new Menu("Ćwiczenia");
	    MenuItem LiterkiMenuItem = new MenuItem("Literki");
	    LiterkiMenuItem.setOnAction(e -> ABC.setPane(ABC.who.getGame(0)));
	
	    gameMenu.getItems().add(LiterkiMenuItem);

	    MenuItem ZgadujLiterkiMenuItem = new MenuItem("Zgaduj Literki");
	    ZgadujLiterkiMenuItem.setOnAction(e -> ABC.setPane(ABC.who.getGame(1)));
	 
	    
	    gameMenu.getItems().add(ZgadujLiterkiMenuItem);
	    
	    MenuItem DodawanieMenuItem = new MenuItem("Dodawanie");
	    DodawanieMenuItem.setOnAction(e -> ABC.setPane(ABC.who.getGame(2))); 
	    
	    gameMenu.getItems().add(DodawanieMenuItem);
	    
	    MenuItem MnozenieMenuItem = new MenuItem("Mnożenie");
	    MnozenieMenuItem.setOnAction(e -> ABC.setPane(ABC.who.getGame(3))); 
	    
	    gameMenu.getItems().add(MnozenieMenuItem);
	    

	    Menu scoreMenu = new Menu("Wyniki");
	    HighScore highscore = new HighScore();
	    MenuItem showScores = new MenuItem("Pokaż wyniki");
	    showScores.setOnAction(e -> {
	    
	    setPane(highscore);
		highscore.play(who);
	    
	    		
	    		
	    		
	    		
	    });
	    scoreMenu.getItems().add(showScores);
	    
	  

	    menuBar.getMenus().addAll(fileMenu, gameMenu, scoreMenu,whoiswho);

	}





	
	  @Override
	  public void start(Stage primaryStage) {
		  String data;
		
		 
		  if (savedData.exists()) {System.out.println("Saved data file is available");
		 try{ 
		  Scanner file = new Scanner(savedData);
		  
		  do {
		  data = file.nextLine();
		  String [] playersData = data.split(",");
	  System.out.println(playersData[0]);
	  
	  
	//  System.out.println(playersData.length);
	 

		
	  
	  
	  System.out.println(playersData[2]);
		  players.add(new Player(playersData[0],Integer.parseInt(playersData[2]),Integer.parseInt(playersData[3]),Integer.parseInt(playersData[4])));
		 
	
		  
		  
		  }while ( file.hasNext() &&(!data.contains("---Date---")));
			  
	
			  
			  
			  
			  
		  
		 
		  file.close();}
		 catch(Exception ex){
			 
			 ex.printStackTrace();
		 }
		  
		  
		  

		  }else {
		  
			  
		  System.out.println("Saved data not available , using empty players list");
		
		  }


		  menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

		  
		  
		  
		 primaryStage.getIcons().add(new Image((getClass().getClassLoader().getResource("abc.png").toString())));
	    
	    Scene scene = new Scene(start, 600, 350, Color.WHITE);
	    Scene startScene = new Scene(root,600,500);

	
	    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	    root.setTop(menuBar);
	    
	
	    

	    start.play(primaryStage,startScene);

	    
	 
	    loadMenu(players);
	    root.setCenter(new Welcome(players,ABC.who));
	    


	    primaryStage.setScene(scene);
	    primaryStage.show();
	  }
	
	
	
	
	public static void main(String[] args) {
		
		
		
		
		launch(args);
	}
}
