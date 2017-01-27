package fr.lerangdufond.serpentin;

import fr.lerangdufond.serpentin.game.SerpentinConfiguration;
import fr.lerangdufond.serpentin.game.SerpentinLevel;
import fr.lerangdufond.serpentin.gui.SerpentinWindow;
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

		// Create the window and start the game
		SerpentinWindow window = new SerpentinWindow("Serpentin", gameData.getCanvas(), gameConfig, gameData);
		window.createGUI();
		game.start();
	}
}
