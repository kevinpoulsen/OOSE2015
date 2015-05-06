package example;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Polygon;

public class Player {
	//player variables
	
	static float xSpeed;  // players speed in the x direction
	static float ySpeed;  // players speed in the y direction
	static int fuel = 5000;	   // fuel decreases as the players uses thrust
	static float gravity = 0.2f; // gravity pulls player in the +y direction
	static int angleState; // determines the way the player is facing,
	
	static String fuelLeft = " Fuel"; // used to display fuel left on the game screen
	
	// Declare and initialize player positions
	static float x1poly = 300;
	static float y1poly = 0;
	static float x2poly = 290;
	static float y2poly = 30;
	static float x3poly = 310;
	static float y3poly = 30;
	
	public static void playerThrust(GameContainer gc, int angleState)
	{
		float ds = 0.0005f; // diagonal speed
		float ns = 0.001f; // normal speed
		
		Input input = gc.getInput(); // listens for keyboard input
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
		
		// this class needs modifications 
		
		gravity += 0.00001f;// there is a problem with the gravity implementation
		x1poly += xSpeed;
		x2poly += xSpeed;
		x3poly += xSpeed;
		y1poly += ySpeed + gravity;
		y2poly += ySpeed + gravity;
		y3poly += ySpeed + gravity;
		
		System.out.println(x1poly + " " + x2poly + " "+ x3poly);
		System.out.println(y1poly + " "+ y2poly + " "+ y3poly);
	}
	
	public static void playerRenderer(Graphics g)
	{
		
		float[] polyCoordinates = {x1poly,y1poly,x2poly,y2poly,x3poly,y3poly};
		Shape shape = new Polygon(polyCoordinates);
		g.drawString(String.valueOf(fuel) + fuelLeft, 530, 10);
		
		
		g.rotate(x2poly+x1poly/2,y2poly+y1poly/2, 45);
		g.setColor(new Color(255,255,0));
		g.fill(shape);
		g.setColor(new Color(255,255,255));
		g.draw(shape);
		
		// Exhaust:
		// when playerThrust is being called, draw some exhaust at the bottom of player
	}	
	
	
	
	public static int playerAngleState(GameContainer gc)
	{
		
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		if(input.isKeyPressed(Input.KEY_LEFT)){ //if left arrow key is pressed
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
