package fr.lerangdufond.serpentin.motion.overlapping;

import fr.lerangdufond.serpentin.game.entities.SerpentinEntityBall;
import fr.lerangdufond.serpentin.game.entities.SerpentinEntityPlayer;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;

/**
 * Class to define all the overlapping rules for Serpentin's entities.
 *
 * It used to trigger "game events" based on collisions depending on the entity responsible for the collision and the
 * impacted entity.
 *
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
public class SerpentinOverlapRules extends OverlapRulesApplierDefaultImpl{
	/**
	 * Define what happens when the player hit a ball.
	 * @param player The player entity that hit the wall.
	 * @param ball The wall entity hit by the player.
	 */
	public void overlapRule(SerpentinEntityPlayer player, SerpentinEntityBall ball){
		ball.getHit();
	}
}
