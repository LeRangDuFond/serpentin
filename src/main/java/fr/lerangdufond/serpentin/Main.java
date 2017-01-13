package fr.lerangdufond.serpentin;

import fr.lerangdufond.serpentin.game.SerpentinConfiguration;
import fr.lerangdufond.serpentin.game.SerpentinLevel;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
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
		SerpentinConfiguration gameConfig = new SerpentinConfiguration();
		GameData gameData = new GameData(gameConfig);
		gameData.addLevel(new SerpentinLevel(gameData));
		GameDefaultImpl game = new GameDefaultImpl(gameData);
		GameWindow window = new GameWindow("Serpentin", gameData.getCanvas(), gameData);
		window.createGUI();
		game.start();
	}
}
