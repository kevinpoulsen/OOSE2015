package example;

import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


public class Map{
	
	static float [] pointArr; // pointArr, Declares float array used for storing the coordinates for the map creation.
	public static Shape mapShape; // mapShape, Declares Shape variable used for storing the polygon shape (the map).
	
	// rectOne,rectTwo and rectThree, Declares Rectangle variable used for storing one of the landing pads.
	public static Rectangle rectOne;
	public static Rectangle rectTwo;
	public static Rectangle rectThree;
	
	// padsOne, padsTwo and padsThree, Declares integer variable that used to store random value for generation of landing pads.
	static int padsOne;
	static int padsTwo;
	static int padsThree;
	
	/**
	 * Method return a array with random generated values, the method random generates the array used for displaying the map.
	 * @return an array of floats, pointArr.
	 */
	public static float[] mapGeneration (){

		Random rnd = new Random();
		
		// initializing the 33 coordinates that creates the map (polygon).
		pointArr = new float[]{
				1,599,						//(0,1)  This point creates the possibility of transforming the array to polygon
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
				599,599,					//(64,65) This point creates the possibility of transforming the array to polygon
		};
		
		// initialized random values in the integers. (padsOne, padsTwo, padsThree).
		padsOne = rnd.nextInt(58)+3;
		padsTwo = rnd.nextInt(58)+3;
		padsThree = rnd.nextInt(58)+3;
		
		// following if statements makes sure that pads are not placed in the same place. 
		if(padsOne == padsTwo){
			padsTwo += 1;
		}
		
		if(padsOne == padsThree){
			padsOne += 1;
		}
		
		if(padsThree == padsTwo){
			padsThree += 1;
		}
		
		// if statements makes sure that integers are odd number. (because the odd number are y values)
		if(padsOne%2 == 0 ){
			padsOne +=1;
		}
		if(padsTwo%2 == 0 ){
			padsTwo +=1;
		}
		if(padsThree%2 == 0 ){
			padsThree +=1;
		}
		
		// Stores the same value in the array index + 2 from padsOne, padsTwo and padsThree.
		pointArr[padsOne+2] = pointArr[padsOne];
		pointArr[padsTwo+2] = pointArr[padsTwo];
		pointArr[padsThree+2] = pointArr[padsThree];
		
		return pointArr; 
	}// float[] mapGeneration.
	
	/**
	 * void method for rendering the map graphics. 
	 * @param g, Graphics rendering library included in the Slick2D engine.
	 * @param arr, takes float array as input for drawing the map polygon.
	 */
	public static void mapRenderer(Graphics g, float[] arr){
		// Draw and initialize polygon based on the pointArr generated in the mapGeneration () method. 
		mapShape =  new Polygon(pointArr);
		g.draw(mapShape);
		
		
		 
		
		
		// Draw and initialize rectangles for landing pads.    
		rectOne = new Rectangle(pointArr[padsOne-1], pointArr[padsOne]-1, 19, 2);
		g.draw(rectOne);
		rectTwo = new Rectangle(pointArr[padsTwo-1], pointArr[padsTwo]-1, 19, 2);
		g.draw(rectTwo);
		rectThree = new Rectangle(pointArr[padsThree-1], pointArr[padsThree]-1, 19, 2);
		g.draw(rectThree);
	}// void mapRenderer()
}// Class Map
