package application;

import java.util.*;

public class Player {
	
	protected String name ;
	private int age ;
	ArrayList<Game> gameList = new ArrayList<>();
	
	public Player(String name  ){
		
		this.name = name;
//		this.age = age;
		gameList.add(new Literki());
	}
	
	
	
	public String getName(){
		return name ;
	}
	
	public int getAge () {
		
		return age;
	
	}
	
	public Game getGame(int num){
		
		return gameList.get(num);
	}
	 public Player getPlayer (){
		 
		 return this;
	 }
	 
	 

	
	
	

}
