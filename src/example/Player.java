package example;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Player {
	//player variables: 
	
	int xPosition; // players x position on the screen
	int yPosition; // players y position on the screen
	
	float xSpeed;  // players speed in the x direction
	float ySpeed;  // players speed in the y direction
	int fuel;	   // fuel decreases as the players uses thrust
	float gravity; // gravity pulls player in the +y direction
	int angleState; // determines the way the player is facing,
					// this alters the way the thrust function will move the player
	static float x1 = 100;
	static float y1 = 300;
	static int width = 25;
	static int height = 25;
	
	
	
	public static void playerThrust(GameContainer gc)
	{
		/*if (key.space)
			move player in direction player is facing
			
		*/
		
		// using keyboard input: 
		/*Input input;
		input = gc.getInput();
			
		if(input.isKeyDown(Input.KEY_SPACE))
		{
			Player.y1--;
		}*/
		
		
		
	}
	
	public void playerDraw(Graphics gc)
	{
		// gc.drawRect uses an x and y position and a width and height input to draw a rectangle
		gc.drawRect(x1, y1, width, height);
		
		
		// Main player:
		// draw player (in shape of a triangle) using position x and y.
		// function must be updated all the time
		// uses the angleState to draw the player,
		// angleState 0 is when the player is in the neutral upright position
	    // angleState 1 is +45 degrees
		// angleState 7 is +315 degrees
		
		
		// Exhaust:
		// when playerThrust is being called, draw some exhaust at the bottom of player
	}	
	
	public static void playerRotate()
	{
		// should enable the player to rotate to 8 different angles using the arrow keys on the keyboard.
		// if(key.left && angleState <= 0)
		// angleState++;
		
		// if(key.right && angleState >= 7)
		// angleState--;
		

		
	}

}
