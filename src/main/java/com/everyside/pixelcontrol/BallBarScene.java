package com.everyside.pixelcontrol;


public class BallBarScene extends BarScene {
	
	int vel = 3;
	int r = 1;
	int color = color(random(50,100),100,100);
	
	@Override
	public void settings() {
		size(300, 300);
		super.settings();
	}

	public void setup() {
	  background(0);
	  colorMode(HSB, 360, 100, 100);
	  noStroke();
	  ellipseMode(RADIUS);
	  setFrameRate(60);

	  colorMode(HSB, 100, 100, 100);
	  super.setup();
	  
	}

	public void draw() {
	  background(0);
	  if(recording){
		  color = color(hue(color), 100, (float)(brightness(color) * 0.99));
		  r = r + vel;
		  if(r <= 0 || r >= height){
			  vel = vel * -1;
	
			  
		  }
		  if(r <= 0){
			  color = color(random(50,100), 100, 100);
		  }
		  fill(color);
		  ellipse((frameCount) % width,(float)(height/2),r * 3, (float)(r * 1.2));
		  
		  
	  }

	  super.draw();
	}
	
	public static void main(String[] args) {
		BarScene.main();
	}
	
	

}
