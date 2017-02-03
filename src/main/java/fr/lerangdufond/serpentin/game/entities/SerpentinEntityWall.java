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
 * The wall entity for the Serpentin.
 *
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
public class SerpentinEntityWall implements Drawable, GameEntity, MoveBlocker {
	/** Image of the wall. */
	private final DrawableImage image;
	/** The game canvas to draw on. */
	private final GameCanvas canvas;
	/** Position of the wall. */
	private final Point position;
	/** Size of the wall */
	private final int size;

	/**
	 * Build a new wall for a specific game data at a specific position.
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

	/**
	 * Return the position of this wall.
	 * @return This wall's position.
	 */
	public Point getPosition() {
		return this.position;
	}

	/**
	 * Return the size of this wall.
	 * @return This wall's size.
	 */
	public int getSize() {
		return this.size;
	}

	@Override
	public Rectangle getBoundingBox() {
		Rectangle rect = new Rectangle(this.size, this.size);
		rect.setLocation(this.position.x, this.position.y);
		return rect;
	}
}
