package example;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class Map{
	


	public float[] mapGeneration (){
		
		int ScreenWidth = 480;
		int kordinateLimit = 30;
		
		// The function random generates the map
		
		// x starts in 0; then x+= random(limit,limit);
		// y = random(limit,limit);
		float[] trackArr = new float[kordinateLimit*4];  
		Random rnd = new Random();
		int i = 0;
		for(int x = 0; x < ScreenWidth; x+= rnd.nextInt(20) + 5){ 
			int y = rnd.nextInt(500)+100;
			trackArr[i] = y;
			trackArr[i+1] = y;
			i+=2;
		}
		
		return trackArr;
		// for loop (x = 0; if x < map.Width; x+= random(limit,limit){y = random(limit,limit);for(for(trackerArr[i,j] = trackerArr[x,y]))} 
		// while creating the map every vector is tracked. Create 2D array that stores the kordinates.
		// track length of landing pads. if (x1 == x2), trackedLengthOne = x2-x1;
		// if statements and counter has to make sure that 3 landing pads are made.
	}
	
	public void mapRenderer(Graphics g, float[] arr){
		// Draw line between points.
		for(int w = 0; w < arr.length-1;w+=4){
			g.drawLine(arr[w],arr[w+1],arr[w+2],arr[w+3]);
		}
		// Mark landing pads, based on length
	} // mapRenderer()
}// Class Map
