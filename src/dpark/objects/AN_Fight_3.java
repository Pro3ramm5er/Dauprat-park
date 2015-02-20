package dpark.objects;

import dpark.Game;
import dpark.GameObject;

/**
 * @author Nickita
 */
public class AN_Fight_3 extends GameObject {

    public int xt;
    public int yt;


    public int TimerToCT = 15;
    public int TX = 0;
    public AN_Fight_3(String name) {
        super(name);
        sprite.addStep(Game.instance.getSprite("FightAn1.png"));
        sprite.addStep(Game.instance.getSprite("FightAn2.png"));
        sprite.addStep(Game.instance.getSprite("FightAn3.png"));
        sprite.addStep(Game.instance.getSprite("FightAn4.png"));
        sprite.addStep(Game.instance.getSprite("FightAn5.png"));
        sprite.addStep(Game.instance.getSprite("FightAn6.png"));
        sprite.addStep(Game.instance.getSprite("FightAn7.png"));
        sprite.addStep(Game.instance.getSprite("FightAn8.png"));
        sprite.addStep(Game.instance.getSprite("FightAn9.png"));
        sprite.addStep(Game.instance.getSprite("FightAn10.png"));
        sprite.addStep(Game.instance.getSprite("FightAn11.png"));

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
            if (TX < 11)
            {
                TX++;
                TimerToCT = 15;
            }
        } else {

            TimerToCT--;

        }
    }

}

