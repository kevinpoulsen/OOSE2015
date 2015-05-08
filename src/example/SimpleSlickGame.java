package example;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class SimpleSlickGame extends BasicGame
{
	
	/**
	 * The SimpleSlickGame class includes the methods init(), update(), render() and main().
	 * @param gamename
	 */
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}
	
	// Declarations used for storing variables related to the sound implementation.
	private Music music; // variable to hold music sound files
	private Sound blast; // variable to hold sound 
	public Sound soundThrust;
	public boolean play = true; //boolean to ensure that the "blast" sound is only played once upon death
	
	// Declaring screen width and height.
	static int screenWidth = 600;
	static int screenHeight = 600;
	
	// Declaring game state which will handle which state the player is in. 
	int gameState;
	public static int score;
	float rotateState;
	
	// Declaring booleans for loss and win conditions
	boolean collisionBool;
	boolean offScreenBool;
	boolean continueBool;
	boolean padOneBool;
	boolean padTwoBool;
	boolean padThreeBool;
	
	// Declaring booleans for reseting game variables.
	boolean winBool;
	boolean resetBool;

	// Declaring a array of floats used for storing the array from the map generation method (Map.mapGeneration())
	float[] mapArr;
	
	// Stores angleState and rotateState from Class Player (currStates[0] = angleState and currStates[1] = rotateState)
	float[] currStates = new float[2];

	
	// The init() method is only called once, when the game starts (init method is from the Slick2D game engine library)
	@Override
	public void init(GameContainer gc) throws SlickException {
		
		// MANGLER COMMENT
		mapArr = Map.mapGeneration();
		music = new Music("sounds/music.ogg");
		soundThrust = new Sound("sounds/thrust.ogg");
		blast = new Sound("sounds/blastLow.ogg");

		gameState = 0;
		score = 0;

	} // void init()
	
	//The update method updates your game logic, frame for frame(update method is from the Slick2D game engine library)
	// int i, i is delta, the integer is the number of miliseconds between each update. an example if you have 10 fps, i = 100
	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		// following if statements listen to the gameState and updates based on the state.
		if(gameState == 0){
			resetBool = false;
			continueBool = GameMaster.enterClick(gc); // listens to player input 
			music.play(); // starts the background music
		}
		
		if(gameState == 1){
			play = true; // sets play to true so the "blast" sound can be replayed
			GameMaster.timer(); // calling the time method from Class GameMaster to update the time.
			
			currStates = Player.playerStates(gc); // calling the playerStates method from Class Player to update the angle and rotation state of the player.
			Player.playerPosition(); // calling the playerPosition method from Class Player to update the position of the player.
			Player.playerThrust(gc, currStates[0]); // // calling the playerThrust method from Class Player to listen to the thrust of the player based on angleState.
			Player.playerOffScreen(gc); // warns user if player is off screen
			
			// Initializing the loss condition booleans. 
			collisionBool = Player.onCollision(Map.mapShape); // collisionBool is set to the boolean condition of onCollision method from Player class which takes the shape of map and checks if it intersects with shape of player.
			offScreenBool = Player.playerOffScreen(gc); // is set to boolean condition of playerOffScreen method in player class. Checks if any of the player coordinates is outside gamescreen.

			// Is set to boolean condition of onCollision method which checks collision between player and rectangles(landing pads)
			padOneBool = Player.onCollision(Map.rectOne);
			padTwoBool = Player.onCollision(Map.rectTwo);
			padThreeBool = Player.onCollision(Map.rectThree);
			
			continueBool = false;
			winBool = false;
		}
		
		if(gameState == 2){
			//if statement to ensure that the "blast" sound is only played once when the player crashes
			if(play){ 
			blast.play();
			play = false;	// sets the boolean play to false so that "blast" will not be played again
			}
			collisionBool = false;
			offScreenBool = false;
			resetBool = GameMaster.rClick(gc); // listens to player input
		}
		
		if(gameState == 3){
			padOneBool = false;
			padTwoBool = false;
			padThreeBool = false;
			winBool = GameMaster.wClick(gc); // listens to player input
		}
		
		if(continueBool == true){
			gameState = 1;
		}
		
		// loss condition. Sets game state to 2(game over) if collision is detected.
		if(collisionBool == true){
			
			music.stop(); // stops the background music upon death
			gameState = 2; // gameState 2 displays the "game over" screen
		}
		// loss condition. Sets game state to 2(game over) if player runs out of fuel.
		if(Player.fuel <= 0){
			gameState = 2;
		}
		// loss condition. Sets game state to 2(game over) if player coordinates go off screen.
		if(offScreenBool == true){
			gameState = 2;
		}
		// Win condition. Checks if player have collided with the landing pads in the correct angle state, 
		//and with the correct amount of speed along the y axis. Sets the game state to 3 if all requirements is met.
		if(padOneBool == true && Player.angleState == 0 && Player.yCond < 10){
			score += Player.fuel/GameMaster.timer;
			gameState = 3;
			
		}
		
		if(padTwoBool == true && Player.angleState == 0 && Player.yCond < 10){
			score+= Player.fuel/GameMaster.timer;
			gameState = 3;
		}

		if(padThreeBool == true && Player.angleState == 0 && Player.yCond < 10){
			score+= Player.fuel/GameMaster.timer;
			gameState = 3;
		}		
		
		// if statements allowing reset game functionality (if loss or win)
		if(winBool == true){
			GameMaster.gameWon();
			gameState = 1;
		}
		
		if(resetBool == true){
			GameMaster.gameOver();
			gameState = 0;
		}
	} // void update()

	@Override
	// void render displays the graphics of the game up the game based on screen width and height.
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		// following if statements render based on gameState. 
		if(gameState == 0){
			GameMaster.GUIRenderZero(g, screenWidth, screenHeight); // render graphics from GUIRenderZero Method from Class GameMaster
		}
		
		if(gameState == 1){
			GameMaster.GUIRenderOne(g,screenWidth, screenHeight); // render graphics from GUIRenderOne() Method from Class GameMaster
			Map.mapRenderer(g,mapArr); // render Map from mapRenderer() Method from Class Map
			Player.playerRenderer(g,currStates[1], gc); // render Player from playerRenderer() Method from Class Player
			
		}

		if(gameState == 2){
			GameMaster.GUIRenderTwo(g, score, screenWidth, screenHeight); // render graphics from GUIRenderTwo() Method from Class GameMaster
		}
		
		if(gameState == 3){
			GameMaster.GUIrenderThree(g, score, screenWidth, screenHeight); // render graphics from GUIRenderThree() Method from Class GameMaster
		}
	} // void render()

	// void main starts up the game based on screen width and height.
	public static void main(String[] args)
	{		
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));

			appgc.setDisplayMode(screenWidth, screenHeight, false);
			appgc.setShowFPS(false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	} // void main()
} // Class SimpleSlickGame
