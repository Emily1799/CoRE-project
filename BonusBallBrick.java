package brickBreaker;

public class BonusBallBrick extends Brick {
	private Ball createdball ;
	private boolean hasBeenSent = true;
	public BonusBallBrick(int xPos, int yPos) {
		super(xPos, yPos);
	}
	@Override
	public void doEffect() {
		createdball = new Ball(350, 70);
		createdball.setDirection(0);
		createdball.setSpeed(1);
		hasBeenSent = false;
	}
	public Ball ballsMade() {
		if(createdball != null) {
			if(!hasBeenSent)
				return createdball;
		}

		return null;
	}
}

