package brickBreaker;

import java.awt.Color;
import java.util.Random;

public class Brick {
	private int length = 50;
	private int width = 15;
	private int xPos;
	private int yPos;
	private boolean isLive = true;
	private Color color;
	
	public Brick(int xPos, int yPos) {

		this.xPos = xPos;
		this.yPos = yPos;
		
		Random rn = new Random();
		int r1 = rn.nextInt(255 - 0 + 1) + 0;
		int r2 = rn.nextInt(255 - 0 + 1) + 0;
		int r3 = rn.nextInt(255 - 0 + 1) + 0;
		this.color = new Color(r1, r2, r3);
	}
	
	public void doEffect() {
		this.setLive(false);
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}
	public Color getColor() {
		return color;
	}

	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	
	public void setLength(int length) {
		this.length = length;
	}

	public void setWidth(int width) {
		this.width = width;
	}




	
	
	
	
}
