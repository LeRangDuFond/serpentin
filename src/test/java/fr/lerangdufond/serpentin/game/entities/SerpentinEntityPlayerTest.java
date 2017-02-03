package fr.lerangdufond.serpentin.game.entities;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Test;

import fr.lerangdufond.serpentin.game.SerpentinConfiguration;
import gameframework.game.GameData;

public class SerpentinEntityPlayerTest {

	@Test
	public void testSerpentinEntityPlayer() {
		SerpentinConfiguration gameConfig = new SerpentinConfiguration();
		GameData gameData = new GameData(gameConfig);
		SerpentinEntityPlayer sep = new SerpentinEntityPlayer(gameData);
		assertTrue(sep.getBoundingBox().equals(new Rectangle(32,32)));
	}
	
	@Test
	public void testGetBoundingBox() {
		SerpentinConfiguration gameConfig = new SerpentinConfiguration();
		GameData gameData = new GameData(gameConfig);
		SerpentinEntityPlayer sep = new SerpentinEntityPlayer(gameData);
		assertTrue(sep.getBoundingBox().equals(new Rectangle(32,32)));
	}
	
}
