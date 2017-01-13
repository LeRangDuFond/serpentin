package fr.lerangdufond.serpentin;

import gameframework.game.Game;

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
		Game serpentin = new Serpentin();
		serpentin.start();
	}

}
