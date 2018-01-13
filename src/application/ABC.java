package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import java.util.*;
import java.io.*;

import javafx.application.Platform;

import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
//import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
//import javafx.scene.control.ToggleGroup;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
import javafx.scene.image.Image;


public class ABC extends Application {
	public static AudioPlayer audioplayer =  new AudioPlayer();
	public static BorderPane root = new BorderPane();
	  public static MenuBar menuBar = new MenuBar();
	//    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	
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
		
		
		

	    // File menu - new, save, exit
	    Menu fileMenu = new Menu("Uczeń");
	    Menu whoiswho= new Menu();
	   if ( ABC.who==null) { whoiswho.setText("uczeń niezalogowany");}
	    else {whoiswho.setText("uczeń : "+ABC.who.getName().toUpperCase());}
	//    MenuItem newMenuItem = new MenuItem("New");
	    ArrayList<MenuItem> menuItem =  new ArrayList<>();
	    
	//    newMenuItem.setOnAction(actionEvent -> {
	    	
	//   players.add( new Player("jan",3));
	 //  loadMenu(menuBar,players);
	    	
	//    });
	    
	    for ( int i=0;i<players.size();i++){
	    	
	    	String itemName = players.get(i).getName();
	    	
	    	menuItem.add( new MenuItem(itemName));
	    }
//	    MenuItem sPlayerMenuItem = new MenuItem("SuperPlayer");
	    MenuItem newMenuItem = new MenuItem("nowy uczeń");
	    newMenuItem.setOnAction(e -> root.setCenter(new Welcome(players,ABC.who)));
	    MenuItem exitMenuItem = new MenuItem("Exit");
	    exitMenuItem.setOnAction(e -> {
	    	
//	    	try {
//	    
//	    FileOutputStream fileStream = new FileOutputStream("Players.saved");
//	    ObjectOutputStream os =  new ObjectOutputStream(fileStream);
//	    os.writeObject(players);
//	    os.close();
//	    
//	    
//	    
//	    
//	    	} catch(Exception ex){
//	    		ex.printStackTrace();
//	    		
//	    	}
//	    		finally	{
	    			
	    			
	    			
	    			Platform.exit();
	    			
	    		
//	    		}
	    					
	    					
	    		
	    		
	    		
	    		
	    }
	    		
	    		);
	    
	    
//for ( int i=0;i<menuItem.size();i++){
//	    	
//	fileMenu.getItems().add(menuItem.get(i));
//	
//	
//	    }

	    fileMenu.getItems().addAll( newMenuItem,
	        new SeparatorMenuItem(), exitMenuItem);

	    Menu gameMenu = new Menu("Game");
	    MenuItem LiterkiMenuItem = new CheckMenuItem("Literki");
	    LiterkiMenuItem.setOnAction(e -> ABC.setPane(ABC.who.getGame(0)));
	   // htmlMenuItem.setSelected(true);
	    gameMenu.getItems().add(LiterkiMenuItem);

	    MenuItem ZgadujLiterkiMenuItem = new CheckMenuItem("Zgaduj Literki");
	    ZgadujLiterkiMenuItem.setOnAction(e -> ABC.setPane(ABC.who.getGame(1)));
	   // cssMenuItem.setSelected(true);
	    
	    gameMenu.getItems().add(ZgadujLiterkiMenuItem);

	    Menu scoreMenu = new Menu("HighScore");
	    HighScore highscore = new HighScore();
	    
	    for ( int i=0;i<menuItem.size();i++){
	    	
	    	scoreMenu.getItems().add(menuItem.get(i));
	    	
	    	
	    	    }
	    
      for ( int i=0;i<scoreMenu.getItems().size();i++){
	    	
	    	scoreMenu.getItems().get(i).setOnAction(e->{
	    		
	    	//	Iterator<Player> iter = players.iterator();
	    	//	if (iter.hasNext()){
	    		setPane(highscore);
	    				highscore.play(who);
	    				
	    	//}
	    		
	    	});
	    	
	    	
	    	    }
	    
 
	

	

	    menuBar.getMenus().addAll(fileMenu, gameMenu, scoreMenu,whoiswho);
		
		
		
		
		
		
	}

	
//	Game literki = new Literki();
	
	
	
	
	
	

Anima start = new Anima ();


	
	  @Override
	  public void start(Stage primaryStage) {
		  ArrayList<Player> players= new ArrayList<Player>();

//			try {
//				FileInputStream fileStream = new FileInputStream("Players.saved");
//				ObjectInputStream os = new ObjectInputStream(fileStream);
//			Object playersList = os.readObject();
//				
//				 players = (ArrayList) playersList;
//				 os.close();
//				
//			}catch(Exception ex ){
//				
//				ex.printStackTrace();
//				 players = new ArrayList<>();
//				
//			}  
		  
		  
//		  Player who = null;
	//	  Welcome welcome = new Welcome(players,who);
		  menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
//		  players.add(new Player ("imie" ));
	//	  players.add(new Player ("imiyyy" ));
		//  players.add(new Player ("i" ));
		  
		  
		  
		 primaryStage.getIcons().add(new Image((getClass().getClassLoader().getResource("abc.png").toString())));
	    
	    Scene scene = new Scene(start, 600, 350, Color.WHITE);
	    Scene startScene = new Scene(root,600,500);

	  //  MenuBar menuBar = new MenuBar();
	    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	    root.setTop(menuBar);
	    
	
	    

	    start.play(primaryStage,startScene);

	    
	    //setGame(root,literki);      waząna metoda na przyszłośc
	    loadMenu(players);
	    root.setCenter(new Welcome(players,ABC.who));
	    


	    primaryStage.setScene(scene);
	    primaryStage.show();
	  }
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
