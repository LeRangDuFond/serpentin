package fr.lerangdufond.serpentin.game.entities;

import java.awt.*;

import gameframework.drawing.*;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.overlapping.Overlappable;
import java.util.Random;

/**
 * The ball entity for the Serpentin.
 *
 * This is the entity "eaten" by the player to increase it's score, each time that entity is eaten, it move elsewhere.
 *
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
public class SerpentinEntityBall extends GameMovable implements Drawable, GameEntity, Overlappable {
	/** The sprite manager used by this ball to be drawn. */
	private final SpriteManager spriteManager;
	/** The game data to impact. */
	private final GameData data;
	/** Amount of points given by eating this ball. */
	private final int points;
	/** Random class used by all balls to generate their new position. */
	private static final Random random = new Random();

	/**
	 * Create a ball entity with a specific game data to impact.
	 * @param data The game data to impact on.
	 */
	public SerpentinEntityBall(GameData data) {
		super();
		this.data = data;
		this.points = 1;

		DrawableImage img = new DrawableImage("/images/fruit.png", this.data.getCanvas());
		this.spriteManager = new SpriteManagerDefaultImpl(img, this.data.getConfiguration().getSpriteSize(), 1);
		this.setRandomPosition();
	}

	/**
	 * Set the position of this ball to a random place without being outside the level and inside a wall of course.
	 */
	private void setRandomPosition() {
		int x = (random.nextInt(this.data.getConfiguration().getNbColumns() - 3) + 1) * this.data.getConfiguration().getSpriteSize();
		int y = (random.nextInt(this.data.getConfiguration().getNbRows() - 3) + 1) * this.data.getConfiguration().getSpriteSize();
		this.position = new Point(x, y);
	}

	/**
	 * Return the position of this ball.
	 * @return This ball's position.
	 */
	public Point getPosition(){
		return this.position;
	}

	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.data.getConfiguration().getSpriteSize(), this.data.getConfiguration().getSpriteSize());
		rectangle.setLocation(this.position.x * this.data.getConfiguration().getSpriteSize(), this.position.y * this.data.getConfiguration().getSpriteSize());
		return rectangle;
	}

	@Override
	public void draw(Graphics g) {
		this.spriteManager.draw(g, position);
		this.spriteManager.increment();
	}

	/**
	 * This function is called every time a player hit the ball. It will increase the global score and will change the
	 * position of the ball.
	 */
	public void getHit() {
		this.data.getScore().setValue(this.data.getScore().getValue() + this.points);
		this.setRandomPosition();
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// UNUSED : The ball don't move
	}
}
