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
	
	// xSpeed, declares a float used for storing the speed which the player travels along the x-axis.
	// ySpeed, declares a float used for storing the speed which the player travels along the y-axis.
	// fuel, declares an integer which determines how much thrust the player has and thereby how far the player can travel. 
	static float xSpeed;  // players speed in the x direction
	static float ySpeed;  // players speed in the y direction
	static int fuel = 1000;	   // fuel decreases as the players uses thrust
	
	// gravity, declares a float and is used for setting a certain speed which the player will be dragged towards the bottom of the screen at all time.
	// yCond, declares a float which is used for displaying the users ySpeed plus gravity. This is displayed in the GUI.
	static float gravity = 0.0f; // gravity pulls player in the +y direction
	static float yCond;

	 // soundThrust, declares a Sound which will play when the player uses thrust.
	 // warning, declares a Sound which will play when the player have a certain amount of fuel left.
	 // play, declares a boolean which is used to control warning sound.
	public static Sound soundThrust;
	public static Sound warning;
	static boolean play = true; // used to control warning sound
	
	
	// thrust, declares boolean which is used for telling if thrust is used. Used to render exhaust.
	static boolean thrust = false; // boolean to tell if thrust is being used, this is used to render the exhaust
	
	// angleState, declares a float which is used for the rotation of the player.
	// rotateState, declares a float which is used for the rotation of the player.
	static float angleState = 0;
	static float rotateState = 0;
	
	// x1poly, y1poly, x2poly, y2poly, x3poly, y3poly, declares six floats which is used for drawing the player polygon.
	static float x1poly = 300;
	static float y1poly = 0;
	static float x2poly = 290;
	static float y2poly = 30;
	static float x3poly = 310;
	static float y3poly = 30;
	
	// collides, declares a boolean which is used for checking collision. Returns true if two shapes intersects.
	// shape, declares the shape used for creating the polygon of the above six floats.
	// polyCoordinates, declares a float[] array used for storing each of the coordinates of the player.
	static boolean collides = false;
	static Shape shape;
	static float[] polyCoordinates;
	
	/**
	 * Void method for player thrust.
	 * @param gc, Game functionality library included in the Slick2D engine.
	 * @param angleState, takes in a float variable called angleState which controls the direction the player is going.
	 */
	public static void playerThrust(GameContainer gc, float angleState)
	{
		// ds and ns declares two floats determining diagonal speed and normal speed.
		float ds = 0.0005f; // diagonal speed
		float ns = 0.001f; // normal speed
		
		// Initializing the sound variables soundThrust and warning.
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
		
		// input, declaring and initializing from slick library to listen for keyboard input.
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		// if statement which initializes when the space key is pressed. 
		if(input.isKeyDown(Input.KEY_SPACE))
		{
			fuel--; // fuel variable counts down depending on how much the player uses thrust.
			thrust = true; // sets the variable thrust true when key is pressed.
			
			// The following 8 if statements controls which way the player travels upon thrusting.
			// This is done by incrementing and decrementing normal speed and diagonal speed depending on which way the player wants to travel.
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
		// if statement which initializes the warning sound to play when fuel is under a certain amount. Sets play boolean to false.
		if(fuel < 200 && warning.playing() != true && play == true){
			warning.play();
			play = false;
		}
	}// void playerThrust
	
	/**
	 * Void method for updating player position based on speed and gravity.
	 */
	public static void playerPosition(){
		// Initializing the gravity variable.
		gravity += 0.000025f; 
		// Used for updating x positions of the player polygon based on speed and y positions based on speed plus gravity.
		x1poly += xSpeed;
		x2poly += xSpeed;
		x3poly += xSpeed;
		y1poly += ySpeed + gravity;
		y2poly += ySpeed + gravity;
		y3poly += ySpeed + gravity;
		
		// Initializing the yCond variable which is used for displaying the speed which the player travels towards the ground with. Multiplied by 100 to make it a "cleaner" number
		yCond = (ySpeed + gravity) *100;
	} // void playerPosition

	/**
	 * Void method for rendering the player.
	 * @param g, Graphics rendering library included in the Slick2D engine.
	 * @param rotateState, the rotation orientation of the player in angles, used for displaying the player polygon correctly.
	 * @param gc, Game functionality library included in the Slick2D engine.
	 */
	public static void playerRenderer(Graphics g, float rotateState, GameContainer gc)
	{	
		// Initializing polyCoordinates array by feeding the coordinates of the six xpoly and ypoly floats. 
		polyCoordinates = new float[]{x1poly,y1poly,x2poly,y2poly,x3poly,y3poly};
		// Initializing the shape by making it a polygon by using polyCoordinates array.
		shape = new Polygon(polyCoordinates);
		
		// Declaring and initializing size of the exhaustCoordinates array, used for drawing exhaust flame.
		float[] exhaustCoordinates = new float[6];
		// using the x2poly and x3poly divided by two to determine the middle of xpoint and y1poly and y2poly divided by two to determine the middle y point to rotate the player around.
		g.rotate((x2poly+x3poly)/2, (y1poly+ y2poly)/2, rotateState);
		// Drawing the player polygon shape.
		g.draw(shape);
		
		// input, declaring and initializing from slick library to listen for keyboard input.
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		// if statement which initializes when the space key is pressed which will make the soundThrust play. 
		if(input.isKeyPressed(Input.KEY_SPACE)){
			// plays exhaust sound
			soundThrust.play();
		}
		
		// if statement which uses the thrust boolean for drawing the exhaust. 
		if(thrust){
			//Initializing the exhaustCoordinates array with the points from the player with addition of 40 to y1poly.
			exhaustCoordinates = new float[]{x1poly,y1poly+40,x2poly,y2poly,x3poly,y3poly};
			// initializing shape by making a new polygon of the exhaustCoordinates.
			shape = new Polygon(exhaustCoordinates);
			// Filling, coloring and drawing the exhaust shape.
			g.fill(shape);
			g.setColor(new Color(255,255,255));
			g.draw(shape);
			// setting thrust to false again.
			thrust = false;
		}
	} // void playerRenderer
	
	/**
	 * boolean method to detect onCollision between two shapes.
	 * @param a, takes a shape as an input.
	 * @return, boolean which is set to true if the two shapes intersect.
	 */
	public static boolean onCollision(Shape a){
		collides = shape.intersects(a);
		return collides; 
	} // boolean onCollision
	
	/**
	 * boolean method for detecting if the player is hits the screen window.
	 * @param gc, Game functionality library included in the Slick2D engine.
	 * @return, boolean depending if one of the player coordinates go outside the screen.
	 */
	public static boolean playerOffScreen(GameContainer gc){
		// If statement which checks each player coordinate if it is outside the screen size.
		if(x1poly > gc.getWidth() || x1poly < 0 || y1poly > gc.getHeight() || y1poly < 0 || 
				x2poly > gc.getWidth() || x2poly < 0 || y2poly > gc.getHeight() || y2poly < 0|| 
					x3poly > gc.getWidth() || x3poly < 0 || y3poly > gc.getHeight() || y3poly < 0){
			return true;
		}
		return false;
	} // boolean playerOffScreen

	/**
	 * float[] method which fills an array with angle and rotate state.
	 * @param gc, gc, Game functionality library included in the Slick2D engine.
	 * @return, float[] with states[0] = angleState and states[1] = rotateState.
	 */
	public static float[] playerStates(GameContainer gc)
	{
		// input, declaring and initializing from slick library to listen for keyboard input.
		Input input; 
		input = gc.getInput(); // listens for keyboard input
		
		// states, declares and initializing the size of a float[].
		float[] states = new float[2];
		
		// if statement which initializes when the left key is pressed which will rotate the (player) counter clockwise by 45 degrees. 
		if(input.isKeyPressed(Input.KEY_LEFT)){ 
			angleState--;
			rotateState -= 45;
			
			// if statement which controls the angleState not being a negative number and ranging from 0 to 7 all the time.
			if(angleState == -1){
				angleState = 7;
				
			}
		}
		
		// if statement which initializes when the right key is pressed which will rotate the (player) clockwise by 45 degrees. 
		if(input.isKeyPressed(Input.KEY_RIGHT)){
			angleState++;
			rotateState += 45;
			
			// if statement which controls the angleState not being a larger number than 8 and ranging from 0 to 7 all the time.
			if(angleState == 8){
				angleState = 0;
			}
		}
		
		// initialize index numbers of the states[] float array.
		states[0] = angleState;
		states[1] = rotateState;
		return states;
	}// static float playerStates()
}// class Player
