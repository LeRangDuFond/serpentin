package fr.lerangdufond.serpentin;

import gameframework.drawing.GameCanvas;
import gameframework.drawing.GameCanvasDefaultImpl;
import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.gui.GameWindow;

/**
 * The Serpentin class is the principal class of the game.
 * */
public class Serpentin implements Game{

	@Override
	public void start() {
		GameConfiguration gc = new GameConfiguration(20,30,40,50);
		String gameName = "Serpentin";
		GameCanvas gameCanvas = new GameCanvasDefaultImpl();
		GameData data = new GameData(gc);
		GameWindow window = new GameWindow(gameName, gameCanvas, data);
		window.createGUI();
	}

}
