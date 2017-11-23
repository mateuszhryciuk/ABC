package application;

import javafx.scene.layout.Pane;

public abstract class  Game extends Pane  {
	
	
	private int score ;
	private String name ;
	private int rewardScore;
	
	public String getName(){
		return name ;
	}
	public int getScore(){
		return score;
	}
	public int getRewardScore(){
		return rewardScore;
	}
	
	public abstract void play();

}
