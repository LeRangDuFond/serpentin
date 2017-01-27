package fr.lerangdufond.serpentin;

import fr.lerangdufond.serpentin.game.SerpentinConfiguration;
import fr.lerangdufond.serpentin.game.SerpentinLevel;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameStatusBarElement;
import gameframework.gui.GameWindow;

/**
 * Main class for the Serpentin.
 *
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
public class Main {
	/**
	 * Entry point of the application.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		// Define the assets to use
		SerpentinConfiguration gameConfig = new SerpentinConfiguration();
		GameData gameData = new GameData(gameConfig);
		gameData.addLevel(new SerpentinLevel(gameData));
		GameDefaultImpl game = new GameDefaultImpl(gameData);

		// Status bar
		GameStatusBarElement<Integer> gameScoreBar = new GameStatusBarElement<>("Score : ", gameData.getScore());

		// Create the window and start the game
		GameWindow window = new GameWindow("Serpentin", gameData.getCanvas(), gameConfig, gameScoreBar);
		window.createGUI();
		game.start();
	}
}
