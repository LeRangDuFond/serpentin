package fr.lerangdufond.serpentin;

import gameframework.drawing.GameCanvas;
import gameframework.drawing.GameCanvasDefaultImpl;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.gui.GameWindow;

/**
 * Main class for the Serpentin.
 *
 * @author Joel Troch
 */
public class Main {

	/**
	 * Entry point of the application.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		GameConfiguration gc = new GameConfiguration();
		String gameName = "Serpentin";
		GameCanvas gameCanvas = new GameCanvasDefaultImpl();
		GameData data = new GameData(gc);
		GameWindow window = new GameWindow(gameName, gameCanvas, data);
		window.createGUI();
	}

}
