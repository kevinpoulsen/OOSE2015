package example;

public class GameMaster {
	
	
	
	public long startTime = System.currentTimeMillis();
	long ellapsedTime;
	long ellapsedSeconds;
	String drawTimer;
	
	
	public long timer(){
		ellapsedTime = System.currentTimeMillis() - startTime;
		ellapsedSeconds = ellapsedTime/1000;
		return ellapsedSeconds;
	}
	

	
	
	
	// The gamemaster class needs a timer and score system. 
	// The score will be depending on remaining time and remaining fuel.
	// The GM therefore needs a timer object, fuel object, score object.
	// The GM also needs xSpeed object and ySpeed object so it can be displayed in game
	// GM needs lossCondition and winCondition. Counter for how far player is in game. 
	

	
}
