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
	// hej jeg committer lige....
	
	int xPosition; // players x position on the screen
	int yPosition; // players y position on the screen
	
	float xSpeed;  // players speed in the x direction
	float ySpeed;  // players speed in the y direction
	int fuel;	   // fuel decreases as the players uses thrust
	static int angleState; // determines the way the player is facing,
					// this alters the way the thrust function will move the player
	
	static float x1 = 100;
	static float y1 = 300;
	static int width = 25;
	static int height = 25;
	
	public float playerGravity(){
		float gravity = 0.0f;
		gravity += (float) 0.5;
		return gravity;
	}
		
	public static void playerThrust(GameContainer gc)
	{	
		
		if(input.isKeyDown(Input.KEY_SPACE))
		{
			
		}
	}
	
	public void playerRenderer(Graphics gc)
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
	
	public static void playerRotate(GameContainer gc)
	{
		
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		if(input.isKeyPressed(input.KEY_LEFT)){ //if left arrow key is pressed
			angleState--;
			if(angleState == -1){
				angleState = 7;
			}
			System.out.println(angleState);
		}
		if(input.isKeyPressed(input.KEY_RIGHT)){
			angleState++;
			if(angleState == 8){
				angleState = 0;
			}
			System.out.println(angleState);
		}
		
		// if angleState changes rotate player

		
	} // void playerRotate()

}
