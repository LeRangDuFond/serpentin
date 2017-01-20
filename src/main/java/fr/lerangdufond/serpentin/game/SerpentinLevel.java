package fr.lerangdufond.serpentin.game;

import fr.lerangdufond.serpentin.game.entities.SerpentinEntityBall;
import fr.lerangdufond.serpentin.game.entities.SerpentinEntityPlayer;
import fr.lerangdufond.serpentin.game.entities.SerpentinEntityWall;
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

	private int getCellIndex(int i) {
		return i * this.spriteSize;
	}

	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortDefaultImpl(data);
		this.gameBoard.setBackgroundImage("/images/background.png");
		this.universe.addGameEntity(new SerpentinEntityPlayer(this.data));

		this.buildWalls();
		this.buildBalls();
	}


	private void buildBalls() {
		while (true){
			this.universe.addGameEntity(new SerpentinEntityBall(this.data));
		}
	}
	/**
	 * Build the walls in the level.
	 */
	private void buildWalls() {
		int rows = this.data.getConfiguration().getNbRows() - 1;
		int cols = this.data.getConfiguration().getNbColumns();

		// Build the top and bottom walls
		int i = 0;
		while (i < cols) {
			this.universe.addGameEntity(new SerpentinEntityWall(this.data, this.getCellIndex(i), this.getCellIndex(0)));
			this.universe.addGameEntity(new SerpentinEntityWall(this.data, this.getCellIndex(i), this.getCellIndex(rows)));
			i++;
		}

		// Build the left and right walls
		i = 1;
		while (i < rows) {
			this.universe.addGameEntity(new SerpentinEntityWall(this.data, this.getCellIndex(0), this.getCellIndex(i)));
			this.universe.addGameEntity(new SerpentinEntityWall(this.data, this.getCellIndex(cols - 1), this.getCellIndex(i)));
			i++;
		}
	}
}
