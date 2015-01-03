package com.edu4java.minitennis1;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	private static final int y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	int x = 0;
	int xSpeed = 0;
	private Game game;

	public Racquet(Game game) {
		this.game= game;
	}

	public void move() {
		if (x + xSpeed > 0 && x + xSpeed < game.getWidth()-WIDTH)
			x = x + xSpeed;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, 330, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		xSpeed = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xSpeed = -game.speed;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xSpeed = game.speed;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	public int getY() {
		return y;
	}
}