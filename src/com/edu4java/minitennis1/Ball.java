package com.edu4java.minitennis1;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game= game;
	}

	void move() {
		boolean changeDirection = true;	
		if (x + xa < 0)
			xa = game.speed;
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -game.speed;
		else if (y + ya < 0)
			ya = game.speed;
		else if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		else if(collision()){	
				ya = -game.speed;
				y = game.paddle.getY() - DIAMETER;
				game.speed++;
		} else changeDirection = false;
		x = x + xa;
		y = y + ya;
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	private boolean collision() {
		return game.paddle.getBounds().intersects(getBounds());
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,DIAMETER,DIAMETER);
	}
}