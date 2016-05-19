package brickBreaker;

import java.util.Random;

public class GameUtilities {
	BallList list;
	Paddle p;
	int points = 0;

	public GameUtilities(BallList list, Paddle p, BrickList bricks) {
		this.list = list;
		this.p = p;
	}
	//returns true
	public boolean ballOverPaddle(Ball b, Paddle p) {
		if((b.getxPos() >= p.getxPos()) && b.getxPos() <= p.getxPos() + p.getLength()) { 
			return true;
		}
		else {return false;}
	}
	//if it's on the left third of paddle, -1, middle third, 0, right third, 1 - maybe edit this later to allow for values not -1, 0 or 1
	public int findDirection(Ball b, Paddle p) {
		int returnval = 0;
		int firstThirdEnd = p.getxPos() + (p.getLength() / 3); //int div, dropping remainder doesn't matter
		int middleThirdEnd = p.getxPos() + 2 * (p.getLength() / 3);
		int lastThirdEnd = p.getxPos() + p.getLength(); //
		if(b.getxPos() >= p.getxPos() && b.getxPos() < firstThirdEnd) {
			returnval = -1;
		}
		//ball in middle third is base case
		if((b.getxPos() >= middleThirdEnd) && b.getxPos() <= lastThirdEnd) {
			returnval = 1;
		}

		return returnval;
	}
	//
	public void setDirection(BallList list, Paddle p) {
		for(Ball b : list.balls) {
			if(ballOverPaddle(b, p) && b.getyPos() == p.getyPos() ) {
				b.setDirection((findDirection(b, p)));
				b.setSpeed(b.getSpeed() * -1);
			}
		}
	}

	public void moveBalls(BallList list, Paddle p) {
		this.setDirection(list, p);
		for(Ball b : list.balls) {
			b.setyPos(b.getyPos() + b.getSpeed());
			b.setxPos(b.getxPos() + b.getDirection());
			if(b.getyPos() > p.getyPos() + 20) {//make a ball dead if it goes past the paddle
				b.setLive(false);
			}
			//deal with ball colliding with edge of window
			if(b.getyPos() <= 0) {
				b.setSpeed(1);
			}
			if(b.getxPos() < 0 || b.getxPos() >= 680) { //magic numbers are frame borders. 

				b.setDirection(b.getDirection() * -1);

			}

		}

	}
	public int brickTouchCheck(BallList list, BrickList bricks)  {
		for(Ball ball: list.balls) {
			for(Brick brick: bricks.bricks) {
				if(ball.getyPos() > brick.getyPos() && ball.getyPos() < (brick.getyPos() + brick.getWidth())) {
					if(ball.getxPos() > brick.getxPos()  && ball.getxPos() < (brick.getxPos() + brick.getLength())) {
						if(brick.isLive()) {
							brick.doEffect();
							ball.setSpeed(ball.getSpeed() * -1);
							Random rn = new Random();
							int r1 = rn.nextInt((3 - 1) + 1) + 1;
							if(r1 == 2) {
								ball.setDirection(-1);
							}
							else if (r1 == 2) {
								ball.setDirection(0);
							}
							else if(r1 == 3) {
								ball.setDirection(1);
							}
							
							
							points++;
						}
						
					}
				}
			}
		}
		return points;
	}
	public int getPoints() {
		return points;
	}

	
}
