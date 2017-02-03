package fr.lerangdufond.serpentin.game.entities;

import java.awt.*;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManager;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.*;
import gameframework.motion.overlapping.Overlappable;

public class SerpentinEntityPieceOfTail extends GameMovable implements
Overlappable, GameEntity, Drawable{

	private GameMovable prevEntity;
	private SpriteManager spriteManager;
	private GameCanvas canvas;
	private int spriteSize;
	private GameData gameData;
	private SpeedVector speed = SpeedVector.createNullVector();
	private Point goalPos;

	public SerpentinEntityPieceOfTail(GameData data, GameMovable prevEntity){
	    super();
		this.prevEntity = prevEntity;
		this.canvas = data.getCanvas();
		this.gameData = data;
		this.spriteSize = data.getConfiguration().getSpriteSize();
		this.spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(
				"/images/tail.png", canvas), this.spriteSize, 1);


		this.setCorrectPosition();
	}

	private void setCorrectPosition(){
	    Point direction = this.prevEntity.getSpeedVector().getDirection();
	    Point position = this.prevEntity.getPosition();
	    Point p = null;
        if (direction.getX() == 1){
            p = new Point((int)position.getX() - this.spriteSize, (int)position.getY());
            //this.goalPos = new Point((int)position.getX() - this.spriteSize-1, (int)position.getY());
        }else if(direction.getX() == -1){
            p = new Point((int)position.getX() + this.spriteSize, (int)position.getY());
            //this.goalPos = new Point((int)position.getX() + this.spriteSize+1, (int)position.getY());
        }else if(direction.getY() == 1){
            p = new Point((int)position.getX(), (int)position.getY() - this.spriteSize);
            //this.goalPos = new Point((int)position.getX(), (int)position.getY() - this.spriteSize-1);
        }else if (direction.getY() == -1){
            p = new Point((int)position.getX(), (int)position.getY() + this.spriteSize);
            //this.goalPos = new Point((int)position.getX(), (int)position.getY() + this.spriteSize+1);
        }
        this.setPosition(p);
    }

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(32,32);
	}

	@Override
	public void draw(Graphics g) {
	    this.spriteManager.draw(g, this.position);
	    this.spriteManager.increment();
	}


	@Override
	public void oneStepMoveAddedBehavior() {};
}
