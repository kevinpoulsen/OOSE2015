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
	
	static String fuelLeft = " Fuel"; // used to display fuel left on the game screen
	static boolean thrust = false; // boolean to tell if thrust is being used, this is used to render the exhaust
	
	static float angleState = 0;
	static float rotateState = 0;
	
	// Declare and initialize player positions
	static float x1poly = 300;
	static float y1poly = 0;
	static float x2poly = 290;
	static float y2poly = 30;
	static float x3poly = 310;
	static float y3poly = 30;
	
	static boolean collides = false;
	static Shape shape;
	static float[] polyCoordinates;
	

	public static void playerThrust(GameContainer gc, float angleState)
	{
		float ds = 0.0005f; // diagonal speed
		float ns = 0.001f; // normal speed
		
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		if(input.isKeyDown(Input.KEY_SPACE))
		{
			fuel--;
			thrust = true;
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
		
		//System.out.println(x1poly + " " + x2poly + " "+ x3poly);
		//System.out.println(y1poly + " "+ y2poly + " "+ y3poly);
	}
	
	public static void playerRenderer(Graphics g, float rotateState, GameContainer gc)
	{
		polyCoordinates = new float[]{x1poly,y1poly,x2poly,y2poly,x3poly,y3poly};

		float exhaustCoordinates[] = new float[6];
		
		shape = new Polygon(polyCoordinates);

		g.drawString(String.valueOf(fuel) + fuelLeft, 530, 10);

		g.rotate((x1poly+x2poly)/2, (y1poly+ y2poly)/2, rotateState);

		g.setColor(new Color(255,255,0));
		g.fill(shape);
		g.setColor(new Color(255,255,255));
		g.draw(shape);
		
		// Exhaust:
		// when playerThrust is being called, draw some exhaust at the bottom of player
		if(thrust){
			
			exhaustCoordinates = new float[]{x1poly+10,y1poly,x2poly,y2poly,x3poly,y3poly};
			shape = new Polygon(exhaustCoordinates);
			g.fill(shape);
			g.setColor(new Color(255,255,255));
			g.draw(shape);
			thrust = false;
		}
		
	}	

	public static boolean onCollision(Shape a){
		collides = shape.intersects(a);
		return collides; 
	}
	
	// warns user is player is off screen. Must be used to create a loss condition
	public static boolean playerOffScreen(GameContainer gc){
		
		if(x1poly > gc.getWidth() || x1poly < 0 || y1poly > gc.getHeight() || y1poly < 0){
			System.out.println("Player is off screen");
			return true;
		}
		return false;
	}

	public static float[] playerStates(GameContainer gc)
	{
		
		Input input; 
		input = gc.getInput(); // listens for keyboard input

		float[] states = new float[2];
		
		if(input.isKeyPressed(Input.KEY_LEFT)){ //if left arrow key is pressed
			angleState--;
			rotateState -= 45;
			if(angleState == -1){
				angleState = 7;
				
			}
		}
		if(input.isKeyPressed(Input.KEY_RIGHT)){
			angleState++;
			rotateState += 45;
			if(angleState == 8){
				angleState = 0;
			}
		}

		states[0] = angleState;
		states[1] = rotateState;
		return states;
	}// static float playerStates()
}// class Player
