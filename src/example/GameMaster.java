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
				System.out.println("ENTER");
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
		g.drawString(String.valueOf(Player.yCond), ScreenHeight/2, ScreenWidth/2);
		
	}

	public static void GUIRenderTwo(Graphics g,int score, int screenWidth,int screenHeight) {
		g.drawString("Game over",(float) (screenWidth/2.5) , (float) (screenHeight/3));
		g.drawString("Your score is: ",(float) (screenWidth/3.1) , (float) (screenHeight/2));
		g.drawString(String.valueOf(score),(float) (screenWidth/1.8) , (float) (screenHeight/2));
	}
	
	public static void GUIrenderThree(Graphics g,int score, int screenWidth,int screenHeight){
		g.drawString("Congrats",(float) (screenWidth/2.5) , (float) (screenHeight/3));
		g.drawString("Your score is: ",(float) (screenWidth/3.1) , (float) (screenHeight/2));
	}
	
	public static void gameOver(){
		Player.fuel = 5000;
		timer = 0;
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
	
	public static void gameWon(){
		Player.fuel = 5000;
		timer = 0;
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
	
//	public static void printGameOver(){
//		System.out.println(Player.fuel);
//		System.out.println(timer);
//		System.out.println(Player.x1poly);
//		System.out.println(Player.y1poly);
//		System.out.println(Player.x2poly);
//		System.out.println(Player.y2poly);
//		System.out.println(Player.x3poly);
//		System.out.println(Player.y3poly);
//		System.out.println(Player.yCond);
//		System.out.println(Player.gravity);
//		System.out.println(Player.xSpeed);
//		System.out.println(Player.ySpeed);
//		System.out.println("Map point " + Map.pointArr[3]);
//	}

	
	// The gamemaster class needs a timer and score system. 
	// The score will be depending on remaining time and remaining fuel.
	// The GM therefore needs a timer object, fuel object, score object.
	// The GM also needs xSpeed object and ySpeed object so it can be displayed in game
	// GM needs lossCondition and winCondition. Counter for how far player is in game. 
	
}
