package application;

import java.util.*;
import java.io.*;

public class Player implements Serializable{
	
	protected String name ;
	private int age ;
	ArrayList<Game> gameList = new ArrayList<>();
	
	public Player(){
		
		this.name = "noname";
//		this.age = age;
		gameList.add(new Literki());
		gameList.add(new ZgadujLiterki());
	}
	
	public Player(String name){
		
		this.name = name;
//		this.age = age;
		gameList.add(new Literki());
		gameList.add(new ZgadujLiterki());
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
	 public int gameListSize(){
		 return gameList.size();
	 }
	 
	 

	
	
	

}
