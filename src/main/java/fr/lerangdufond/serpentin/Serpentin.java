package fr.lerangdufond.serpentin;

import fr.lerangdufond.serpentin.game.SerpentinLevel;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;

/**
 * Main class for the Serpentin.
 *
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
public class Serpentin extends GameDefaultImpl {
	/**
	 * Create a default Serpentin game with the default level.
	 * @param data The game data to use (the framework's default one should do).
	 */
	public Serpentin(GameData data) {
		super(data);
		this.data.addLevel(new SerpentinLevel(data));
	}
}
