package fr.lerangdufond.serpentin.game;

import fr.lerangdufond.serpentin.motion.overlapping.SerpentinOverlapRules;
import gameframework.game.GameConfiguration;
import gameframework.motion.overlapping.OverlapRulesApplier;

/**
 * Configuration class for the Serpentin.
 *
 * Used to set the number of rows, columns, sprites sizes, lives for the player and overlapping rules for the game.
 *
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
public class SerpentinConfiguration extends GameConfiguration {
	/**
	 * Create the Serpentin's configuration with our specific values.
	 */
	public SerpentinConfiguration() {
		super(20, 30, 32, 1);
	}

	@Override
	public OverlapRulesApplier createOverlapRulesApplier() {
		return new SerpentinOverlapRules();
	}
}
