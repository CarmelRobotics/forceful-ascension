package org.usfirst.frc.team2035.robot.vision;

import java.util.ArrayList;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class Processing {
	static {
		System.out.println("Trying to load '" + Core.NATIVE_LIBRARY_NAME + "'...");
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		}
	static VisTracker tracker;
	static Mat matOriginal;
	static Mat matOutput;
	static VideoCapture videoCapture;
	static double lengthBetweenContours;
	static double distanceFromTarget;
	static double angleToTarget;
	static double[] centerX;
	static double WIDTH_CLOSENESS = .15;

	public static final double OFFSET_TO_FRONT = 0;
	public static final double DISTANCE_CONSTANT= 5738;
	public static final double CAMERA_WIDTH = 320;
	public static final double ANGLE_OFFSET =  0;
	public static final double WIDTH_BETWEEN_TARGET = 8.5;

	
	public static void startProcessing(){
		System.out.println("       _\r\n" + 
				"      /X \\ \r\n" + 
				"    _------_\r\n" + 
				"   /        \\\r\n" + 
				"  |          |\r\n" + 
				"  |          |\r\n" + 
				"  |     __  __)\r\n" + 
				"  |    /  \\/  \\\r\n" + 
				" /\\/\\ (o   )o  )\r\n" + 
				" /c    \\__/ --.\r\n" + 
				" \\_   _-------'\r\n" + 
				"  |  /         \\\r\n" + 
				"  | | '\\________)\r\n" + 
				"  |  \\_____)\r\n" + 
				"  |_____ |\r\n" + 
				" |_____/\\/\\");
		while(true) {
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
			camera.setResolution(640, 480);
			tracker = new VisTracker();
			videoCapture = new VideoCapture();
			videoCapture.open(camera.getVideo());
			while(!videoCapture.isOpened()) {
				System.out.println("Video capture failed, retrying...");
			}
			
			System.out.println("*hacker voice* we're in");
			
			while(videoCapture.isOpened()){
				processImage();
			} 
		}
	}
	public static void processImage() {
		System.out.println("processing...");	
		matOriginal = new Mat();
		
		while(true) {
			matOutput = new Mat();
			Core.flip(matOriginal, matOutput , 0);
			videoCapture.read(matOriginal);
			tracker.process(matOriginal);
			findCenterX();
			System.out.println(centerX);
			findDistanceFromTarget();
			System.out.println(distanceFromTarget);
			findAngleToTarget();
			System.out.println(angleToTarget);
			
			videoCapture.read(matOriginal);
		}
	}
	
	public static double findCenterX() {
		double[] defaultValue = new double[0];
		if(!tracker.filterContoursOutput.isEmpty() && tracker.filterContoursOutput.size() >= 2){
			Rect r = Imgproc.boundingRect(tracker.filterContoursOutput.get(1));
			Rect r1 = Imgproc.boundingRect(tracker.filterContoursOutput.get(0)); 
			centerX = new double[]{r1.x + (r1.width / 2), r.x + (r.width / 2)};
			if(tracker.filterContoursOutput.size() == 2){
				// subtracts one another to get length in pixels
				lengthBetweenContours = Math.abs(centerX[0] - centerX[1]);
				System.out.println("I see: " + centerX.length);
			}else {
				Rect[] rectangleArray = new Rect[tracker.filterContoursOutput.size()];
				System.out.println("I see: " + rectangleArray.length);
				for(int i = 0 ; i < tracker.filterContoursOutput.size(); i++){
					rectangleArray[i] = Imgproc.boundingRect(tracker.filterContoursOutput().get(i)); 
					System.out.println("Object" + i + " X " + rectangleArray[i].x + " Y "+rectangleArray[i].y + "Width = " + rectangleArray[i].width);
				}
				ArrayList<ArrayList<Integer>> Pairs = new ArrayList<ArrayList<Integer>>();
				for(int i = 0; i < rectangleArray.length; i++){
					for(int j =i+1; j < rectangleArray.length; j++){
						if(rectangleArray[i].width * (1-WIDTH_CLOSENESS) <= rectangleArray[j].height 
								&& rectangleArray[i].width * (1+WIDTH_CLOSENESS) >= rectangleArray[j].height){
								ArrayList<Integer> tempPairs = new ArrayList<Integer>();
								tempPairs.add(i);
								tempPairs.add(j);
								Pairs.add(tempPairs);
								System.out.println("\t Found Pair" + i + "and " + j);
						}  
					}
				}
				if(Pairs.size() != 0){
					double bestDistance = 1000000;
					int currentBest = -1;
					for(int i = 0; i < Pairs.size(); i++){
						ArrayList<Integer> tempPairs = Pairs.get(i);
						 r = rectangleArray[tempPairs.get(0)];
						 r1 = rectangleArray[tempPairs.get(1)];
						double[] r1Points = {r.x + (r.width /2) , r.y + (r.height / 2)};
						double[] r2Points = {r1.x + (r1.width /2) , r1.y + (r1.height / 2)};
						double distanceBetweenPoints = Math.sqrt(Math.pow((r2Points[0] - r1Points[0]), 2) + (Math.pow((r2Points[1] - r1Points[1]), 2)));
						System.out.println("\t r1 X : " + r.x);
						System.out.println("\t r2 X : " + r1.x);

						if(distanceBetweenPoints < bestDistance){
							//System.out.println("\t Best Distance = " + distanceBetweenPoints );
							currentBest = i;
							bestDistance = distanceBetweenPoints;
						} 
					}
					ArrayList<Integer> tempPairs = Pairs.get(currentBest);
					r = rectangleArray[tempPairs.get(0)];
					r1 = rectangleArray[tempPairs.get(1)];	
					centerX = new double[]{r.x + (r.width / 2), r1.x + (r1.width / 2)};
					System.out.println("\t Best Pairs Found: " + tempPairs.get(0) +" "+ tempPairs.get(1));
					// subtracts one another to get length in pixels
					lengthBetweenContours = Math.abs((centerX[0] + centerX[1]) / 2) - CAMERA_WIDTH /2;
				}
			}
		}
		return lengthBetweenContours;
	}
	
	public static double findDistanceFromTarget(){
		// distance constant divided by length between centers of contours
		distanceFromTarget = DISTANCE_CONSTANT / lengthBetweenContours;
		return distanceFromTarget - OFFSET_TO_FRONT; 
	}
	
	public static double findAngleToTarget(){
		// 8.5in is for the distance from center to center from goal, then divide by lengthBetweenCenters in pixels to get proportion
		double constant = WIDTH_BETWEEN_TARGET / lengthBetweenContours;
		angleToTarget = 0;
			//Looking for the 2 blocks to actually start trig
		if(!tracker.filterContoursOutput.isEmpty() && tracker.filterContoursOutput.size() >= 2){

			if(centerX.length == 2){
				// this calculates the distance from the center of goal to center of webcam 
				double distanceFromCenterPixels= ((centerX[0] + centerX[1]) / 2) - (CAMERA_WIDTH / 2);
				// Converts pixels to inches using the constant from above. 
				double distanceFromCenterInch = distanceFromCenterPixels * constant;
					angleToTarget = Math.atan(distanceFromCenterInch / findDistanceFromTarget());
					angleToTarget = Math.toDegrees(angleToTarget);
					angleToTarget= -angleToTarget - ANGLE_OFFSET;
					
					}
			}
			return angleToTarget;
	}

}


