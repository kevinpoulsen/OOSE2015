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
	
	static float xSpeed;  // players speed in the x direction
	static float ySpeed;  // players speed in the y direction
	static int fuel = 5000;	   // fuel decreases as the players uses thrust
	static float gravity = 0.2f; // gravity pulls player in the +y direction
	static int angleState; // determines the way the player is facing,
					// this alters the way the thrust function will move the player
	
	static String fuelLeft = " Fuel"; // used to display fuel left on the game screen
	static float xPosition = 100;
	static float yPosition = 300;
	static int width = 25;
	static int height = 25;
	public static void playerThrust(GameContainer gc, int angleState)
	{
		float ds = 0.0001f; // diagonal speed
		float ns = 0.0002f; // normal speed
		
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		if(input.isKeyDown(Input.KEY_SPACE))
		{
			fuel--;
			
		 	if(angleState == 0){
				ySpeed -= ns; 
			}
			if(angleState == 1){
				ySpeed -= ds;
				xSpeed += ds;
			}
			if(angleState == 2){
				xSpeed +=ns;
			}
			if(angleState == 3){
				ySpeed += ds;
				xSpeed += ds;
			}
			if(angleState == 4){
				ySpeed += ns;
			}
			if(angleState == 5){
				ySpeed += ds;
				xSpeed -= ds;
			}
			if(angleState == 6){
				xSpeed -= ns;
			}
			if(angleState == 7){
				ySpeed -= ds;
				xSpeed -= ds;
			}
		}// if (input.isKeyDown(Input.KEY_SPACE))
	}// void playerThrust
	
	public static void playerPosition(){
		gravity += 0.00001f;
		xPosition += xSpeed;
		yPosition += ySpeed + gravity;
	}
	
	public static void playerRenderer(Graphics g)
	{
		// gc.drawRect uses an x and y position and a width and height input to draw a rectangle
		
		g.drawOval(xPosition, yPosition, 50, 50);
		
		g.drawString(String.valueOf(fuel) + fuelLeft, 530, 10);
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
	
	
	
	public static int playerAngleState(GameContainer gc)
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
		if(input.isKeyPressed(Input.KEY_RIGHT)){
			angleState++;
			if(angleState == 8){
				angleState = 0;
			}
			System.out.println(angleState);
		}
		return angleState;

		
	} // void playerRotate()

}
