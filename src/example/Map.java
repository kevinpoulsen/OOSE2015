package example;

import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


public class Map{

	
	static float [] pointArr;
	public static Shape mapShape;
	public static Rectangle rectOne;
	public static Rectangle rectTwo;
	public static Rectangle rectThree;
	static int padsOne;
	static int padsTwo;
	static int padsThree;
	
	public static float[] mapGeneration (int screenWidth){

		Random rnd = new Random();
		
		// initializing the 30 coordinates that creates the map.
		pointArr = new float[]{
				1,599,//(x,y)  This point creates the possibilty of transforming the array to polygon
				1,rnd.nextInt(400)+100,//1 Start point
				20,rnd.nextInt(400)+100,// 2
				40,rnd.nextInt(400)+100,// 3
				60,rnd.nextInt(400)+100,// 4
				80,rnd.nextInt(400)+100,// 5
				100,rnd.nextInt(400)+100,// 6
				120,rnd.nextInt(400)+100,// 7
				140,rnd.nextInt(400)+100,// 8
				160,rnd.nextInt(400)+100,// 9
				180,rnd.nextInt(400)+100,// 10
				200,rnd.nextInt(400)+100,// 11
				220,rnd.nextInt(400)+100,// 12
				240,rnd.nextInt(400)+100,// 13
				260,rnd.nextInt(400)+100,// 14
				280,rnd.nextInt(400)+100,// 15
				300,rnd.nextInt(400)+100,// 16
				320,rnd.nextInt(400)+100,// 17
				340,rnd.nextInt(400)+100,// 18
				360,rnd.nextInt(400)+100,// 19
				380,rnd.nextInt(400)+100,// 20
				400,rnd.nextInt(400)+100,// 21
				420,rnd.nextInt(400)+100,// 22
				440,rnd.nextInt(400)+100,// 23
				460,rnd.nextInt(400)+100,// 24
				480,rnd.nextInt(400)+100,// 25
				500,rnd.nextInt(400)+100,// 26
				520,rnd.nextInt(400)+100,// 27
				540,rnd.nextInt(400)+100,// 28
				560,rnd.nextInt(400)+100,// 29
				580,rnd.nextInt(400)+100,// 30
				599,rnd.nextInt(400)+100,// 31 end point
				599,599,//This point creates the possibilty of transforming the array to polygon
		};
		
		padsOne = rnd.nextInt(60)+3;
		padsTwo = rnd.nextInt(60)+3;
		padsThree = rnd.nextInt(60)+3;
		
		// if statements makes sure that integers are odd number. 
		if(padsOne%2 == 0 ){
			padsOne +=1;
		}
		if(padsTwo%2 == 0 ){
			padsTwo +=1;
		}
		if(padsThree%2 == 0 ){
			padsThree +=1;
		}
		
		pointArr[padsOne+2] = pointArr[padsOne];
		pointArr[padsTwo+2] = pointArr[padsTwo];
		pointArr[padsThree+2] = pointArr[padsThree];
		
		return pointArr;
	}// float[] mapGeneration.
	
	public static void mapRenderer(Graphics g, float[] arr){
		// Draw line between points.
		mapShape =  new Polygon(pointArr);
		g.draw(mapShape);
		
		//Color padsColor = new Color(255,0,0);
		//g.setColor(new Color(255,255,255));
		rectOne = new Rectangle(pointArr[padsOne-1], pointArr[padsOne]-1, 19, 2);
		//g.fill(rectOne);
		g.draw(rectOne);
		rectTwo = new Rectangle(pointArr[padsTwo-1], pointArr[padsTwo]-1, 19, 2);
		//g.fill(rectTwo);
		g.draw(rectTwo);
		rectThree = new Rectangle(pointArr[padsThree-1], pointArr[padsThree]-1, 19, 2);
		//g.fill(rectThree);
		g.draw(rectThree);
		
		
//		g.drawLine(88,499,120,499); // marking landing pads
//		g.drawLine(242,399,284,399); // marking landing pads
//		g.drawLine(570,299,592,299); // marking landing pads
//		g.drawString("x4", 94, 502); // display point bonus
//		g.drawString("x2", 252, 402); // display point bonus
//		g.drawString("x8", 571, 302); // display point bonus
	} // mapRenderer()
}// Class Map
