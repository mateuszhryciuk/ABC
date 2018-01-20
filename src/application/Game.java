package application;



public abstract class  Game extends MainPane  {
	
	protected String gameName;
	protected int score ;
	protected int totalScore;
	protected String name ;
	protected int rewardScore;
	protected int factor;
	
	
	public Game ( ){
	
		name = this.getClass().getSimpleName();
		score = 0;
		rewardScore=10;
		factor=2;
		totalScore=0;
		gameName=null;
	}
	public Game (int highscores ){
	
			name = this.getClass().getSimpleName();
			score = 0;
			rewardScore=10;
			factor=2;
			totalScore=highscores;
			gameName=null;
		}
	
	public String getName(){
		return name ;
	}
	public int getScore(){
		return score;
	}
	public void resetScore(){
		this.score=0;
	}
	public int getRewardScore(){
		return rewardScore;
	}
	public void setRewardScore(int reward){
		rewardScore=reward;
	}
	public void setFactor(int factor){
		this.factor=factor;
	}
	public int getTotalScore(){
		return totalScore;
	}
	
	
	public int getFactor(){
		return factor ;}
	public String getGameName(){
		return gameName;
	}
	

	
	

}
