package application;

import javafx.scene.layout.Pane;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
public abstract class  Game extends GridPane  {
	
	
	protected int score ;
	protected String name ;
	protected int rewardScore;
	
	public Game ( ){
		this.setAlignment(Pos.CENTER);
		name = this.getClass().getSimpleName();
		score = 0;
		rewardScore=10;
	}
	
	public String getName(){
		return name ;
	}
	public int getScore(){
		return score;
	}
	public int getRewardScore(){
		return rewardScore;
	}
	public void setRewardScore(int reward){
		rewardScore=reward;
	}
	
	public abstract void play();{}

}
