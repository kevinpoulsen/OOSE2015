package example;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;


public class SimpleSlickGame extends BasicGame
{
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}
	// Declaring screen width and height.
	static int screenWidth = 640;
	static int screenHeight = 600;
	// Declaring game state which will handle which state the player is in. 
	int gameState;
	
	int score;
	
	Input inp;

	float rotateState;
	
	// Declaring booleans for loss conditions
	boolean collisionBool;
	boolean offScreenBool;
	boolean continueBool;
	
	// Declaring booleans for win conditions
	boolean padOneBool;
	boolean padTwoBool;
	boolean padThreeBool;

	// Stores 
	float[] mapArr;
	
	// Stores angleState and rotateState from Class Player (currStates[0] = angleState and currStates[1] = rotateState)
	float[] currStates = new float[2];
	
	private Music music; // variable to hold music sound files
	private Sound sound; // variable to hold music sound files
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		// The init() method is only called once
		// this is were we place all the stuff needed for the game
		// In our case where we create all the objects (player,map and so on).
		mapArr = Map.mapGeneration();
		music = new Music("sounds/music.ogg");
		gameState = 0;
		score = 10;
		inp = gc.getInput();

	}
	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		// The update function updates your game logic
		// in this case player movement, score and so on.
		
		// int i, i is delta, the integer is the number of miliseconds between each update.
		// an example if you have 10 fps, i = 100

		// following if statements update the desired functions based in which state the game is in.
		if(gameState == 0){
			continueBool = GameMaster.enterClick(gc);
			music.play();
		}
		
		if(gameState == 1){
			GameMaster.timer();
			currStates = Player.playerStates(gc);
			Player.playerPosition();
			Player.playerThrust(gc, currStates[0]);
			Player.playerOffScreen(gc); // warns user if player is off screen
			// Initializing the loss condition booleans. 
			// collisionBool is set to the bool condition of onCollision method from Player class which takes the shape of map and checks if it intersects with shape of player.
			collisionBool = Player.onCollision(Map.mapShape);
			// is set to bool condition of playerOffScreen method in player class. Checks if any of the player coordinates is outside gamescreen.
			offScreenBool = Player.playerOffScreen(gc);
			// Is set to bool condition of onCollision method which checks collision between player and rectangles(landing pads)
			padOneBool = Player.onCollision(Map.rectOne);
			padTwoBool = Player.onCollision(Map.rectTwo);
			padThreeBool = Player.onCollision(Map.rectThree);
			continueBool = false;
		}
		
		if(gameState == 2){
			collisionBool = false;
			
		}
		
		if(gameState == 3){
			
		}
		
		if(continueBool == true){
			gameState = 1;
		}
		
		// loss condition. Sets game state to 2(game over) if collision is detected.
		if(collisionBool == true){
			// explosion sound
			sound = new Sound("sounds/blastLow.ogg");
			sound.play();
			gameState = 2;
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
		if(padOneBool == true && Player.angleState == 0 && Player.yCond < 2){
			gameState = 3;
		}
		// Same win condition, another landing pad.
		if(padTwoBool == true && Player.angleState == 0 && Player.yCond < 2){
			gameState = 3;
		}
		// Same win condition, last landing pad.
		if(padThreeBool == true && Player.angleState == 0 && Player.yCond < 2){
			gameState = 3;
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.drawString("State " + gameState, 100, 100);
		g.drawString("bool" + continueBool, 400, 100);
		g.drawString("colBool" + collisionBool, 400, 120);
		
		if(gameState == 0){
			GameMaster.GUIRenderZero(g, screenWidth, screenHeight);
		}
		
		if(gameState == 1){
			GameMaster.GUIRenderOne(g,screenWidth, screenHeight);
			Map.mapRenderer(g,mapArr);			
			Player.playerRenderer(g,currStates[1], gc);
			
		}

		if(gameState == 2){
			GameMaster.GUIRenderTwo(g, score, screenWidth, screenHeight);
		}
		
		if(gameState == 3){
			GameMaster.GUIrenderThree(g, score, screenWidth, screenHeight);
		}
	}

	
	public static void main(String[] args) // This function starts up the game.
	{		
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));

			appgc.setDisplayMode(screenWidth, screenHeight, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
