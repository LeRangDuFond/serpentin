package fr.lerangdufond.serpentin.game.entities;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Test;

import fr.lerangdufond.serpentin.game.SerpentinConfiguration;
import gameframework.game.GameData;

public class SerpentinEntityWallTest {
	@Test
	public void testiIsMovable() {
		SerpentinConfiguration gameConfig = new SerpentinConfiguration();
		GameData gameData = new GameData(gameConfig);
		SerpentinEntityWall sew = new SerpentinEntityWall(gameData, 100, 100);
		assertEquals(sew.isMovable(), false);
	}

	@Test
	public void testGetBoundingBox() {
		SerpentinConfiguration gameConfig = new SerpentinConfiguration();
		GameData gameData = new GameData(gameConfig);
		SerpentinEntityWall sew = new SerpentinEntityWall(gameData, 100, 100);
		Rectangle rect = new Rectangle(sew.getSize(), sew.getSize());
		rect.setLocation(sew.getPosition().x, sew.getPosition().y);
		assertTrue(sew.getBoundingBox().equals(rect));
	}
}
