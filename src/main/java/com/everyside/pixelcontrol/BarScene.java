package com.everyside.pixelcontrol;

import processing.core.PApplet;
import flexion.unity.OPCRecorder;

public class BarScene extends OPCRecorder {
	
	private static final int ROW_COUNT = 3;
	private static final int COL_COUNT = 31;
	
	protected int framesToRecord = 300;
	protected boolean recording = true;

	public BarScene() {
		super("localhost", 7890, "/tmp/foo.opc");
	}
	
	@Override
	public void settings() {
		super.settings();
		size(500,500);
	}

	@Override
	public void setup() {
		

		super.setup();
		
		this.showLocations(true);
		
		int rowSpacing = height / (ROW_COUNT + 1);
		int colSpacing = width / (COL_COUNT + 1);
		
		
		for (int row = 0; row < ROW_COUNT; row++) {
			for(int col = 0; col < COL_COUNT; col++){

				int x = (col+1)*colSpacing;
				int y = (row+1)*rowSpacing;
				
				led(row*64 + col, x,y);
			}
		}
		
	}
	
	@Override
	public void draw() {
		if(recording){
			super.draw();
			writePixelFrame(packetData);
			if(frameCount > framesToRecord){
				recording = false;
				stopRecording();
				pixelLocations = null;
			}
		}else{
			packetData = readPixelFrame();
			writePixels();
		}
	}
	
	public static void main() {
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		PApplet.main(new String[] { stack[stack.length-1].getClassName() });
	}
	
}
