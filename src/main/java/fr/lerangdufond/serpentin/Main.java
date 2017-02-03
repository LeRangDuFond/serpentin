package fr.lerangdufond.serpentin;

import fr.lerangdufond.serpentin.game.SerpentinConfiguration;
import fr.lerangdufond.serpentin.game.SerpentinLevel;
import fr.lerangdufond.serpentin.gui.SerpentinWindow;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;

/**
 * Main class for the Serpentin.
 * This class act as the entry point of the application, it instantiate all the "core" elements and start the game
 * when everything is ready.
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
		SerpentinWindow window = new SerpentinWindow(gameData.getCanvas(), gameConfig, gameData);
		window.createGUI();
		game.start();
	}
}
