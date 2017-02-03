package fr.lerangdufond.serpentin.game;

import fr.lerangdufond.serpentin.game.entities.SerpentinEntityBall;
import fr.lerangdufond.serpentin.game.entities.SerpentinEntityPlayer;
import fr.lerangdufond.serpentin.game.entities.SerpentinEntityWall;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

/**
 * The Serpentin's core level.
 *
 * Walls around the level, a player, and a first ball.
 *
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
public class SerpentinLevel extends GameLevelDefaultImpl {
	/**
	 * Create a Serpentin's level with a specific game data to use.
	 * @param data The game to use (the framework's default should do).
	 */
	public SerpentinLevel(GameData data) {
		super(data, 3);
	}

	/**
	 * Returns the position of a cell by it's index.
	 * This is very useful for a game that relies on cells, the size of those cells are determined by the size of the
	 * sprites (which is defined by the game configuration your game is using).
	 * @param i The index of the cell you wish to retrieve it's position.
	 * @return The position of the cell.
	 */
	private int getCellPositionByIndex(int i) {
		return i * this.spriteSize;
	}

	@Override
	protected void init() {
		this.gameBoard = new GameUniverseViewPortDefaultImpl(data);
		this.gameBoard.setBackgroundImage("/images/background.png");
		this.universe.addGameEntity(new SerpentinEntityPlayer(this.data));

		this.spawnWalls();
		this.spawnFirstBall();
	}

	/**
	 * Spawn the first ball in the game.
	 */
	private void spawnFirstBall() {
		this.universe.addGameEntity(new SerpentinEntityBall(this.data));
	}

	/**
	 * Build the walls in the level.
	 */
	private void spawnWalls() {
		int rows = this.data.getConfiguration().getNbRows() - 1;
		int cols = this.data.getConfiguration().getNbColumns();

		// Build the top and bottom walls
		int i = 0;
		while (i < cols) {
			this.universe.addGameEntity(new SerpentinEntityWall(this.data, this.getCellPositionByIndex(i), this.getCellPositionByIndex(0)));
			this.universe.addGameEntity(new SerpentinEntityWall(this.data, this.getCellPositionByIndex(i), this.getCellPositionByIndex(rows)));
			i++;
		}

		// Build the left and right walls
		i = 1;
		while (i < rows) {
			this.universe.addGameEntity(new SerpentinEntityWall(this.data, this.getCellPositionByIndex(0), this.getCellPositionByIndex(i)));
			this.universe.addGameEntity(new SerpentinEntityWall(this.data, this.getCellPositionByIndex(cols - 1), this.getCellPositionByIndex(i)));
			i++;
		}
	}
}
