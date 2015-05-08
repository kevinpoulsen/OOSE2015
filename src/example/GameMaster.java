package example;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class GameMaster {
	
	
	/**
	 * timer, Declares a long variable used for storing timer, displayed in the GUI.
	 * startTime, Stores the long variable collected from the System.currentTimeMillis() method.
	 * space, Declares a Image variable used for storing a image. 
	 */
	static long timer;
	static long startTime = System.currentTimeMillis();
	private static Image space; 

	/**
	 * Creates timer, based on System.currentTimeMillis()
	 */
	public static void timer(){	
		long ellapsedTime;
		long ellapsedSeconds;
		ellapsedTime = System.currentTimeMillis() - startTime;
		ellapsedSeconds = ellapsedTime/1000;
		timer = ellapsedSeconds;
	}
	
	/**
	 * boolean method that listens to key click. (ENTER)
	 * @param gc Game functionality library included in the Slick2D engine.  
	 * @return  true/false
	 */
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
	
	/**
	 * boolean method that listens to key click. (R)
	 * @param gc Game functionality library included in the Slick2D engine.  
	 * @return  true/false
	 */
	public static boolean rClick(GameContainer gc){
		
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		if(input.isKeyPressed(Input.KEY_R)){ //if left arrow key is pressed
			return true;
		}
		return false;
	}
	
	/**
	 * boolean method that listens to key click. (W)
	 * @param gc, Game functionality library included in the Slick2D engine.  
	 * @return  true/false
	 */
	public static boolean wClick(GameContainer gc){
		
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		if(input.isKeyPressed(Input.KEY_W)){ //if left arrow key is pressed
			startTime = System.currentTimeMillis();
			return true;
		}
		return false;
	}
	
	/**
	 * void method for rendering GUI needed for gameState 0.
	 * @param g, Graphics rendering library included in the Slick2D engine.
	 * @param screenWidth, the width of the game screen, used in the method to display the graphics in relation to the width.  
	 * @param screenHeight, the height of the game screen, used in the method to display the graphics in relation to the height.
	 */
	public static void GUIRenderZero(Graphics g, int screenWidth,int screenHeight) {
		try {
			space = new Image("images/spaceDone.jpg");
		} catch (SlickException e) {
			System.out.println("could not load image 'spaceDone.jpg'");
		}
		space.draw(0,0);
		g.drawString("Insert Coin",(float) (screenWidth/2.5) , (float) (screenHeight/3));
		g.drawString("Press Enter to continue",(float) (screenWidth/3.1) , (float) (screenHeight/2));
		
	}
	/**
	 * void method for rendering GUI needed for gameState 1.
	 * @param g, Graphics rendering library included in the Slick2D engine.
	 * @param screenWidth, the width of the game screen, used in the method to display the graphics in relation to the width.  
	 * @param screenHeight, the height of the game screen, used in the method to display the graphics in relation to the height.
	 */
	public static void GUIRenderOne(Graphics g, int ScreenWidth, int ScreenHeight){
		g.setColor(new Color(255,255,255));
		g.drawString("Time: " + String.valueOf(timer),(float) (ScreenWidth/1.2), (float)(ScreenHeight/30));
		g.drawString("Fuel: " + String.valueOf(Player.fuel),(float)(ScreenWidth/1.2) , (float)(ScreenHeight/15));
		g.drawString("Vertical speed: " + String.valueOf(Player.yCond), (float)(ScreenWidth/60), (float)(ScreenHeight/30));
		g.drawString("Horizontal speed: " + String.valueOf(Player.xSpeed), (float)(ScreenWidth/60), (float)(ScreenHeight/15));
		g.drawString("Score: " + SimpleSlickGame.score, (float)(ScreenWidth/1.2) , (float)(ScreenHeight/7.5));
	}
	
	/**
	 * void method for rendering GUI needed for gameState 2.
	 * @param g, Graphics rendering library included in the Slick2D engine. 
	 * @param score, the score integer is used for displaying the score.
	 * @param screenWidth, the width of the game screen, used in the method to display the graphics in relation to the width.
	 * @param screenHeight, the height of the game screen, used in the method to display the graphics in relation to the height.
	 */
	public static void GUIRenderTwo(Graphics g,int score, int screenWidth,int screenHeight) {
		g.drawString("Game over",(float) (screenWidth/2.5) , (float) (screenHeight/3));
		g.drawString("Press R to restart",(float) (screenWidth/3) , (float) (screenHeight/2.5));

		g.drawString("Your score is: " + score,(float) (screenWidth/3.1) , (float) (screenHeight/2));

	}
	
	/**
	 * void method for rendering GUI needed for gameState 3.
	 * @param g, Graphics rendering library included in the Slick2D engine.
	 * @param score, the score integer is used for displaying the score.
	 * @param screenWidth, the width of the game screen, used in the method to display the graphics in relation to the width.
	 * @param screenHeight, the height of the game screen, used in the method to display the graphics in relation to the height.
	 */
	public static void GUIrenderThree(Graphics g,int score, int screenWidth,int screenHeight){
		g.drawString("Congrats",(float) (screenWidth/2.5) , (float) (screenHeight/3));
		g.drawString("Press W to continue",(float) (screenWidth/3.1) , (float) (screenHeight/1.5));
		g.drawString("Your score is: " + score,(float) (screenWidth/3.1) , (float) (screenHeight/2));
	}
	
	/**
	 * void method that resets all variables in the game and generate a new map. 
	 */
	public static void gameOver(){
		Player.fuel = 1000;
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
	
	/**
	 * void method that resets all variables in the game and generate a new map, except score.  
	 */
	public static void gameWon(){
		Player.fuel = 1000;
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
}
