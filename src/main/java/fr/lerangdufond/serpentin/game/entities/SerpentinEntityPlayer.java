package fr.lerangdufond.serpentin.game.entities;

import java.awt.Graphics;
import java.awt.Point;
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
import gameframework.motion.GameMovableDriverDefaultImpl;
import gameframework.motion.MoveStrategyKeyboard;
import gameframework.motion.overlapping.Overlappable;

public class SerpentinEntityPlayer extends GameMovable implements Observer,
Overlappable, GameEntity, Drawable, KeyListener{
	
	protected SpriteManager spriteManager;
	protected GameCanvas canvas;
	protected int spriteSize;
	protected GameData data;
	protected Point direction;
	
	public SerpentinEntityPlayer(GameData data){
		this.canvas = data.getCanvas();
		this.data = data;
		this.canvas = data.getCanvas();
		this.spriteSize = data.getConfiguration().getSpriteSize();
		this.spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(
				"/images/head.png", canvas), this.spriteSize, 1);
		this.direction = new Point(0, 1);
		this.setPosition(new Point(this.data.getCanvas().getWidth()/2, this.data.getCanvas().getHeight()/2));
		
		MoveStrategyKeyboard keyboard = new MoveStrategyKeyboard();
		GameMovableDriverDefaultImpl moveDriver = new GameMovableDriverDefaultImpl();

		moveDriver.setStrategy(keyboard);
		moveDriver.setmoveBlockerChecker(data.getMoveBlockerChecker());

		data.getCanvas().addKeyListener(keyboard);
		setDriver(moveDriver);

		data.getCanvas().addKeyListener(this);
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(32,32);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyChar());
	}

	/**
	 * Not used here.
	 * */
	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	/**
	 * Not used here.
	 * */
	@Override
	public void keyReleased(KeyEvent e) {
		
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
