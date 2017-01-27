package fr.lerangdufond.serpentin.game.utils;

import java.awt.Point;
import java.awt.event.KeyEvent;

import gameframework.motion.SpeedVector;

/**
 * {@link MoveStrategy} which listens to the keyboard and answers new
 * {@link SpeedVector speed vectors} based on what the user typed.
 */
public class SerpentinMoveStrategyKeyboard extends SerpentinMoveStrategyConfigurableKeyboard {
	public SerpentinMoveStrategyKeyboard() {
		this(true);
	}
	
	/**
	 * {@link MoveStrategyConfigurableKeyboard#MoveStrategyKeyboard(Boolean)}
	 */
	public SerpentinMoveStrategyKeyboard(Boolean alwaysMove) {
		this(alwaysMove, new SpeedVector(new Point(0, 0), 15));
	}
	
	/**
	 * {@link MoveStrategyConfigurableKeyboard#MoveStrategyKeyboard(SpeedVector)}
	 */
	public SerpentinMoveStrategyKeyboard(SpeedVector speedVector) {
		this(true, speedVector);
	}
	
	/**
	 * {@link MoveStrategyConfigurableKeyboard#MoveStrategyKeyboard(Boolean, SpeedVector)}
	 */
	public SerpentinMoveStrategyKeyboard(Boolean alwaysMove, SpeedVector speedVector) {
		this(alwaysMove, speedVector, false);
	}
	
	/**
	 * {@link MoveStrategyConfigurableKeyboard#MoveStrategyKeyboard(Boolean, SpeedVector, Boolean)}
	 */
	public SerpentinMoveStrategyKeyboard(Boolean alwaysMove, SpeedVector speedVector, Boolean combineDirections) {
		super(alwaysMove, speedVector, combineDirections);
		
		addKeyDirection(KeyEvent.VK_RIGHT, new Point(1, 0));
		addKeyDirection(KeyEvent.VK_LEFT, new Point(-1, 0));
		addKeyDirection(KeyEvent.VK_DOWN, new Point(0, 1));
		addKeyDirection(KeyEvent.VK_UP, new Point(0, -1));
	}
}

