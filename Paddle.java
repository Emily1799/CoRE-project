package brickBreaker;

import java.awt.Color;

public class Paddle {
	private static int length = 50; // all paddles share the same length
	private int xPos = 300;
	private final int yPos = 450; 
	private final Color COLOR = new Color(255, 0, 0); 
	
	public Paddle(int paddleLength) {
		length = paddleLength;
		
	}
	
	//getters for all fields, setters for length, x and y positions
	public int getLength() {
		return length;
	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public Color getCOLOR() {
		return COLOR;
	}

	public void setLength(int paddleLength) {
		length = paddleLength;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}	
}
