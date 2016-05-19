package brickBreaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public  class Game extends JPanel implements KeyListener {

	static Paddle p = new Paddle(100);
	static BallList list = new BallList();
	static BrickList bricks = new BrickList();
	static JFrame frame = new JFrame();
	static Game m = new Game();
	static Timer timer = new Timer(5, m.new MyActionListener());
	static GameUtilities util = new GameUtilities(list, p, bricks);
	static int numBricks = 0;



	Game(){
		frame.setTitle("BrickBreaker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);


	}

	public static void main(String[] args) {
		Ball ball1 = new Ball(350, 100);
		list.add(ball1);
		int xPosition = 30;
		int yPosition = 40;
		for(int i = 1; i <= 30; i++) {
			Brick newBrick = new Brick(xPosition, yPosition);
			numBricks++;
			bricks.add(newBrick);
			xPosition += 60;
			if(i % 10 == 0) {
				yPosition += 20;
				xPosition = 30;
				
			}
		}
		frame.add(m);
		frame.setVisible(true);
		frame.setSize(720, 530);

		frame.requestFocusInWindow();
		frame.addKeyListener(m);
		timer.start();
		m.repaint(); 
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.ORANGE);
		for(Ball b: list.balls) {
			g.fillOval(b.getxPos(), b.getyPos(), 10, 10);
		}

		for(Brick b : bricks.bricks) { //draw bricks
			if(b.isLive()) {
				g.setColor(b.getColor());
				g.fillRect(b.getxPos(), b.getyPos(), b.getLength(), b.getWidth());
			}
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 30)); 
		if(util.getPoints() == numBricks) {
			g.drawString("YOU WON! Press R to Restart", 200, 250);
		}
		g.setColor(Color.RED);
		g.fillRect(p.getxPos(), p.getyPos(), p.getLength(), 10); //paddle
		g.setColor(Color.BLACK);
		g.setFont(new Font(g.getFont().getFontName(), Font.PLAIN, 10)); 
		g.drawString("Points: " + util.getPoints(), 630, 470);
		g.drawString("Press R to restart the game", 20, 470);
	}
	//@Override
	//public void actionPerformed(ActionEvent e) {



	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			p.setxPos(p.getxPos() - 5 );



		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			p.setxPos(p.getxPos() + 5);
			//util.moveBalls(list, p);
		}
		//reset game on R keypress
		else if(e.getKeyCode() == KeyEvent.VK_R) {
			System.out.println("Game Reset");
			for(Brick brick : bricks.bricks) {
				brick.setLive(true);
			}
			for(Ball b : list.balls) {
				b.setLive(false);
			}
			list.checkAndRemoveBalls();
			list.add(new Ball(350, 100));
			util = new GameUtilities(list, p, bricks);

		}

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	private class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			m.repaint();
			util.moveBalls(list, p);
			util.brickTouchCheck(list, bricks);

		}
	}

}

