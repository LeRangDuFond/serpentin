package fr.lerangdufond.serpentin.motion;

import java.awt.Point;
import java.awt.event.KeyEvent;

import gameframework.motion.MoveStrategyConfigurableKeyboard;
import gameframework.motion.SpeedVector;

/**
 * Class that listen to user's input and define the new vector direction.
 *
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
public class SerpentinMoveStrategyKeyboard extends SerpentinMoveStrategyConfigurableKeyboard {
	/**
	 * See {@link MoveStrategyConfigurableKeyboard#(Boolean, SpeedVector, Boolean)}
	 */
	private SerpentinMoveStrategyKeyboard(Boolean alwaysMove, SpeedVector speedVector, Boolean combineDirections) {
		super(alwaysMove, speedVector, combineDirections);

		this.addKeyDirection(KeyEvent.VK_RIGHT, new Point(1, 0));
		this.addKeyDirection(KeyEvent.VK_LEFT, new Point(-1, 0));
		this.addKeyDirection(KeyEvent.VK_DOWN, new Point(0, 1));
		this.addKeyDirection(KeyEvent.VK_UP, new Point(0, -1));
	}

	/**
	 * See {@link MoveStrategyConfigurableKeyboard#MoveStrategyConfigurableKeyboard(Boolean, SpeedVector)}
	 */
	private SerpentinMoveStrategyKeyboard(Boolean alwaysMove, SpeedVector speedVector) {
		this(alwaysMove, speedVector, false);
	}

	/**
	 * See {@link MoveStrategyConfigurableKeyboard#MoveStrategyConfigurableKeyboard(Boolean)}
	 */
	private SerpentinMoveStrategyKeyboard(Boolean alwaysMove) {
		this(alwaysMove, new SpeedVector(new Point(1, 0), 1));
	}

	/**
	 * See {@link MoveStrategyConfigurableKeyboard(Boolean)}
	 */
	public SerpentinMoveStrategyKeyboard() {
		this(true);
	}
}
