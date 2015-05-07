package example;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class GameMaster {
	
	static long timer;
	static long startTime = System.currentTimeMillis();
	//static int tempScore;
	
	public static void timer(){	
		long ellapsedTime;
		long ellapsedSeconds;
		ellapsedTime = System.currentTimeMillis() - startTime;
		ellapsedSeconds = ellapsedTime/1000;
		timer = ellapsedSeconds;
	}
	
//	public static int scoreSystem(int fuel, long timer){
//		int scores;
//		scores = 10;
//		return scores;
//	}
	
	public static boolean enterClick(GameContainer gc){
		
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		if(input.isKeyPressed(Input.KEY_ENTER)){ //if left arrow key is pressed
			System.out.println("ENTER");
			startTime = System.currentTimeMillis();
			return true;
		}
		return false;
	}
	
	public static boolean rClick(GameContainer gc){
		
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		if(input.isKeyPressed(Input.KEY_R)){ //if left arrow key is pressed
			return true;
		}
		return false;
	}
	
	public static boolean wClick(GameContainer gc){
		
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		if(input.isKeyPressed(Input.KEY_W)){ //if left arrow key is pressed
			startTime = System.currentTimeMillis();
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
		g.drawString("Time: " + String.valueOf(timer),(float) (ScreenWidth/1.2), (float)(ScreenHeight/30));
		g.drawString("Fuel: " + String.valueOf(Player.fuel),(float)(ScreenWidth/1.2) , (float)(ScreenHeight/15));
		g.drawString("Horizontal speed: " + String.valueOf(Player.yCond), (float)(ScreenWidth/60), (float)(ScreenHeight/30));
		g.drawString("Vertical speed: " + String.valueOf(Player.xSpeed), (float)(ScreenWidth/60), (float)(ScreenHeight/15));
		g.drawString("Score: " + SimpleSlickGame.score, (float)(ScreenWidth/1.2) , (float)(ScreenHeight/7.5));
	}

	public static void GUIRenderTwo(Graphics g,int score, int screenWidth,int screenHeight) {
		g.drawString("Game over",(float) (screenWidth/2.5) , (float) (screenHeight/3));
		g.drawString("Press R to restart",(float) (screenWidth/3) , (float) (screenHeight/2.5));

		g.drawString("Your score is: " + score,(float) (screenWidth/3.1) , (float) (screenHeight/2));

	}
	
	public static void GUIrenderThree(Graphics g,int score, int screenWidth,int screenHeight){
		g.drawString("Congrats",(float) (screenWidth/2.5) , (float) (screenHeight/3));
		g.drawString("Press W to continue",(float) (screenWidth/3.1) , (float) (screenHeight/1.5));
		g.drawString("Your score is: " + score,(float) (screenWidth/3.1) , (float) (screenHeight/2));
	}
	
	public static void gameOver(){
		Player.fuel = 1000;
		//startTime = System.currentTimeMillis();
		// SimpleSlickGame.score = 0;
		SimpleSlickGame.score = 0;
		Player.x1poly = 300;
		Player.y1poly = 0;
		Player.x2poly = 290;
		Player.y2poly = 30;
		Player.x3poly = 310;
		Player.y3poly = 30;
		Player.yCond = 0;
		Player.gravity = 0.0f;
		Player.xSpeed = 0;
		Player.ySpeed = 0;
		Player.rotateState = 0;
		Player.angleState = 0;
		Map.mapGeneration();
		
	}
	
	public static void gameWon(){
		Player.fuel = 1000;
//		tempScore = SimpleSlickGame.score;
//		SimpleSlickGame.score = SimpleSlickGame.score + tempScore;
		Player.x1poly = 300;
		Player.y1poly = 0;
		Player.x2poly = 290;
		Player.y2poly = 30;
		Player.x3poly = 310;
		Player.y3poly = 30;
		Player.yCond = 0;
		Player.gravity = 0.0f;
		Player.xSpeed = 0;
		Player.ySpeed = 0;
		Map.mapGeneration();	
	}

	
	// The gamemaster class needs a timer and score system. 
	// The score will be depending on remaining time and remaining fuel.
	// The GM therefore needs a timer object, fuel object, score object.
	// The GM also needs xSpeed object and ySpeed object so it can be displayed in game
	// GM needs lossCondition and winCondition. Counter for how far player is in game. 
	
}
