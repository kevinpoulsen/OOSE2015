package example;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class GameMaster {
	
	public long startTime = System.currentTimeMillis();
	long ellapsedTime;
	long ellapsedSeconds;
	String drawTimer;
	int remainFuel;	
	
	public long timer(){
		ellapsedTime = System.currentTimeMillis() - startTime;
		ellapsedSeconds = ellapsedTime/1000;
		return ellapsedSeconds;
	}
	
	public static void GUIRenderZero(Graphics g, int screenWidth,int screenHeight) {
		g.drawString("Insert Coin",(float) (screenWidth/2.5) , (float) (screenHeight/3));
		g.drawString("Press Enter to continue",(float) (screenWidth/3.1) , (float) (screenHeight/2));
		
	}
	
	public static void GUIRenderOne(Graphics g, long timer,int fuel, int ScreenWidth, int ScreenHeight){
		g.setColor(new Color(255,255,255));
		g.drawString("Time: ",ScreenWidth/2 , ScreenHeight/2);
		g.drawString(String.valueOf(timer), ScreenWidth/2, ScreenHeight/2);
		g.drawString("Fuel: ",ScreenWidth/2 , ScreenHeight/2);
		g.drawString(String.valueOf(fuel), ScreenWidth/2 , ScreenHeight/2);
		
	}

	public static void GUIRenderTwo(Graphics g,int score, int screenWidth,int screenHeight) {
		g.drawString("Game over",(float) (screenWidth/2.5) , (float) (screenHeight/3));
		g.drawString("Your score is: ",(float) (screenWidth/3.1) , (float) (screenHeight/2));
		g.drawString(String.valueOf(score),(float) (screenWidth/3.1) , (float) (screenHeight/2));
	}

	
	// The gamemaster class needs a timer and score system. 
	// The score will be depending on remaining time and remaining fuel.
	// The GM therefore needs a timer object, fuel object, score object.
	// The GM also needs xSpeed object and ySpeed object so it can be displayed in game
	// GM needs lossCondition and winCondition. Counter for how far player is in game. 
	

	
}
