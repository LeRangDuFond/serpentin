package fr.lerangdufond.serpentin.game;

import gameframework.game.GameConfiguration;
import gameframework.motion.overlapping.OverlapRulesApplier;

/**
 * Configuration class for the Serpentin.
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
public class SerpentinConfiguration extends GameConfiguration {

	/**
	 * Create the Serpentin's configuration.
	 */
	public SerpentinConfiguration() {
		super(20, 30, 32, 1);
	}


	/*
	 * (non-Javadoc)
	 * @see gameframework.game.GameConfiguration#createOverlapRulesApplier()
	 */
	@Override
	public OverlapRulesApplier createOverlapRulesApplier() { return new SerpentinOverlapRules();}

}
