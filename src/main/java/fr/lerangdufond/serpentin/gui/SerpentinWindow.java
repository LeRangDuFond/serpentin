package fr.lerangdufond.serpentin.gui;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.gui.GameMenuBar;
import gameframework.gui.GameStatusBar;
import gameframework.gui.GameStatusBarElement;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Serpentin's version of "GameWindow".
 *
 * The main reason we have to make our own version which is basically a copy/paste of "GameWindow" is to override the
 * status bar to our own version. For some reason, the framework was still using the standard "GameWindow" instead of
 * our own. We should make a PR of that.
 *
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
public class SerpentinWindow {

	/** The window's frame. */
	private final Frame frame;
	/** The game's canvas. */
	private GameCanvas gameCanvas;
	/** The status bar. */
	private final GameStatusBar statusBar = new SerpentinGameStatusBar();

	/**
	 * Create a new Serpentin window.
	 * @param gameName Name of the frame (generally the name of the game).
	 * @param gameCanvas Game canvas to use.
	 * @param gameConfiguration Game configuration to use.
	 * @param gameData Game data to use.
	 */
	public SerpentinWindow(String gameName, GameCanvas gameCanvas, GameConfiguration gameConfiguration, GameData gameData) {
		if (gameCanvas == null)
			throw new IllegalArgumentException("GameCanvas is null!");

		this.statusBar.add(new GameStatusBarElement<>("Score : ", gameData.getScore()));
		this.frame = new Frame(gameName);
		this.gameCanvas = gameCanvas;
		this.gameCanvas.setSize(gameConfiguration.getSpriteSize() * gameConfiguration.getNbColumns(), gameConfiguration.getSpriteSize() * gameConfiguration.getNbRows());
	}

	/**
	 * Create the GUI.
	 */
	public void createGUI() {
		this.frame.dispose();
		this.frame.setMenuBar(new GameMenuBar().getComponent());
		this.gameCanvas.addTo(this.frame);

		this.frame.add(this.statusBar.getContainer(), BorderLayout.NORTH);
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);

		this.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
