package fr.lerangdufond.serpentin.game.entities;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Wall entity for Serpentin.
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
public class SerpentinEntityWall implements Drawable, GameEntity, MoveBlocker {
	/** Image of the wall. */
	private DrawableImage image;
	/** The game canvas to draw on. */
	private GameCanvas canvas;
	/** Position of the wall. */
	private Point position;
	/** Size of the wall */
	private int size;

	/**
	 * Build a new wall.
	 * @param data The game data to register this wall in.
	 * @param x The X position of the wall.
	 * @param y The Y position of the wall.
	 */
	public SerpentinEntityWall(GameData data, int x, int y) {
		this.canvas = data.getCanvas();
		this.image = new DrawableImage("/images/wall.png", this.canvas);
		this.position = new Point(x, y);
		this.size = data.getConfiguration().getSpriteSize();
	}

	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.image.getImage(), this.position.x, this.position.y);
	}

	@Override
	public boolean isMovable() {
		return false;
	}

	@Override
	public Rectangle getBoundingBox() {
		Rectangle rect = new Rectangle(this.size, this.size);
		rect.setLocation(this.position.x, this.position.y);
		return rect;
	}
}
