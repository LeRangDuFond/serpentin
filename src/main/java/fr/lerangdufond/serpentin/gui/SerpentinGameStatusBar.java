package fr.lerangdufond.serpentin.gui;

import gameframework.gui.GameStatusBar;
import gameframework.gui.GameStatusBarElement;

import javax.swing.JPanel;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;

/**
 * Serpentin's version of "GameStatusBar".
 *
 * Used to fix an issue where if the score was higher than 9 (like "Score : 10"), the last digit would be half cut.
 *
 * @author Joel Troch - Robin Bossart - Francois Masson
 */
class SerpentinGameStatusBar extends GameStatusBar {
	@Override
	public Container getContainer() {
		JPanel container = new JPanel();
		GridLayout layout = new GridLayout(1, 2);
		container.setLayout(layout);

		for (GameStatusBarElement<?> element : elements) {
			element.getElementText().setAlignment(Label.RIGHT);
			container.add(element.getElementText());
			container.add(element.getElementValue());
		}

		super.update();
		return container;
	}
}
