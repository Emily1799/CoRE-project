package brickBreaker;

public class Ball {
	private int xPos;
	private int yPos;
	private int speed = 1;
	private int direction = 0;
	private boolean live = true;
	
	public Ball(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}

	//getters and setters. setLive is weird, because you can't reanimate a dead ball
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isLive() {
		return live;
	}
	//you cannot make a previously dead ball live
	public void setLive(boolean live) {
		if (live == true) {
			throw new IllegalArgumentException("You cannot reanimate a dead ball");
		}
		this.live = live;
	}
	
}
