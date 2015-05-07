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
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}
	
	private Music music; // variable to hold music sound files
	private Sound sound; // variable to hold sound effect files

	// Declaring GameMaster class.
	public GameMaster gm;	
	// Declaring screen width and height.
	static int screenWidth = 640;
	static int screenHeight = 600;
	// Declaring game state which will handle which state the player is in. 
	int gameState;
	
	int score;
	long timer;
	int fuel;
	public Map mapOne = new Map();

	float rotateState;
	
	//Declaring booleans for loss conditions
	boolean collisionBool;
	boolean offScreenBool;
	boolean continueBool;

	float[] mapArr;
	
	float[] currStates = new float[2];
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		// The init() method is only called once
		// this is were we place all the stuff needed for the game
		// In our case where we create all the objects (player,map and so on).
		mapArr = Map.mapGeneration();
		music = new Music("sounds/music.ogg");
		
		gm = new GameMaster();
		gameState = 0;
		score = 10;

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
			timer = gm.timer();
			fuel = Player.fuelLeft();
			currStates = Player.playerStates(gc);
			Player.playerPosition();
			Player.playerThrust(gc, currStates[0]);
			Player.playerOffScreen(gc); // warns user if player is off screen
			// Initializing the loss condition booleans. 
			// collisionBool is set to the bool condition of onCollision method from Player class which takes the shape of map and checks if it intersects with shape of player.
			collisionBool = Player.onCollision(Map.mapShape);
			// is set to bool condition of playerOffScreen method in player class. Checks if any of the player coordinates is outside gamescreen.
			offScreenBool = Player.playerOffScreen(gc);
		}
		
		if(gameState == 2){
			
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
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.drawString("State " + gameState, 100, 100);
		
		if(gameState == 0){
			GameMaster.GUIRenderZero(g, screenWidth, screenHeight);
		}
		
		if(gameState == 1){
			GameMaster.GUIRenderOne(g, timer, fuel, screenWidth, screenHeight);
			mapOne.mapRenderer(g, mapArr);
			Player.playerRenderer(g,currStates[1], gc);
		}

		if(gameState == 2){
			GameMaster.GUIRenderTwo(g, score, screenWidth, screenHeight);
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
