package fr.lerangdufond.serpentin.motion;

import java.awt.Point;

import gameframework.motion.MoveStrategyConfigurableKeyboard;
import gameframework.motion.SpeedVector;

/**
 * Class that listen to user's input and define the new vector direction.
 *
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
class SerpentinMoveStrategyConfigurableKeyboard extends MoveStrategyConfigurableKeyboard{
	/** Previous direction of the entity. */
	private final Point prevDirection;

	/**
	 * Create a new configurable move strategy for an entity using the keyboard.
	 * @param alwaysMove Define if the entity should always move.
	 * @param speedVector The speed vector to apply when this move strategy is instantiated.
	 * @param combineDirections Define if directions for this entity should be combined.
	 */
	SerpentinMoveStrategyConfigurableKeyboard(Boolean alwaysMove, SpeedVector speedVector, Boolean combineDirections) {
		super(alwaysMove, speedVector, combineDirections);
		this.prevDirection = new Point(-1,0);
	}

	/**
	 * Update the entity's direction depending on the keys pressed.
	 */
	protected void updateDirection() {
		final Point newDirection = new Point(0, 0);

		for (Integer keyCode : keyPressed) {
			final Point keyDirection = directions.get(keyCode);

			if (keyDirection != null) {
				// Check if player is trying to return back and if it's not the first move.
				if ((this.prevDirection.x + this.prevDirection.y) != 0) {
					if (keyDirection.x == 0 && this.prevDirection.x == 0 || keyDirection.y == 0 && this.prevDirection.y == 0)
						return;
				}

				newDirection.x += keyDirection.x;
				newDirection.y += keyDirection.y;
				this.prevDirection.x = newDirection.x;
				this.prevDirection.y = newDirection.y;
				
				// If we don't combine directions, then we should stop here
				if (!this.combineDirections)
					break;
			}
		}

		if (newDirection.x != 0 || newDirection.y != 0 || !this.alwaysMove)
			this.speedVector.setDirection(newDirection);
	}
}
