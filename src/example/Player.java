package example;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Polygon;

public class Player {
	//player variables
	
	
	
	static float xSpeed;  // players speed in the x direction
	static float ySpeed;  // players speed in the y direction
	static int fuel = 1000;	   // fuel decreases as the players uses thrust
	static float gravity = 0.0f; // gravity pulls player in the +y direction

	//public Sound soundThrust;
	public static Sound soundThrust;
	public static Sound warning;
	static boolean play = true; // used to control warning sound
	
	static float yCond;
	
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
		
		// Initialize sound variables:
		try {
			soundThrust = new Sound("sounds/thrust.ogg");
		} catch (SlickException e) {
			System.out.println("Cannot load sound file 'thrust.ogg'");
		}
		try {
			warning = new Sound("sounds/warning.ogg");
		} catch (SlickException e) {
			System.out.println("Cannot load sound file 'warning.ogg'");
		}
		
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
		if(fuel < 1000 && warning.playing() != true && play == true){
			warning.play();
			play = false;
		}
	}// void playerThrust
	
	
	
	public static void playerPosition(){
		
		// this class needs modifications 
		
		gravity += 0.000018f;// there is a problem with the gravity implementation
		
		x1poly += xSpeed;
		x2poly += xSpeed;
		x3poly += xSpeed;
		y1poly += ySpeed + gravity;
		y2poly += ySpeed + gravity;
		y3poly += ySpeed + gravity;
		
		
		yCond = (ySpeed + gravity) *100;
		
		//System.out.println("TOOOOOPPPPP "+ yCond);

	}
	
	public static void playerRenderer(Graphics g, float rotateState, GameContainer gc)
	{	
		polyCoordinates = new float[]{x1poly,y1poly,x2poly,y2poly,x3poly,y3poly};
		
		shape = new Polygon(polyCoordinates);

		float[] exhaustCoordinates = new float[6];
		
		g.rotate((x1poly+x2poly)/2, (y1poly+ y2poly)/2, rotateState);
		g.draw(shape);
		
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		if(input.isKeyPressed(Input.KEY_SPACE)){
			// plays exhaust sound
			soundThrust.play();
		}
		
		// Exhaust:
		if(thrust){
			exhaustCoordinates = new float[]{x1poly,y1poly+40,x2poly,y2poly,x3poly,y3poly};
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
	
	// warns user if player is off screen. Must be used to create a loss condition
	public static boolean playerOffScreen(GameContainer gc){
		
		if(x1poly > gc.getWidth() || x1poly < 0 || y1poly > gc.getHeight() || y1poly < 0 || 
				x2poly > gc.getWidth() || x2poly < 0 || y2poly > gc.getHeight() || y2poly < 0|| 
					x3poly > gc.getWidth() || x3poly < 0 || y3poly > gc.getHeight() || y3poly < 0){
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
