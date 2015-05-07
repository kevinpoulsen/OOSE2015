package example;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class GameMaster {
	
	static long startTime = System.currentTimeMillis();
	static long timer;
	String drawTimer;
	
	public static void timer(){
		long ellapsedTime;
		long ellapsedSeconds;
		ellapsedTime = System.currentTimeMillis() - startTime;
		ellapsedSeconds = ellapsedTime/1000;
		timer = ellapsedSeconds;
	}
	
	public static boolean enterClick(GameContainer gc){
		
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		if(input.isKeyPressed(Input.KEY_ENTER)){ //if left arrow key is pressed
				return true;
		}
		return false;
	}
	
	public static void GUIRenderZero(Graphics g, int screenWidth,int screenHeight) {
		g.drawString("Insert Coin",(float) (screenWidth/2.5) , (float) (screenHeight/3));
		g.drawString("Press Enter to continue",(float) (screenWidth/3.1) , (float) (screenHeight/2));
		
	}
	
	public static void GUIRenderOne(Graphics g, int ScreenWidth, int ScreenHeight){
		g.setColor(new Color(255,255,255));
		g.drawString("Time: ",(float) (ScreenWidth/1.2), (float)(ScreenHeight/30));
		g.drawString(String.valueOf(GameMaster.timer), (float)(ScreenWidth/1.1), (float)(ScreenHeight/30));
		g.drawString("Fuel: ",(float)(ScreenWidth/1.2) , (float)(ScreenHeight/15));
		g.drawString(String.valueOf(Player.fuel),(float) (ScreenWidth/1.1) ,(float) (ScreenHeight/15));
		
	}

	public static void GUIRenderTwo(Graphics g,int score, int screenWidth,int screenHeight) {
		g.drawString("Game over",(float) (screenWidth/2.5) , (float) (screenHeight/3));
		g.drawString("Your score is: ",(float) (screenWidth/3.1) , (float) (screenHeight/2));
		g.drawString(String.valueOf(score),(float) (screenWidth/1.8) , (float) (screenHeight/2));
	}

	
	// The gamemaster class needs a timer and score system. 
	// The score will be depending on remaining time and remaining fuel.
	// The GM therefore needs a timer object, fuel object, score object.
	// The GM also needs xSpeed object and ySpeed object so it can be displayed in game
	// GM needs lossCondition and winCondition. Counter for how far player is in game. 
	
}
