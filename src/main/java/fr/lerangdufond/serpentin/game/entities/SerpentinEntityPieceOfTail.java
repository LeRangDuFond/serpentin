package fr.lerangdufond.serpentin.game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManager;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.overlapping.Overlappable;

public class SerpentinEntityPieceOfTail extends GameMovable implements Observer,
Overlappable, GameEntity, Drawable, KeyListener{

	private GameMovable prevEntity;
	private SpriteManager spriteManager;
	private GameCanvas canvas;
	private int spriteSize;
	
	public SerpentinEntityPieceOfTail(GameData data, GameMovable prevEntity){
		this.prevEntity = prevEntity;
		this.canvas = data.getCanvas();
		this.canvas = data.getCanvas();
		this.spriteSize = data.getConfiguration().getSpriteSize();
		this.spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(
				"/images/tail.png", canvas), this.spriteSize, 1);
		this.setPosition(this.prevEntity.getPosition());
	}
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(32,32);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		this.spriteManager.draw(g, this.position);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
		
	}
	
}
