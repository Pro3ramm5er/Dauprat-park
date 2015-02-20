package dpark.rooms;

import dpark.Game;
import dpark.GameObject;
import dpark.GameOtherVars;

/**
 * @author Nickita
 */
public class AN_Fight extends GameObject {

    public int xt;
    public int yt;


    public int TimerToCT = 1;
    public int TX = 0;
    public AN_Fight(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("Fight.png"));
        sprite.addStep(Game.instance.getSprite("Fight1.png"));
        sprite.addStep(Game.instance.getSprite("Fight2.png"));
        sprite.addStep(Game.instance.getSprite("Fight3.png"));
        sprite.addStep(Game.instance.getSprite("Fight4.png"));
        sprite.addStep(Game.instance.getSprite("Fight5.png"));
        sprite.addStep(Game.instance.getSprite("Fight6.png"));
        sprite.addStep(Game.instance.getSprite("Fight7.png"));
        sprite.addStep(Game.instance.getSprite("Fight8.png"));

        sprite.addStep(Game.instance.getSprite("Fight12.png"));
        sprite.addStep(Game.instance.getSprite("Fight12.png"));
        sprite.addStep(Game.instance.getSprite("Fight12.png"));
        sprite.addStep(Game.instance.getSprite("Fight12.png"));
        sprite.addStep(Game.instance.getSprite("Fight12.png"));
        sprite.addStep(Game.instance.getSprite("Fight12.png"));
        sprite.addStep(Game.instance.getSprite("Fight12.png"));
        sprite.addStep(Game.instance.getSprite("Fight12.png"));
        sprite.addStep(Game.instance.getSprite("Fight12.png"));
        sprite.addStep(Game.instance.getSprite("TNT_none.png"));


    }


    @Override
    public void update() {
        // STEPS
        xt = x;
        yt = y;
        z = 1000;
        sprite.currentStep = TX;
        if (TimerToCT <= 0) {
            if (TX < 18)
            {
                TX++;
                TimerToCT = 1;
            }
        } else {
            if (GameOtherVars.FightAnimation == 1) {
                TimerToCT--;
            }
        }
    }

}
