package fr.lerangdufond.serpentin.game;

import fr.lerangdufond.serpentin.game.entities.SerpentinEntityPlayer;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

/**
 * The Serpentin's level.
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
public class SerpentinLevel extends GameLevelDefaultImpl {
	/**
	 * Create a Serpentin's level with a specific game data to use.
	 * @param data The game to use (the framework's default should do).
	 */
	public SerpentinLevel(GameData data) {
		super(data);
	}

	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortDefaultImpl(data);
		this.gameBoard.setBackgroundImage("/images/background.png");
		this.universe.addGameEntity(new SerpentinEntityPlayer(this.data));
	}
}
