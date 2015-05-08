package example;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class GameMaster {
	
	static long timer; // timer, Declares a long variable used for storing timer, displayed in the GUI.
	static long startTime = System.currentTimeMillis(); // startTime, Stores the long variable collected from the System.currentTimeMillis() method. 
	private static Image space; // space, Declares a Image variable used for storing a image. 
	private static Image victory;
	private static Image crash;

	
	/**
	 * Creates timer, based on System.currentTimeMillis(). Using the constant variable startTime and subtracting that from System.currentTimeMillis()
	 * to store the time passed by since the start of the game. 
	 */
	public static void timer(){	
		long ellapsedTime;
		long ellapsedSeconds;
		ellapsedTime = System.currentTimeMillis() - startTime; // Subtracting the startTime from the current time.
		ellapsedSeconds = ellapsedTime/1000; // Divide by a 1000 for displaying.
		timer = ellapsedSeconds;
	} // void timer()
	
	/**
	 * boolean method that listens to key click. (ENTER)
	 * @param gc, Game functionality library included in the Slick2D engine.  
	 * @return  true/false
	 */
	public static boolean enterClick(GameContainer gc){
		
		// input, declaring and initializing from slick library to listen for keyboard input.
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		// if statement which returns boolean state, when the space key is pressed.
		if(input.isKeyPressed(Input.KEY_ENTER)){ //if Enter arrow key is pressed
			startTime = System.currentTimeMillis();
			return true;
		}
		return false;
	} // boolean enterClick()
	
	/**
	 * boolean method that listens to key click. (R)
	 * @param gc, Game functionality library included in the Slick2D engine.  
	 * @return  true/false
	 */
	public static boolean rClick(GameContainer gc){
		
		// input, declaring and initializing from slick library to listen for keyboard input.
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		// if statement which returns boolean state, when the space key is pressed.
		if(input.isKeyPressed(Input.KEY_R)){ //if R arrow key is pressed
			return true;
		}
		return false;
	} // boolean rClick()
	
	/**
	 * boolean method that listens to key click. (W)
	 * @param gc, Game functionality library included in the Slick2D engine.  
	 * @return  true/false
	 */
	public static boolean wClick(GameContainer gc){
		
		// input, declaring and initializing from slick library to listen for keyboard input.
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		// if statement which returns boolean state, when the space key is pressed.
		if(input.isKeyPressed(Input.KEY_W)){ //if w arrow key is pressed
			startTime = System.currentTimeMillis();
			return true;
		}
		return false;
	} // boolean wClick()
	
	/**
	 * void method for rendering GUI needed for gameState 0.
	 * @param g, Graphics rendering library included in the Slick2D engine.
	 * @param screenWidth, the width of the game screen, used in the method to display the graphics in relation to the width.  
	 * @param screenHeight, the height of the game screen, used in the method to display the graphics in relation to the height.
	 */
	public static void GUIRenderZero(Graphics g, int screenWidth,int screenHeight) {
		// try: to load background image, catch(if failing): Draw string (Failed to load background image) 
		try {
			space = new Image("images/spaceDone.jpg");
		} catch (SlickException e) {
			g.drawString("Failed to load background image",(float) (screenWidth/3.1) , (float) (screenHeight/2));
		}
		// Draw background image. 
		space.draw(screenWidth-screenWidth,screenHeight-screenHeight);
		
		// Draws GUI based on screen width and height (Strings)
		g.drawString("Insert Coin",(float) (screenWidth/2.5) , (float) (screenHeight/3));
		g.drawString("Press Enter to continue",(float) (screenWidth/3.1) , (float) (screenHeight/2));
		g.drawString("Gameplay info:",(float) (screenWidth/15) , (float) (screenHeight/1.22));
		g.drawString("The aircraft has to land with a vertical speed below 5.",(float) (screenWidth/15) , (float) (screenHeight/1.15));
		g.drawString("Press Space to thrust, Press left or right arrow to rotate.",(float) (screenWidth/15) , (float) (screenHeight/1.1));
		
	} // void GUIRenderZero()
	
	/**
	 * void method for rendering GUI needed for gameState 1.
	 * @param g, Graphics rendering library included in the Slick2D engine.
	 * @param screenWidth, the width of the game screen, used in the method to display the graphics in relation to the width.  
	 * @param screenHeight, the height of the game screen, used in the method to display the graphics in relation to the height.
	 */
	public static void GUIRenderOne(Graphics g, int ScreenWidth, int ScreenHeight){

		g.drawString("Time: " + String.valueOf(timer),(float) (ScreenWidth/1.2), (float)(ScreenHeight/30));
		g.drawString("Fuel: " + String.valueOf(Player.fuel),(float)(ScreenWidth/1.2) , (float)(ScreenHeight/15));
		g.drawString("Vertical speed: " + String.valueOf(Player.yCond), (float)(ScreenWidth/60), (float)(ScreenHeight/30));
		g.drawString("Horizontal speed: " + String.valueOf(Player.xSpeed), (float)(ScreenWidth/60), (float)(ScreenHeight/15));
		g.drawString("Score: " + SimpleSlickGame.score, (float)(ScreenWidth/1.2) , (float)(ScreenHeight/7.5));
	} // GUIRenderOne()
	
	/**
	 * void method for rendering GUI needed for gameState 2.
	 * @param g, Graphics rendering library included in the Slick2D engine. 
	 * @param score, the score integer is used for displaying the score.
	 * @param screenWidth, the width of the game screen, used in the method to display the graphics in relation to the width.
	 * @param screenHeight, the height of the game screen, used in the method to display the graphics in relation to the height.
	 */
	public static void GUIRenderTwo(Graphics g,int score, int screenWidth,int screenHeight) {
		// try: to load background image, catch(if failing): Draw string (Failed to load background image) 
		try {
			crash = new Image("Images/crash.jpg");
		} catch (SlickException e) {
			g.drawString("Failed to load background image",(float) (screenWidth/3.1) , (float) (screenHeight/2));
		}
		// Draw background image.
		crash.draw(screenWidth-screenWidth,screenHeight-screenHeight);
		
		// Draws GUI for game over screen based on screen width and height   ( strings,score)
		g.drawString("Game over",(float) (screenWidth/2.5) , (float) (screenHeight/3));
		g.drawString("Press R to restart",(float) (screenWidth/3.1) , (float) (screenHeight/2.5));
		g.drawString("Your score is: " + score,(float) (screenWidth/3.1) , (float) (screenHeight/2));

	} // void GUIRenderTwo()
	
	/**
	 * void method for rendering GUI needed for gameState 3.
	 * @param g, Graphics rendering library included in the Slick2D engine.
	 * @param score, the score integer is used for displaying the score.
	 * @param screenWidth, the width of the game screen, used in the method to display the graphics in relation to the width.
	 * @param screenHeight, the height of the game screen, used in the method to display the graphics in relation to the height.
	 */
	public static void GUIrenderThree(Graphics g,int score, int screenWidth,int screenHeight){
		// try: to load background image, catch(if failing): Draw string (Failed to load background image) 
		try {
			victory = new Image("Images/victory1.jpg");
		} catch (SlickException e) {
			g.drawString("Failed to load background image",(float) (screenWidth/3.1) , (float) (screenHeight/2));
		}
		// Draw background image.
		victory.draw(screenWidth-screenWidth,screenHeight-screenHeight);
		
		// Draws GUI for game over screen based on screen width and height
		g.drawString("One small step for man, one giant leap for mankind",(float) (screenWidth/7.5) , (float) (screenHeight/5));
		g.drawString("Press W to continue",(float) (screenWidth/3.1) , (float) (screenHeight/1.5));

		g.drawString("Your score is: " + score,(float) (screenWidth/3.1) , (float) (screenHeight/4));
	} // void GUIrenderThree()

	
	/**
	 * void method that resets all variables in the game and generate a new map. 
	 */
	public static void gameOver(){
		// reset values from Class Player
		SimpleSlickGame.score = 0;
		
		// reset values from Class Player
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
		
		// calls the map generation method to create a new map when game over.
		Map.mapGeneration();	
	} // void gameOver()
	
	/**
	 * void method that resets all variables in the game and generate a new map, except score.  
	 */
	public static void gameWon(){
		// reset values from Class Player
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
		
		// calls the map generation method to create a new map when game over.
		Map.mapGeneration();	
	}	
}
