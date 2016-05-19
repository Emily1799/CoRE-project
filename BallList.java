package brickBreaker;

import java.util.ArrayList;

public class BallList {
	public ArrayList<Ball> balls = new ArrayList<>();
	
	public void add(Ball ball) {
		if (ball != null) {
			balls.add(ball);
		}
		else{
			throw new IllegalArgumentException("Ball is null");
		}
	}
	public int checkAndRemoveBalls() { //jeeze that sounds wrong. Returns number of dead balls
		int numBallsRemoved = 0;
		ArrayList<Ball> deadBalls = new ArrayList<>(); //prevent issues when using enhanced for loop
		for(Ball ball: balls) {
			if (!ball.isLive()) {
				deadBalls.add(ball);
			}
		} 
		for(Ball dead : deadBalls) {
			balls.remove(dead);
			numBallsRemoved++;
		}
		
		return numBallsRemoved;
	}
}
