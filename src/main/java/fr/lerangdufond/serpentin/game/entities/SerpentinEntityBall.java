package fr.lerangdufond.serpentin.game.entities;

import java.awt.*;

import gameframework.drawing.*;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyDefaultImpl;
import gameframework.motion.SpeedVector;
import gameframework.motion.overlapping.Overlappable;
import java.util.Random;


public class SerpentinEntityBall extends GameMovable implements
Overlappable, GameEntity, Drawable {

	protected GameCanvas canvas;
	protected SpriteManager spriteManager;
	protected SpeedVector speed = SpeedVector.createNullVector();
	protected int spriteSize;
	protected GameData data;
	static Random random = new Random();

	protected MoveStrategyDefaultImpl moveStrategyDefault;

	protected MoveStrategy getMoveStrategy(){
        return new MoveStrategyDefaultImpl();
    }

	public SerpentinEntityBall(GameData pdata){
	    super();

	    this.canvas = pdata.getCanvas();
	    this.spriteSize = pdata.getConfiguration().getSpriteSize();

        DrawableImage img = new DrawableImage("/images/fruit.png", canvas);
        this.spriteManager =new SpriteManagerDefaultImpl(img, this.spriteSize, 1);
        this.setRandomPosition();

    }

    private void setRandomPosition(){
	    this.position = new Point(100,100);//random.nextInt(this.data.getConfiguration().getNbColumns()-3)+1,random.nextInt(this.data.getConfiguration().getNbRows()-3)+1);
    }

	@Override
	public Rectangle getBoundingBox(){
        Rectangle rectangle = new Rectangle(this.spriteSize, this.spriteSize);
        rectangle.setLocation(position.x * this.spriteSize, position.y * this.spriteSize);
        return rectangle;
    }


	@Override
	public void draw(Graphics g) {
		this.spriteManager.draw(g, position);
		this.spriteManager.increment();
	}
	
	@Override
	public void oneStepMoveAddedBehavior() {

		
	}
}
