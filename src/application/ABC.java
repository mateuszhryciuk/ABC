package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import java.util.*;
//import javafx.application.Application;
import javafx.application.Platform;
//import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
import javafx.scene.image.Image;


public class ABC extends Application {
	public static BorderPane root = new BorderPane();
	  public static MenuBar menuBar = new MenuBar();
	//    menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
	
	public static Player who = null;
	public static void setWho(Player player){
		
		who = player;
	}
	
	public static void  setGame(BorderPane root , Game game){
		
		 root.setCenter(game);
		
		    game.play();
	}
	
	public static void  setGame(Game game){
		
		 
		root.setCenter(game);
		    game.play();
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
	    MenuItem sPlayerMenuItem = new MenuItem("SuperPlayer");
	    MenuItem newMenuItem = new MenuItem("nowy uczeń");
	    newMenuItem.setOnAction(e -> root.setCenter(new Welcome(players,ABC.who)));
	    MenuItem exitMenuItem = new MenuItem("Exit");
	    exitMenuItem.setOnAction(e -> Platform.exit());
	    
	    
for ( int i=0;i<menuItem.size();i++){
	    	
	fileMenu.getItems().add(menuItem.get(i));
	
	
	    }

	    fileMenu.getItems().addAll( sPlayerMenuItem,newMenuItem,
	        new SeparatorMenuItem(), exitMenuItem);

	    Menu webMenu = new Menu("Game");
	    CheckMenuItem htmlMenuItem = new CheckMenuItem("HTML");
	    htmlMenuItem.setSelected(true);
	    webMenu.getItems().add(htmlMenuItem);

	    CheckMenuItem cssMenuItem = new CheckMenuItem("CSS");
	    cssMenuItem.setSelected(true);
	    webMenu.getItems().add(cssMenuItem);

	    Menu sqlMenu = new Menu("HighScore");
	    ToggleGroup tGroup = new ToggleGroup();
	    RadioMenuItem mysqlItem = new RadioMenuItem("MySQL");
	    mysqlItem.setToggleGroup(tGroup);

	    RadioMenuItem oracleItem = new RadioMenuItem("Oracle");
	    oracleItem.setToggleGroup(tGroup);
	    oracleItem.setSelected(true);

	    sqlMenu.getItems().addAll(mysqlItem, oracleItem,
	        new SeparatorMenuItem());

	    Menu tutorialManeu = new Menu("Tutorial");
	    tutorialManeu.getItems().addAll(
	        new CheckMenuItem("Java"),
	        new CheckMenuItem("JavaFX"),
	        new CheckMenuItem("Swing"));

	    sqlMenu.getItems().add(tutorialManeu);

	    menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu,whoiswho);
		
		
		
		
		
		
	}

	
	Game literki = new Literki();
	ArrayList<Player> players = new ArrayList<>();

Anima start = new Anima ();


	
	  @Override
	  public void start(Stage primaryStage) {
		  
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
