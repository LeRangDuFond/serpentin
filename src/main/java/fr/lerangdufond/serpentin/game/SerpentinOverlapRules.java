package fr.lerangdufond.serpentin.game;

import fr.lerangdufond.serpentin.game.entities.SerpentinEntityBall;
import fr.lerangdufond.serpentin.game.entities.SerpentinEntityPieceOfTail;
import fr.lerangdufond.serpentin.game.entities.SerpentinEntityPlayer;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;


/**
 * Class to define all the Overlapping rule from our entities
 */
public class SerpentinOverlapRules extends OverlapRulesApplierDefaultImpl{

    /**
     * Define what happen when the player hit a ball.
     * @param sEP
     *      The entity who define the player;
     * @param sEB
     *      The entity who define the ball
     */
    public void overlapRule(SerpentinEntityPlayer sEP, SerpentinEntityBall sEB){
        sEP.addTail();
        sEB.getHit();
    }

    public void overlapRule(SerpentinEntityPlayer sEP, SerpentinEntityPieceOfTail sEPOT){
        sEP.endOfGame();
    }

    public void overlapRule(SerpentinEntityBall sEB, SerpentinEntityPieceOfTail sEPOT){
        sEB.setRandomPosition();
    }
}
