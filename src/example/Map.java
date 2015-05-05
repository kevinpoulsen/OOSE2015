package example;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class Map {
	
	public static void mapGeneration (){
		// The function random generates the map
		
		// x starts in 0; then x+= random(limit,limit);
		// y = random(limit,limit);
		
		// for loop (x = 0; if x < map.Width; x+= random(limit,limit){y = random(limit,limit);for(for(trackerArr[i,j] = trackerArr[x,y]))} 
		// while creating the map every vector is tracked. Create 2D array that stores the kordinates.
		// track length of landing pads. if (x1 == x2), trackedLengthOne = x2-x1;
		// if statements and counter has to make sure that 3 landing pads are made.
	}
	
	public static void mapRenderer(){
		// Draw line between points.
		// Mark landing pads, based on length
	}
}// Class Map
