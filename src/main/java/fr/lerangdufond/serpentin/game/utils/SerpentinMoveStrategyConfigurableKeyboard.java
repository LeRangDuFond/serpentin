package fr.lerangdufond.serpentin.game.utils;

import java.awt.Point;

import gameframework.motion.MoveStrategyConfigurableKeyboard;
import gameframework.motion.SpeedVector;

public class SerpentinMoveStrategyConfigurableKeyboard extends MoveStrategyConfigurableKeyboard{
	
	private Point prevDirection;
	
	SerpentinMoveStrategyConfigurableKeyboard(Boolean alwaysMove, SpeedVector speedVector, Boolean combineDirections){
		super(alwaysMove, speedVector, combineDirections);
		this.prevDirection = new Point(0,0);
	}
	
	/**
	 * Update the direction depending on the keys pressed
	 */
	protected void updateDirection() {
		final Point newDirection = new Point(0, 0);
		for (Integer keyCode : keyPressed) {
			final Point keyDirection = directions.get(keyCode);
			if (keyDirection != null) {
				/*Check if player is trying to return back.*/
				/*Check if it is not the first move.*/
				if((this.prevDirection.x + this.prevDirection.y) != 0){
					if((keyDirection.x == 0 && this.prevDirection.x == 0) || (keyDirection.y == 0 && this.prevDirection.y == 0)){
						return;
					}
				}
				newDirection.x += keyDirection.x;
				newDirection.y += keyDirection.y;
				this.prevDirection.x = newDirection.x;
				this.prevDirection.y = newDirection.y;
				
				// If we don't combine directions, then we should stop here
				if (!combineDirections) {
					break;
				}
			}
		}
		
		if (newDirection.x != 0 || newDirection.y != 0 || !alwaysMove)
			speedVector.setDirection(newDirection);
	}
	
}


