package brickBreaker;

import java.util.ArrayList;

public class BrickList {
	public ArrayList<Brick> bricks = new ArrayList<>();
	public int checkAndRemoveBricks() {
		int numBricksRemoved = 0;
		ArrayList<Brick> deadBricks = new ArrayList<>(); //prevent issues when using enhanced for loop
		for(Brick brick: bricks) {
			if (!brick.isLive()) {
				deadBricks.add(brick);
			}
		} 
		for(Brick dead : deadBricks) {
			bricks.remove(dead);
			numBricksRemoved++;
		}
		
		return numBricksRemoved;
	}
	public void add(Brick b) {
		if (b != null) {
			bricks.add(b);
		}
		else {throw new IllegalArgumentException("Brick was null"); }
	}
}
