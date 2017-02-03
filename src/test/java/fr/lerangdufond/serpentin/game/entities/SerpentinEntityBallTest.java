package fr.lerangdufond.serpentin.game.entities;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Test;

import fr.lerangdufond.serpentin.game.SerpentinConfiguration;
import gameframework.game.GameData;

public class SerpentinEntityBallTest {

	@Test
	public void testGetBoundingBox() {
		SerpentinConfiguration gameConfig = new SerpentinConfiguration();
		GameData gameData = new GameData(gameConfig);
		SerpentinEntityBall seb = new SerpentinEntityBall(gameData);
		Rectangle rectangle = new Rectangle(seb.spriteSize, seb.spriteSize);
		rectangle.setLocation(seb.getPosition().x * seb.spriteSize, seb.getPosition().y * seb.spriteSize);
		assertTrue(seb.getBoundingBox().equals(rectangle));
	}

}
