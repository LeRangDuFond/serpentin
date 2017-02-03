package fr.lerangdufond.serpentin.game.entities;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.lerangdufond.serpentin.motion.SerpentinMoveStrategyKeyboard;
import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManager;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.overlapping.Overlappable;

/**
 * The player entity for the Serpentin.
 *
 * Implements all the interface required for player control, movement and physics.
 *
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
public class SerpentinEntityPlayer extends GameMovable implements Drawable, GameEntity, KeyListener, Overlappable {
	/** The game data's to gather some information from. */
	private final GameData data;
	/** The sprite manager used by this player. */
	private final SpriteManager spriteManager;

	/**
	 * Create a player entity for a specific game data.
	 * @param data The game data to use.
	 */
	public SerpentinEntityPlayer(GameData data) {
		// Draw the player
		this.data = data;
		GameCanvas canvas = this.data.getCanvas();
		this.spriteManager = new SpriteManagerDefaultImpl(new DrawableImage("/images/head.png", canvas),
				data.getConfiguration().getSpriteSize(), 1);
		this.setPosition(new Point(canvas.getWidth() / 2, canvas.getHeight() / 2));

		// Assign it's controls
		SerpentinMoveStrategyKeyboard keyboard = new SerpentinMoveStrategyKeyboard();
		GameMovableDriverDefaultImpl moveDriver = new GameMovableDriverDefaultImpl();

		moveDriver.setStrategy(keyboard);
		moveDriver.setmoveBlockerChecker(this.data.getMoveBlockerChecker());

		canvas.addKeyListener(keyboard);
		this.setDriver(moveDriver);
		canvas.addKeyListener(this);
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(this.data.getConfiguration().getSpriteSize(), this.data.getConfiguration().getSpriteSize());
	}

	@Override
	public void draw(Graphics g) {
		this.spriteManager.draw(g, this.position);
	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {
		// TODO: Unused (yet)
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		// TODO: Unused (yet)
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
		// TODO: Unused (yet)
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO: Unused (yet)
	}
}
