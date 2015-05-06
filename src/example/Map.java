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

		Random rnd = new Random();
		
		// initializing the 30 koordinates that creates the map.
		float[] pointArr = {
				0,rnd.nextInt(400)+100,//(x,y) 1
				22,rnd.nextInt(400)+100,// 2
				44,rnd.nextInt(400)+100,// 3
				66,rnd.nextInt(400)+100,// 4
				88,500,// 5
				120,500,// 6
				132,rnd.nextInt(400)+100,// 7
				154,rnd.nextInt(400)+100,// 8
				166,rnd.nextInt(400)+100,// 9
				198,rnd.nextInt(400)+100,// 10
				210,rnd.nextInt(400)+100,// 11
				242,400,// 12
				284,400,// 13
				290,rnd.nextInt(400)+100,// 14
				306,rnd.nextInt(400)+100,// 15
				328,rnd.nextInt(400)+100,// 16
				350,rnd.nextInt(400)+100,// 17
				372,rnd.nextInt(400)+100,// 18
				394,rnd.nextInt(400)+100,// 19
				416,rnd.nextInt(400)+100,// 20
				438,rnd.nextInt(400)+100,// 21
				460,rnd.nextInt(400)+100,// 22
				482,rnd.nextInt(400)+100,// 23
				504,rnd.nextInt(400)+100,// 24
				526,rnd.nextInt(400)+100,// 25
				548,rnd.nextInt(400)+100,// 26
				570,300,// 27
				592,300,// 28
				614,rnd.nextInt(400)+100,// 29
				640,rnd.nextInt(400)+100,// 30
		};
		
		return pointArr;
	}// float[] mapGeneration.
	
	public void mapRenderer(Graphics g, float[] arr){
		// Draw line between points.
		for(int w = 0; w < arr.length-3; w+=2){
			g.drawLine(arr[w],arr[w+1],arr[w+2],arr[w+3]);
		}
		g.drawLine(88,499,120,499); // marking landing pads
		g.drawLine(242,399,284,399); // marking landing pads
		g.drawLine(570,299,592,299); // marking landing pads
		g.drawString("x4", 94, 502); // display point bonus
		g.drawString("x2", 252, 402); // display point bonus
		g.drawString("x8", 571, 302); // display point bonus
	} // mapRenderer()
}// Class Map
