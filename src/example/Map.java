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
	
	public static float[] mapGeneration (){

		Random rnd = new Random();
		
		// initializing the 30 coordinates that creates the map.
		pointArr = new float[]{
				1,599,						//(0,1)  This point creates the possibilty of transforming the array to polygon
				1,rnd.nextInt(400)+100,		//(2,3) Start point
				20,rnd.nextInt(400)+100,	//(4,5)
				40,rnd.nextInt(400)+100,	//(6,7)
				60,rnd.nextInt(400)+100,	//(8,9)
				80,rnd.nextInt(400)+100,	//(10,11)
				100,rnd.nextInt(400)+100,	//(12,13)
				120,rnd.nextInt(400)+100,	//(14,15)
				140,rnd.nextInt(400)+100,	//(16,17)
				160,rnd.nextInt(400)+100,	//(18,19)
				180,rnd.nextInt(400)+100,	//(20,21)
				200,rnd.nextInt(400)+100,	//(22,23)
				220,rnd.nextInt(400)+100,	//(24,25)
				240,rnd.nextInt(400)+100,	//(26,27)
				260,rnd.nextInt(400)+100,	//(28,29)
				280,rnd.nextInt(400)+100,	//(30,31)
				300,rnd.nextInt(400)+100,	//(32,33) 
				320,rnd.nextInt(400)+100,	//(34,35)
				340,rnd.nextInt(400)+100,	//(36,37)
				360,rnd.nextInt(400)+100,	//(38,39)
				380,rnd.nextInt(400)+100,	//(40,41)
				400,rnd.nextInt(400)+100,	//(42,43)
				420,rnd.nextInt(400)+100,	//(44,45)
				440,rnd.nextInt(400)+100,	//(46,47)
				460,rnd.nextInt(400)+100,	//(48,49)
				480,rnd.nextInt(400)+100,	//(50,51)
				500,rnd.nextInt(400)+100,	//(52,53)
				520,rnd.nextInt(400)+100,	//(54,55)
				540,rnd.nextInt(400)+100,	//(56,57)
				560,rnd.nextInt(400)+100,	//(58,59)
				580,rnd.nextInt(400)+100,	//(60,61)
				599,rnd.nextInt(400)+100,	//(62,63) End point
				599,599,					//(64,65) This point creates the possibilty of transforming the array to polygon
		};
		
		padsOne = rnd.nextInt(58)+3;
		padsTwo = rnd.nextInt(58)+3;
		padsThree = rnd.nextInt(58)+3;
		
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
	}
}// Class Map
