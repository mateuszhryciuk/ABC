package application;

import java.util.*;


public class Player implements Comparable<Player> {
	
	protected String name ;
	private int playerScore;
	
	ArrayList<Game> gameList = new ArrayList<>();
	
	public Player(){
		
		this.name = "noname";

		gameList.add(new Literki());
		gameList.add(new ZgadujLiterki());
		gameList.add(new Dodawanie());
		gameList.add(new Mnozenie());
	}
	
	public Player(String name){
		
		this.name = name;

		gameList.add(new Literki());
		gameList.add(new ZgadujLiterki());
		gameList.add(new Dodawanie());
		gameList.add(new Mnozenie());
	}
public Player(String name,int highscores1,int highscores2, int highscores3){
		
		this.name = name;
//		this.age = age;
		gameList.add(new Literki());
		gameList.add(new ZgadujLiterki(highscores1));
		gameList.add(new Dodawanie(highscores2));
		gameList.add(new Mnozenie(highscores3));
	}
	
	
	
	public String getName(){
		return name ;
	}
	
	
	
	public Game getGame(int num){
		
		return gameList.get(num);
	}
	 public Player getPlayer (){
		 
		 return this;
	 }
	 public int gameListSize(){
		 return gameList.size();
	 }
	 
 
 public int getPlayerScore(){
	 
	  return this.playerScore;
	 
	 
	 
 }
 public void updatePlayerScore(){
	 int playerScore=0;
	 for (int i=1;i<this.gameListSize();i++){
		 playerScore += this.getGame(i).getTotalScore();
	 }
	  this.playerScore=playerScore;
	 
	 }
 public int compareTo(Player p){
	 return this.getPlayerScore()-p.getPlayerScore();
	 
 }
 
	 
 }


