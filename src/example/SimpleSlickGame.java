package example;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class SimpleSlickGame extends BasicGame
{
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	public GameMaster test;	
	long timer;
	public Map mapOne = new Map();
	float[] mapArr;
	float[] currStates = new float[2];
	
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		// The init() method is only called once
		// this is were we place all the stuff needed for the game
		// In our case where we create all the objects (player,map and so on).
		mapArr = mapOne.mapGeneration();
		test = new GameMaster();
	}
	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		// The update function updates your game logic
		// in this case player movement, score and so on.
		
		// int i, i is delta, the integer is the number of miliseconds between each update.
		// an example if you have 10 fps, i = 100

		//timer in seconds is updated here
	
		currStates = Player.playerStates(gc);
		//System.out.println(rotateState);
		Player.playerPosition();
		Player.playerThrust(gc, currStates[0]);
		timer = test.timer();
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		// The render function updates the displayed graphics.
		//Timer in seconds is drawn here
		
		g.drawString("Angle: ", 530, 70);
		g.drawString(String.valueOf(currStates[0]), 600, 70);
		
		g.drawString("Time: ", 530, 40);
		g.drawString(String.valueOf(timer), 600, 40);
		mapOne.mapRenderer(g, mapArr);
		
		Player.playerRenderer(g,currStates[1], gc);
		
	}

	
	
	public static void main(String[] args) // This function starts up the game.
	{		
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
			appgc.setDisplayMode(640, 600, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

