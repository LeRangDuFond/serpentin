package fr.lerangdufond.serpentin.game.entities;

import java.awt.*;

import gameframework.drawing.*;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.overlapping.Overlappable;
import java.util.Random;

/**
 * This class is used to create the entity who is the ball eaten by the player,
 * and all the method needed to be place randomly.
 */
public class SerpentinEntityBall extends GameMovable implements
Overlappable, GameEntity, Drawable {

	protected GameCanvas canvas;
	protected SpriteManager spriteManager;
	protected int spriteSize;
	protected GameData data;
	protected int point;

	static Random random = new Random();

    /**
     * Create the ball entity
     * @param pdata
     *      Data of our game
     */
	public SerpentinEntityBall(GameData pdata){
	    super();
		this.data = pdata;
	    this.canvas = pdata.getCanvas();
	    this.spriteSize = pdata.getConfiguration().getSpriteSize();
        this.point = 1;
        DrawableImage img = new DrawableImage("/images/fruit.png", canvas);
        this.spriteManager =new SpriteManagerDefaultImpl(img, this.spriteSize, 1);
        this.setRandomPosition();

    }

    /**
     * Set the position of this entity to a random place who aren't a wall and/or
     * outside our game
     */
    private void setRandomPosition(){
		int x = (random.nextInt(this.data.getConfiguration().getNbColumns()-3)+1) * this.data.getConfiguration().getSpriteSize();
		int y = (random.nextInt(this.data.getConfiguration().getNbRows()-3)+1) * this.data.getConfiguration().getSpriteSize();
	    this.position = new Point(x, y);
    }

    /**
     * Return the position of the ball.
     * @return the ball position.
     * */
    public Point getPosition(){
    	return this.position;
    }
    
	@Override
	public Rectangle getBoundingBox(){
        Rectangle rectangle = new Rectangle(this.spriteSize, this.spriteSize);
        rectangle.setLocation(position.x * this.spriteSize, position.y * this.spriteSize);
        return rectangle;
    }

    /**
     * Draw our sprite.
     * @param g
     *      The place where the spriteManage will draw our sprite
     */
	@Override
	public void draw(Graphics g) {
		this.spriteManager.draw(g, position);
		this.spriteManager.increment();
	}

    /**
     * This function define what happen when the player hit the ball
     * <p>
     * This function will increase the global score and will change
     * the position of the ball
     */
	public void getHit() {
	    this.data.getScore().setValue(this.data.getScore().getValue() + this.point);
	    this.setRandomPosition();
    }

    /**
     * Not use here the ball don't move
     */
    @Override
    public void oneStepMoveAddedBehavior(){}
}
