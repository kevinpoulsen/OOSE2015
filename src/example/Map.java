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
		// The function random generates the map
		int kordinateLimit = 30;
		
		// x starts in 0; then x+= random(limit,limit);
		// y = random(limit,limit);
	float[] trackArr = new float[kordinateLimit*2]; 
	
		Random rnd = new Random();
		
		int i = 0;
		float xSum = 0;
		
		trackArr[0] = 0;
		trackArr[1] = rnd.nextInt(400)+100;

			for(int c = 2; c < 28; c++){
				trackArr[i] = rnd.nextInt(20)+5 + xSum;
				trackArr[i+1] = rnd.nextInt(400)+100;
				xSum += trackArr[i];
				if(trackArr[i] > 640){
					trackArr[i] = 640; 
				}// if()
				i+=2;
			}// for loop (c)
		
		System.out.println("KordinateOne: "+ trackArr[0] + " " + trackArr[1] + " " + "KordinateTwo: "+ trackArr[2] + " " + trackArr[3]);
		
		trackArr[58] = 640;
		trackArr[59] = rnd.nextInt(400)+100;
		
		return trackArr;
		
		// track length of landing pads. if (x1 == x2), trackedLengthOne = x2-x1;
		// if statements and counter has to make sure that 3 landing pads are made.
	}// float[] mapGeneration.
	
	public void mapRenderer(Graphics g, float[] arr){
		// Draw line between points.
		for(int w = 0; w < arr.length-3; w+=2){
			g.drawLine(arr[w],arr[w+1],arr[w+2],arr[w+3]);
		}
		// Mark landing pads, based on length
	} // mapRenderer()
}// Class Map
